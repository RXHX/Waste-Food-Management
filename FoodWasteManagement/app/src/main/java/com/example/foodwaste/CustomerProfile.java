package com.example.foodwaste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CustomerProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile);
        Button search_For_Restaurant = findViewById(R.id.btnsearchRestaurant);
        Button edit_profile = findViewById(R.id.btnupdate);
        String userName = "";
        Intent getUsername = getIntent();
        if (getUsername != null) {
            String title = getUsername.getStringExtra("username");
            userName = title;
            Toast.makeText(CustomerProfile.this, "logged in as " + title, Toast.LENGTH_SHORT).show();


            search_For_Restaurant.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(CustomerProfile.this, CustomerSearchForRestaurant.class));
                }

            });

            String finalUserName = userName;
            edit_profile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(CustomerProfile.this,UpdateProfile.class);
                    intent.putExtra("username", finalUserName);
                    startActivity(intent);

                }


            });
        }
    }
}