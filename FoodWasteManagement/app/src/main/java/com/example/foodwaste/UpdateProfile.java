package com.example.foodwaste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        Intent getUsername = getIntent();
        if (getUsername != null)
        {
            String shoutUser = getUsername.getStringExtra("username");
            Toast.makeText(UpdateProfile.this, "logged in as " + shoutUser, Toast.LENGTH_SHORT).show();

        }

    }
}