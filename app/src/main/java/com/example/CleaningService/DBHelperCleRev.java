package com.example.CleaningService;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperCleRev extends SQLiteOpenHelper {
    public DBHelperCleRev( Context context) {
        super(context, "CleRevDaata.db",null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
      DB.execSQL("create Table cleRdata(cleanerName TEXT primary key, customerName TEXT , reviewbyCleaner TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists cleRdata");

    }

    public Boolean insertclerevdata(String cleanerName, String customerName, String reviewbyCleaner)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cleanerName",cleanerName);
        contentValues.put("customerName",customerName);
        contentValues.put("reviewbyCleaner" ,reviewbyCleaner);
        Long result = DB.insert("cleRdata",null,contentValues);
        if (result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Cursor  getCleRevData()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from cleRdata", null);
        return cursor;
    }
}
