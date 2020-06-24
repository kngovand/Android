package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void onClick(View view) {
        EditText text = findViewById(R.id.editText);
        int number = Integer.parseInt(text.getText().toString());
        int guessedNumber = (int)(Math.random()*20);

        if(number == guessedNumber) {
            Toast.makeText(
                    getApplicationContext(), "Congrats you guessed right! Number = " + number, Toast.LENGTH_LONG).show();
        }

        else {
            Toast.makeText(
                    getApplicationContext(), "Try again... Correct Number = " + guessedNumber, Toast.LENGTH_LONG).show();

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
