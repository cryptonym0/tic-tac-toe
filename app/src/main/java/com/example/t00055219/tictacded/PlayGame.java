package com.example.t00055219.tictacded;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.HashMap;
import java.util.Random;

import static android.R.attr.x;
import static android.R.id.toggle;
import static com.example.t00055219.tictacded.R.id.currentPlayer;
import static com.example.t00055219.tictacded.R.id.p1Img;
import static com.example.t00055219.tictacded.R.id.p2Img;
import static com.example.t00055219.tictacded.R.string.p2;


public class PlayGame extends AppCompatActivity {
    Handler ha = new Handler();
    //Player Names
    String p1Name = "Player 1";
    String p2Name = "Player 2";
    int p1Win =0, p2Win =0;
    String p1c="", p2c="";
    int p1resID, p2resID;
    Random rand = new Random();


    //Variables for current Player
    int turn = 1;
    TextView pCurrent;
    int wa, wb, wc;

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

//    mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
//    {
//        @Override
//        public void onCompletion(MediaPlayer mp)
//        {
//            // Code to start the next audio in the sequence
//        }
//    });

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
            pCurrent.setText(p1Name +"'s Turn");
        }
        else if(turn == 2) {
            pCurrent.setText(p2Name+"'s Turn");
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
                pCurrent.setText(p2Name+"'s Turn");
                checkWin(turn);
                if(!win && !isFull(filled)){pickPlaceSound(p1c);}
                turn = 2;
            }
            else if(turn == 2){
                filled[currentButton] = 2;
                btn.setBackgroundResource(p2n);
                pCurrent.setText(p1Name+"'s Turn");
                checkWin(turn);
                if(!win && !isFull(filled)){pickPlaceSound(p2c);}
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
        else if(isFull(filled)){
            if(turn==1){
                pickTieSound(p1c);
            }else{
                pickTieSound(p2c);
            }

            pCurrent.setText("It's A Tie!");
            p1Face.setImageResource(p1s);
            p2Face.setImageResource(p2s);

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
            pickWinSound(p1c);
//            Runnable r = new Runnable() {
//                @Override
//                public void run(){
//                    pickLoseSound(p2c);
//                }
//            };
//            ha.postDelayed(r, 5000);

            pCurrent.setText(p1Name + " Wins!");
            p1Win = Integer.parseInt(values.getString("p1w", "0"));
            p1Face.setImageResource(p1h);
            p2Face.setImageResource(p2m);
            setWinBackRound(wa, wb, wc, b, p1h);
            p1Win +=1;
            editor.putString("p1w", String.valueOf(p1Win));

        }else{
            pickWinSound(p2c);
//            pickLoseSound(p1c);
            pCurrent.setText(p2Name + " Wins!");
            p2Win = Integer.parseInt(values.getString("p2w", "0"));
            p1Face.setImageResource(p1m);
            p2Face.setImageResource(p2h);
            setWinBackRound(wa, wb, wc, b, p2h);
            p2Win +=1;
            editor.putString("p2w", String.valueOf(p2Win));
        }
        editor.apply();
        win = true;
    }

