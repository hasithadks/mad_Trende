package com.example.hasiya_mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Payment extends AppCompatActivity {
    private Button btn;
    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_payment);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Payment.this, "Payment Success..", Toast.LENGTH_SHORT).show();
                openActivity2();

            }

        });
    }
        public void openActivity2(){
            Intent j = new Intent(this, PaymentComplete.class);
            startActivity(j);
        }
    }
