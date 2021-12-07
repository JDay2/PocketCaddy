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

        if (left.isChecked()) {
            //send data
            left.setChecked(false);
        } else {
            //send data
            right.setChecked(false);
        }

        RadioButton thin = (RadioButton) findViewById(R.id.thinButton);
        RadioButton chunky = (RadioButton) findViewById(R.id.chunkyButton);

        if (thin.isChecked()) {
            //send data
            thin.setChecked(false);
        } else {
            //send data
            chunky.setChecked(false);
        }

        RadioButton curve = (RadioButton) findViewById(R.id.curveButton);
        RadioButton onTarget = (RadioButton) findViewById(R.id.onTargetButton);

        if (curve.isChecked()) {
            //send data
            curve.setChecked(false);
        } else {
            //send data
            onTarget.setChecked(false);
        }
    }
}
