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
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static com.example.t00055219.tictacded.R.id.currentPlayer;
import static com.example.t00055219.tictacded.R.id.fill;
import static com.example.t00055219.tictacded.R.id.winView;
import static com.example.t00055219.tictacded.R.string.p1;
import static com.example.t00055219.tictacded.R.string.p2;



public class PlayGameGirlfriend extends AppCompatActivity {

    //Declaring Variables
    String p1Name = "Player 1";
    int p1Win = 0, aiWin = 0;
    String p1c = "";
    int p1resID, airesID;

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
    //Current button for AI
    ImageButton b[];
    String[] aiArr = new String[9];
    static int lastTurn = 1;

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
        p1c         = values.getString("p1c", "p1c");
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
                                if (turn == 2) {
                                    Girlfriend gf = new Girlfriend();
                                    gf.execute(currentButton);
                                }
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
                                if (turn == 2) {
                                    Girlfriend gf = new Girlfriend();
                                    gf.execute(currentButton);
//                                    gf.execute(currentButton);
                                }
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
                                if (turn == 2) {
                                    Girlfriend gf = new Girlfriend();
                                    gf.execute(currentButton);
                                }
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

                                if(turn==2){
                                    Girlfriend gf = new Girlfriend();
                                    gf.execute(currentButton);
                                }
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
                                if (turn == 2) {
                                    Girlfriend gf = new Girlfriend();
                                    gf.execute(currentButton);
                                }
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
                                if(turn==2){
                                    Girlfriend gf = new Girlfriend();
                                    gf.execute(currentButton);
                                }
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
                                if(turn==2){
                                    Girlfriend gf = new Girlfriend();
                                    gf.execute(currentButton);
                                }
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
                                if(turn==2){
                                    Girlfriend gf = new Girlfriend();
                                    gf.execute(currentButton);
                                }
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
                                if(turn==2){
                                    Girlfriend gf = new Girlfriend();
                                    gf.execute(currentButton);
                                }
                            }
                            break;
                        }
                    }//Button Switch

            }
        }
    };//On click listener

    public void toggleTurn(int lastTurn, int turn){
        if(lastTurn == 1){
            turn = 2;
            lastTurn = 2;
        }
        else{
            turn = 1;
            lastTurn = 2;
        }
    }
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
        toggleTurn(lastTurn, turn);
        if (turn == 1) {
            pCurrent.setText(p1Name + "'s Turn");
        } else if (turn == 2) {
            pCurrent.setText("Saika's Turn");
            Random rand = new Random();
            int x =rand.nextInt(8);
            Girlfriend gf = new Girlfriend();
            gf.execute(x);
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

        for (int i = 0; i < 9; ++i) {
            filled[i] = 0;
            aiArr[i] = " ";

        }
//        for(int i=0; i<9; i++)
//            aiArr[i] = " ";

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
                pCurrent.setText("Saika's Turn");
                checkWin(turn);
//                getScore(filled);
                turn = 2;
            } else if (turn == 2) {
                filled[currentButton] = 2;
                btn.setBackgroundResource(getResources().getIdentifier("char_a_neutral", "drawable", getPackageName()));
                pCurrent.setText(p1Name + "'s Turn");
                checkWin(turn);
//                getScore(filled);
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
        for (int i = 0; i < a.length; ++i) {
            if (a[i] == 0) {
                return false;
            }
        }
        return true;
    }

    /*******************************************
     * Make a win view
     ******************************************/

    private void setWin(int c) {

        if (c == 1) {
            pWin.setText("I Let You Win...");
            pCurrent.setText(p1Name + " Wins!");
            p1Win = Integer.parseInt(values.getString("p1w", "0"));
            Log.d("CHECK", "playerOneScore before add = " + p1Win);
            p1Win += 1;
            Log.d("CHECK", "playerOneScore after add = " + p1Win);
            editor.putString("p1w", String.valueOf(p1Win));

        } else {
            pWin.setText("You Can't Beat Me!");
            pCurrent.setText("Saika Wins!");
            aiWin = Integer.parseInt(values.getString("aiw", "0"));
            Log.d("CHECK", "player2Score before add = " + aiWin);
            aiWin += 1;
            Log.d("CHECK", "player2Score after add = " + aiWin);
            editor.putString("aiw", String.valueOf(aiWin));
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

//    public int findPlayerTwoCharacter() {
//        p2resID = getResources().getIdentifier("char_a_neutral", "drawable", getPackageName());
//        return p2resID;
//    }


    /*******************************************
     * AI STUFF
     ******************************************/
    public class Girlfriend extends AsyncTask<Integer, String, Integer>{
        Handler ha = new Handler();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(Integer... in) {
            int index = in[0];
            Log.d("AI Recieves Index", ""+index);

            //Make Move Function
            handleMe(index);

            return null;
        }
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

//            b[myMove].performClick();
        }


        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
        }

        //String Array For the AI


        public String inverse(String l)
        {
            return (l.equals("MIN")) ? "MAX" : "MIN" ;
        }
        public int getScore(String[] a)
        {
            if( (a[0].equalsIgnoreCase("x") && a[1].equalsIgnoreCase("x") && a[2].equalsIgnoreCase("x")) || (a[3].equalsIgnoreCase("x") && a[4].equalsIgnoreCase("x") && a[5].equalsIgnoreCase("x")) ||
                    (a[6].equalsIgnoreCase("x") && a[7].equalsIgnoreCase("x") && a[8].equalsIgnoreCase("x")) || (a[0].equalsIgnoreCase("x") && a[3].equalsIgnoreCase("x") && a[6].equalsIgnoreCase("x")) ||
                    (a[1].equalsIgnoreCase("x") && a[4].equalsIgnoreCase("x") && a[7].equalsIgnoreCase("x")) || (a[2].equalsIgnoreCase("x") && a[5].equalsIgnoreCase("x") && a[8].equalsIgnoreCase("x")) ||
                    (a[0].equalsIgnoreCase("x") && a[4].equalsIgnoreCase("x") && a[8].equalsIgnoreCase("x")) || (a[2].equalsIgnoreCase("x") && a[4].equalsIgnoreCase("x") && a[6].equalsIgnoreCase("x"))
                    )
                return -1;
            if( (a[0].equalsIgnoreCase("o") && a[1].equalsIgnoreCase("o") && a[2].equalsIgnoreCase("o")) || (a[3].equalsIgnoreCase("o") && a[4].equalsIgnoreCase("o") && a[5].equalsIgnoreCase("o")) ||
                    (a[6].equalsIgnoreCase("o") && a[7].equalsIgnoreCase("o") && a[8].equalsIgnoreCase("o")) || (a[0].equalsIgnoreCase("o") && a[3].equalsIgnoreCase("o") && a[6].equalsIgnoreCase("o")) ||
                    (a[1].equalsIgnoreCase("o") && a[4].equalsIgnoreCase("o") && a[7].equalsIgnoreCase("o")) || (a[2].equalsIgnoreCase("o") && a[5].equalsIgnoreCase("o") && a[8].equalsIgnoreCase("o")) ||
                    (a[0].equalsIgnoreCase("o") && a[4].equalsIgnoreCase("o") && a[8].equalsIgnoreCase("o")) || (a[2].equalsIgnoreCase("o") && a[4].equalsIgnoreCase("o") && a[6].equalsIgnoreCase("o"))
                    )
                return 1;
            return 0;
        }
        public boolean drawGame(String[] arr)
        {
            for(int i=0; i<9; i++)
                if(arr[i].equals(" "))
                    return false;
            return true;
        }
        public boolean gameOver(String[] arr)
        {
            return (getScore(arr)!=0) ? true : false;
        }
        public ArrayList<String[]> genere_succ(String[] demo, String level)
        {
            ArrayList<String[]> kid = new ArrayList<>();
            for(int i=0; i<demo.length; i++)
            {
                if( demo[i].equals(" ") )
                {
                    String[] child = new String[9];
                    for(int j=0; j<9; j++)
                        child[j] = demo[j];
                    if(level.equals("MAX"))
                        child[i] = "o";
                    else
                        child[i] = "x";
                    kid.add(child);
                }
            }
            return ( kid.size() == 0 ) ? null : kid ;
        }
        public ResultMM getResult(ArrayList<ResultMM> list, String l)
        {
            ResultMM result= list.get(0);
            if(l.equals("MAX"))
            {
                for(int i=1; i<list.size(); i++)
                {
                    if( (list.get(i).getScore() > result.getScore())
                            ||
                            (list.get(i).getScore() == result.getScore() && list.get(i).d < result.d) )
                        result = list.get(i);
                }
            }
            else
            {
                for(int i=1; i<list.size(); i++)
                {
                    if( (list.get(i).getScore() < result.getScore())
                            ||
                            (list.get(i).getScore() == result.getScore() && list.get(i).d < result.d) )
                        result = list.get(i);
                }
            }
            return result;
        }
        public ResultMM MinMax(String[] demo, String l, int f, int d)
        {
            ArrayList<String[]> children = genere_succ(demo,l);
            if(children == null || gameOver(demo))
            {
                return new ResultMM(demo, getScore(demo), d);
            }
            else
            {
                ArrayList<ResultMM> listScore = new ArrayList<>();
                for(int i = 0; i<children.size(); i++)
                {
                    listScore.add( MinMax(children.get(i), inverse(l), 1, d+1));
                }
                ResultMM res = getResult(listScore, l);
                if( f == 1)
                    res.updateMatrix(demo);
                return res;
            }
        }
        public int makeMove(int index)
        {
            aiArr[index] = "X";
            if(gameOver(aiArr)) { return -1; }
            if(drawGame(aiArr)) { return -2; }
            ResultMM res = MinMax(aiArr,"MAX", 0, 0);
            int i = res.getIntrus();
            aiArr[i] = "O";
            b[i].performClick();
            if(gameOver(aiArr)) { return i+20;}
            if(drawGame(aiArr)) { return i-30;}
            return i;
        }
        public void handleMe(int i){
            //Handler
            final int x = i;
            Runnable r = new Runnable() {
                @Override
                public void run(){
                    makeMove(x);
                }
            };
            ha.postDelayed(r, 500);
        }
    }

    public class ResultMM {
        String[] m;
        int score;
        int d;
        public ResultMM(String[] m, int score, int d)
        {
            this.m = m;
            this.score = score;
            this.d = d;
        }
        public void updateMatrix(String[] m)
        {
            this.m = m;
        }
        public int getScore()
        {
            return score;
        }
        public int getIntrus()
        {
            for(int i=0; i<9; i++)
                if(m[i].equals("o"))
                    return i;
            return -1;
        }
    }
