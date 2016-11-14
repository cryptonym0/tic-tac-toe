package com.example.t00055219.tictacded;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import static com.example.t00055219.tictacded.R.id.currentPlayer;
import static com.example.t00055219.tictacded.R.id.p1Img;
import static com.example.t00055219.tictacded.R.id.p2Img;
import static com.example.t00055219.tictacded.R.string.p2;


public class PlayGame extends AppCompatActivity {

    //Player Names
    String p1Name = "Player 1";
    String p2Name = "Player 2";
    int p1Win =0, p2Win =0;
    String p1c="", p2c="";

    //Variables for current Player
    int turn = 1;
    TextView pCurrent;

    //Variables for current button
    int currentButton;
    //bool
    boolean win = false;

    //Toast
    private Toast g, h;

    //Array for board
    public static int[] filled = new int[9];
    ImageButton b[];


    //Make shared Preferences
    public static final String PREFS_NAME = "MyPreferenceFile";
    SharedPreferences values;
    SharedPreferences.Editor editor;

    //Player emotions
    ImageView p1Face, p2Face;
    int p1h, p1s, p1m, p1n, p2h, p2s, p2m, p2n;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        values = getSharedPreferences(PREFS_NAME, 0);
        editor = values.edit();

        //applies shared preferences values
        p1Name = values.getString("p1", "Player 1");
        p2Name= values.getString("p2", "Player 2");
        p1c = values.getString("p1c", "p1c");
        p2c = values.getString("p2c", "p2c");
        editor.apply();

        //Create Players
        Player player1 = new Player(PlayGame.this);
        Player player2 = new Player(PlayGame.this);
        player1.setEmotions(p1c);
        player2.setEmotions(p2c);
        p1h = player1.getHappy();
        p1s = player1.getSad();
        p1m = player1.getMad();
        p1n = player1.getNeutral();
        p2h = player2.getHappy();
        p2s = player2.getSad();
        p2m = player2.getMad();
        p2n = player2.getNeutral();
        p1Face = (ImageView) findViewById(p1Img);
        p2Face = (ImageView) findViewById(p2Img);


        g = Toast.makeText(getApplicationContext(), "You Can't Go There!", Toast.LENGTH_SHORT);
        h = Toast.makeText(getApplicationContext(), "Press Rest To Start A New Game", Toast.LENGTH_SHORT);

        //Players
        b = new ImageButton[9];
        pCurrent = (TextView)findViewById(currentPlayer);

