package com.example.foodwaste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class CustomerOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_order);

        Intent intent = getIntent();
        System.out.println("Transfered Data"+ intent.getParcelableExtra("menuList"));
        //intent.getBundleExtra("menuList");


    }
}