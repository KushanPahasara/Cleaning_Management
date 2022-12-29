package com.example.CleaningService;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Appointment extends AppCompatActivity {

    EditText cusName, jobType, cusContact, jobDate, jobTime, noRooms, noBrooms, floorType;
    Button btnapadd,btnapdelete,btnapupdate,btnapview;

    Calendar calendar=Calendar.getInstance();
    DBHelperJobData DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        cusName = findViewById(R.id.txtcusName);
        jobType = findViewById(R.id.txtjobType);
        cusContact =findViewById(R.id.txtconNumber);
        jobDate = findViewById(R.id.txtjobDate);
        jobTime = findViewById(R.id.txtjobTime);
        noRooms =findViewById(R.id.txtnumofRooms);
        noBrooms = findViewById(R.id.txtnumofBrooms);
        floorType = findViewById(R.id.txtFloorType);
     /*   Spinner floorType = (Spinner) findViewById(R.id.spinnerUserType);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Appointment.this,
        android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.floorType));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        floorType.setAdapter(myAdapter);
*/


        btnapadd = findViewById(R.id.btnappadd);
        btnapdelete = findViewById(R.id.btnappdelete);
        btnapupdate = findViewById(R.id.btnappupdate);
        btnapview = findViewById(R.id.btnappview);
        DB= new DBHelperJobData(this);

        DatePickerDialog.OnDateSetListener listener =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                GettDate();
            }
        };

        jobDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Appointment.this,listener,calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        jobTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute= calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog;



                timePickerDialog = new TimePickerDialog(v.getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        jobTime.setText(hourOfDay +":"+minute);
                    }
                },hour,minute,true);
                timePickerDialog.setTitle("Select Appointment time");
                timePickerDialog.show();
                    }


        });




        btnapadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cusNameTXT = cusName.getText().toString();
                String jobTypeTXT = jobType.getText().toString();
                String cusContactTXT = cusContact.getText().toString();
                String DateTXT = jobDate.getText().toString();
                String timeTXT = jobTime.getText().toString();
                String nofRoomsTXT = noRooms.getText().toString();
                String noBroomsTXT = noBrooms.getText().toString();
                String floorTypeTXT = floorType.getText().toString();



                Boolean checkinsertdata = DB.insertappdata(cusNameTXT,jobTypeTXT,cusContactTXT, DateTXT,timeTXT, nofRoomsTXT, noBroomsTXT, floorTypeTXT);

                if(checkinsertdata==true){
                    Toast.makeText(Appointment.this,"New Appointment Added",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Appointment.this,"New Appointment not Added",Toast.LENGTH_SHORT).show();
                }
            }
        });



        btnapupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cusNameTXT = cusName.getText().toString();
                String jobTypeTXT = jobType.getText().toString();
                String cusContactTXT = cusContact.getText().toString();
                String DateTXT = jobDate.getText().toString();
                String timeTXT = jobTime.getText().toString();
                String nofRoomsTXT = noRooms.getText().toString();
                String noBroomsTXT = noBrooms.getText().toString();
                String floorTypeTXT = floorType.getText().toString();



                Boolean checkupdatedata = DB.updateappdata(cusNameTXT,jobTypeTXT,cusContactTXT, DateTXT,timeTXT, nofRoomsTXT, noBroomsTXT, floorTypeTXT);

                if(checkupdatedata==true){
                    Toast.makeText(Appointment.this,"New Appointment Added",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Appointment.this,"New Appointment not Added",Toast.LENGTH_SHORT).show();
                }


            }
        });




        btnapdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cusNameTXT = cusName.getText().toString();
                Boolean checkdeletedata = DB.deleteappdata(cusNameTXT);

                if(checkdeletedata==true){
                    Toast.makeText(Appointment.this," Appointment Deleted",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Appointment.this," Appointment not Deleted",Toast.LENGTH_SHORT).show();
                }
            }
        });



       /* btnapview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.getappdata();
                if(res.getCount()==0)
                {
                    Toast.makeText(Appointment.this,"List Empty",Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Customer Name :" + res.getString(0)+"\n");
                    buffer.append("Job Type :" + res.getString(1)+"\n");
                    buffer.append("Customer Contact Number :" + res.getString(2)+"\n");
                    buffer.append("Jon Date:" + res.getString(3)+"\n");
                    buffer.append("JOb Time :" + res.getString(4)+"\n");
                    buffer.append("No of Rooms :" + res.getString(5)+"\n");
                    buffer.append("No of Bathrooms :" + res.getString(6)+"\n");
                    buffer.append("Floor Type :" + res.getString(7)+"\n\n");

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(Appointment.this);
                builder.setCancelable(true);
                builder.setTitle("Job Informations");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });
*/

        btnapview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ViewJob       .class);
                startActivity(i);
            }
        });

            }





    private void GettDate() {
        String date = "dd/MM/yyyy";
        SimpleDateFormat format = new SimpleDateFormat(date, Locale.UK);
        jobDate.setText(format.format(calendar.getTime()));
    }
}