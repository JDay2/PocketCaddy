package edu.highpoint.golfapp2;

import android.Manifest;
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

public class SearchActivity extends AppCompatActivity implements LocationListener{

    Button buttonUp;
    Button buttonDown;
    Integer radius;
    EditText editsqmi;
    LocationManager locationManager;
    double lat;
    double lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        buttonUp = (Button) findViewById(R.id.buttonUp);
        buttonDown = (Button) findViewById(R.id.buttonDown);
        editsqmi = (EditText) findViewById(R.id.editsqmi);
        radius = 10;
        editsqmi.setText(radius.toString());

        //Runtime Permissions makes sure you can access location
        if (ContextCompat.checkSelfPermission(SearchActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(SearchActivity.this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);
        }

        getLocation();



    }

    public void toMap(View view) {

        radius = Integer.parseInt(editsqmi.getText().toString());
        if (radius > 350)
            radius = 349;


        Intent intent = new Intent(this, SearchCourses.class);
        intent.putExtra("squaremiles", radius);
        intent.putExtra("Latitude", lat);
        intent.putExtra("Longitude", lon);

        startActivity(intent);
    }

    public void up(View view) {
        radius = Integer.parseInt(editsqmi.getText().toString());
        if (radius < 350)
            radius++;
        else if (radius > 350)
            radius = 349;
        //editsqmi.setText(radius.toString());
    }

    public void down(View view) {
        radius = Integer.parseInt(editsqmi.getText().toString());
        if (radius > 1)
            radius--;
        else if (radius < 1)
            radius = 1;
       // editsqmi.setText(radius.toString());
    }

    //gets long and lat of user
    @Override
    public void onLocationChanged(@NonNull Location location) {
        lon = location.getLongitude();
        lat = location.getLatitude();
    }

    private void getLocation() {
        try {
            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, SearchActivity.this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}