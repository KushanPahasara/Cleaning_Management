package com.example.CleaningService;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CleanerReview extends AppCompatActivity {
    EditText cleanerName, customerName,reviewbyCleaner;
    Button btnAddR, btnViewR;
    DBHelperCleRev DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaner_review);

        cleanerName = findViewById(R.id.cleanerName1);
        customerName = findViewById(R.id.customerName1);
        reviewbyCleaner = findViewById(R.id.reviewbyCleaner);
        btnAddR =findViewById(R.id.btnAddR1);
        btnViewR= findViewById(R.id.btnViewR1);
        DB = new DBHelperCleRev(this);

        btnViewR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CleanerReview.this,CLeRevList.class));
            }
        });

        btnAddR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cleanerNameTXT = cleanerName.getText().toString();
                String customerNameTXT = customerName.getText().toString();
                String reviewbyCleanerTXT = reviewbyCleaner.getText().toString();

                Boolean checkinsertdata = DB.insertclerevdata(cleanerNameTXT,customerNameTXT,reviewbyCleanerTXT);
                if (checkinsertdata==true)
                {
                    Toast.makeText(CleanerReview.this,"New Cleaner Review Added" ,Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(CleanerReview.this,"Cleaner Review Not Added" ,Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}