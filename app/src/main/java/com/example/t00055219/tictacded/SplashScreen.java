package com.example.t00055219.tictacded;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final MediaPlayer splashme = MediaPlayer.create(this, R.raw.chargo2);
        splashme.start();
        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent startMain = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(startMain);
                }//finally
            }//run
        };//timerThread
        timerThread.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }

}
