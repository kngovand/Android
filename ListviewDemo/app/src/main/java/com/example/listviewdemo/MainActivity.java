package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> array = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Mary", "John", "Pong"));

        FloatingActionButton button = findViewById(R.id.fab);

        ListView listView = findViewById(R.id.listView);

        // add all names to primary array
        for(String name : names) {
            array.add(name);
        }

        // instantiate and plugging in array
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);

        listView.setAdapter(arrayAdapter);


        button.setOnClickListener(new FloatingActionButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("tag","i clicked!");
            }
        });


 /*       final ListView listView = findViewById(R.id.ListView);

        final ArrayList<String> myArray = new ArrayList<>();

        myArray.add("john");
        myArray.add("mary");
        myArray.add("cody");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myArray);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.i("tag", "position " + position);

                myArray.remove(position);

                listView.setAdapter(arrayAdapter);
            }
        });*/





    }
}
