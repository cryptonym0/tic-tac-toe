package com.example.t00055219.tictacded;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Create Buttons
    Button start_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create Buttons
        start_ = (Button) findViewById(R.id.startButton);

    }

    public void start(View view){
        Intent start = new Intent(MainActivity.this, PlayGame.class);
        startActivity(start);
    }

}

