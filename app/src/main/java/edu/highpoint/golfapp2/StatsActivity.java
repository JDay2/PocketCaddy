package edu.highpoint.golfapp2;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class StatsActivity extends AppCompatActivity {

    RadioButton left;
    RadioButton right;
    RadioButton thin;
    RadioButton chunky;
    RadioButton curve;
    RadioButton offTarget;

    private DBHandler dbHandler;
    boolean leftBool = false;
    boolean rightBool = false;
    boolean thinBool = false;
    boolean chunkyBool = false;
    boolean curveBool = false;
    boolean offTargetBool = false;


    private RadioGroup LRRadioGroup;
    private RadioGroup TCRadioGroup;
    private RadioGroup CSRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_activity);

        dbHandler = new DBHandler(StatsActivity.this);

        left = (RadioButton) findViewById(R.id.leftButton);
        right = (RadioButton) findViewById(R.id.rightButton);
        thin = (RadioButton) findViewById(R.id.thinButton);
        chunky = (RadioButton) findViewById(R.id.chunkyButton);
        curve = (RadioButton) findViewById(R.id.curveButton);
        offTarget = (RadioButton) findViewById(R.id.offTargetButton);

        LRRadioGroup = (RadioGroup) findViewById(R.id.leftOrRight);
        TCRadioGroup = (RadioGroup)  findViewById(R.id.thinOrChunky);
        CSRadioGroup = (RadioGroup)  findViewById(R.id.curveOrOn);


    }



    public void calcStats(View view){

        Intent intent = new Intent(StatsActivity.this, StatsFinalActivity.class);
        startActivity(intent);
    }

    public void setLeft(View view){
        leftBool = true;
        rightBool = false;
    }
    public void setRight(View view) {
        rightBool = true;
        leftBool = false;
    }
    public void setThin(View view){
        thinBool = true;
        chunkyBool = false;
    }
    public void setChunky(View view) {
        chunkyBool = true;
        thinBool = false;
    }
    public void setCurve(View view){
        curveBool = true;
        offTargetBool = false;
    }
    public void setOffTarget(View view) {
        offTargetBool = true;
        curveBool = false;
    }


    public void enterShot(View view) {


// open FBdatabase app , open main activity, model the entershot function after the Onclick function
//dont forget to add conditions, if no button clicked then assume good shot, if off target then curve or
//started off must be pushed to record the shot

        String Direction;
        String Solid;
        String Type;

        if(leftBool){
            Direction = "L";   // l indicates the shot went left of the target
        } else if (rightBool){
            Direction = "R";   // r indicates that the shot went right of the target
        } else
            Direction = "S";    // s indicates the athe shot was straight


        if(thinBool) {
            Solid = "T";    // T indidcates that the shot was thin
        } else if(chunkyBool){
            Solid = "C";   // c indicates the shot was  chunky
        } else
            Solid ="S";    // s indicates the shot was solid


        if(Direction.equals("S")){
            Type = "S";      // enters the shot as an "S" regardless of selection if not selected off target
        } else if(curveBool){
            Type = "C";   //C indicates that the shot curved left or right of target
        } else
            Type = "W";    // W indicates that the player hit a shot that was straight off target

        dbHandler.addNewShot(Direction,Solid,Type);

        //resets the radio buttons


        LRRadioGroup.clearCheck();
        TCRadioGroup.clearCheck();
        CSRadioGroup.clearCheck();
        leftBool = false;
        rightBool =false;
        thinBool = false;
        chunkyBool = false;
        curveBool = false;
        offTargetBool = false;

        Toast.makeText(StatsActivity.this, "Shot Entered", Toast.LENGTH_SHORT).show();

    }
    public void openPopUp(View view){

        Toast.makeText(StatsActivity.this, "Thin: hit top half of ball. Chunky: caught too much ground.", Toast.LENGTH_LONG).show();

    }
}
