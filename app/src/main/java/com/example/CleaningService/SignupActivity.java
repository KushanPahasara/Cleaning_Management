package com.example.CleaningService;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    EditText name, passw,email;
    Button signupbtn;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name =findViewById(R.id.txtsname);
        passw =findViewById(R.id.txtspass);
        email = findViewById(R.id.txtsemail);
        Spinner mySpinner = (Spinner) findViewById(R.id.spinnerUserType);
        //userType = findViewById(R.id.txtConPass);
        signupbtn = findViewById(R.id.btnsignup);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(SignupActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        preferences = getSharedPreferences("Userinfo",0);
        signupbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String usernamevalue = name.getText().toString();
                String passwordvalue = passw.getText().toString();
                String emailvalue = email.getText().toString();
              //String userTypevalue = userType.getText().toString();
                String userTypeValue = mySpinner.getSelectedItem().toString();

                if(usernamevalue.length()>1) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("name", usernamevalue);
                    editor.putString("passw", passwordvalue);
                    editor.putString("email", emailvalue);
                    //editor.putString("userType",userTypevalue);
                    editor.putString("mySpinner",userTypeValue);
                    editor.apply();
                    Toast.makeText(SignupActivity.this, userTypeValue, Toast.LENGTH_SHORT).show();

                     //if(userTypeValue == "Customer"){
                        Intent i = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                  // }
                    /*else
                    {
                        Intent i = new Intent(getApplicationContext(),CustomerHomeData.class);
                        startActivity(i);
                    }
*/


                }else{
                    Toast.makeText(SignupActivity.this, "Please enter the values", Toast.LENGTH_SHORT).show();
                }


            }
        });





    }
}