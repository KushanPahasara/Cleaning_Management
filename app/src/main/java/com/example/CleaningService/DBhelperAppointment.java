package com.example.CleaningService;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelperAppointment extends SQLiteOpenHelper {
    public DBhelperAppointment(@Nullable Context context) {
        super(context, "appoin.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table JobInfo(cusName TEXT primary key, jobType TEXT, cusContact TEXT, jobDate TEXT, jobTime TEXT, noRomms TEXT, noBrooms TEXT, floorType Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop Table if exists JobInfo");

    }


    public Boolean insertAppointment(String cusName,String jobType, String cusContact, String jobDate,String jobTime, String noRooms, String noBrooms, String floorType){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cusName",cusName);
        contentValues.put("jobType",jobType);
        contentValues.put("cusContact",cusContact);
        contentValues.put("jobDate", jobDate);
        contentValues.put("jobTtime", jobTime);
        contentValues.put("noRooms" , noRooms);
        contentValues.put("noBrooms",noBrooms);
        contentValues.put("floorType",floorType);

        long answer = DB.insert("JobInfo",null,contentValues);
        if(answer == -1){
            return false;
        }else{
            return true;
        }




    }




    public Boolean updateAppointment(String cusName,String jobType, String cusContact, String jobDate,String jobTime, String noRooms, String noBrooms, String floorType){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cusName",cusName);
        contentValues.put("jobType",jobType);
        contentValues.put("cusContact",cusContact);
        contentValues.put("jobDate", jobDate);
        contentValues.put("jobTtime", jobTime);
        contentValues.put("noRooms" , noRooms);
        contentValues.put("noBrooms",noBrooms);
        contentValues.put("floorType",floorType);

        Cursor cursor = DB.rawQuery("Select * from JobInfo where cusName =?", new String[]{cusName});



        if(cursor.getCount()>0) {

            long answer = DB.update("JobInfo", contentValues, "cusName=?", new String[]{cusName});

            if (answer == -1) {
                return false;
            } else {
                return true;
            }

        }else{
            return false;
        }



    }



    public Boolean deleteAppointment(String cusName){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();



        Cursor cursor = DB.rawQuery("Select * from JobInfo where cusName =?", new String[]{cusName});



        if(cursor.getCount()>0) {

            long answer = DB.delete("JobInfo", "cusName=?", new String[]{cusName});

            if (answer == -1) {
                return false;
            } else {
                return true;
            }

        }else{
            return false;
        }



    }



    public  Cursor ViewdataAppointment(){
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor =DB.rawQuery("Select * from JobInfo",null);
        return cursor;

    }




}

