package com.example.hasiya_mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddItem extends AppCompatActivity {

    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        b1 = findViewById(R.id.seller1);
        b2 = findViewById(R.id.addcart);
    }
    protected void onResume() {
        super.onResume();

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view1) {
                Intent save = new Intent(AddItem.this,ViewSellerDetails.class);
                startActivity(save);
            }
        });

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view2) {
                Intent cart = new Intent(AddItem.this,Cart.class);
                startActivity(cart);
            }
        });

    }

}
