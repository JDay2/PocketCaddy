package edu.highpoint.golfapp2;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class OnCourseActivity extends AppCompatActivity implements LocationListener {

    Button ButtonFindYardage;
    Button ButtonNext;
    Button ButtonPrev;
    EditText DistanceOut;
    EditText LabelHole;
    LocationManager locationManager;

    Integer Hole;
    double Distance;
    double lon1;
    double lat1;
    double lat2;
    double lon2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_activity);

        ButtonFindYardage = (Button) findViewById(R.id.ButtonFindYardage);
        ButtonNext = (Button) findViewById(R.id.ButtonNext);
        ButtonPrev = (Button) findViewById(R.id.ButtonPrev);
        DistanceOut = (EditText) findViewById(R.id.DistanceOut);
        LabelHole = (EditText) findViewById(R.id.LabelHole);

        Intent a = getIntent();
        String title = a.getStringExtra(SearchCourses.name);
        String location = a.getStringExtra(SearchCourses.location);
        System.out.println(title);
        System.out.println(location);


        //Runtime Permissions makes sure you can access location

        if (ContextCompat.checkSelfPermission(OnCourseActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(OnCourseActivity.this,new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);

            Hole = 1; //set to first hole
            Distance = 0;  //distance to 0
            LabelHole.setText("Hole " + Hole.toString());  //label set to hole 1




        }

    }



    //  ActionBar actionBar=getActionBar();
    // actionBar.hide();

    @SuppressLint("MissingPermission")
    private void getLocation() {
        try {
            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, OnCourseActivity.this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    //calculates distance to the hole and updates the hole label and distance field
    //this distance still uses the old way of the holes for storage and acess
    public void FindDistance(View view) {

        getLocation();

        double theta = lon1 - lon2;
        Distance = Math.sin(deg2rad(lat1)) *  Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        Distance = Math.acos(Distance);
        Distance = rad2deg(Distance);
        Distance = Distance *60 *1.1515;
        Distance = Distance *1.609344;
        Distance = Distance * 1000;
        Distance = Distance * 1.09361;


        //Distance =  Math.sqrt(Distance);
        LabelHole.setText("Hole " + Hole.toString());
        String DisString = String.valueOf((int)Distance);
        DistanceOut.setText(DisString);
    }


    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    //gets long and lat of user
    @Override
    public void onLocationChanged(@NonNull Location location) {
        lon1 = location.getLongitude();
        lat1 = location.getLatitude();
    }

    //increments hole up to 18
    public void NextHole(View view){
        if(Hole<=17){
            Hole+=1;
            LabelHole.setText("Hole " + Hole.toString());
            DistanceOut.setText("NADA");
        }
     }

    //decrements hole down to 1
   public void PrevHole(View view){
        if(Hole>1){
            Hole=Hole-1;
            LabelHole.setText("Hole " + Hole.toString());
            //DistanceOut.setText("NADA");
        }
    }


}