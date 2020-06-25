package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;

    TextView view1 = findViewById(R.id.textView);

    ImageView image1 = findViewById(R.id.imageView1);
    ImageView image2 = findViewById(R.id.imageView2);
    ImageView image3 = findViewById(R.id.imageView3);
    ImageView image4 = findViewById(R.id.imageView4);
    ImageView image5 = findViewById(R.id.imageView5);
    ImageView image6 = findViewById(R.id.imageView6);
    ImageView image7 = findViewById(R.id.imageView7);
    ImageView image8 = findViewById(R.id.imageView8);
    ImageView image9 = findViewById(R.id.imageView9);

    public void dropIn(View view) {

        Log.i("Tag","dropIn method called.");

        ImageView counter = (ImageView)(view);

        if(activePlayer == 0) {
            Log.i("Tag","White");
            counter.setImageResource(R.drawable.chess_white);
            view1.setText("Black turn.");
            activePlayer = 1;
        }

        else {
            Log.i("Tag","Black");
            counter.setImageResource(R.drawable.chess_black);
            view1.setText("White turn.");
            activePlayer = 0;
        }
    }

    public void onReset(View view) {

        Log.i("Tag","onReset method called.");

        activePlayer = 0;

        image1.setImageResource(0);
        image2.setImageResource(0);
        image3.setImageResource(0);
        image4.setImageResource(0);
        image5.setImageResource(0);
        image6.setImageResource(0);
        image7.setImageResource(0);
        image8.setImageResource(0);
        image9.setImageResource(0);

        view1.setText("Reset! White turn.");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
