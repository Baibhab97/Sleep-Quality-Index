package com.example.baibhab.sleep1;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;


public class screen1 extends AppCompatActivity {

    EditText q1Answer_var,q2Answer_var,q3Answer_var,q4Answer_var;
    DatabaseHandler mydb;
    long id;


    private int hour;
    private int minute;

    static final int TIME_DIALOG_ID_q1 = 999;
    static final int TIME_DIALOG_ID_q3 = 998;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);

        Bundle extras = getIntent().getExtras();
        id = extras.getLong("ID");

        q1Answer_var = (EditText) findViewById(R.id.q1Answer);
        q2Answer_var = (EditText) findViewById(R.id.q2Answer);
        q3Answer_var = (EditText) findViewById(R.id.q3Answer);
        q4Answer_var = (EditText) findViewById(R.id.q4Answer);
        mydb = new DatabaseHandler(this);

        addListenerOnq1Answer();
        addListenerOnq3Answer();
    }

    public void addListenerOnq1Answer() {
        q1Answer_var.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(TIME_DIALOG_ID_q1);
                    }
                }
        );
    }


    public void addListenerOnq3Answer() {
        q3Answer_var.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(TIME_DIALOG_ID_q3);
                    }
                }
        );
    }


    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case TIME_DIALOG_ID_q1:
                return new TimePickerDialog(this,
                        timePickerListener_q1, hour, minute,false);

            case TIME_DIALOG_ID_q3:
                return new TimePickerDialog(this,
                        timePickerListener_q3, hour, minute,false);

        }
        return null;
    }

    private TimePickerDialog.OnTimeSetListener timePickerListener_q1 =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int selectedHour,
                                      int selectedMinute) {
                    hour = selectedHour;
                    minute = selectedMinute;

                    q1Answer_var.setText(new StringBuilder().append(pad(hour))
                            .append(":").append(pad(minute)));

                }
            };


    private TimePickerDialog.OnTimeSetListener timePickerListener_q3 =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int selectedHour,
                                      int selectedMinute) {
                    hour = selectedHour;
                    minute = selectedMinute;

                    q3Answer_var.setText(new StringBuilder().append(pad(hour))
                            .append(":").append(pad(minute)));

                }
            };


    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

    public void nextScreen1ButtonOnClick(View view) {
        Intent i = new Intent(this, screen2.class);
        boolean isUpdated = mydb.update_screen1(q1Answer_var.getText().toString(),q2Answer_var.getText().toString(),q3Answer_var.getText().toString(),q4Answer_var.getText().toString(),id);
        if(isUpdated == true)
            Toast.makeText(this,"Data Inserted",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Data Not Inserted",Toast.LENGTH_SHORT).show();
        i.putExtra("ID",id);
        startActivity(i);
    }

}