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
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> names = new ArrayList<>(Arrays.asList("Mary", "John", "Pong"));
        final ArrayList<String> array = new ArrayList<>();

        FloatingActionButton button = findViewById(R.id.fab);

        final ListView listView = findViewById(R.id.listView);

        // add all names to primary array
        for(String name : names) {
            array.add(name);
        }

        // instantiate and plugging in array
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);

        listView.setAdapter(arrayAdapter);

        // for removing item in array on click
        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("tag","listview item clicked!");

                array.remove(position);
                listView.setAdapter(arrayAdapter);
            }
        });

        button.setOnClickListener(new FloatingActionButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("tag","fab clicked!");

                int rnd = new Random().nextInt(names.size());
                array.add(names.get(rnd));

                // refresh adapter to show new names
                listView.setAdapter(arrayAdapter);

            }
        });
    }
}
