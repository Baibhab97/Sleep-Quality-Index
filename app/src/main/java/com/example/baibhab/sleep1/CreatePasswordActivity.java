package com.example.baibhab.sleep1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePasswordActivity extends AppCompatActivity {

    EditText etNewPassword_var,etConfirmNewPassword_var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);

        etNewPassword_var = (EditText)findViewById(R.id.etNewPassword);
        etConfirmNewPassword_var = (EditText)findViewById(R.id.etConfirmNewPassword);

    }

    public void confirmCreatePasswordButtonOnClick(View v) {
        String text1 = etNewPassword_var.getText().toString();
        String text2 = etConfirmNewPassword_var.getText().toString();

        if(text1.equals("") || text2.equals("")) {
            Toast.makeText(CreatePasswordActivity.this,"No Password Entered!!",Toast.LENGTH_SHORT).show();
        }
        else {
            if(text1.equals(text2)) {
                SharedPreferences settings = getSharedPreferences("PREFS",0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("password",text1);
                editor.apply();

                Intent i = new Intent(CreatePasswordActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
            else {
                Toast.makeText(CreatePasswordActivity.this,"Passwords doesn't Match!!",Toast.LENGTH_SHORT).show();
            }
        }
    }
}