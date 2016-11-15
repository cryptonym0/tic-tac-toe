package com.example.t00055219.tictacded;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;
import android.os.Handler;

import static com.example.t00055219.tictacded.R.id.aiEmotion;
import static com.example.t00055219.tictacded.R.id.currentPlayer;
import static com.example.t00055219.tictacded.R.id.winView;




public class PlayGameGirlfriend extends AppCompatActivity {

    //Declaring Variables
    String p1Name = "Player 1";
    int p1Win = 0, aiWin = 0;
    String p1c = "";
    int p1resID, airesID, aiEmote;
    int wa, wb, wc;

    //Variables for current Player
    int turn = 1;
    TextView pCurrent;
    TextView pWin;
    ImageView aiFace;
    int aih, ais, aim, ain, p1h, p1s, p1m, p1n;
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

        aiFace              = (ImageView) findViewById(aiEmotion);
        values              = getSharedPreferences(PREFS_NAME, 0);
        editor              = values.edit();
        p1Name              = values.getString("p1", "Player 1");
        p1c                 = values.getString("p1c", "p1c");
        editor.apply();
        g                   = Toast.makeText(getApplicationContext(), "You Can't Go There!", Toast.LENGTH_SHORT);
        h                   = Toast.makeText(getApplicationContext(), "Press Rest To Start A New Game", Toast.LENGTH_SHORT);
        //Players
        b                   = new ImageButton[9];
        pCurrent            = (TextView) findViewById(currentPlayer);
        pWin                = (TextView) findViewById(winView);
        Player player1      = new Player(PlayGameGirlfriend.this);
        Player girlfriend   = new Player(PlayGameGirlfriend.this);
        player1.setEmotions(p1c);
        girlfriend.setEmotions("ai");
        aih = girlfriend.getHappy();
        ais = girlfriend.getSad();
        aim = girlfriend.getMad();
        ain = girlfriend.getNeutral();
        p1n = player1.getNeutral();

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
                if (turn != 2) {
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

                                if (turn == 2) {
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
                                if (turn == 2) {
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
                                if (turn == 2) {
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
                                if (turn == 2) {
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
                                if (turn == 2) {
                                    Girlfriend gf = new Girlfriend();
                                    gf.execute(currentButton);
                                }
                            }
                            break;
                        }
                    }//Button Switch
                }
                else{
                    Girlfriend gf = new Girlfriend();
                    gf.execute(currentButton);
                }

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
        aiFace.setImageResource(ain);
        //Reset Board
        populateBoard();
        win = false;
//        toggleTurn(lastTurn, turn);
        if (turn == 1) {
            pCurrent.setText(p1Name + "'s Turn");
        } else if (turn == 2) {
            pCurrent.setText("AI's Turn");
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
                btn.setBackgroundResource(p1n);
                pCurrent.setText("AI's Turn");
                checkWin(turn);
                turn = 2;
            } else if (turn == 2) {
                filled[currentButton] = 2;
                btn.setBackgroundResource(ain);
                pCurrent.setText(p1Name + "'s Turn");
                checkWin(turn);
                turn = 1;
            } else {
                Toast.makeText(getApplicationContext(), "You Can't Go There!", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(getApplicationContext(), "You Can't Go There!", Toast.LENGTH_SHORT).show();
        }

    }

    public void setWinBackRound(int a, int b, int c, ImageButton arr[], int emote){
        try {
            arr[a].setBackgroundResource(emote);
            arr[b].setBackgroundResource(emote);
            arr[c].setBackgroundResource(emote);
        }catch(NumberFormatException e){}

    }

    /*******************************************
     * Check If Win Method
     ******************************************/

    public void checkWin(int c){
        //This is gunna be messy :)

        //Horizontal win
        if(filled[0] == c && filled[1] == c && filled[2] == c){
            wa=0;
            wb=1;
            wc=2;
            setWin(c);
        }else if(filled[3] == c && filled[4] == c && filled[5] == c){
            wa=3;
            wb=4;
            wc=5;
            setWin(c);
        }else if(filled[6] == c && filled[7] == c && filled[8] == c){
            wa=6;
            wb=7;
            wc=8;
            setWin(c);
        }//Vertical win
        else if(filled[0] == c && filled[3] == c && filled[6] == c){
            wa=0;
            wb=3;
            wc=6;
            setWin(c);
        }

        else if(filled[1] == c && filled[4] == c && filled[7] == c){
            wa=1;
            wb=7;
            wc=4;
            setWin(c);
        }

        else if(filled[2] == c && filled[5] == c && filled[8] == c){
            wa=2;
            wb=5;
            wc=8;
            setWin(c);
        }
        //Diagonal Win
        else if(filled[0] == c && filled[4] == c && filled[8] == c){
            wa=0;
            wb=4;
            wc=8;
            setWin(c);
        }
        else if(filled[6] == c && filled[4] == c && filled[2] == c){
            wa=6;
            wb=4;
            wc=2;
            setWin(c);
        }
        //Draw
        else if (isFull(filled)) {
            pWin.setText("Nice Try..");
            pCurrent.setText("It's A Draw!");
            aiFace.setImageResource(ais);
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
            pWin.setText("...");
            pCurrent.setText(p1Name + " Wins!");
            aiFace.setImageResource(aim);
            setWinBackRound(wa, wb, wc, b, p1h);
            p1Win = Integer.parseInt(values.getString("p1w", "0"));
            p1Win += 1;
            editor.putString("p1w", String.valueOf(p1Win));

        } else {
            pWin.setText("Hehe!");
            pCurrent.setText("AI Wins!");
            setWinBackRound(wa, wb, wc, b, aih);
            aiFace.setImageResource(aih);
            aiWin = Integer.parseInt(values.getString("aiw", "0"));
            aiWin += 1;
            editor.putString("aiw", String.valueOf(aiWin));
        }
        editor.apply();
        win = true;
    }


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
        }


        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
        }


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
            Log.d("AI's Move", ""+index);
            aiArr[index] = "X";
            if(gameOver(aiArr)) { return -1; }
            if(drawGame(aiArr)) { return -2; }
            ResultMM res = MinMax(aiArr,"MAX", 0, 0);
            int i = res.getIntrus();
            aiArr[i] = "O";
            filled[i] = 2;
            b[i].setBackgroundResource(ain);
            pCurrent.setText(p1Name + "'s Turn");
            checkWin(turn);
            turn = 1;
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
}