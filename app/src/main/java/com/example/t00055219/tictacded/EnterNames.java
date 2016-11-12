package com.example.t00055219.tictacded;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class EnterNames extends AppCompatActivity {

    //Create Variabls
    EditText p1Input, p2Input;
    ImageButton ap1, bp1, cp1, dp1, ep1, ap2, bp2, cp2, dp2, ep2;
    String p1Output="", p2Output="", p1Saved="", p2Saved="";

    //Shared Preferences
    SharedPreferences values;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_names);

        p1Input = (EditText)findViewById(R.id.p1EnterName);
        p2Input = (EditText)findViewById(R.id.p2EnterName);
        findViewById(R.id.saveNameBtn).setOnClickListener(saveNames);

    }

    private View.OnClickListener saveNames = new View.OnClickListener(){
        @Override
        public void onClick(View v){

        }
    };
    //
}
