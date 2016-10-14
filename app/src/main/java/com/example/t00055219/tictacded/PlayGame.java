package com.example.t00055219.tictacded;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class PlayGame extends AppCompatActivity {

    //Declaring Variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        //Listeners for buttins
        findViewById(R.id.btn1).setOnClickListener(gameAction);
        findViewById(R.id.btn2).setOnClickListener(gameAction);
        findViewById(R.id.btn3).setOnClickListener(gameAction);
        findViewById(R.id.btn4).setOnClickListener(gameAction);
        findViewById(R.id.btn5).setOnClickListener(gameAction);
        findViewById(R.id.btn6).setOnClickListener(gameAction);
        findViewById(R.id.btn7).setOnClickListener(gameAction);
        findViewById(R.id.btn8).setOnClickListener(gameAction);
        findViewById(R.id.btn9).setOnClickListener(gameAction);
        findViewById(R.id.btnR).setOnClickListener(gameAction);


    }

    //Game Action handles gameplay
    //listener for which button on the game board was hit
    public View.OnClickListener gameAction = new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            Button btn = (Button) arg0;

            switch (btn.getId()) {

                //Button 1
                case R.id.btn1: {
                    String XO = "X";
                    if (XO.equals("")) {
                        btn.setText(btn.getText());
                    } else {
                        btn.setText(XO);
                    }
                    break;
                }
                //Button 2
                case R.id.btn2: {
                    String XO = "X";
                    if (XO.equals("")) {
                        btn.setText(btn.getText());
                    } else {
                        btn.setText(XO);
                    }
                    break;
                }
                //Button 3
                case R.id.btn3: {
                    String XO = "X";
                    if (XO.equals("")) {
                        btn.setText(btn.getText());
                    } else {
                        btn.setText(XO);
                    }
                    break;
                }
                //Button 4
                case R.id.btn4: {
                    String XO = "X";
                    if (XO.equals("")) {
                        btn.setText(btn.getText());
                    } else {
                        btn.setText(XO);
                    }
                    break;
                }
                //Button 5
                case R.id.btn5: {
                    String XO = "X";
                    if (XO.equals("")) {
                        btn.setText(btn.getText());
                    } else {
                        btn.setText(XO);
                    }
                    break;
                }
                //Button 6
                case R.id.btn6: {
                    String XO = "X";
                    if (XO.equals("")) {
                        btn.setText(btn.getText());
                    } else {
                        btn.setText(XO);
                    }
                    break;
                }
                //Button 7
                case R.id.btn7: {
                    String XO = "X";
                    if (XO.equals("")) {
                        btn.setText(btn.getText());
                    } else {
                        btn.setText(XO);
                    }
                    break;
                }
                //Button 8
                case R.id.btn8: {
                    String XO = "X";
                    if (XO.equals("")) {
                        btn.setText(btn.getText());
                    } else {
                        btn.setText(XO);
                    }
                    break;
                }
                //Button 9
                case R.id.btn9: {
                    String XO = "X";
                    if (XO.equals("")) {
                        btn.setText(btn.getText());
                    } else {
                        btn.setText(XO);
                    }
                    break;
                }
                //Reset
                case R.id.btnR: {
                    reset();
                    break;
                }
            }//Button Switch
        }
    };//On click listener

    //Reset Function
    public void reset() {
        Button b1 = (Button) findViewById(R.id.btn1);
        Button b2 = (Button) findViewById(R.id.btn2);
        Button b3 = (Button) findViewById(R.id.btn3);
        Button b4 = (Button) findViewById(R.id.btn4);
        Button b5 = (Button) findViewById(R.id.btn5);
        Button b6 = (Button) findViewById(R.id.btn6);
        Button b7 = (Button) findViewById(R.id.btn7);
        Button b8 = (Button) findViewById(R.id.btn8);
        Button b9 = (Button) findViewById(R.id.btn9);

        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");

    }

}
