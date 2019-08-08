package com.example.hasiya_mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheakOut extends AppCompatActivity {
Button b1;
    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_cheak_out);
        b1 = findViewById(R.id.pay);
    }

    protected void onResume() {
        super.onResume();

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view1) {
                Intent save = new Intent(CheakOut.this,Payment.class);
                startActivity(save);
            }
        });

    }
}
