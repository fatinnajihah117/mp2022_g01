package com.example.tranquiltrip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InvoiceActivity extends AppCompatActivity {

    private TextView FName, PNo, RType, Dte, TGuest, Price;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        FName = findViewById(R.id.tvFname);
        PNo = findViewById(R.id.tvPnumber);
        RType = findViewById(R.id.tvRtype);
        Dte = findViewById(R.id.tvDte);
        TGuest = findViewById(R.id.tvTguest);
        Price = findViewById(R.id.tvPrce);
        back = findViewById(R.id.backbtntodashboard);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InvoiceActivity.this, SecondActivity.class));
            }
        });

        DatabaseReference databaseReference = firebaseDatabase.getReference("Booking Details").child(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ConfirmBooking confirmBooking = snapshot.getValue(ConfirmBooking.class);
                FName.setText(confirmBooking.getFullName());
                PNo.setText(confirmBooking.getPhoneNo());
                RType.setText(confirmBooking.getRoomType());
                Dte.setText(confirmBooking.getDate());
                TGuest.setText(confirmBooking.getGuest());
                Price.setText(confirmBooking.getTotal());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(InvoiceActivity.this, error.getCode(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}