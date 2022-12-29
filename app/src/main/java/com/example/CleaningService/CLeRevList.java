package com.example.CleaningService;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class CLeRevList extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> cleanerName, customerName, reviewbyCleaner;
    DBHelperCleRev DB;
    CleanerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cle_rev_list);
        DB = new DBHelperCleRev(this);
        cleanerName = new ArrayList<>();
        customerName=new ArrayList<>();
        reviewbyCleaner = new ArrayList<>();
        recyclerView = findViewById(R.id.cleanerRecyclerview);
        adapter = new CleanerAdapter(this,cleanerName,customerName,reviewbyCleaner);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();


    }

    private void displaydata() {

        Cursor cursor = DB.getCleRevData();
        if(cursor.getCount()==0)
        {
            Toast.makeText(CLeRevList.this,"No Entry Exists",Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                cleanerName.add(cursor.getString(0));
                customerName.add(cursor.getString(1));
                reviewbyCleaner.add(cursor.getString(2));
            }
        }
    }
}