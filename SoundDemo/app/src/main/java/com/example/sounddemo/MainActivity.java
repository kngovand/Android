package com.example.sounddemo;

import androidx.appcompat.app.AppCompatActivity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    AudioManager audioManager;

    // play song
    public void play(View view) {
        TextView view1 = (TextView) findViewById(R.id.textView);
        mediaPlayer.start();
        view1.setText("!! Tu tu tu tu !!");
    }

    //pause song
    public void pause(View view) {
        TextView view1 = (TextView) findViewById(R.id.textView);
        mediaPlayer.pause();
        view1.setText("It's quiet in here...");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // need to grab system service or will crash
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        // values for volume control
        int maxVol = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        // grab mp3 file
        mediaPlayer = MediaPlayer.create(this, R.raw.tutu);

        SeekBar volume = findViewById(R.id.seekBar);

        // set volume values for seekbar
        volume.setMax(maxVol);
        volume.setProgress(currentVol);

        volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override

            // if seekbar touched
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("tag", Integer.toString(progress));

                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
