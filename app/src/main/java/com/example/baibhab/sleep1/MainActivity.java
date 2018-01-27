package com.example.baibhab.sleep1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void initialButtonOnClick(View view) {
        Intent i = new Intent(this, home.class);
        startActivity(i);
    }

    public void changePasswordButtonOnClick(View V) {
        Intent i = new Intent(this, CreatePasswordActivity.class);
        startActivity(i);
    }
}