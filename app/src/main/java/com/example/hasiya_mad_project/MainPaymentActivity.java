package com.example.hasiya_mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainPaymentActivity extends AppCompatActivity {

    private Button vwButton , ManageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_payment);

        vwButton = findViewById(R.id.ViewPayments);
        ManageButton = findViewById(R.id.managePayments);

        vwButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainPaymentActivity.this, "Accessing Data", Toast.LENGTH_SHORT).show();

                Intent fav_intent = new Intent(MainPaymentActivity.this,viewPaymentDetails.class);
                startActivity(fav_intent);
            }
        });


        ManageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent fav_intent = new Intent(MainPaymentActivity.this,Payment.class);
                startActivity(fav_intent);
            }
        });
    }


}
