package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0; // 0 - white, 1 - black, 2 - null
    boolean gameState = true;
    int[] board = {2,2,2,2,2,2,2,2,2}; // 3x3 grid, initialized to null values
    int[][] wins = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}}; // winning patterns

    // method when imageview on grid is clicked
    public void dropIn(View view) {

        Log.i("Tag","dropIn method called.");

        TextView view1 = findViewById(R.id.textView);

        ImageView image = (ImageView)(view);

        // white turn
        if(activePlayer == 0) {

            int counter = Integer.parseInt(image.getTag().toString());

            image.setImageResource(R.drawable.chess_white);

            board[counter] = 0;
            activePlayer = 1;

            Log.i("Tag","White, " + "board index: " + counter);

            view1.setText("Black turn.");
        }

        // black turn
        else {
            int counter = Integer.parseInt(image.getTag().toString());

            image.setImageResource(R.drawable.chess_black);

            board[counter] = 0;
            activePlayer = 0;

            Log.i("Tag","Black, " + "board index: " + counter);

            view1.setText("Black turn.");
        }

        // to check if grid has winning positions?
        for (int[] winningPosition : wins) {
            if(board[winningPosition[0]] == board[winningPosition[1]] && board[winningPosition[1]] == board[winningPosition[2]] && board[winningPosition[0]] != 2) {

                // white winner!
                if(activePlayer == 0) {
                    Log.i("Tag","array: " + Arrays.toString(winningPosition));

                    Toast.makeText(getApplicationContext(), "White has won!", Toast.LENGTH_LONG).show();
                    resetBoard();
                }

                else {
                    Log.i("Tag","array: " + Arrays.toString(winningPosition));

                    Toast.makeText(getApplicationContext(), "Black has won!", Toast.LENGTH_LONG).show();
                    resetBoard();
                }

                view1.setText("Click RESET to play again!");
            }
        }
    }

    // resets 3x3 grid by clearing imageviews and resets board array
    public void onReset(View view) {

        Log.i("Tag","onReset method called.");

        resetBoard();

        // androidx.gridlayout.widget.GridLayout gridLayout = findViewById(R.id.gridLayout);

        TextView view1 = findViewById(R.id.textView);

        // better way to loop through all imageviews
/*        for (int i = 0; i < gridLayout.getChildCount() ; i++) {
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }*/

        activePlayer = 0;

        view1.setText("Reset! White turn.");


        ImageView image1 = findViewById(R.id.imageView1);
        ImageView image2 = findViewById(R.id.imageView2);
        ImageView image3 = findViewById(R.id.imageView3);
        ImageView image4 = findViewById(R.id.imageView4);
        ImageView image5 = findViewById(R.id.imageView5);
        ImageView image6 = findViewById(R.id.imageView6);
        ImageView image7 = findViewById(R.id.imageView7);
        ImageView image8 = findViewById(R.id.imageView8);
        ImageView image9 = findViewById(R.id.imageView9);

        image1.setImageResource(0);
        image2.setImageResource(0);
        image3.setImageResource(0);
        image4.setImageResource(0);
        image5.setImageResource(0);
        image6.setImageResource(0);
        image7.setImageResource(0);
        image8.setImageResource(0);
        image9.setImageResource(0);
    }

    // resets board array to null values again
    public void resetBoard() {
        Log.i("Tag", "resetBoard method called");

        for (int i : board) {
            board[i] = 2; // to null value again
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
