package edu.highpoint.golfapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.ArrayList;

public class StatsFinalActivity extends AppCompatActivity {

    TextView EditBox1;
    TextView EditBox2;
    TextView EditBox3;
    ImageView arrow;


    double totalShots;
    double leftShots;
    double rightShots;
    double chunkyShots;
    double thinShots;
    double curveShots;
    double offTargetShots;
    int count;
    String hold;

    private DBHandler dbHandler;
    private ArrayList<ShotModal> shotModalArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_final);

        EditBox1 = (TextView) findViewById(R.id.TextBox1);
        EditBox2 = (TextView) findViewById(R.id.TextBox2);
        EditBox3 = (TextView) findViewById(R.id.TextBox3);
        arrow = (ImageView) findViewById(R.id.arrow);

        totalShots = 0;
        leftShots = 0;
        rightShots = 0;
        chunkyShots = 0;
        thinShots = 0;
        curveShots = 0;
        offTargetShots = 0;

        count=0;


       /* calculatePercentages();
        print();
        rotateArrow(); */
        shotModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(StatsFinalActivity.this);

        shotModalArrayList = dbHandler.readShots();

        ShotModal modal;
        while(shotModalArrayList.size()>count) {
            modal = shotModalArrayList.get(count);

            if(modal.getDirection().equals("L")){
                leftShots++;
            } else if (modal.getDirection().equals("R")){
                rightShots++;
            }


            if(modal.getSolid().equals("T")){
                thinShots++;
            } else if (modal.getSolid().equals("C")){
                chunkyShots++;
            }


            if(modal.getType().equals("C")){
                curveShots++;
            } else if (modal.getType().equals("W")){
                offTargetShots++;
            }


            count++;
        }



        String DirectionTOPRINT;
        if(leftShots>rightShots)
            DirectionTOPRINT = "LEFT";
        else
            DirectionTOPRINT = "RIGHT";

        if (DirectionTOPRINT.equals("LEFT")) {
            hold = String.format("%.2f", leftShots / count * 100);
            if(Double.parseDouble(hold)<35) {
                arrow.setRotation((float) -Double.parseDouble(hold));
            }else
                arrow.setRotation(-35);
        }
        else {
            hold = String.format("%.2f", rightShots / count * 100);
            if(Double.parseDouble(hold)<35){
                arrow.setRotation((float) Double.parseDouble(hold));
            }else
                arrow.setRotation(35);
        }

        String SolidTOPRINT;
        String var;
        if(thinShots>chunkyShots) {
            SolidTOPRINT = "THIN";
            var = String.format("%.2f", thinShots / count * 100);
        } else {
            SolidTOPRINT = "CHUNKY";
            var = String.format("%.2f", chunkyShots / count * 100);
        }

        String where;
        String HEHE;
        double TotalOffTarget = curveShots+offTargetShots;
        if(curveShots>offTargetShots){
            where = "CURVED";
            HEHE = String.format("%.2f", curveShots / TotalOffTarget * 100);
        }else {
            where = "PULLED/PUSHED";
            HEHE = String.format("%.2f", offTargetShots / TotalOffTarget * 100);
        }

        EditBox1.setText(" You hit "+ hold+"% of shots "+ DirectionTOPRINT);
        EditBox2.setText(" You hit " + var +"% of shots " +SolidTOPRINT);
        EditBox3.setText(HEHE+"% of your shots off target "+where);

    }



   /* public void calculatePercentages(){

    }

    public void print(){

    }
    private void rotateArrow(){

    }

    } */
}