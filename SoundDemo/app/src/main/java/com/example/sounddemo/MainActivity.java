package com.example.sounddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    public void play(View view) {
        TextView view1 = (TextView) findViewById(R.id.textView);
        mediaPlayer.start();
        view1.setText("Tu tu tu tu");
    }

    public void pause(View view) {
        TextView view1 = (TextView) findViewById(R.id.textView);
        mediaPlayer.pause();
        view1.setText("It's quiet here...");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.tutu);
    }
}
