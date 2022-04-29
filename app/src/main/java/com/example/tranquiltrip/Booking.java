package com.example.tranquiltrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Booking extends AppCompatActivity {
    EditText FullName, PhoneNo, RoomType, Date, Guest;
    Button Submit;
    ImageButton back;
    String[] roomtype = {
            "Single Bedroom",
            "Double Bedroom",
            "King Bedroom",
            "Quad Bedroom",
            "Family Bedroom",
    };

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
        back = findViewById(R.id.btnbackdashboard);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();

            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, roomtype);
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.etRoomType);
        textView.setThreshold(1);
        textView.setAdapter(adapter);


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