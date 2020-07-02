package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int[] timeInSeconds = {0};

        final Button button = findViewById(R.id.startButton);
        final SeekBar seekBar = findViewById(R.id.seekBar);
        final TextView text = findViewById(R.id.textView);

        seekBar.setMax(1200);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("tag", "" + progress);

                // time conversions
                int minutes = (progress % 3600) / 60;
                int seconds = progress % 60;

                String time = String.format("%02d:%02d", minutes, seconds);
                text.setText(time);
                timeInSeconds[0] = progress;

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        button.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                seekBar.setEnabled(false);
                button.setText("Stop");

                int time = timeInSeconds[0];

                new CountDownTimer(time*1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                        int seconds = (int) millisUntilFinished / 1000;
                        int minutes = (seconds % 3600) / 60;

                        Log.i("Seconds", "" + seconds);

                        text.setText(String.format("%02d:%02d", minutes, seconds % 60));
                    }

                    @Override
                    public void onFinish() {
                        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.tutu);
                        mediaPlayer.start();

                        text.setText("Wow!");
                    }
                }.start();

            }
        });


    }
}
