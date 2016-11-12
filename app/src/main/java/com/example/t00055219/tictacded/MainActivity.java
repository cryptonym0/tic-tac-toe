package com.example.t00055219.tictacded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.FragmentManager;

import android.util.Log;
import android.widget.TextView;
import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity implements MenuListFragmentA.OnFragmentInteractionListener{

    //Create Buttons
    Button start_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create Buttons
//        start_ = (Button) findViewById(R.id.startButton);

    }

    public void start(View view){
        Intent start = new Intent(MainActivity.this, PlayGame.class);
        startActivity(start);
    }
    @Override
    public void onFragmentInteraction(Uri data) {
        FragmentManager FragManager = getSupportFragmentManager();

        Log.d("Fragment Interaction", "Fragments Should Interact");
    }
}