//    public void pickWinSound(String myGuy){


    public void pickWinSound(String myGuy){
        MediaPlayer a1pick = MediaPlayer.create(this, R.raw.elywin1);
        MediaPlayer b1pick = MediaPlayer.create(this, R.raw.matwin1);
        MediaPlayer c1pick = MediaPlayer.create(this, R.raw.char1win);
        MediaPlayer d1pick = MediaPlayer.create(this, R.raw.dywin4);
        MediaPlayer e1pick = MediaPlayer.create(this, R.raw.ellwin4);
        if(myGuy=="ap"){a1pick.start();}
        if(myGuy=="bp"){b1pick.start();}
        if(myGuy=="cp"){c1pick.start();}
        if(myGuy=="dp"){d1pick.start();}
        if(myGuy=="ep"){e1pick.start();}
    }
    public void pickLoseSound(String myGuy){
        final MediaPlayer a1pick = MediaPlayer.create(this, R.raw.elylose1);
        final MediaPlayer b1pick = MediaPlayer.create(this, R.raw.matlose2);
        final MediaPlayer c1pick = MediaPlayer.create(this, R.raw.charlose);
        final MediaPlayer d1pick = MediaPlayer.create(this, R.raw.dylose2);
        final MediaPlayer e1pick = MediaPlayer.create(this, R.raw.ellose5);
        if(myGuy=="ap"){a1pick.start();}
        if(myGuy=="bp"){b1pick.start();}
        if(myGuy=="cp"){c1pick.start();}
        if(myGuy=="dp"){d1pick.start();}
        if(myGuy=="ep"){e1pick.start();}
    }
    public void pickTieSound(String myGuy){
        final MediaPlayer a1pick = MediaPlayer.create(this, R.raw.elylose2);
        final MediaPlayer b1pick = MediaPlayer.create(this, R.raw.mattye);
        final MediaPlayer c1pick = MediaPlayer.create(this, R.raw.chartye);
        final MediaPlayer d1pick = MediaPlayer.create(this, R.raw.dytie);
        final MediaPlayer e1pick = MediaPlayer.create(this, R.raw.ellose3);
        if(myGuy=="ap"){a1pick.start();}
        if(myGuy=="bp"){b1pick.start();}
        if(myGuy=="cp"){c1pick.start();}
        if(myGuy=="dp"){d1pick.start();}
        if(myGuy=="ep"){e1pick.start();}
    }
    //Danger
    public void pickPlaceSound(String myGuy){
        final MediaPlayer a1pick = MediaPlayer.create(this, R.raw.elygo1);
        final MediaPlayer b1pick = MediaPlayer.create(this, R.raw.matgo3);
        final MediaPlayer c1pick = MediaPlayer.create(this, R.raw.chargo2);
        final MediaPlayer d1pick = MediaPlayer.create(this, R.raw.dygo);
        final MediaPlayer e1pick = MediaPlayer.create(this, R.raw.ellmove);
        if(myGuy=="ap"){a1pick.start();}
        if(myGuy=="bp"){b1pick.start();}
        if(myGuy=="cp"){c1pick.start();}
        if(myGuy=="dp"){d1pick.start();}
        if(myGuy=="ep"){e1pick.start();}
    }



//    public class WinSound extends AsyncTask<SoundPool, String, String> {
//
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//        @Override
//        protected String doInBackground(SoundPool... poolFriends) {
//            try {
//                //For each SoundPool object
//                // int soundLength = however long the SoundPool object is
//                // Play the sound
//                // Thread.sleep(soundLength);
////                winSoundPoolMap.put(1, winSoundPool.load(getApplicationContext(), R.raw.char1win, 1));
////                winSoundPool.play(winSoundPoolMap.get(1), streamVolume, streamVolume, 1, 0, 1f);
////                final MediaPlayer charwin1 = MediaPlayer.create(this, R.raw.char1win);
////                final MediaPlayer charwin2 = MediaPlayer.create(this, R.raw.char2win);
////                final MediaPlayer charwin3 = MediaPlayer.create(this, R.raw.char3win);
//
//
//            } catch (IllegalStateException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//        @Override
//        protected void onProgressUpdate(String... values) {
//            super.onProgressUpdate(values);
//        }
//
//
//        @Override
//        protected void onPostExecute(String result) {
//            super.onPostExecute(result);
//        }
//
//    }
//
//    //SOUND FILES
//    //Here we go
//
//    //Store these in a service call them when needed.
//
//    //Charlotte
//////Get win lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.char1win);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.char2win);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.char3win);
//
//    //Get lose lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.charlose);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.charlose2);
//
//    //Get Draw Lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.chartye);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.chartye2);
//
//    //Get Place Lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.charego1);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.chargo2);
//
//    //Get Pick Lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.charpick1);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.charpick2);
//
//    //Elliott
////Get win lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.ellwin1);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.ellwin2);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.ellwin3);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.ellwin4);
//
//    //Get lose lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.ellose5);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.ellose1);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.ellose2);
//
//    //Get Draw Lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.ellose3);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.ellose4);
//
//    //Get Place Lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.ellcoat);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.ellmove);
//
//    //Get Pick Lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.ellpick1);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.ellpick1);
//
//    //Dyson
////Get win lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.);
//
//    //Get lose lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.);
//
//    //Get Draw Lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.);
//
//    //Get Place Lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.);
//
//    //Get Pick Lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.);
//
//    //Elycia
////Get win lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.elywin1);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.elywin2);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.elywin3);
//
//    //Get lose lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.elylose1);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.elylose2);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.elylose3);
//
//    //Get Draw Lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.elytie);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.elytie2);
//
//    //Get Place Lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.elygo1);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.elygo1);
//
//    //Get Pick Lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.);
//
//    //Matt
////Get win lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.matwin1);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.matwin2);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.matwin3);
//
//    //Get lose lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.matlose1);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.matlose2);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.matlose3);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.matlose4);
//
//    //Get Draw Lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.mattye);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.mattye2);
//
//    //Get Place Lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.matgo);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.matgo2);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.matgo3);
//
//    //Get Pick Lines
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.matpick1);
//    final MediaPlayer mp = MediaPlayer.create(this, R.raw.matpick2);

}