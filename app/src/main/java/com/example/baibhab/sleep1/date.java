package com.example.baibhab.sleep1;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.Calendar;

public class date extends Activity {

    DatabaseHandler mydb;
    EditText dateDate_var;
    RatingBar ratingBar_var;
    int year_x, month_x, day_x;
    static final int DIALOG_ID=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);

        dateDate_var = (EditText) findViewById(R.id.dateDate);
        mydb = new DatabaseHandler(this);
        ratingBar_var = (RatingBar)findViewById(R.id.ratingBar);

        showDateDialog();
    }

    public void showDateDialog() {
        dateDate_var.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }

    @Override
    public Dialog onCreateDialog(int id) {
        if(id == DIALOG_ID)
            return new DatePickerDialog(this,dpickerListner,year_x,month_x,day_x);
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListner
            = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            year_x = year;
            month_x = month + 1;
            day_x = dayOfMonth;
            dateDate_var.setText(year_x + " - " + month_x + " - " + day_x );
        }
    };

    public void nextDateButtonOnClick(View view) {
        Intent i = new Intent(this,screen1.class);
        long isInserted = mydb.insertData_date(dateDate_var.getText().toString(),ratingBar_var.getRating());
        if(isInserted == -1)
            Toast.makeText(this,"Data Not Inserted",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Data Inserted",Toast.LENGTH_SHORT).show();
        i.putExtra("ID",isInserted);
        startActivity(i);
    }
    
}