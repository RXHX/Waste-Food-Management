package com.example.foodwaste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileCustomer extends AppCompatActivity {
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_customer);
        EditText hobbies = findViewById(R.id.edTxtHobbies);
        EditText favoriteFood = findViewById(R.id.edTxtFavFood);
        TextView profileName = findViewById(R.id.txtNameProfile);
        Button goNext = findViewById(R.id.btnNextProfileCustomer);
        databaseHelper = new DatabaseHelper(this);
       Intent intent = getIntent();
       String[] userStore = {intent.getStringExtra("username")};
        Cursor c = databaseHelper.getProfileInfo(userStore);

        if(c.getCount() >0)
        {
            for(int i=0; c.moveToNext() != false; i++)
            {
                System.out.println("Column 1"+c.getString(i));
                profileName.setText(c.getString(0));

            }
        }

        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userHobbies = hobbies.getText().toString();
                String userFood = favoriteFood.getText().toString();
                String currentUser = profileName.getText().toString();

                Intent intent = new Intent(ProfileCustomer.this,ProfileCustomer2.class);
                intent.putExtra("user",currentUser);
                intent.putExtra("food",userFood);
                intent.putExtra("hobbies",userHobbies);
                startActivity(intent);


            }
        });

        }
    }

