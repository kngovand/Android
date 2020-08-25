package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    public void chooseAnswer(View view) {
        // testing input
        Toast.makeText(this,"hi", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView sumTextView = findViewById(R.id.sumTextView);

        Random rand = new Random();

        // max of 21
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        //sumTextView.setText(a + " + " + b);
    }
}
