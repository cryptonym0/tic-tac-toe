package com.example.t00055219.tictacded;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.LogRecord;
import android.os.Handler;

import static android.R.attr.level;
import static android.R.attr.x;
import static android.R.attr.y;
import static android.R.id.toggle;
import static com.example.t00055219.tictacded.R.id.currentPlayer;
import static com.example.t00055219.tictacded.R.id.fill;
import static com.example.t00055219.tictacded.R.id.winView;
import static com.example.t00055219.tictacded.R.string.p1;
import static com.example.t00055219.tictacded.R.string.p2;



public class PlayGameGirlfriend extends AppCompatActivity {

    //Declaring Variables
    //Player Names
    String p1Name = "Player 1";
    String p2Name = "Player 2";
    int p1Win = 0, p2Win = 0;
    String p1c = "", p2c = "";
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
    public static int[] filled = new int[9];
    //Current buttin
    ImageButton b[];

    //Make shared Preferences
    public static final String PREFS_NAME = "MyPreferenceFile";
    SharedPreferences values;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game_girlfriend);

        values      = getSharedPreferences(PREFS_NAME, 0);
        editor      = values.edit();
        p1Name      = values.getString("p1", "Player 1");
        p2Name      = values.getString("p2", "Player 2");
        p1c         = values.getString("p1c", "p1c");
        p2c         = values.getString("p2c", "p2c");
        editor.apply();
        g           = Toast.makeText(getApplicationContext(), "You Can't Go There!", Toast.LENGTH_SHORT);
        h           = Toast.makeText(getApplicationContext(), "Press Rest To Start A New Game", Toast.LENGTH_SHORT);
        //Players
        b           = new ImageButton[9];
        pCurrent    = (TextView) findViewById(currentPlayer);
        pWin        = (TextView) findViewById(winView);
        setOnClickListeners();
        reset();//Reset values
    }

    //Options action
    public View.OnClickListener optionAction = new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            Button btn = (Button) arg0;

            switch (btn.getId()) {
                case R.id.btnR: {
                    Log.d("Reset Called", "RESET CASE");
                    reset();
                    break;
                }
                case R.id.scoresButton: {
                    Log.d("Scores Called", "Scores CASE");
                    Intent intent = new Intent(PlayGameGirlfriend.this, Scores.class);
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
            if (win) {
                h.show();
            } else {

                switch (btn.getId()) {
                    //Button 1
                    case R.id.btn1: {
                        currentButton = 0;
                        if (filled[currentButton] != 0) {
                            g.show();
                        } else {
                            placeStar(btn);
                            if(turn==2){handleMe(currentButton);}
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
                            if(turn==2){handleMe(currentButton);}
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
                            if(turn==2){handleMe(currentButton);}
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
                            if(turn==2){handleMe(currentButton);}
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
                            if(turn==2){handleMe(currentButton);}
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
                            if(turn==2){handleMe(currentButton);}
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
                            if(turn==2){handleMe(currentButton);}
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
                            if(turn==2){handleMe(currentButton);}
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
                            if(turn==2){handleMe(currentButton);}
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
        b3.setBackgroundResource(R.color.clearColor);
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
        turn = 1; //TODO REMOVE ME!!
        if (turn == 1) {
            pCurrent.setText("Current Player: " + p1Name);
        } else if (turn == 2) {
            pCurrent.setText("Current Player: " + p2Name);
        }
        pWin.setText("");
    }

    /*******************************************
     * Populate Board
     ******************************************/
    public void populateBoard() {
        b[0] = (ImageButton) findViewById(R.id.btn1);
        b[1] = (ImageButton) findViewById(R.id.btn2);
        b[2] = (ImageButton) findViewById(R.id.btn3);
        b[3] = (ImageButton) findViewById(R.id.btn4);
        b[4] = (ImageButton) findViewById(R.id.btn5);
        b[5] = (ImageButton) findViewById(R.id.btn6);
        b[6] = (ImageButton) findViewById(R.id.btn7);
        b[7] = (ImageButton) findViewById(R.id.btn8);
        b[8] = (ImageButton) findViewById(R.id.btn9);

        //Ai #TODO
        for (int i = 0; i < 9; ++i) {
            filled[i] = 0;
        }

        controller();
    }//End Populate Board

    /*******************************************
     * Set On Click Listener Method
     ******************************************/
    public void setOnClickListeners() {
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
     ******************************************/
    public void placeStar(ImageButton btn) {
        if (filled[currentButton] == 0) {
            if (turn == 1) {
                filled[currentButton] = 1;
                btn.setBackgroundResource(findPlayerOneCharacter(p1c));
                pCurrent.setText("Current Player: " + p2Name);
                checkWin(turn);
                turn = 2;
            } else if (turn == 2) {
                filled[currentButton] = 2;
                btn.setBackgroundResource(findPlayerTwoCharacter(p2c));
                pCurrent.setText("Current Player: " + p1Name);
                checkWin(turn);
                turn = 1;
            } else {
                Toast.makeText(getApplicationContext(), "You Can't Go There!", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(getApplicationContext(), "You Can't Go There!", Toast.LENGTH_SHORT).show();
        }

    }

    /*******************************************
     * Check If Win Method
     ******************************************/
    public void checkWin(int c) {
        //This is gunna be messy :)

        //Horizontal win
        if ((filled[0] == c && filled[1] == c && filled[2] == c) |
                (filled[3] == c && filled[4] == c && filled[5] == c) |
                (filled[6] == c && filled[7] == c && filled[8] == c)) {
            setWin(c);
        }
        //Vertical win
        else if ((filled[0] == c && filled[3] == c && filled[6] == c) |
                (filled[1] == c && filled[4] == c && filled[7] == c) |
                (filled[2] == c && filled[5] == c && filled[8] == c)) {
            setWin(c);
        }
        //Diagonal Win
        else if ((filled[0] == c && filled[4] == c && filled[8] == c) |
                (filled[6] == c && filled[4] == c && filled[2] == c)) {
            setWin(c);
        }
        //Draw
        else if (isFull(filled)) {
            pCurrent.setText("DRAW!");

        }
    }


    /*******************************************
     * Check If Board is Full
     ******************************************/
    public boolean isFull(int a[]) {
        boolean v = true;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] == 0) {
                return v = false;
            }
        }
        return v;
    }

    /*******************************************
     * Make a win view
     ******************************************/

    private void setWin(int c) {

        if (c == 1) {
            pWin.setText(p1Name + " Wins!");
            pCurrent.setText("Congrats!");
            p1Win = Integer.parseInt(values.getString("p1w", "0"));
            Log.d("CHECK", "playerOneScore before add = " + p1Win);
            p1Win += 1;
            Log.d("CHECK", "playerOneScore after add = " + p1Win);
            editor.putString("p1w", String.valueOf(p1Win));

        } else {
            pWin.setText(p2Name + " Wins!");
            pCurrent.setText("Sucks 2 Suck");
            p2Win = Integer.parseInt(values.getString("p2w", "0"));
            Log.d("CHECK", "player2Score before add = " + p2Win);
            p2Win += 1;
            Log.d("CHECK", "player2Score after add = " + p2Win);
            editor.putString("p2w", String.valueOf(p2Win));
        }
        editor.apply();
        win = true;
    }


    public int findPlayerOneCharacter(String p1c) {
        p1resID = getResources().getIdentifier("star", "drawable", getPackageName());
        if (p1c == "") {
            p1resID = getResources().getIdentifier("star", "drawable", getPackageName());
        } else if (p1c == "ap1") {
            p1resID = getResources().getIdentifier("char_a_neutral", "drawable", getPackageName());
        } else if (p1c == "bp1") {
            p1resID = getResources().getIdentifier("char_b_neutral", "drawable", getPackageName());
        } else if (p1c == "cp1") {
            p1resID = getResources().getIdentifier("char_c_neutral", "drawable", getPackageName());
        } else if (p1c == "dp1") {
            p1resID = getResources().getIdentifier("char_d_neutral", "drawable", getPackageName());
        } else if (p1c == "ep1") {
            p1resID = getResources().getIdentifier("char_e_neutral", "drawable", getPackageName());
        }
        return p1resID;
    }

    public int findPlayerTwoCharacter(String p2c) {
        p2resID = getResources().getIdentifier("star2", "drawable", getPackageName());
        if (p2c == "") {
            p2resID = getResources().getIdentifier("star2", "drawable", getPackageName());
        } else if (p2c == "ap2") {
            p2resID = getResources().getIdentifier("char_a_neutral", "drawable", getPackageName());
        } else if (p2c == "bp2") {
            p2resID = getResources().getIdentifier("char_b_neutral", "drawable", getPackageName());
        } else if (p2c == "cp2") {
            p2resID = getResources().getIdentifier("char_c_neutral", "drawable", getPackageName());
        } else if (p2c == "dp2") {
            p2resID = getResources().getIdentifier("char_d_neutral", "drawable", getPackageName());
        } else if (p2c == "ep2") {
            p2resID = getResources().getIdentifier("char_e_neutral", "drawable", getPackageName());
        }
        return p2resID;
    }


    /*******************************************
     * AI STUFF
     ******************************************/

    public class ResultMM {
        int[] matrix;
        int score;
        int depth;
        public ResultMM(int[] matrix, int score, int depth)
        {
            this.matrix = matrix;
            this.score = score;
            this.depth = depth;
        }
        public void updateMatrix(int[] matrix)
        {
            this.matrix = matrix;
        }
        public int getScore()
        {
            return score;
        }
        public int getIntrus()
        {
            for(int i=0; i<9; i++)
                if(matrix[i]==2)
                    return i;
            return -1;
        }
    }

    //gameXO is the game
    static int[] gameXO = new int[9];
    //_sdepth is used to control the depth
    static int sdepth;


    public void controller()
    {//reInitialise the gameXO when i create a new controller
        for(int i=0; i<9; i++)
            gameXO[i] = 0;
    }

    //inverse: this method is used to toggle between level (Min and Max)
    public String inverse(String level)
    { //inverse level from MIN to MAX
        return (level.equals("MIN")) ? "MAX" : "MIN" ;
    }

    public int getScore(int[] demo)
    { //return the score:
        //if X win return -1;
        //if O win return 1;
        //else return 0, this mean draw
        if( (demo[0]==(1) && demo[1]==(1) && demo[2]==(1)) || (demo[3]==(1) && demo[4]==(1) && demo[5]==(1) ||
                (demo[6]==(1) && demo[7]==(1) && demo[8]==(1)) || (demo[0]==(1) && demo[3]==(1) && demo[6]==(1)) ||
                (demo[1]==(1) && demo[4]==(1) && demo[7]==(1)) || (demo[2]==(1) && demo[5]==(1) && demo[8]==(1)) ||
                (demo[0]==(1) && demo[4]==(1) && demo[8]==(1)) || (demo[2]==(1) && demo[4]==(1) && demo[6]==(1))))
            return -1;
        if( (demo[0]==(2) && demo[1]==(2) && demo[2]==(2)) || (demo[3]==(2) && demo[4]==(2) && demo[5]==(2)) ||
                (demo[6]==(2) && demo[7]==(2) && demo[8]==(2)) || (demo[0]==(2) && demo[3]==(2) && demo[6]==(2)) ||
                (demo[1]==(2) && demo[4]==(2) && demo[7]==(2)) || (demo[2]==(2) && demo[5]==(2) && demo[8]==(2)) ||
                (demo[0]==(2) && demo[4]==(2) && demo[8]==(2)) || (demo[2]==(2) && demo[4]==(2) && demo[6]==(2))
                )
            return 1;
        return 0;
    }
    public boolean drawGame(int[] demo)
    {
        //test if the game is draw.
        //if demo is full, this mean that game is draw
        //if demo still has empty square, this mean that the game isn't finished
        for(int i=0; i<9; i++)
            if(demo[i]==(0))
                return false;
        return true;
    }
    public boolean gameOver(int[] demo)
    {//if the score of the game is 0 then return false else we have a winner
        return (getScore(demo)!=0) ? true : false;
    }

    public ArrayList<int[]> genere_succ(int[] demo, String level)
    {//generate successor
        //if level is MAX, generate successor with o (o in lowercase)
        //if level is MIN, generate successor with x (x in lowercase)
        //if demo has no successor, return null
        ArrayList<int[]> succ = new ArrayList<>();
        for(int i=0; i<demo.length; i++)
        {
            if( demo[i]==0)
            {
                int[] child = new int[9];
                for(int j=0; j<9; j++)
                    child[j] = demo[j];
                if(level.equals("MAX"))
                    child[i] = 2;
                else
                    child[i] = 1;
                succ.add(child);
            }
        }
        return ( succ.size() == 0 ) ? null : succ ;
    }

    public ResultMM getResult(ArrayList<ResultMM> listScore, String level)
    {//this method is used to get the appropriate score
        //if level is MAX, i search for the higher score in the nearer depth
        //if level is MIN, i search for the lowest score in the nearer depth
        ResultMM result= listScore.get(0);
        if(level.equals("MAX"))
        {
            for(int i=1; i<listScore.size(); i++)
            {
                if( (listScore.get(i).getScore() > result.getScore())
                        ||
                        (listScore.get(i).getScore() == result.getScore() && listScore.get(i).depth < result.depth) )
                    result = listScore.get(i);
            }
        }
        else
        {
            for(int i=1; i<listScore.size(); i++)
            {
                if( (listScore.get(i).getScore() < result.getScore())
                        ||
                        (listScore.get(i).getScore() == result.getScore() && listScore.get(i).depth < result.depth) )
                    result = listScore.get(i);
            }
        }
        return result;
    }

    public ResultMM MinMax(int[] demo, String level, int fils, int depth)
    {/*MinMax algorithm
           * 1- generate successor
           * 2- if no successor or game is finished return score
           * 3- if there is successor
           *      a) apply MinMax for each successor
           *     b) after recursive call, i return the good score
           */
        //1---------------
        ArrayList<int[]> children = genere_succ(demo,level);
        //2------------------
        if(children == null || gameOver(demo))
        {
            return new ResultMM(demo, getScore(demo), depth);
        }
        else
        {//3------------------
            ArrayList<ResultMM> listScore = new ArrayList<ResultMM>();
            //pass into each child
            for(int i = 0; i<children.size(); i++)
            {//3 a)---------------
                listScore.add( MinMax(children.get(i), inverse(level), 1, depth+1));
            }
            //3 b)----------------
            ResultMM res = getResult(listScore, level);
            if( fils == 1)
                res.updateMatrix(demo);
            return res;
        }
    }

    public int makeMove(int index)
    {     /*Step to do in this method
           *1- update gameXO. put X in the gameXO[index]
           *2- test if game is finished (draw or X win)
           *3- call MinMax algorithm and return the score and return the best position for O
           *4- update gameXO. put O in its position
           *5- test if game is finished (draw or O win)
           */
        //return -1 to know that player X wins
        //return -2 to know that the game is draw
        //1
        gameXO[index] = 1;
        //2
        if(gameOver(gameXO)) { return -1; }
        if(drawGame(gameXO)) { return -2; }
        //3
        ResultMM res = MinMax(gameXO,"MAX", 0, 0);
        int i = res.getIntrus();
        //4
        gameXO[i] = 2;
        //5
        // return i+20 to know that o wins (i used this method for programming issues)
        // retrun i-30 to know that the game is draw (i used this method for programming issues)
        if(gameOver(gameXO)) { return i+20; }
        if(drawGame(gameXO)) { return i-30; }
        whoDoIClick(i);
        return i;
    }

    public void whoDoIClick(int i){
        b[i].performClick();
    }

    public void handleMe(int i){
        //Handler
        final int x = i;
        Handler ha = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run(){
                makeMove(x);
            }
        };
        ha.postDelayed(r, 250);
    }
}
