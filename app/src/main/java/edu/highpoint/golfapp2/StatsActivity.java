package edu.highpoint.golfapp2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class StatsActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_activity);
    }

    public void calcStats(View view){
        Intent intent = new Intent(this, StatsFinalActivity.class);

        //send data (if any)


        startActivity(intent);
    }
    public void enterShot(View view){
        //reset the radio buttons, send data to database
    }
}
