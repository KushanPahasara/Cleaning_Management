package com.example.CleaningService;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomerReview extends AppCompatActivity {
    EditText customerName, cleanerName, reviewbyCustomer;
    Button btnAddr, btnViewR;
    DBHelperCusRev DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_review);
        customerName = findViewById(R.id.customerName);
        cleanerName = findViewById(R.id.cleanerName);
        reviewbyCustomer = findViewById(R.id.reviewbyCustomer);
        btnAddr = findViewById(R.id.btnAddR);
        btnViewR = findViewById(R.id.btnViewR);

        DB = new DBHelperCusRev(this);


        btnViewR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CustomerReview.this,CusRevList.class));
            }
        });
        btnAddr.setOnClickListener(new View.OnClickListener() {
            private Object CustomerReview;

            @Override
            public void onClick(View view) {
                String customerNameTXT = customerName.getText().toString();
                String cleanerNameTXT = cleanerName.getText().toString();
                String reviewbyCustomerTXT = reviewbyCustomer.getText().toString();

                Boolean checkinsertdata = DB.insertcusrevdata(customerNameTXT, cleanerNameTXT, reviewbyCustomerTXT);
                if (checkinsertdata==true)
                {
                    Toast.makeText(CustomerReview.this,"New Review added",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(CustomerReview.this,"Not added",Toast.LENGTH_LONG).show();
                }


            }
        });


    }
}