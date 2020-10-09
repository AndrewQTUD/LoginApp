package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private TextView tvRemaingAttempts;
    private EditText etPassword;
    private EditText etName;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        tvRemaingAttempts = (TextView)findViewById(R.id.tvRemaingAttempts);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etName = (EditText) findViewById(R.id.etName);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(etName.getText().toString(), etPassword.getText().toString());
            }
        });

    }

    private void validate(String username, String password){
        counter = 5;
        if(username.equals("Andrew") && (password.equals("Twitter"))){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);


        }else{
            counter--;
            tvRemaingAttempts.append(String.valueOf(counter--));
            counter--;
            if(counter == 0) btnLogin.setEnabled(false);
    }
    }
}