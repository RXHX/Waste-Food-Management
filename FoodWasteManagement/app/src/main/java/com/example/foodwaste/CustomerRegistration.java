package com.example.foodwaste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class CustomerRegistration extends AppCompatActivity {
    DatabaseHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_registration);
        dbh=new DatabaseHelper(this);
        EditText uName=findViewById(R.id.editTextTextPersonName);
        EditText pass=findViewById(R.id.editTextTextPassword);
        EditText fullName=findViewById(R.id.editTextTextPersonName2);
        EditText DOB=findViewById(R.id.editTextDate);





    }
}