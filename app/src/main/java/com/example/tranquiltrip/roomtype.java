package com.example.tranquiltrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class roomtype extends AppCompatActivity {
    private Button booking1,booking2,booking3,booking4,booking5,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomtype);

        booking1 = findViewById(R.id.btnbook1);
        booking2 = findViewById(R.id.btnbook2);
        booking3 = findViewById(R.id.btnbook3);
        booking4 = findViewById(R.id.btnbook4);
        booking5 = findViewById(R.id.btnbook5);
        back = findViewById(R.id.btnback);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(roomtype.this,SecondActivity.class));
            }
        });

        booking1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(roomtype.this,Booking.class));
            }
        });
        booking2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(roomtype.this,Booking.class));
            }
        });
        booking3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(roomtype.this,Booking.class));
            }
        });
        booking4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(roomtype.this,Booking.class));
            }
        });
        booking5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(roomtype.this,Booking.class));
            }
        });
    }
}