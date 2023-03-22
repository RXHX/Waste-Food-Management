package com.example.foodwaste;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class RestaurantMenu extends AppCompatActivity {

    String [] description = { "Burger","Fries"};
    int [] images = {R.drawable.burger,R.drawable.fries};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_menu);

        ArrayList<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
        for (int i =0;  i<description.length; i++)
        {
            HashMap<String,String>hm = new HashMap<>();
            hm.put("txt",description[i]);
            hm.put("images",Integer.toString(images[i]));
            aList.add(hm);
        }

        String from [] = {"images","txt"};
        int to [] = {R.id.itemImage,R.id.txtDescription};

        SimpleAdapter adapter = new SimpleAdapter(RestaurantMenu.this,aList,R.layout.menulist_container,from,to);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:

                        break;
                    case 1:

                        break;
                }
            }
        });
    }

}
