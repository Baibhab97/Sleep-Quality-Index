package com.example.baibhab.sleep1;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class showData extends AppCompatActivity {

    DatabaseHandler mydb;
    Cursor data;
    TextView q1AnswerDisplay_var,q2AnswerDisplay_var,q3AnswerDisplay_var, q4AnswerDisplay_var, q5aAnswerDisplay_var, q5bAnswerDisplay_var, q5cAnswerDisplay_var, q5dAnswerDisplay_var, q5eAnswerDisplay_var, q5fAnswerDisplay_var, q5gAnswerDisplay_var, q5hAnswerDisplay_var, q5iAnswerDisplay_var, q5jAnswerDisplay_var, q6AnswerDisplay_var, q7AnswerDisplay_var, q8AnswerDisplay_var, q9AnswerDisplay_var;
    ArrayList<String> result = new ArrayList<>();
    int score,comp1=0,comp2=0,comp3=0,comp4=0,comp5=0,comp6=0,comp7=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        Bundle extras = getIntent().getExtras();
        String dateReq = extras.getString("requiredDate");

        mydb = new DatabaseHandler(this);
        q1AnswerDisplay_var = (TextView)findViewById(R.id.q1AnswerDisplay);
        q2AnswerDisplay_var = (TextView)findViewById(R.id.q2AnswerDisplay);
        q3AnswerDisplay_var = (TextView)findViewById(R.id.q3AnswerDisplay);
        q4AnswerDisplay_var = (TextView)findViewById(R.id.q4AnswerDisplay);
        q5aAnswerDisplay_var = (TextView)findViewById(R.id.q5aAnswerDisplay);
        q5bAnswerDisplay_var = (TextView)findViewById(R.id.q5bAnswerDisplay);
        q5cAnswerDisplay_var = (TextView)findViewById(R.id.q5cAnswerDisplay);
        q5dAnswerDisplay_var = (TextView)findViewById(R.id.q5dAnswerDisplay);
        q5eAnswerDisplay_var = (TextView)findViewById(R.id.q5eAnswerDisplay);
        q5fAnswerDisplay_var = (TextView)findViewById(R.id.q5fAnswerDisplay);
        q5gAnswerDisplay_var = (TextView)findViewById(R.id.q5gAnswerDisplay);
        q5hAnswerDisplay_var = (TextView)findViewById(R.id.q5hAnswerDisplay);
        q5iAnswerDisplay_var = (TextView)findViewById(R.id.q5iAnswerDisplay);
        q5jAnswerDisplay_var = (TextView)findViewById(R.id.q5jAnswerDisplay);
        q6AnswerDisplay_var = (TextView)findViewById(R.id.q6AnswerDisplay);
        q7AnswerDisplay_var = (TextView)findViewById(R.id.q7AnswerDisplay);
        q8AnswerDisplay_var = (TextView)findViewById(R.id.q8AnswerDisplay);
        q9AnswerDisplay_var = (TextView)findViewById(R.id.q9AnswerDisplay);

        data = mydb.getSpecificData(dateReq);
        while (data.moveToNext()){
            result.add(data.getString(2));
            result.add(data.getString(3));
            result.add(data.getString(4));
            result.add(data.getString(5));
            result.add(data.getString(6));
            result.add(data.getString(7));
            result.add(data.getString(8));
            result.add(data.getString(9));
            result.add(data.getString(10));
            result.add(data.getString(11));
            result.add(data.getString(12));
            result.add(data.getString(13));
            result.add(data.getString(14));
            result.add(data.getString(15));
            result.add(data.getString(16));
            result.add(data.getString(17));
            result.add(data.getString(18));
            result.add(data.getString(19));
        }

        q1AnswerDisplay_var.setText("Ans : "+result.get(0));
        q2AnswerDisplay_var.setText("Ans : "+result.get(1));
        q3AnswerDisplay_var.setText("Ans : "+result.get(2));
        q4AnswerDisplay_var.setText("Ans : "+result.get(3));
        q5aAnswerDisplay_var.setText("Ans : "+result.get(4));
        q5bAnswerDisplay_var.setText("Ans : "+result.get(5));
        q5cAnswerDisplay_var.setText("Ans : "+result.get(6));
        q5dAnswerDisplay_var.setText("Ans : "+result.get(7));
        q5eAnswerDisplay_var.setText("Ans : "+result.get(8));
        q5fAnswerDisplay_var.setText("Ans : "+result.get(9));
        q5gAnswerDisplay_var.setText("Ans : "+result.get(10));
        q5hAnswerDisplay_var.setText("Ans : "+result.get(11));
        q5iAnswerDisplay_var.setText("Ans : "+result.get(12));
        q5jAnswerDisplay_var.setText("Ans : "+result.get(13));
        q6AnswerDisplay_var.setText("Ans : "+result.get(14));
        q7AnswerDisplay_var.setText("Ans : "+result.get(15));
        q8AnswerDisplay_var.setText("Ans : "+result.get(16));
        q9AnswerDisplay_var.setText("Ans : "+result.get(17));

    }

    public void backShowDataButtonOnClick(View view){
        Intent i = new Intent(this,home.class);
        startActivity(i);
    }


    public void checkScoreButtonOnClick(View v){

        //Component 1
        if("Very Good".equals(result.get(17)))
            comp1 = 0;
        else if("Fairly Good".equals(result.get(17)))
            comp1 = 1;
        else if("Fairly Bad".equals(result.get(17)))
            comp1 = 2;
        else //if("Very Bad".equals(result.get(17)))
            comp1 = 3;

        //Component 2
        Integer q2value = new Integer(Integer.valueOf(result.get(1)));


        if(q2value>0 && q2value <= 15)
            comp2 = 0;
        else if(q2value > 15 && q2value <= 30)
            comp2 = 1;
        else if(q2value > 30 && q2value <= 60)
            comp2 = 2;
        else //if(q2value > 60)
            comp2 = 3;

        if ("Not during the past month".equals(result.get(4)))
            comp2 += 0;
        else if("Less than once a week".equals(result.get(4)))
            comp2 += 1;
        else if("Once or twice a week".equals(result.get(4)))
            comp2 += 2;
        else //if("Three or more times a week".equals(result.get(4)))
            comp2 += 3;

        //Component 3
        Integer q4value = Integer.valueOf(Integer.valueOf(result.get(3)));

        if(q4value > 7)
            comp3 = 0;
        else if(q4value > 6 && q4value <=7)
            comp3 = 1;
        else if(q4value >= 5 && q4value <=6)
            comp3 = 2;
        else //if(q4value < 5)
            comp3 = 3;


        //Component 4
        int comp4Value;
        long diff;
        String firstTime = result.get(0);
        String secondTime = result.get(2);
        String for_date_00 = "00:00";
        String for_date_24 = "24:00";
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date date1 = null;
        Date date2 = null;
        Date date_00 = null;
        Date date_24 = null;
        try {
            date1 = format.parse(firstTime);
            date2 = format.parse(secondTime);
            date_00 = format.parse(for_date_00);
            date_24 = format.parse(for_date_24);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //get difference between the two times and then convert it in hours
        if(date1.getTime() > date2.getTime()){
            diff=(date_24.getTime() - date1.getTime())+(date2.getTime() - date_00.getTime());
        }
        else
            diff = date2.getTime() - date1.getTime();
        int diffHours = (int)(diff / (60 * 60 * 1000));

        comp4Value = (q4value*100/diffHours);
        if(comp4Value >= 85)
            comp4=0;
        else if(comp4Value>=75 && comp4Value<85)
            comp4=1;
        else if(comp4Value>=65 && comp4Value<75)
            comp4=2;
        else if(comp4Value<65)
            comp4=3;


        //Component 5
        int q5bValue, q5cValue, q5dValue, q5eValue, q5fValue, q5gValue, q5hValue, q5iValue, q5jValue,total5;

        if ("Not during the past month".equals(result.get(5)))
            q5bValue=0;
        else if("Less than once a week".equals(result.get(5)))
            q5bValue=1;
        else if("Once or twice a week".equals(result.get(5)))
            q5bValue=2;
        else //if("Three or more times a week".equals(result.get(5)))
            q5bValue=3;

        if ("Not during the past month".equals(result.get(6)))
            q5cValue=0;
        else if("Less than once a week".equals(result.get(6)))
            q5cValue=1;
        else if("Once or twice a week".equals(result.get(6)))
            q5cValue=2;
        else //if("Three or more times a week".equals(result.get(6)))
            q5cValue=3;

        if ("Not during the past month".equals(result.get(7)))
            q5dValue=0;
        else if("Less than once a week".equals(result.get(7)))
            q5dValue=1;
        else if("Once or twice a week".equals(result.get(7)))
            q5dValue=2;
        else //if("Three or more times a week".equals(result.get(7)))
            q5dValue=3;

        if ("Not during the past month".equals(result.get(8)))
            q5eValue=0;
        else if("Less than once a week".equals(result.get(8)))
            q5eValue=1;
        else if("Once or twice a week".equals(result.get(8)))
            q5eValue=2;
        else //if("Three or more times a week".equals(result.get(8)))
            q5eValue=3;

        if ("Not during the past month".equals(result.get(9)))
            q5fValue=0;
        else if("Less than once a week".equals(result.get(9)))
            q5fValue=1;
        else if("Once or twice a week".equals(result.get(9)))
            q5fValue=2;
        else //if("Three or more times a week".equals(result.get(9)))
            q5fValue=3;

        if ("Not during the past month".equals(result.get(10)))
            q5gValue=0;
        else if("Less than once a week".equals(result.get(10)))
            q5gValue=1;
        else if("Once or twice a week".equals(result.get(10)))
            q5gValue=2;
        else //if("Three or more times a week".equals(result.get(10)))
            q5gValue=3;

        if ("Not during the past month".equals(result.get(11)))
            q5hValue=0;
        else if("Less than once a week".equals(result.get(11)))
            q5hValue=1;
        else if("Once or twice a week".equals(result.get(11)))
            q5hValue=2;
        else //if("Three or more times a week".equals(result.get(11)))
            q5hValue=3;

        if ("Not during the past month".equals(result.get(12)))
            q5iValue=0;
        else if("Less than once a week".equals(result.get(12)))
            q5iValue=1;
        else if("Once or twice a week".equals(result.get(12)))
            q5iValue=2;
        else //if("Three or more times a week".equals(result.get(12)))
            q5iValue=3;

        if ("Not during the past month".equals(result.get(13)))
            q5jValue=0;
        else if("Less than once a week".equals(result.get(13)))
            q5jValue=1;
        else if("Once or twice a week".equals(result.get(13)))
            q5jValue=2;
        else //if("Three or more times a week".equals(result.get(13)))
            q5jValue=3;

        total5 = q5bValue+q5cValue+q5dValue+q5eValue+q5fValue+q5gValue+q5hValue+q5iValue+q5jValue;

        if(total5==0)
            comp5=0;
        else if(total5>0 && total5<=9)
            comp5=1;
        else if(total5>9 && total5<=18)
            comp5=2;
        else if(total5>18 && total5<=27)
            comp5=3;


        //Component 6
        if ("Not during the past month".equals(result.get(14)))
            comp6=0;
        else if("Less than once a week".equals(result.get(14)))
            comp6=1;
        else if("Once or twice a week".equals(result.get(14)))
            comp6=2;
        else //if("Three or more times a week".equals(result.get(14)))
            comp6=3;


        //Component 7
        int q7value,q8value,total7;
        if ("Not during the past month".equals(result.get(15)))
            q7value=0;
        else if("Less than once a week".equals(result.get(15)))
            q7value=1;
        else if("Once or twice a week".equals(result.get(15)))
            q7value=2;
        else //if("Three or more times a week".equals(result.get(15)))
            q7value=3;

        if ("Not during the past month".equals(result.get(16)))
            q8value=0;
        else if("Less than once a week".equals(result.get(16)))
            q8value=1;
        else if("Once or twice a week".equals(result.get(16)))
            q8value=2;
        else //if("Three or more times a week".equals(result.get(16)))
            q8value=3;

        total7 = q7value + q8value;
        if(total7==0)
            comp7 = 0;
        else if(total7>0 && total7<=2)
            comp7 = 1;
        else if(total7>2 && total7<=4)
            comp7 = 2;
        else if(total7>4 && total7<=6)
            comp7 = 3;

        score = comp1+comp2+comp3+comp4+comp5+comp6+comp7;
        Intent i = new Intent(this,showScore.class);
        i.putExtra("SCORE",score);
        startActivity(i);
    }
}