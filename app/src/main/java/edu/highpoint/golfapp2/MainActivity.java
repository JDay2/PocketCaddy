package edu.highpoint.golfapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    /*Button ButtonFindYardage;
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
    double lon2; */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToSearch(View view){
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }
    public void goToStats(View view){
        Intent intent = new Intent(this, StatsActivity.class);
        startActivity(intent);
    }
}