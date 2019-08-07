package com.example.hasiya_mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserProfile extends AppCompatActivity {
    Button editProfile,myad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        editProfile = findViewById(R.id.edit_profile);
        myad = findViewById(R.id.myads);
    }

    @Override
    protected void onResume() {
        super.onResume();

        editProfile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent editp = new Intent(UserProfile.this,ModifyUser.class);
                startActivity(editp);
            }
        });

        myad.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent editp = new Intent(UserProfile.this,MyAds.class);
                startActivity(editp);
            }
        });
    }
}
