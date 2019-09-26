package com.example.hasiya_mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Payment extends AppCompatActivity {
    private Button btn;
    EditText cardNo, cardName , cvcNum;
    Button calender;
    DatabaseReference dbRef;
    paymentDBClass pc;
    CalendarView simpleCalendarView;

    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_payment);


        btn = findViewById(R.id.button);
        cardNo = findViewById(R.id.cardnum);
        cardName= findViewById(R.id.name);
        simpleCalendarView = findViewById(R.id.paymentCal);
        cvcNum = findViewById(R.id.cvc);
        pc = new paymentDBClass();




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try
                {
                    if(TextUtils.isEmpty(cardNo.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Please Enter a card number", Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(cardName.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Please Enter a card Owner name", Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(cvcNum.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Please Enter a Security Code", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {

                        Toast.makeText(Payment.this, "Payment Success..", Toast.LENGTH_SHORT).show();
                        dbRef = FirebaseDatabase.getInstance().getReference().child("paymentDBClass");
                        pc.setCno(cardNo.getText().toString().trim());
                        pc.setCname(cardName.getText().toString().trim());
                        pc.getCvcNo(cvcNum.getText().toString().trim());

                        dbRef.push().setValue(pc);
                        Toast.makeText(getApplicationContext(),"Data saved Successfully.", Toast.LENGTH_SHORT).show();
                        clearControls();
                        openActivity2();
                    }


                }
                catch (Exception ex)
                {
                    Toast.makeText(getApplicationContext(),"Error : "+ex,Toast.LENGTH_SHORT).show();
                }



            }

        });


    }

    private void clearControls()
    {
        cardNo.setText("");
        cardName.setText("");
        cvcNum.setText("");

    }

    public void openActivity2(){
            Intent j = new Intent(this, PaymentComplete.class);
            startActivity(j);
        }
    }
