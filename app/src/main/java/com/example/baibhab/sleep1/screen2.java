package com.example.baibhab.sleep1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class screen2 extends AppCompatActivity {

    RadioGroup q5aAnswer_var,q5bAnswer_var,q5cAnswer_var,q5dAnswer_var,q5eAnswer_var,q5fAnswer_var,q5gAnswer_var,q5hAnswer_var,q5iAnswer_var,q5jAnswer_var;
    long id;
    DatabaseHandler mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        Bundle extras = getIntent().getExtras();
        id = extras.getLong("ID");

        mydb = new DatabaseHandler(this);
        q5aAnswer_var = (RadioGroup)findViewById(R.id.q5aAnswer);
        q5bAnswer_var = (RadioGroup)findViewById(R.id.q5bAnswer);
        q5cAnswer_var = (RadioGroup)findViewById(R.id.q5cAnswer);
        q5dAnswer_var = (RadioGroup)findViewById(R.id.q5dAnswer);
        q5eAnswer_var = (RadioGroup)findViewById(R.id.q5eAnswer);
        q5fAnswer_var = (RadioGroup)findViewById(R.id.q5fAnswer);
        q5gAnswer_var = (RadioGroup)findViewById(R.id.q5gAnswer);
        q5hAnswer_var = (RadioGroup)findViewById(R.id.q5hAnswer);
        q5iAnswer_var = (RadioGroup)findViewById(R.id.q5iAnswer);
        q5jAnswer_var = (RadioGroup)findViewById(R.id.q5jAnswer);

    }

    public void nextScreen2ButtonOnClick(View view) {
        Intent i = new Intent(this,screen3.class);

        int q5aSelected, q5bSelected, q5cSelected, q5dSelected, q5eSelected, q5fSelected, q5gSelected, q5hSelected, q5iSelected, q5jSelected;
        RadioButton q5a,q5b,q5c,q5d,q5e,q5f,q5g,q5h,q5i,q5j;

        q5aSelected = q5aAnswer_var.getCheckedRadioButtonId();
        q5bSelected = q5bAnswer_var.getCheckedRadioButtonId();
        q5cSelected = q5cAnswer_var.getCheckedRadioButtonId();
        q5dSelected = q5dAnswer_var.getCheckedRadioButtonId();
        q5eSelected = q5eAnswer_var.getCheckedRadioButtonId();
        q5fSelected = q5fAnswer_var.getCheckedRadioButtonId();
        q5gSelected = q5gAnswer_var.getCheckedRadioButtonId();
        q5hSelected = q5hAnswer_var.getCheckedRadioButtonId();
        q5iSelected = q5iAnswer_var.getCheckedRadioButtonId();
        q5jSelected = q5jAnswer_var.getCheckedRadioButtonId();


        q5a = (RadioButton) findViewById(q5aSelected);
        q5b = (RadioButton) findViewById(q5bSelected);
        q5c = (RadioButton) findViewById(q5cSelected);
        q5d = (RadioButton) findViewById(q5dSelected);
        q5e = (RadioButton) findViewById(q5eSelected);
        q5f = (RadioButton) findViewById(q5fSelected);
        q5g = (RadioButton) findViewById(q5gSelected);
        q5h = (RadioButton) findViewById(q5hSelected);
        q5i = (RadioButton) findViewById(q5iSelected);
        q5j = (RadioButton) findViewById(q5jSelected);



        /*
        if(q5aSelected == R.id.radioButton5aA)
            q5a = 0;
        else if(q5aSelected == R.id.radioButton5aB)
            q5a = 1;
        else if(q5aSelected == R.id.radioButton5aC)
            q5a = 2;
        else //if(q5aSelected == R.id.radioButton5aD)
            q5a = 3;

        if(q5bSelected == R.id.radioButton5bA)
            q5b = 0;
        else if(q5bSelected == R.id.radioButton5bB)
            q5b = 1;
        else if(q5bSelected == R.id.radioButton5bC)
            q5b = 2;
        else //if(q5bSelected == R.id.radioButton5bD)
            q5b = 3;

        if(q5cSelected == R.id.radioButton5cA)
            q5c = 0;
        else if(q5cSelected == R.id.radioButton5cB)
            q5c = 1;
        else if(q5cSelected == R.id.radioButton5cC)
            q5c = 2;
        else //if(q5cSelected == R.id.radioButton5cD)
            q5c = 3;

        if(q5dSelected == R.id.radioButton5dA)
            q5d = 0;
        else if(q5dSelected == R.id.radioButton5dB)
            q5d = 1;
        else if(q5dSelected == R.id.radioButton5dC)
            q5d = 2;
        else //if(q5dSelected == R.id.radioButton5dD)
            q5d = 3;

        if(q5eSelected == R.id.radioButton5eA)
            q5e = 0;
        else if(q5eSelected == R.id.radioButton5eB)
            q5e = 1;
        else if(q5eSelected == R.id.radioButton5eC)
            q5e = 2;
        else //if(q5eSelected == R.id.radioButton5eD)
            q5e = 3;

        if(q5fSelected == R.id.radioButton5fA)
            q5f = 0;
        else if(q5fSelected == R.id.radioButton5fB)
            q5f = 1;
        else if(q5fSelected == R.id.radioButton5fC)
            q5f = 2;
        else //if(q5fSelected == R.id.radioButton5fD)
            q5f = 3;

        if(q5gSelected == R.id.radioButton5gA)
            q5g = 0;
        else if(q5gSelected == R.id.radioButton5gB)
            q5g = 1;
        else if(q5gSelected == R.id.radioButton5gC)
            q5g = 2;
        else //if(q5gSelected == R.id.radioButton5gD)
            q5g = 3;

        if(q5hSelected == R.id.radioButton5hA)
            q5h = 0;
        else if(q5hSelected == R.id.radioButton5hB)
            q5h = 1;
        else if(q5hSelected == R.id.radioButton5hC)
            q5h = 2;
        else //if(q5hSelected == R.id.radioButton5hD)
            q5h = 3;

        if(q5iSelected == R.id.radioButton5iA)
            q5i = 0;
        else if(q5iSelected == R.id.radioButton5iB)
            q5i = 1;
        else if(q5iSelected == R.id.radioButton5iC)
            q5i = 2;
        else //if(q5iSelected == R.id.radioButton5iD)
            q5i = 3;

        if(q5jSelected == R.id.radioButton5jA)
            q5j = 0;
        else if(q5jSelected == R.id.radioButton5jB)
            q5j = 1;
        else if(q5jSelected == R.id.radioButton5jC)
            q5j = 2;
        else //if(q5jSelected == R.id.radioButton5jD)
            q5j = 3;
    */

        boolean isUpdated = mydb.update_screen2(q5a.getText().toString(),q5b.getText().toString(),q5c.getText().toString(),q5d.getText().toString(),q5e.getText().toString(),q5f.getText().toString(),q5g.getText().toString(),q5h.getText().toString(),q5i.getText().toString(),q5j.getText().toString(),id);
        if(isUpdated == true)
            Toast.makeText(this,"Data Inserted",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Data Not Inserted",Toast.LENGTH_SHORT).show();
        i.putExtra("ID",id);
        startActivity(i);
    }
}