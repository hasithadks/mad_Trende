package com.example.hasiya_mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    Button home,signup;
    TextView forgotpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        home = findViewById(R.id.loginbtn);
        signup = findViewById(R.id.signupbtn);
        forgotpass = findViewById(R.id.forgot);

    }

    @Override
    protected void onResume() {
        super.onResume();

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent save = new Intent(Login.this, MainActivity.class);
                startActivity(save);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent save = new Intent(Login.this, SignUp.class);
                startActivity(save);
            }
        });

        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent save = new Intent(Login.this, ForgotPassword.class);
                startActivity(save);
            }
        });
    }
}
