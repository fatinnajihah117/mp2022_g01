package com.example.tranquiltrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Booking extends AppCompatActivity {
    EditText FullName, PhoneNo, RoomType, Date, Guest;
    Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        Submit = findViewById(R.id.btnSubmit);
        FullName = findViewById(R.id.etFullName);
        PhoneNo = findViewById(R.id.etPhoneNo);
        Date = findViewById(R.id.etDate);
        Guest = findViewById(R.id.etGuest);
        RoomType = findViewById(R.id.etRoomType);

        Submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String iFullName = FullName.getText().toString();
                String iPhoneNo = PhoneNo.getText().toString();
                String iRoomType = RoomType.getText().toString();
                String iDate = Date.getText().toString();
                String iGuest = Guest.getText().toString();

                Intent intent = new Intent(Booking.this, ConfirmActivity.class);
                intent.putExtra("keyfullname", iFullName);
                intent.putExtra("keyphoneno", iPhoneNo);
                intent.putExtra("keydate", iDate);
                intent.putExtra("keyguest", iGuest);
                intent.putExtra("keyroomtype", iRoomType);
                startActivity(intent);
            }
        });

    }
}