package edu.highpoint.golfapp2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity{

    Button buttonUp;
    Button buttonDown;
    Integer sqmi;
    EditText editsqmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        buttonDown=(Button) findViewById(R.id.downButton);
        buttonUp=(Button) findViewById(R.id.upButton);
        sqmi=10;
        editsqmi=(EditText)findViewById(R.id.editSqMi);
        editsqmi.setText(sqmi.toString());
    }

    public void goUp(View view){

        Integer sqmi=Integer.parseInt(editsqmi.getText().toString());

        if(sqmi<100)
            sqmi++;
        else if(sqmi>100)
            sqmi=99;

        editsqmi.setText(sqmi.toString());
    }

    public void goDown(View view){

        Integer sqmi=Integer.parseInt(editsqmi.getText().toString());

        if(sqmi>1)
            sqmi--;
        else if(sqmi<1)
            sqmi=1;

        editsqmi.setText(sqmi.toString());
    }

    public void searchCourses(View view){
        Intent intent = new Intent(this, SearchCourses.class);
        startActivity(intent);
    }
}