//    //String Array For the AI
//    static String[] aiArr = new String[9];
//
//    public String inverse(String l)
//    {
//        return (l.equals("MIN")) ? "MAX" : "MIN" ;
//    }
//    public int getScore(String[] a)
//    {
//        if( (a[0].equalsIgnoreCase("x") && a[1].equalsIgnoreCase("x") && a[2].equalsIgnoreCase("x")) || (a[3].equalsIgnoreCase("x") && a[4].equalsIgnoreCase("x") && a[5].equalsIgnoreCase("x")) ||
//                (a[6].equalsIgnoreCase("x") && a[7].equalsIgnoreCase("x") && a[8].equalsIgnoreCase("x")) || (a[0].equalsIgnoreCase("x") && a[3].equalsIgnoreCase("x") && a[6].equalsIgnoreCase("x")) ||
//                (a[1].equalsIgnoreCase("x") && a[4].equalsIgnoreCase("x") && a[7].equalsIgnoreCase("x")) || (a[2].equalsIgnoreCase("x") && a[5].equalsIgnoreCase("x") && a[8].equalsIgnoreCase("x")) ||
//                (a[0].equalsIgnoreCase("x") && a[4].equalsIgnoreCase("x") && a[8].equalsIgnoreCase("x")) || (a[2].equalsIgnoreCase("x") && a[4].equalsIgnoreCase("x") && a[6].equalsIgnoreCase("x"))
//                )
//            return -1;
//        if( (a[0].equalsIgnoreCase("o") && a[1].equalsIgnoreCase("o") && a[2].equalsIgnoreCase("o")) || (a[3].equalsIgnoreCase("o") && a[4].equalsIgnoreCase("o") && a[5].equalsIgnoreCase("o")) ||
//                (a[6].equalsIgnoreCase("o") && a[7].equalsIgnoreCase("o") && a[8].equalsIgnoreCase("o")) || (a[0].equalsIgnoreCase("o") && a[3].equalsIgnoreCase("o") && a[6].equalsIgnoreCase("o")) ||
//                (a[1].equalsIgnoreCase("o") && a[4].equalsIgnoreCase("o") && a[7].equalsIgnoreCase("o")) || (a[2].equalsIgnoreCase("o") && a[5].equalsIgnoreCase("o") && a[8].equalsIgnoreCase("o")) ||
//                (a[0].equalsIgnoreCase("o") && a[4].equalsIgnoreCase("o") && a[8].equalsIgnoreCase("o")) || (a[2].equalsIgnoreCase("o") && a[4].equalsIgnoreCase("o") && a[6].equalsIgnoreCase("o"))
//                )
//            return 1;
//        return 0;
//    }
//    public boolean drawGame(String[] arr)
//    {
//        for(int i=0; i<9; i++)
//            if(arr[i].equals(" "))
//                return false;
//        return true;
//    }
//    public boolean gameOver(String[] arr)
//    {
//        return (getScore(arr)!=0) ? true : false;
//    }
//    public ArrayList<String[]> genere_succ(String[] demo, String level)
//    {
//        ArrayList<String[]> kid = new ArrayList<>();
//        for(int i=0; i<demo.length; i++)
//        {
//            if( demo[i].equals(" ") )
//            {
//                String[] child = new String[9];
//                for(int j=0; j<9; j++)
//                    child[j] = demo[j];
//                if(level.equals("MAX"))
//                    child[i] = "o";
//                else
//                    child[i] = "x";
//                kid.add(child);
//            }
//        }
//        return ( kid.size() == 0 ) ? null : kid ;
//    }
//    public ResultMM getResult(ArrayList<ResultMM> list, String l)
//    {
//        ResultMM result= list.get(0);
//        if(l.equals("MAX"))
//        {
//            for(int i=1; i<list.size(); i++)
//            {
//                if( (list.get(i).getScore() > result.getScore())
//                        ||
//                        (list.get(i).getScore() == result.getScore() && list.get(i).d < result.d) )
//                    result = list.get(i);
//            }
//        }
//        else
//        {
//            for(int i=1; i<list.size(); i++)
//            {
//                if( (list.get(i).getScore() < result.getScore())
//                        ||
//                        (list.get(i).getScore() == result.getScore() && list.get(i).d < result.d) )
//                    result = list.get(i);
//            }
//        }
//        return result;
//    }
//    public ResultMM MinMax(String[] demo, String l, int f, int d)
//    {
//        ArrayList<String[]> children = genere_succ(demo,l);
//        if(children == null || gameOver(demo))
//        {
//            return new ResultMM(demo, getScore(demo), d);
//        }
//        else
//        {
//            ArrayList<ResultMM> listScore = new ArrayList<>();
//            for(int i = 0; i<children.size(); i++)
//            {
//                listScore.add( MinMax(children.get(i), inverse(l), 1, d+1));
//            }
//            ResultMM res = getResult(listScore, l);
//            if( f == 1)
//                res.updateMatrix(demo);
//            return res;
//        }
//    }
//    public int makeMove(int index)
//    {
//        aiArr[index] = "X";
//        if(gameOver(aiArr)) { return -1; }
//        if(drawGame(aiArr)) { return -2; }
//        ResultMM res = MinMax(aiArr,"MAX", 0, 0);
//        int i = res.getIntrus();
//        aiArr[i] = "O";
//        b[i].performClick();
//        if(gameOver(aiArr)) { return i+20;}
//        if(drawGame(aiArr)) { return i-30;}
//        return i;
//    }
//    public void handleMe(int i){
//        //Handler
//        final int x = i;
//        Handler ha = new Handler();
//        Runnable r = new Runnable() {
//            @Override
//            public void run(){
//                makeMove(x);
//            }
//        };
//        ha.postDelayed(r, 500);
//    }
}
