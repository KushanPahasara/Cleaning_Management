package com.example.CleaningService;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperJobData extends SQLiteOpenHelper {
    public DBHelperJobData( Context context) {
        super(context, "Cleaning.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table AppointmentData (cusName TEXT primary key, jobType TEXT, conNumber TEXT, jobDate TEXT, jobtime TEXT," +
                "noRooms TEXT, noBrooms TEXT, floorType TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {

        DB.execSQL("drop Table if exists AppointmentData");
    }

    public Boolean insertappdata (String cusName, String jobType, String conNumber, String jobData, String jobTime, String noRooms,
                                  String noBrooms, String floorType)
    {
        SQLiteDatabase DB =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cusName",cusName);
        contentValues.put("jobType",jobType);
        contentValues.put("conNumber",conNumber);
        contentValues.put("jobDate",jobData);
        contentValues.put("jobTime",jobTime);
        contentValues.put("noRooms",noRooms);
        contentValues.put("nobRooms",noBrooms);
        contentValues.put("floorType",floorType);
        long result = DB.insert("AppointmentData", null, contentValues);
        if (result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }



    public Boolean updateappdata (String cusName, String jobType, String conNumber, String jobData, String jobTime, String noRooms,
                                  String noBrooms, String floorType) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("jobType", jobType);
        contentValues.put("conNumber", conNumber);
        contentValues.put("jobDate", jobData);
        contentValues.put("jobTime", jobTime);
        contentValues.put("noRooms", noRooms);
        contentValues.put("nobRooms", noBrooms);
        contentValues.put("floorType", floorType);

        Cursor cursor = DB.rawQuery("Select * from AppointmentData where cusName = ?", new String[]{cusName});
        if (cursor.getCount() > 0) {

            long result = DB.update("AppointmentData", contentValues, "cusName=?", new String[]{cusName});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else
        {
        return  false;
        }
    }
    public Boolean deleteappdata (String cusName) {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from AppointmentData where cusName = ?", new String[]{cusName});
        if (cursor.getCount() > 0) {

            long result = DB.delete("AppointmentData",  "cusName=?", new String[]{cusName});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else
        {
            return  false;
        }
    }

    public Cursor getappdata() {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from AppointmentData",null);
        return cursor;
    }



}


