package com.example.foodwaste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

public class SoldOrder extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sold_order);
        DatabaseHelper  databaseHelper = new DatabaseHelper(this);
        Cursor c = databaseHelper.getOrderInfo();
        recyclerView = findViewById(R.id.recyclerView3);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new OrderAdapter(c.getCount());
        recyclerView.setAdapter(adapter);
    }
}