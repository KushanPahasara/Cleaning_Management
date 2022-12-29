package com.example.CleaningService;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CleanerHomeData extends AppCompatActivity {
    Button btnaddReview, btnviewJob, btnviewReview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaner_home_data);
        btnviewJob= findViewById(R.id.btnViewJob);
        btnaddReview = findViewById(R.id.btnAddReview);
        btnviewReview = findViewById(R.id.btnviewReview);

        btnviewJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ViewJob.class);
                startActivity(intent);
            }
        });

        btnaddReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(getApplicationContext(),CleanerReview.class);
                startActivity(intent);
            }
        });

        btnviewReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CusRevList.class);
                startActivity(intent);
            }
        });


    }
}