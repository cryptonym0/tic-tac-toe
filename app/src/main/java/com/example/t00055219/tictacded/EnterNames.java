package com.example.t00055219.tictacded;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class EnterNames extends AppCompatActivity {

    //Create Variabls
    EditText p1Input, p2Input;
    ImageButton ap1, bp1, cp1, dp1, ep1, ap2, bp2, cp2, dp2, ep2;
    String p1="", p2="", p1Saved="", p2Saved="";

    //Shared Preferences
    public static final String PREFS_NAME = "MyPreferenceFile";
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
            Button btn = (Button)v;
            //Shared Preferences
            values = getSharedPreferences(PREFS_NAME, 0);
            editor = values.edit();
            //Check current
            p1Saved = values.getString("p1", "Player 1");
            p2Saved = values.getString("p2", "Player 2");

            noValueCheckMe();
            resetCheckMe();
            shareMe();
            startGame();



        }
    };

    //See if no value was entered
    public void noValueCheckMe() {
        //See if no value was entered
        if(p1Input.getText().toString().length()==0){
            p1="Player 1";
        }else{
            p1=p1Input.getText().toString();
        }

        if (p2Input.getText().toString().length() == 0) {
            p2 = "Player 2";
        } else {
            p2 = p2Input.getText().toString();
        }
    }

    //Score Reset Check
    public void resetCheckMe(){
        if(!p1.equals(p1Saved) || !p2.equals(p2Saved)){
            editor.putString("p1w", "0");
            editor.putString("p2w", "0");
        }
    }


    //Put stuff in shared preferences
    public void shareMe(){
        editor.putString("p1", p1);
        editor.putString("p2", p2);
        editor.apply();
    }

    //Start game
    public void startGame(){
        Intent gameIntent = new Intent(EnterNames.this, PlayGame.class);
        startActivity(gameIntent);
        finish();//Close this activity
    }
}
