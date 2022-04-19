package com.example.tranquiltrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfirmActivity extends AppCompatActivity {
    TextView FullName, PhoneNo, RoomType, Date, Guest, Total;
    private FirebaseAuth firebaseauth;
    private FirebaseDatabase firebaseDatabase;
    Button Confirm;
    String iFullName, iPhoneNo, iRoomType, iGuest, iDate, iTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        firebaseauth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        FullName = findViewById(R.id.tvFullName);
        PhoneNo = findViewById(R.id.tvPhoneNo);
        RoomType = findViewById(R.id.tvRoomType);
        Date = findViewById(R.id.tvDate);
        Guest = findViewById(R.id.tvGuest);
        Total = findViewById(R.id.tvTotal);
        Confirm = findViewById(R.id.btnConfirm);

        iFullName = getIntent().getStringExtra("keyfullname");
        iPhoneNo = getIntent().getStringExtra("keyphoneno");
        iRoomType = getIntent().getStringExtra("keyroomtype");
        iDate = getIntent().getStringExtra("keydate");
        iGuest = getIntent().getStringExtra("keyguest");

        FullName.setText(iFullName);
        PhoneNo.setText(iPhoneNo);
        RoomType.setText(iRoomType);
        Date.setText(iDate);
        Guest.setText(iGuest);

        calculateRoomPrice(iRoomType);
        Total.setText(iTotal);

        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference databaseReference = firebaseDatabase.getReference("Booking Details").child(firebaseauth.getUid());
                ConfirmBooking confirmBooking = new ConfirmBooking(iFullName, iPhoneNo, iRoomType, iDate, iGuest, iTotal);
                databaseReference.setValue(confirmBooking);
                Toast.makeText(ConfirmActivity.this,"Booking Successful",Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(ConfirmActivity.this, SecondActivity.class));
            }
        });


    }

    public void calculateRoomPrice (String iRoomType){
        this.iRoomType = iRoomType;
        if (iRoomType.equals("Single Bedroom")){
            iTotal = "RM 120";
        }else if(iRoomType.equals("Single")){
            iTotal = "RM 120";
        }else if(iRoomType.equals("single bedroom")){
            iTotal = "RM 120";
        }else if(iRoomType.equals("single")){
            iTotal = "RM 120";
        }else if(iRoomType.equals("Double Bedroom")){
            iTotal = "RM 213";
        }else if(iRoomType.equals("double bedroom")){
            iTotal = "RM 213";
        }else if(iRoomType.equals("Double")){
            iTotal = "RM 213";
        }else if(iRoomType.equals("double")){
            iTotal = "RM 213";
        }else if(iRoomType.equals("King Bedroom")){
            iTotal = "RM 240";
        }else if(iRoomType.equals("king bedroom")) {
            iTotal = "RM 240";
        }else if(iRoomType.equals("King")) {
            iTotal = "RM 240";
        }else if(iRoomType.equals("king")){
                iTotal = "RM 240";
        }else if(iRoomType.equals("Quad Bedroom")) {
            iTotal = "RM 288";
        }else if(iRoomType.equals("quad bedroom")){
                iTotal = "RM 288";
        }else if(iRoomType.equals("Quad")){
            iTotal = "RM 288";
        }else if(iRoomType.equals("quad")){
            iTotal = "RM 288";
        }else if(iRoomType.equals("Family Room")) {
            iTotal = "RM 315";
        }else if(iRoomType.equals("family room")) {
            iTotal = "RM 315";
        }else if(iRoomType.equals("Family")) {
            iTotal = "RM 315";
        }else if(iRoomType.equals("family")) {
            iTotal = "RM 315";
        }
    }
}