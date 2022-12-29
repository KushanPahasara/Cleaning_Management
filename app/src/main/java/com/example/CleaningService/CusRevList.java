package com.example.CleaningService;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class CusRevList extends AppCompatActivity {
        RecyclerView recyclerView;
        ArrayList customerName, cleanerName, reviewbyCustomer;
        DBHelperCusRev DB;
        CustomerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus_rev_list);
        DB = new DBHelperCusRev(this);
        customerName = new ArrayList<>();
        cleanerName= new ArrayList<>();
        reviewbyCustomer = new ArrayList<>();
        recyclerView = findViewById(R.id.customerRecyclerview);
        adapter = new CustomerAdapter(this,customerName,cleanerName,reviewbyCustomer);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        displayData();
    }

    private void displayData() {

        Cursor cursor = DB.getCusRevData();
        if (cursor.getCount()==0)
        {
            Toast.makeText(CusRevList.this, "No Entry Exists",Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                customerName.add(cursor.getString(0));
                cleanerName.add(cursor.getString(1));
                reviewbyCustomer.add(cursor.getString(2 ));
            }


        }

    }
}