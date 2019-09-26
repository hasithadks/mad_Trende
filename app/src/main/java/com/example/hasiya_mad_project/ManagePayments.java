package com.example.hasiya_mad_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
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

import java.util.ArrayList;
import java.util.List;

public class ManagePayments extends AppCompatActivity {

    private Spinner namespn;
    DatabaseReference dbRef;
    Button btnUpdate , delbutton;
    TextView cardn;
    paymentDBClass pc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_payments);

        dbRef = FirebaseDatabase.getInstance().getReference().child("paymentDBClass");
        namespn = findViewById(R.id.namespinner2);
        cardn = findViewById(R.id.cardnum2);
        btnUpdate = findViewById(R.id.updatePayments);
        delbutton = findViewById(R.id.deletePayments);

        pc = new paymentDBClass();

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



                ArrayAdapter<String> arryadapter = new ArrayAdapter<String>(ManagePayments.this, android.R.layout.simple_spinner_item,nameless);
                arryadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                namespn.setAdapter(arryadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(ManagePayments.this,databaseError.getMessage(),Toast.LENGTH_LONG).show();
            }
        });


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try
                {

                    if(TextUtils.isEmpty(cardn.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Please Enter a card number", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        String selected = namespn.getSelectedItem().toString();
                        dbRef= FirebaseDatabase.getInstance().getReference().child("paymentDBClass").child(selected);

                        pc.setCname(selected);
                        pc.setCno(cardn.getText().toString());
                        pc.setCvcNo("123");

                        dbRef.setValue(pc);
                        Toast.makeText(getApplicationContext(),"Data Updated",Toast.LENGTH_SHORT).show();
                        clearControls();
                    }
                }
                catch (Exception ex)
                {
                    System.out.println(ex);
                }
            }
        });

        delbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef= FirebaseDatabase.getInstance().getReference().child("paymentDBClass");
                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        dbRef = FirebaseDatabase.getInstance().getReference().child("paymentDBClass").child(namespn.getSelectedItem().toString());
                        dbRef.removeValue();
                        clearControls();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

    }

    private void clearControls()
    {
        cardn = findViewById(R.id.cardnum2);
        cardn.setText("");
    }
}
