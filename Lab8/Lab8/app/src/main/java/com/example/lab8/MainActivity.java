package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer=null;
    }

    public void Music(View view) {

        switch (view.getId()){

            case R.id.Play:
            {
                if(mediaPlayer==null){

                    mediaPlayer=MediaPlayer.create(this,R.raw.samplemusic);
                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        StopMusic();
                    }
                });
                mediaPlayer.start();
                break;
            }

            case R.id.Pause:{

                mediaPlayer.pause();
                break;
            }

            case R.id.Stop:{
                mediaPlayer.stop();
                StopMusic();
            }
        }

    }

    public void StopMusic(){
        mediaPlayer.release();
        mediaPlayer=null;
    }
}