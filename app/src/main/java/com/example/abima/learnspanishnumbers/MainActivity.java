package com.example.abima.learnspanishnumbers;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void playSound(View view){
        int ID = view.getId();
        String resource = view.getResources().getResourceEntryName(ID);
        int identifier = getResources().getIdentifier(resource,"raw","com.example.abima.learnspanishnumbers");

        mediaPlayer = MediaPlayer.create(this,identifier);

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mp) {
                if (mp != null)
                    mp.start();
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }

}
