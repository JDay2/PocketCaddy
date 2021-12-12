package edu.highpoint.golfapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToSearch(View view){

        Intent intent;

       intent = new Intent(this, SearchActivity.class);

        startActivity(intent);
    }
    public void goToStats(View view){
        Intent intent = new Intent(this, StatsActivity.class);
        startActivity(intent);
    }
}