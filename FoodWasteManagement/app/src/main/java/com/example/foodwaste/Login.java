package com.example.foodwaste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        databaseHelper=new DatabaseHelper(this);
        EditText username=findViewById(R.id.edTxtUserName);
        EditText password=findViewById(R.id.edTxtPassword);
        Button btnLogin=findViewById(R.id.btnLogin);
        Button btnForgot=findViewById(R.id.btnForgot);
        Button btnSignCust=findViewById(R.id.btnSignCust);
        Button btnSignManager=findViewById(R.id.btnSignManager);

        btnSignCust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,CustomerRegistration.class));
            }
        });
        btnSignManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,ManagerRegistration.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,CustomerProfile.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = databaseHelper.checkLogin();
                StringBuilder str = new StringBuilder();
                if(c.getCount()>0){
                    while(c.moveToNext()){
                 System.out.println(c.getString(1));
                 System.out.println(c.getString(2));
                 System.out.println(c.getString(3));
                        if(c.getString(1).equals(username.getText().toString()) && c.getString(2).equals(password.getText().toString()))
                        {
                           if(c.getString(3).equals("Manager"))
                           {
                             startActivity(new Intent(Login.this,ManagerProfile.class));
                           }
                           else if(c.getString(3).equals("Customer")){
                             startActivity(new Intent(Login.this,CustomerProfile.class));
                           }
                           else {
                               System.out.println("error");
                           }
                        }
                        else {
                        System.out.println("Invalid Credentials");
                        }
                    }

                }
                else{

                }
                c.close();

            }
        });


    }
}