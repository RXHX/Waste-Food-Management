package com.example.foodwaste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        databaseHelper=new DatabaseHelper(this);
        EditText username=findViewById(R.id.userId);
        EditText password=findViewById(R.id.newpass);
        EditText repassword=findViewById(R.id.reenterpass);

        Button btnSubmit=findViewById(R.id.submt);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            String Id;
            boolean isUpdated;
            @Override
            public void onClick(View v) {





                if(username.getText().toString().equals("") && password.getText().toString().equals("") && repassword.getText().toString().equals(""))
                {
                    Toast.makeText(ForgotPassword.this,"All the Field are Empty",
                            Toast.LENGTH_LONG).show();
                }
                else if(username.getText().toString().equals(""))
                {
                    Toast.makeText(ForgotPassword.this,"UserName Field is Empty",
                            Toast.LENGTH_LONG).show();
                }
                else if(password.getText().toString().equals(""))
                {
                    Toast.makeText(ForgotPassword.this,"Password is Empty",
                            Toast.LENGTH_LONG).show();
                }
                else if(repassword.getText().toString().equals(""))
                {
                    Toast.makeText(ForgotPassword.this,"RePassword is Empty",
                            Toast.LENGTH_LONG).show();
                }
                else{
                    if(password.getText().toString().equals(repassword.getText().toString()))
                    {
                        Id = username.getText().toString();


                        if(password.getText().toString().length() < 8){
                            password.setError("password must be minimum 8 characters");
                            password.setText("");
                            repassword.setText("");

                        }
                        else {

                            isUpdated = databaseHelper.updatePassword(Id,password.getText().toString());
                            if(isUpdated){
                                Toast.makeText(ForgotPassword.this,"record is updated",
                                        Toast.LENGTH_LONG).show();
                                startActivity(new Intent(ForgotPassword.this,Login.class));
                            }
                            else
                            {
                                Toast.makeText(ForgotPassword.this,"Please Enter Correct Username",
                                        Toast.LENGTH_LONG).show();
                            }

                        }



                    }
                    else{


                        Toast.makeText(ForgotPassword.this,"Please type correct Password",Toast.LENGTH_LONG).show();
                    }


                }









            }
        });



    }
}