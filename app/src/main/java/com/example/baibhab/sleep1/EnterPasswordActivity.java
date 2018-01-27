package com.example.baibhab.sleep1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EnterPasswordActivity extends AppCompatActivity {

    EditText etEnterPassword_var;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);

        SharedPreferences settings = getSharedPreferences("PREFS",0);
        password = settings.getString("password","");

        etEnterPassword_var = (EditText)findViewById(R.id.etEnterPassword);
    }

    public void enterPasswordButtonOnClick(View v) {
        String text = etEnterPassword_var.getText().toString();
        if(text.equals(password)){
            Intent i = new Intent(EnterPasswordActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }
        else {
            Toast.makeText(EnterPasswordActivity.this,"Wrong Password!!!",Toast.LENGTH_SHORT).show();
        }
    }
}