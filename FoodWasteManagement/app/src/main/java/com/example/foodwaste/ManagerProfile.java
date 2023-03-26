package com.example.foodwaste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManagerProfile extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_profile);
        databaseHelper=new DatabaseHelper(this);
        Button addOrRemove =  findViewById(R.id.btnAddremove);

        addOrRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userIntent = getIntent();
                String[] currentUser  = {userIntent.getStringExtra("UserName")};
                Cursor c = databaseHelper.getLoggedUserInfo(currentUser);
                StringBuilder str = new StringBuilder();
                String RestaurantName = "";
                String RestaurantLocation = "";
                String UserName = "";
                if(c.getCount()>0){
                    while(c.moveToNext()) {
                         UserName = c.getString(0);
                         RestaurantName = c.getString(4);
                        RestaurantLocation = c.getString(5);

                    }
                    }
              Intent intent = new Intent(ManagerProfile.this,ManagerInventory.class);

                intent.putExtra("RestaurantName",RestaurantName);

                intent.putExtra("RestaurantLocation",RestaurantLocation);


                intent.putExtra("UserName",UserName);
                    System.out.println("Restaurant UserName:"+userIntent);
                    System.out.println("Restaurant Name:"+RestaurantName);
                     System.out.println("Restaurant Location:"+RestaurantLocation);
               startActivity(intent);


            }
        });
    }
}