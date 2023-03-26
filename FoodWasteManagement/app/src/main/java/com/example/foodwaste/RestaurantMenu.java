package com.example.foodwaste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class RestaurantMenu extends AppCompatActivity {


    int position=0;

    ArrayList<HashMap<String,String>> aList1 = null;


    public ArrayList createMenu(int position)
    {


        ArrayList<HashMap<String,String>> aList1 = new ArrayList<HashMap<String,String>>();


        if(position == 0)
        {
            String [] description0 = { "A","B"};
            int [] images0 = {R.drawable.burger,R.drawable.fries};
            for (int i =0;  i<description0.length; i++)
            {
                HashMap<String,String> hm = new HashMap<>();
                hm.put("txt",description0[i]);
                hm.put("images",Integer.toString(images0[i]));
                aList1.add(hm);
            }

        }else if(position == 1)
        {
            String [] description1 = { "C","D"};
            int [] images1 = {R.drawable.burger,R.drawable.fries};
            for (int i =0;  i<description1.length; i++)
            {
                HashMap<String,String> hm = new HashMap<>();
                hm.put("txt",description1[i]);
                hm.put("images",Integer.toString(images1[i]));
                aList1.add(hm);
            }


        }else if(position == 2)
        {
            String [] description2 = { "E","F"};
            int [] images2 = {R.drawable.burger,R.drawable.fries};
            for (int i =0;  i<description2.length; i++)
            {
                HashMap<String,String> hm = new HashMap<>();
                hm.put("txt",description2[i]);
                hm.put("images",Integer.toString(images2[i]));
                aList1.add(hm);
            }
        }else if(position == 3)
        {
            String [] description3 = { "G","H"};
            int [] images3 = {R.drawable.burger,R.drawable.fries};
            for (int i =0;  i<description3.length; i++)
            {
                HashMap<String,String> hm = new HashMap<>();
                hm.put("txt",description3[i]);
                hm.put("images",Integer.toString(images3[i]));
                aList1.add(hm);
            }

        }else if(position == 4)
        {


            String [] description4 = { "I","J"};
            int [] images4 = {R.drawable.burger,R.drawable.fries};
            for (int i =0;  i<description4.length; i++)
            {
                HashMap<String,String> hm = new HashMap<>();
                hm.put("txt",description4[i]);
                hm.put("images",Integer.toString(images4[i]));
                aList1.add(hm);
            }

        }






  return aList1;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_menu);


        Intent intent = getIntent();
        int position = intent.getIntExtra("pos",-1);

        System.out.println("position is"+position);


        ArrayList<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();



        switch (position)
        {
            case 0:
                     aList = createMenu(position);
                     break;
            case 1: aList = createMenu(position);
                    break;
            case 2:  aList = createMenu(position);
                          break;
            case 3:    aList = createMenu(position);
                         break;
            case 4:   aList = createMenu(position);
                      break;
            default: break;

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
