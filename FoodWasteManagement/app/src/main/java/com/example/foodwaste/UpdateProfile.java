package com.example.foodwaste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateProfile extends AppCompatActivity {
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        databaseHelper=new DatabaseHelper(this);
        RadioGroup rGroup = findViewById(R.id.rGroup);
        RadioButton rdb_Yes = findViewById(R.id.rdb_Yes);
        RadioButton rdb_No = findViewById(R.id.rdb_No);
        Button btn_update = findViewById(R.id.btn_update);
        EditText hobbies = findViewById(R.id.hobbies);
        EditText favouriteFood = findViewById(R.id.favouriteFood);
        EditText studentOrganization = findViewById(R.id.studentOrganization);
        EditText studentID = findViewById(R.id.studentID);
        Intent getUsername = getIntent();


        String shoutUser = getIntent().getStringExtra("username");
        

       


     
        btn_update.setOnClickListener(new View.OnClickListener() {

            boolean isInserted;
            @Override
            public void onClick(View v) {
                RadioButton rdb_Yes = findViewById(R.id.rdb_Yes);
                RadioButton rdb_No = findViewById(R.id.rdb_No);
                String aStudent = null;
                if(rdb_Yes.isChecked())
                {
                    aStudent = "Yes";
                }
                else if(rdb_No.isChecked())
                {
                    aStudent = "No";
                }
                isInserted = databaseHelper.updateProfile(shoutUser,hobbies.getText().toString(),favouriteFood.getText().toString(), aStudent,studentOrganization.getText().toString(),studentID.getText().toString());


                if(isInserted) {
                    Toast.makeText(UpdateProfile.this, "data added", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
