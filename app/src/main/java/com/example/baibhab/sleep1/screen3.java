package com.example.baibhab.sleep1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class screen3 extends AppCompatActivity {

    long id;
    DatabaseHandler mydb;
    RadioGroup q6Answer_var,q7Answer_var,q8Answer_var,q9Answer_var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);

        Bundle extras = getIntent().getExtras();
        id = extras.getLong("ID");

        mydb = new DatabaseHandler(this);
        q6Answer_var = (RadioGroup)findViewById(R.id.q6Answer);
        q7Answer_var = (RadioGroup)findViewById(R.id.q7Answer);
        q8Answer_var = (RadioGroup)findViewById(R.id.q8Answer);
        q9Answer_var = (RadioGroup)findViewById(R.id.q9Answer);

    }

    public void nextScreen3ButtonOnClick(View view) {

        int q6Selected, q7Selected, q8Selected, q9Selected;
        RadioButton q6,q7,q8,q9;


        q6Selected = q6Answer_var.getCheckedRadioButtonId();
        q7Selected = q7Answer_var.getCheckedRadioButtonId();
        q8Selected = q8Answer_var.getCheckedRadioButtonId();
        q9Selected = q9Answer_var.getCheckedRadioButtonId();


        q6 = (RadioButton) findViewById(q6Selected);
        q7 = (RadioButton) findViewById(q7Selected);
        q8 = (RadioButton) findViewById(q8Selected);
        q9 = (RadioButton) findViewById(q9Selected);


        /*
        if(q6Selected == R.id.radioButton6A)
            q6 = 0;
        else if(q6Selected == R.id.radioButton6B)
            q6 = 1;
        else if(q6Selected == R.id.radioButton6C)
            q6 = 2;
        else //if(q6Selected == R.id.radioButton6D)
            q6 = 3;

        if(q7Selected == R.id.radioButton7A)
            q7 = 0;
        else if(q7Selected == R.id.radioButton7B)
            q7 = 1;
        else if(q7Selected == R.id.radioButton7C)
            q7 = 2;
        else //if(q7Selected == R.id.radioButton7D)
            q7 = 3;

        if(q8Selected == R.id.radioButton8A)
            q8 = 0;
        else if(q8Selected == R.id.radioButton8B)
            q8 = 1;
        else if(q8Selected == R.id.radioButton8C)
            q8 = 2;
        else //if(q8Selected == R.id.radioButton8D)
            q8 = 3;

        if(q9Selected == R.id.radioButton9A)
            q9 = 0;
        else if(q9Selected == R.id.radioButton9B)
            q9 = 1;
        else if(q9Selected == R.id.radioButton9C)
            q9 = 2;
        else //if(q9Selected == R.id.radioButton9D)
            q9 = 3;
        */

        boolean isUpdated = mydb.update_screen3(q6.getText().toString(),q7.getText().toString(),q8.getText().toString(),q9.getText().toString(),id);
        if(isUpdated == true)
            Toast.makeText(this,"Data Inserted",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Data Not Inserted",Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, home.class);
        startActivity(i);
    }
}