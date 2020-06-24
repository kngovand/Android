package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void onConvert(View view) {
        double rate = 0.884204; // as of 6/23/2020
        double result = 0;
        String resultString = "";

        EditText text = findViewById(R.id.text2);
        result = Double.parseDouble(text.getText().toString()) * rate;
        resultString = "In euros: " + result;

        Toast.makeText(getApplicationContext(), resultString, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
