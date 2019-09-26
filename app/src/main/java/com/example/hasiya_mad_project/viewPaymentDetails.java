package com.example.hasiya_mad_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.security.PublicKey;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class viewPaymentDetails extends AppCompatActivity {


    private Spinner namespn;
    DatabaseReference dbRef;
    TextView cardno;
    Button viewCard;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_payment_details);

        dbRef = FirebaseDatabase.getInstance().getReference().child("paymentDBClass");
        namespn = findViewById(R.id.namespinner);
        viewCard = findViewById(R.id.loadResult);


        Query qr = dbRef.orderByChild("cname");


        qr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final List<String> nameless = new ArrayList<>();
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    String nm = dataSnapshot1.child("cname").getValue(String.class);
                    nameless.add(nm);
                }



                ArrayAdapter<String> arryadapter = new ArrayAdapter<String>(viewPaymentDetails.this, android.R.layout.simple_spinner_item,nameless);
                arryadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                namespn.setAdapter(arryadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(viewPaymentDetails.this,databaseError.getMessage(),Toast.LENGTH_LONG).show();
            }
        });


        viewCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("paymentDBClass").child(namespn.getSelectedItem().toString());

                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        cardno = findViewById(R.id.cardnumber);
                        cardno.setText(dataSnapshot.child("cno").getValue().toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(),"No Card Number to Display",Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });



    }
}
