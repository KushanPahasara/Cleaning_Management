package com.example.CleaningService;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.CleaningService.R;

import java.util.ArrayList;

public class ViewJob extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> cusName, jobType, conNumber, jobDate, jobTime, noRooms, noBrooms, floorType;
    DBHelperJobData DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.activity_view_job));

        DB = new DBHelperJobData(this);
        cusName = new ArrayList<>();
        jobType = new ArrayList<>();
        conNumber = new ArrayList<>();
        jobDate = new ArrayList<>();
        jobTime = new ArrayList<>();
        noRooms = new ArrayList<>();
        noBrooms = new ArrayList<>();
        floorType = new ArrayList<>();


        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this,cusName,jobType,conNumber,jobDate,jobTime,noRooms,noBrooms,floorType);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
        

    }

    private void  displaydata()
    {
        Cursor cursor = DB.getappdata();
        if (cursor.getCount()==0)
        {
            Toast.makeText(ViewJob.this,"No Entry Exists", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                cusName.add(cursor.getString(0));
                jobType.add(cursor.getString(1));
                conNumber.add(cursor.getString(2));
                jobDate.add(cursor.getString(3));
                jobTime.add(cursor.getString(4));
                noRooms.add(cursor.getString(5));
                noBrooms.add(cursor.getString(6));
                floorType .add(cursor.getString(7));





            }
        }
    }




}