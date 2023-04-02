package com.example.foodwaste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CustomerProfile extends AppCompatActivity {

DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile);
        TextView userName = findViewById(R.id.loggedUser);
        Button logout = findViewById(R.id.btnLogOutuser);
        databaseHelper = new DatabaseHelper(this);
        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        String[] userInfo = {sh.getString("UserName","")};
        Cursor c = databaseHelper.getRegistrationInfo(userInfo);
        if(c.getCount() >0)
        {
            for(int i=0; c.moveToNext() != false; i++)
            {
                System.out.println("Column 1"+c.getString(i));
                 userName.setText(c.getString(2));
            }
        }
        Button search_For_Restaurant = findViewById(R.id.btnsearchRestaurant);
        Button order_history = findViewById(R.id.btnOrderHistory);
        search_For_Restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(new Intent(CustomerProfile.this,CustomerSearchForRestaurant.class));
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerProfile.this,Login.class));
            }
        });

        order_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(CustomerProfile.this,CustomerOrderReview.class));
            }
        });


    }
}