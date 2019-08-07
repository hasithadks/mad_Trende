package com.example.hasiya_mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModifyUser extends AppCompatActivity {
Button savechange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_user);
        savechange = findViewById(R.id.savechange);

    }

    @Override
    protected void onResume() {
        super.onResume();

        savechange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent save = new Intent(ModifyUser.this,UserProfile.class);
                startActivity(save);
            }
        });
}
}
