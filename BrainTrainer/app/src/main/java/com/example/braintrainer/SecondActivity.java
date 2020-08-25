package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    ArrayList<Integer> answers = new ArrayList<>();

    Random rand = new Random();
    int correctIndex = rand.nextInt(4);

    public void chooseAnswer(View view) {
        TextView answerTextView = findViewById(R.id.answerTextView);

        Log.i("tag", view.getTag().toString());

        if(view.getTag().toString().equals(String.valueOf(correctIndex)) ) {
            Toast.makeText(this, "yes", Toast.LENGTH_SHORT).show();
            answerTextView.setText("Correct!");
        }
        else {
            answerTextView.setText("Wrong!");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView sumTextView = findViewById(R.id.sumTextView);
        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);



        // max of 21
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        // random to 3 for placing correct answer in button position
        correctIndex = rand.nextInt(4);

        for (int i = 0; i < 4; i++) {
            if(i == correctIndex) {
                // for correct answer
                answers.add(a + b);
            }
            else {
                int wrongAnswer = rand.nextInt(41);
                // in case wrong answer accidentally rolled to right answer
                while(wrongAnswer == a + b) {
                    wrongAnswer = rand.nextInt(41);
                }
              // for wrong answers
              answers.add(rand.nextInt(41));
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }
}
