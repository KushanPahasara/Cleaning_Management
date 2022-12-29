package com.example.CleaningService;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomerHomeData extends AppCompatActivity {

    Button btnAddJob, btnAddReview, btnViewReview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home_data);
        btnAddJob = findViewById(R.id.btnAddJob);
        btnAddReview = findViewById(R.id.btnAReview);
        btnViewReview = findViewById(R.id.btnVReview);

        btnAddJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Appointment.class);
                startActivity(intent);
            }
        });
        btnAddReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CustomerReview.class);
                startActivity(intent);
            }
        });

        btnViewReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CLeRevList.class);
                startActivity(intent);
            }
        });




    }
}