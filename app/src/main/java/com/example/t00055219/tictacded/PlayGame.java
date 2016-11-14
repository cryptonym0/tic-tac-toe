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
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.x;
import static android.R.attr.y;
import static com.example.t00055219.tictacded.R.id.currentPlayer;
import static com.example.t00055219.tictacded.R.id.winView;
import static com.example.t00055219.tictacded.R.string.p1;
import static com.example.t00055219.tictacded.R.string.p2;

public class PlayGame extends AppCompatActivity {

    //Player Names
    String p1Name = "Player 1";
    String p2Name = "Player 2";
    int p1Win =0, p2Win =0;
    String p1c="", p2c="";
    int p1resID, p2resID;

    //Variables for current Player
    int turn = 1;
    TextView pCurrent;
    TextView pWin;

    //Variables for current button
    int currentButton;

    //bool
    boolean win = false;

    //Toast
    private Toast g, h;

    //Array for board
    public static int[][] board = new int[3][3];
    public static int[] filled = new int[9];
    //Current buttin
    ImageButton b[][];

    //Possible Wins
    public int move = 0;

    //Make shared Preferences
    public static final String PREFS_NAME = "MyPreferenceFile";
    SharedPreferences values;
    SharedPreferences.Editor editor;


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
        g = Toast.makeText(getApplicationContext(), "You Can't Go There!", Toast.LENGTH_SHORT);
        h = Toast.makeText(getApplicationContext(), "Press Rest To Start A New Game", Toast.LENGTH_SHORT);

        //Players
        b = new ImageButton[3][3];
        pCurrent = (TextView)findViewById(currentPlayer);

        pWin = (TextView)findViewById(winView);
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
        b1.setBackgroundResource(R.color.clearColor);
        b2.setBackgroundResource(R.color.clearColor);
        b3.setBackgroundResource(R.color.clearColor);;
        b4.setBackgroundResource(R.color.clearColor);
        b5.setBackgroundResource(R.color.clearColor);
        b6.setBackgroundResource(R.color.clearColor);
        b7.setBackgroundResource(R.color.clearColor);
        b8.setBackgroundResource(R.color.clearColor);
        b9.setBackgroundResource(R.color.clearColor);
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
        pWin.setText("");
    }

    /*******************************************
    * Populate Board
    * ******************************************/
    public void populateBoard(){
        //Ai #TODO
        //Get dem btns
        b[0][0] = (ImageButton) findViewById(R.id.btn1);
        b[0][1] = (ImageButton) findViewById(R.id.btn2);
        b[0][2] = (ImageButton) findViewById(R.id.btn3);
        b[1][0] = (ImageButton) findViewById(R.id.btn4);
        b[1][1] = (ImageButton) findViewById(R.id.btn5);
        b[1][2] = (ImageButton) findViewById(R.id.btn6);
        b[2][0] = (ImageButton) findViewById(R.id.btn7);
        b[2][1] = (ImageButton) findViewById(R.id.btn8);
        b[2][2] = (ImageButton) findViewById(R.id.btn9);
        for(int i=0; i<3; ++i){
            for(int j=0; j<3; ++j){
                board[i][j] = 0;
            }
        }
        for(int i=0; i<9; ++i){
            filled[i]=0;
        }
        //Set Text View #// TODO: 11/10/2016

    }//End Populate Board

    /*******************************************
     * Player Makes a Move
     * ******************************************/
    public static void makeAMove(int move[]){
        //Input validation?

        //If win check
        //Else
        //Int
        int x, y;

    }

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
                btn.setBackgroundResource(findPlayerOneCharacter(p1c));
                pCurrent.setText("Current Player: " + p2Name);
                checkWin(turn);
                turn = 2;
            }
            else if(turn == 2){
                filled[currentButton] = 2;
                btn.setBackgroundResource(findPlayerTwoCharacter(p2c));
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
            pWin.setText(p1Name + " Wins!");
            pCurrent.setText("Congrats!");
            p1Win = Integer.parseInt(values.getString("p1w", "0"));
            Log.d("CHECK", "playerOneScore before add = "+p1Win);
            p1Win +=1;
            Log.d("CHECK", "playerOneScore after add = "+p1Win);
            editor.putString("p1w", String.valueOf(p1Win));

        }else{
            pWin.setText(p2Name + " Wins!");
            pCurrent.setText("Sucks 2 Suck");
            p2Win = Integer.parseInt(values.getString("p2w", "0"));
            Log.d("CHECK", "player2Score before add = "+p2Win);
            p2Win +=1;
            Log.d("CHECK", "player2Score after add = "+p2Win);
            editor.putString("p2w", String.valueOf(p2Win));
        }
        editor.apply();
        win = true;
    }


    public int findPlayerOneCharacter(String p1c){
        p1resID = getResources().getIdentifier("char_a_neutral", "drawable",  getPackageName());
        if(p1c==""){
            p1resID = getResources().getIdentifier("star", "drawable",  getPackageName());
        }
        else if(p1c=="ap1"){
            p1resID = getResources().getIdentifier("char_a_neutral", "drawable",  getPackageName());
        }
        else if(p1c=="bp1"){
            p1resID = getResources().getIdentifier("char_b_neutral", "drawable",  getPackageName());
        }
        else if(p1c=="cp1"){
            p1resID = getResources().getIdentifier("char_c_neutral", "drawable",  getPackageName());
        }
        else if(p1c=="dp1"){
            p1resID = getResources().getIdentifier("char_d_neutral", "drawable",  getPackageName());
        }
        else if(p1c=="ep1"){
            p1resID = getResources().getIdentifier("char_e_neutral", "drawable",  getPackageName());
        }
        return p1resID;
    }

    public int findPlayerTwoCharacter(String p2c){
        p2resID = getResources().getIdentifier("char_b_neutral", "drawable",  getPackageName());
        if(p2c==""){
            p2resID = getResources().getIdentifier("star2", "drawable",  getPackageName());
        }
        else if(p2c=="ap2"){
            p2resID = getResources().getIdentifier("char_a_neutral", "drawable",  getPackageName());
        }
        else if(p2c=="bp2"){
            p2resID = getResources().getIdentifier("char_b_neutral", "drawable",  getPackageName());
        }
        else if(p2c=="cp2"){
            p2resID = getResources().getIdentifier("char_c_neutral", "drawable",  getPackageName());
        }
        else if(p2c=="dp2"){
            p2resID = getResources().getIdentifier("char_d_neutral", "drawable",  getPackageName());
        }
        else if(p2c=="ep2"){
            p2resID = getResources().getIdentifier("char_e_neutral", "drawable",  getPackageName());
        }
        return  p2resID;
    }

}
