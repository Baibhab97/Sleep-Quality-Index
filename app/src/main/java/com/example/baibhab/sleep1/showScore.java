package com.example.baibhab.sleep1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class showScore extends AppCompatActivity {

    int score;
    TextView showScoreResult_var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);

        Bundle extras = getIntent().getExtras();
        score = extras.getInt("SCORE");

        showScoreResult_var = (TextView)findViewById(R.id.showScoreResult);
        showScoreResult_var.setText(String.valueOf(score));
    }

    public void gotoHomeButtonOnClick(View v){
        Intent i = new Intent(this,home.class);
        startActivity(i);
    }
}
