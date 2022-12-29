package com.example.CleaningService;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperCusRev extends SQLiteOpenHelper {
    public DBHelperCusRev(Context context ) {
        super(context, "CusRevData.db" , null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
    DB.execSQL("create Table CusRdata (customerName TEXT primary key, cleanerName TEXT, reviewbyCustomer TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
    DB.execSQL("drop Table if exists CusRdata");
    }


    public  Boolean insertcusrevdata(String customerName, String cleanerName, String reviewbyCustomer)
    {
        SQLiteDatabase DB =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("customerName",customerName);
        contentValues.put("cleanerName",cleanerName);
        contentValues.put("reviewbyCustomer",reviewbyCustomer);
        Long result = DB.insert("CusRdata", null,contentValues);
        if (result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Cursor getCusRevData ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from cusRdata", null);
        return cursor;
    }

}
