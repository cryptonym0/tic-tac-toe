package com.example.t00055219.tictacded;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import static com.example.t00055219.tictacded.R.string.p1;
import static com.example.t00055219.tictacded.R.string.p2;

public class Scores extends AppCompatActivity {

    //Create Variabls
    TextView p1Name, p2Name, p1Win, p2Win;
    ImageButton p1char, p2char;//Currently not implemented

    //Shared Preferences
    public static final String PREFS_NAME = "MyPreferenceFile";
    SharedPreferences values;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        values = getSharedPreferences(PREFS_NAME, 0);
        editor = values.edit();

        p1Name = (TextView)findViewById(R.id.play1Name);
        p2Name = (TextView)findViewById(R.id.play2Name);
        p1Win = (TextView)findViewById(R.id.play1Score);
        p2Win = (TextView)findViewById(R.id.play2Score);

        findViewById(R.id.sReset).setOnClickListener(resetMe);
        findViewById(R.id.pReset).setOnClickListener(resetMe);

        p1Name.setText(values.getString("p1", "Player 1"));
        p2Name.setText(values.getString("p2", "Player 2"));
        p1Win.setText(values.getString("p1w", "0"));
        p2Win.setText(values.getString("p2w", "0"));
        editor.apply();

    }


    private View.OnClickListener resetMe = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button)v;
            switch(btn.getId()){
                case R.id.sReset:{
                    resetScore();
                    break;
                }
                case R.id.pReset:{
                    resetScore();
                    //goes the enter names activity
                    Intent reEnter = new Intent(Scores.this, EnterNames.class);
                    startActivity(reEnter);
                    finish();//Close this activity
                    break;
                }
            }

        }
    };

    public void resetScore(){
        p1Win.setText("0");
        p2Win.setText("0");

        editor.putString("p1w", p1Win.getText().toString());
        editor.putString("p2w", p2Win.getText().toString());
        editor.apply();
        editor.commit();
    }
}
