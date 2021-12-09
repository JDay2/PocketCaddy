package edu.highpoint.golfapp2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class StatsActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_activity);
    }

    public void calcStats(View view){

        enterShot();

        Intent intent = new Intent(this, StatsFinalActivity.class);
        startActivity(intent);
    }
    public void enterShot() {

        RadioButton left = (RadioButton) findViewById(R.id.leftButton);
        RadioButton right = (RadioButton) findViewById(R.id.rightButton);
        RadioButton thin = (RadioButton) findViewById(R.id.thinButton);
        RadioButton chunky = (RadioButton) findViewById(R.id.chunkyButton);
        RadioButton curve = (RadioButton) findViewById(R.id.curveButton);
        RadioButton offTarget = (RadioButton) findViewById(R.id.offTargetButton);
        boolean leftOrRight=false;

        if (left.isChecked()) {
            //send data
            left.setChecked(false);
            leftOrRight=true;
        }
        else if(right.isChecked()){
            //send data
            right.setChecked(false);
            leftOrRight=true;
        }

        if (thin.isChecked()) {
            //send data
            thin.setChecked(false);
        }
        else if(chunky.isChecked()) {
            //send data
            chunky.setChecked(false);
        }

        if (curve.isChecked() && leftOrRight) {
            //send data
            curve.setChecked(false);
        }
        else if(offTarget.isChecked() && leftOrRight) {
            //send data
            offTarget.setChecked(false);
        }
        else{
            curve.setChecked(false);
            offTarget.setChecked(false);
        }
    }
    public void openPopUp(){

    }
}
