package com.example.foodwaste;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import java.util.ArrayList;
import java.util.HashMap;

public class CustomerOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_order);
        ArrayList<Menu> menu = (ArrayList<Menu>) getIntent().getSerializableExtra("MenuItem");
        ArrayList<HashMap<String,String>> aList =
                new ArrayList<HashMap<String,String>>();
        String[] ItemName =  new String[menu.size()];
        String[] ItemQty = new String[menu.size()];
        String[] ItemPrice = new String[menu.size()];


         for(int i=0;i<menu.size();i++)
         {

             ItemName[i] = menu.get(i).itemName;
             ItemQty[i] = menu.get(i).Qty;
             ItemPrice[i] = menu.get(i).price;

         }


        for(int i=0;i<menu.size();i++)
         {
             HashMap<String,String> hashMap = new HashMap<>();
              hashMap.put("name",ItemName[i]);
              hashMap.put("qty",ItemQty[i]);
              hashMap.put("price",ItemPrice[i]);
             aList.add(hashMap);

         }

        String[] from = {"name","qty","price"};
        int[] to = {R.id.ItemName,R.id.ItemQty,R.id.ItemPrice};

        System.out.println("List:"+aList);

        SimpleAdapter adapter = new SimpleAdapter(CustomerOrder.this,
                aList,R.layout.bill_generation,from,to);

        ListView listView = findViewById(R.id.listview);

        listView.setAdapter(adapter);




    }
}