        setOnClickListeners();
        reset();//Reset values
    }

    //Options action
    public View.OnClickListener optionAction = new View.OnClickListener(){
        @Override
        public void onClick(View arg0) {
            Button btn = (Button) arg0;

            switch (btn.getId()) {
                case R.id.btnR: {
                    Log.d("Reset Called", "RESET CASE");
                    reset();
                    break;
                }
                case R.id.scoresButton:{
                    Log.d("Scores Called", "Scores CASE");
                    Intent intent = new Intent(PlayGame.this, Scores.class);
                    startActivity(intent);
                    finish();
                    break;
                }
            }
        }
    };

    //Game Action handles gameplay
    //listener for which button on the game board was hit
    public View.OnClickListener gameAction = new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            ImageButton btn = (ImageButton) arg0;
            if(win){
                h.show();
            }
            else {

                switch (btn.getId()) {
                    //Button 1
                    case R.id.btn1: {
                        currentButton = 0;
                        if (filled[currentButton] != 0) {
                            g.show();
                        } else {
                            placeStar(btn);
                        }
                        break;
                    }
                    //Button 2
                    case R.id.btn2: {
                        currentButton = 1;
                        if (filled[currentButton] != 0) {
                            g.show();
                        } else {
                            placeStar(btn);
                        }
                        break;
                    }
                    //Button 3
                    case R.id.btn3: {
                        currentButton = 2;
                        if (filled[currentButton] != 0) {
                            g.show();
                        } else {
                            placeStar(btn);
                        }
                        break;
                    }
                    //Button 4
                    case R.id.btn4: {
                        currentButton = 3;
                        if (filled[currentButton] != 0) {
                            g.show();
                        } else {
                            placeStar(btn);
                        }
                        break;
                    }
                    //Button 5
                    case R.id.btn5: {
                        currentButton = 4;
                        if (filled[currentButton] != 0) {
                            g.show();
                        } else {
                            placeStar(btn);
                        }
                        break;
                    }
                    //Button 6
                    case R.id.btn6: {
                        currentButton = 5;
                        if (filled[currentButton] != 0) {
                            g.show();
                        } else {
                            placeStar(btn);
                        }
                        break;
                    }
                    //Button 7
                    case R.id.btn7: {
                        currentButton = 6;
                        if (filled[currentButton] != 0) {
                            g.show();
                        } else {
                            placeStar(btn);
                        }
                        break;
                    }
                    //Button 8
                    case R.id.btn8: {
                        currentButton = 7;
                        if (filled[currentButton] != 0) {
                            g.show();
                        } else {
                            placeStar(btn);
                        }
                        break;
                    }
                    //Button 9
                    case R.id.btn9: {
                        currentButton = 8;
                        if (filled[currentButton] != 0) {
                            g.show();
                        } else {
                            placeStar(btn);
                        }
                        break;
                    }
                }//Button Switch
            }
        }
    };//On click listener

    //Reset Function
    public void reset() {
        Log.d("Reset Called", "Test");
        ImageButton b1 = (ImageButton) findViewById(R.id.btn1);
        ImageButton b2 = (ImageButton) findViewById(R.id.btn2);
        ImageButton b3 = (ImageButton) findViewById(R.id.btn3);
        ImageButton b4 = (ImageButton) findViewById(R.id.btn4);
        ImageButton b5 = (ImageButton) findViewById(R.id.btn5);
        ImageButton b6 = (ImageButton) findViewById(R.id.btn6);
        ImageButton b7 = (ImageButton) findViewById(R.id.btn7);
        ImageButton b8 = (ImageButton) findViewById(R.id.btn8);
        ImageButton b9 = (ImageButton) findViewById(R.id.btn9);
        b1.setBackgroundResource(R.color.clearColor2);
        b2.setBackgroundResource(R.color.clearColor2);
        b3.setBackgroundResource(R.color.clearColor2);;
        b4.setBackgroundResource(R.color.clearColor2);
        b5.setBackgroundResource(R.color.clearColor2);
        b6.setBackgroundResource(R.color.clearColor2);
        b7.setBackgroundResource(R.color.clearColor2);
        b8.setBackgroundResource(R.color.clearColor2);
        b9.setBackgroundResource(R.color.clearColor2);
        p1Face.setImageResource(p1n);
        p2Face.setImageResource(p2n);
        //Reset Board
        populateBoard();

        //Close win
        win = false;
        //Set All Text Views
        if(turn == 1){
            pCurrent.setText("Current Player: " + p1Name);
        }
        else if(turn == 2) {
            pCurrent.setText("Current Player: " + p2Name);
        }
    }

    /*******************************************
    * Populate Board
    * ******************************************/
    public void populateBoard(){
        b[0] = (ImageButton) findViewById(R.id.btn1);
        b[1] = (ImageButton) findViewById(R.id.btn2);
        b[2] = (ImageButton) findViewById(R.id.btn3);
        b[3] = (ImageButton) findViewById(R.id.btn4);
        b[4] = (ImageButton) findViewById(R.id.btn5);
        b[5] = (ImageButton) findViewById(R.id.btn6);
        b[6] = (ImageButton) findViewById(R.id.btn7);
        b[7] = (ImageButton) findViewById(R.id.btn8);
        b[8] = (ImageButton) findViewById(R.id.btn9);
        for(int i=0; i<9; ++i){
            filled[i]=0;
        }

    }//End Populate Board


    /*******************************************
     * Set On Click Listener Method
     * ******************************************/
    public void setOnClickListeners(){
        findViewById(R.id.btn1).setOnClickListener(gameAction);
        findViewById(R.id.btn2).setOnClickListener(gameAction);
        findViewById(R.id.btn3).setOnClickListener(gameAction);
        findViewById(R.id.btn4).setOnClickListener(gameAction);
        findViewById(R.id.btn5).setOnClickListener(gameAction);
        findViewById(R.id.btn6).setOnClickListener(gameAction);
        findViewById(R.id.btn7).setOnClickListener(gameAction);
        findViewById(R.id.btn8).setOnClickListener(gameAction);
        findViewById(R.id.btn9).setOnClickListener(gameAction);
        findViewById(R.id.btnR).setOnClickListener(optionAction);
        findViewById(R.id.scoresButton).setOnClickListener(optionAction);

    }

    /*******************************************
     * Place star Method
     * ******************************************/
    public void placeStar(ImageButton btn){
        if(filled[currentButton] ==0){
            if(turn == 1){
                filled[currentButton] = 1;
                btn.setBackgroundResource(p1n);
                Log.d("IMG", ""+p1n);
                pCurrent.setText("Current Player: " + p2Name);
                checkWin(turn);
                turn = 2;
            }
            else if(turn == 2){
                filled[currentButton] = 2;
                btn.setBackgroundResource(p2n);
                pCurrent.setText("Current Player: " + p1Name);
                checkWin(turn);
                turn = 1;
            }else{
                Toast.makeText(getApplicationContext(), "You Can't Go There!", Toast.LENGTH_SHORT).show();
            }

        }
        else{
            Toast.makeText(getApplicationContext(), "You Can't Go There!", Toast.LENGTH_SHORT).show();
        }

    }

    /*******************************************
     * Check If Win Method
     * ******************************************/
    public void checkWin(int c){
        //This is gunna be messy :)

        //Horizontal win
        if((filled[0] == c && filled[1] == c && filled[2] == c) |
           (filled[3] == c && filled[4] == c && filled[5] == c) |
           (filled[6] == c && filled[7] == c && filled[8] == c)){
            setWin(c);
        }
        //Vertical win
        else if((filled[0] == c && filled[3] == c && filled[6] == c) |
                (filled[1] == c && filled[4] == c && filled[7] == c) |
                (filled[2] == c && filled[5] == c && filled[8] == c)){
            setWin(c);
        }
        //Diagonal Win
        else if((filled[0] == c && filled[4] == c && filled[8] == c) |
                (filled[6] == c && filled[4] == c && filled[2] == c)){
            setWin(c);
        }
        //Draw
        else if(isFull(filled)){
            pCurrent.setText("DRAW!");

        }
    }
    /*******************************************
     * Check If Board is Full
     * ******************************************/
    public boolean isFull(int a[]){
        boolean v = true;
        for(int i=0; i<a.length;++i){
            if(a[i]==0){return v=false;}
        }
        return v;
    }

    /*******************************************
     * Make a win view
     * ******************************************/

    private void setWin(int c){

        if(c==1){
            pCurrent.setText(p1Name + " Wins!");
            p1Win = Integer.parseInt(values.getString("p1w", "0"));
            p1Face.setImageResource(p1h);
            p2Face.setImageResource(p2m);
            p1Win +=1;
            editor.putString("p1w", String.valueOf(p1Win));

        }else{
            pCurrent.setText(p2Name + " Wins!");
            p2Win = Integer.parseInt(values.getString("p2w", "0"));
            p1Face.setImageResource(p1m);
            p2Face.setImageResource(p2h);
            p2Win +=1;
            editor.putString("p2w", String.valueOf(p2Win));
        }
        editor.apply();
        win = true;
    }

}
