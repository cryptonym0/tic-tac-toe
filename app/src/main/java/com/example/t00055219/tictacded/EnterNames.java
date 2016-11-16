package com.example.t00055219.tictacded;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import static com.example.t00055219.tictacded.PlayGame.filled;

public class EnterNames extends AppCompatActivity {

    //Create Variabls
    EditText p1Input, p2Input;
    ImageButton ap1, bp1, cp1, dp1, ep1, ap2, bp2, cp2, dp2, ep2;
    String p1="", p2="", p1Saved="", p2Saved="";
    String p1c="", p2c="";
    Toast g;

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
        g = Toast.makeText(getApplicationContext(), "Choose A Different Character", Toast.LENGTH_SHORT);

        findViewById(R.id.ap1).setOnClickListener(selectChar);
        findViewById(R.id.bp1).setOnClickListener(selectChar);
        findViewById(R.id.cp1).setOnClickListener(selectChar);
        findViewById(R.id.dp1).setOnClickListener(selectChar);
        findViewById(R.id.ep1).setOnClickListener(selectChar);
        findViewById(R.id.ap2).setOnClickListener(selectChar);
        findViewById(R.id.bp2).setOnClickListener(selectChar);
        findViewById(R.id.cp2).setOnClickListener(selectChar);
        findViewById(R.id.dp2).setOnClickListener(selectChar);
        findViewById(R.id.ep2).setOnClickListener(selectChar);

        //Character Buttons
        ap1 = (ImageButton)findViewById(R.id.ap1);
        bp1 = (ImageButton)findViewById(R.id.bp1);
        cp1 = (ImageButton)findViewById(R.id.cp1);
        dp1 = (ImageButton)findViewById(R.id.dp1);
        ep1 = (ImageButton)findViewById(R.id.ep1);
        ap2 = (ImageButton)findViewById(R.id.ap2);
        bp2 = (ImageButton)findViewById(R.id.bp2);
        cp2 = (ImageButton)findViewById(R.id.cp2);
        dp2 = (ImageButton)findViewById(R.id.dp2);
        ep2 = (ImageButton)findViewById(R.id.ep2);

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

    private View.OnClickListener selectChar = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            ImageButton btn = (ImageButton)v;
            switch (btn.getId()) {
                //Player 1 Select
                case R.id.ap1: {
                    if (p2c == "ap") {
                        g.show();
                    } else {
                        restP1Char();
                        ap1.setBackgroundResource(R.drawable.char_a_win);
                        p1c = "ap";
                        pickSounds(p1c);
                    }
                    break;
                }
                case R.id.bp1: {
                    if (p2c == "bp") {
                        g.show();
                    } else {
                        p1c = "bp";
                        restP1Char();
                        bp1.setBackgroundResource(R.drawable.char_b_win);
                        pickSounds(p1c);
                    }
                    break;
                }
                case R.id.cp1: {
                    if (p2c == "cp") {
                        g.show();
                    } else {
                        p1c = "cp";
                        restP1Char();
                        cp1.setBackgroundResource(R.drawable.char_c_win);
                        pickSounds(p1c);
                    }
                    break;
                }
                case R.id.dp1: {
                    if (p2c == "dp") {
                        g.show();
                    } else {
                        p1c = "dp";
                        restP1Char();
                        dp1.setBackgroundResource(R.drawable.char_d_win);
                        pickSounds(p1c);
                    }
                    break;
                }
                case R.id.ep1: {
                    if (p2c == "ep") {
                        g.show();
                    } else {
                        p1c = "ep";
                        restP1Char();
                        ep1.setBackgroundResource(R.drawable.char_e_win);
                        pickSounds(p1c);
                    }
                    break;
                }
                //Player 2 Select
                case R.id.ap2: {
                    if (p1c == "ap") {
                        g.show();
                    } else {
                        p2c = "ap";
                        restP2Char();
                        ap2.setBackgroundResource(R.drawable.char_a_win);
                        pickSounds(p2c);
                    }
                    break;
                }
                case R.id.bp2: {
                    if (p1c == "bp") {
                        g.show();
                    } else {
                        p2c = "bp";
                        restP2Char();
                        bp2.setBackgroundResource(R.drawable.char_b_win);
                        pickSounds(p2c);
                    }
                    break;
                }
                case R.id.cp2: {
                    if (p1c == "cp") {
                        g.show();
                    } else {
                        p2c = "cp";
                        restP2Char();
                        cp2.setBackgroundResource(R.drawable.char_c_win);
                        pickSounds(p2c);
                    }
                    break;
                }
                case R.id.dp2: {
                    if (p1c == "dp") {
                        g.show();
                    } else {
                        p2c = "dp";
                        restP2Char();
                        dp2.setBackgroundResource(R.drawable.char_d_win);
                        pickSounds(p2c);
                    }
                    break;
                }
                case R.id.ep2: {
                    if (p1c == "ep") {
                        g.show();
                    } else {
                        p2c = "ep";
                        restP2Char();
                        ep2.setBackgroundResource(R.drawable.char_e_win);
                        pickSounds(p2c);
                    }
                    break;
                }


            }
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

    public void restP1Char(){
        ap1.setBackgroundResource(R.drawable.char_a_neutral);
        bp1.setBackgroundResource(R.drawable.char_b_neutral);
        cp1.setBackgroundResource(R.drawable.char_c_neutral);
        dp1.setBackgroundResource(R.drawable.char_d_neutral);
        ep1.setBackgroundResource(R.drawable.char_e_neutral);
    }

    public void restP2Char(){
        ap2.setBackgroundResource(R.drawable.char_a_neutral);
        bp2.setBackgroundResource(R.drawable.char_b_neutral);
        cp2.setBackgroundResource(R.drawable.char_c_neutral);
        dp2.setBackgroundResource(R.drawable.char_d_neutral);
        ep2.setBackgroundResource(R.drawable.char_e_neutral);
    }

    //Put stuff in shared preferences
    public void shareMe(){
        editor.putString("p1", p1);
        editor.putString("p2", p2);
        editor.putString("p1c", p1c);
        editor.putString("p2c", p2c);
        editor.apply();
    }

    //Start game
    public void startGame(){
        Intent gameIntent = new Intent(EnterNames.this, PlayGame.class);
        startActivity(gameIntent);
        finish();//Close this activity
    }
    public void pickSounds(String myGuy){
        final MediaPlayer a1pick = MediaPlayer.create(this, R.raw.elypick2);
        final MediaPlayer b1pick = MediaPlayer.create(this, R.raw.matpick1);
        final MediaPlayer c1pick = MediaPlayer.create(this, R.raw.charpick1);
        final MediaPlayer d1pick = MediaPlayer.create(this, R.raw.dypick);
        final MediaPlayer e1pick = MediaPlayer.create(this, R.raw.ellpick1);
        if(myGuy=="ap"){a1pick.start();}
        if(myGuy=="bp"){b1pick.start();}
        if(myGuy=="cp"){c1pick.start();}
        if(myGuy=="dp"){d1pick.start();}
        if(myGuy=="ep"){e1pick.start();}
    }
}
