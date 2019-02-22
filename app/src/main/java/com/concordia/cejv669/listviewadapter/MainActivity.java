package com.concordia.cejv669.listviewadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final List<Integer> myList = new ArrayList<>();
        final ArrayAdapter<Integer> itemAdapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,myList);

        final List<String> myStrList = new ArrayList<>();
        final ArrayAdapter<String> itemStrAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myStrList);


        Button b = findViewById(R.id.button4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myList.add((int)(Math.random()*100));
                itemAdapter.notifyDataSetChanged();

                ListView lv = findViewById(R.id.listview_result);
                lv.setAdapter(itemAdapter);

            }
        });

        Button b2 = findViewById(R.id.button5);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                char c = (char)(r.nextInt(26) + 'a');
                myStrList.add(String.valueOf(c));
                itemAdapter.notifyDataSetChanged();

                ListView lv = findViewById(R.id.listview_result);
                lv.setAdapter(itemStrAdapter);

            }
        });

        Button sort = findViewById(R.id.button6);

        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemAdapter.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1-o2;
                    }
                });
            }
        });





/*        List<String> myList = new ArrayList<>();

        myList.add("One");
        myList.add("Two");
        myList.add("Three");

       ArrayAdapter<String> itemAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myList);
        ListView lv = findViewById(R.id.listview_result);
       lv.setAdapter(itemAdapter);*/
    }
}
