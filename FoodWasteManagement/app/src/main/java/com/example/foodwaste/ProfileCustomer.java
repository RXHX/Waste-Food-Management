package com.example.foodwaste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileCustomer extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_customer);
        TextView profileName = findViewById(R.id.txtNameProfile);
        databaseHelper = new DatabaseHelper(this);
        Intent intent = getIntent();
        //String [] username = {intent.getStringExtra("username")};
        String [] username = {"karlo"};

        Cursor c = databaseHelper.getProfileInfo(username);


        Toast.makeText(ProfileCustomer.this,c.getString(1),Toast.LENGTH_LONG);
    }
}