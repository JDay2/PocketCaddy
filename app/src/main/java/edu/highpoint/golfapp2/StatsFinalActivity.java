package edu.highpoint.golfapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class StatsFinalActivity extends AppCompatActivity {

    TextView EditBox1;
    TextView EditBox2;
    TextView EditBox3;


    double totalShots;
    double leftShots;
    double rightShots;
    double chunkyShots;
    double thinShots;
    double curveShots;
    double offTargetShots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_final);

        EditBox1 = (TextView) findViewById(R.id.TextBox1);
        EditBox2 = (TextView) findViewById(R.id.TextBox2);
        EditBox3 = (TextView) findViewById(R.id.TextBox3);

        totalShots=0;
        leftShots=0;
        rightShots=0;
        chunkyShots=0;
        thinShots=0;
        curveShots=0;
        offTargetShots=0;

        getShots();
        calculatePercentages();
        print();
        rotateArrow();
    }


    public void getShots(View view){
        //getshot
        totalShots++;

    }

    public void calculatePercentages(View view){

    }

    public void print(){

    }
    private void rotateArrow(){

    }

}