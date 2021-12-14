package edu.highpoint.golfapp2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchCourses extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
  //  private ActivityMapsBinding binding;
    Integer radius;
    ArrayList<LatLng> courses=new ArrayList<LatLng>();
    ArrayList<String> titles=new ArrayList<String>();
    double Distance;
    double lat;
    double lon;
    public static final String name="";
    public static final String location="";

    String clickID = "", oldClickID = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        radius = getIntent().getIntExtra("squaremiles", 50);
        lat = getIntent().getDoubleExtra("Latitude",30);
        lon = getIntent().getDoubleExtra("Longitude",30);

      //  binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_search_courses);


        try {
            InputStream txtFile= getAssets().open("data.txt");
            Scanner reader= new Scanner(txtFile);

            while(reader.hasNext()){
                Double lat=reader.nextDouble();
                Double lon=reader.nextDouble();
                String name=reader.nextLine();

                LatLng latLng=new LatLng(lat, lon);
                courses.add(latLng);
                titles.add(name);
                System.out.println("ayooooo");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        ///Obtain the SupportMapFragment and get notified when the map is ready to be used.
      SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
              .findFragmentById(R.id.map);
       mapFragment.getMapAsync(this);

    }



    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        //lon = -80;
        LatLng latLng= new LatLng(lat,lon);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.defaultMarker(67)).position(latLng).title("Current Location"));

        //gets long and lat of user
        LatLng current = new LatLng(lat, lon); //change to device location
        Distance = 600;

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(current, 7));

        for(int i =0; i<courses.size(); i++) {
            double theta = lon - courses.get(i).longitude;
            Distance = Math.sin(deg2rad(lat)) *  Math.sin(deg2rad(courses.get(i).latitude)) + Math.cos(deg2rad(lat)) * Math.cos(deg2rad(courses.get(i).latitude)) * Math.cos(deg2rad(theta));
            Distance = Math.acos(Distance);
            Distance = rad2deg(Distance);
            Distance = Distance *60 *1.1515;


            if(Distance<=radius) {
                mMap.addMarker(new MarkerOptions().position(courses.get(i)).title(titles.get(i)));


                mMap.setOnMarkerClickListener(marker -> {
                    clickID = marker.getId();
                    if(clickID.matches(oldClickID)){
                        Intent a = new Intent(this,OnCourseActivity.class);
                        a.putExtra(name, (Serializable) marker.getTitle());
                        a.putExtra(location, marker.getPosition());
                        startActivity(a);
                    }

                    oldClickID=clickID;

                    return false;
                });


            }
            else
                mMap.addMarker(new MarkerOptions().position(courses.get(i)).title(titles.get(i)).visible(false));

        }

    }





    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

   /*         mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
        @Override
        public boolean onMarkerClick(Marker marker) {
            // on marker click we are getting the title of our marker
            // which is clicked and displaying it in a toast message.
            String markerName = marker.getTitle();
            Toast.makeText(SearchCourses.this, "Clicked location is " + markerName, Toast.LENGTH_SHORT).show();
            return false;
        }
    }); */
}