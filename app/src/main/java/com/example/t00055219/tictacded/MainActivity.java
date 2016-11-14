package com.example.t00055219.tictacded;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.support.v4.app.FragmentManager;
import android.util.Log;


import static android.R.attr.data;

public class MainActivity extends AppCompatActivity implements MenuListFragmentA.OnFragmentInteractionListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view){
        Intent start = new Intent(MainActivity.this, PlayGame.class);
        startActivity(start);
    }
    @Override
    public void onFragmentInteraction(String data) {
        FragmentManager FragManager = getSupportFragmentManager();
        MenuListFragmentA frag = (MenuListFragmentA) FragManager.findFragmentById(R.id.fragment);
        Log.d("Fragment Interaction", "Fragments Should Interact");
    }
}

