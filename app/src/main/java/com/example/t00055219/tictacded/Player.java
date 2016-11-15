package com.example.t00055219.tictacded;

import android.content.Context;
import android.content.res.Resources;

/**
 * Created by t00055219 on 11/14/2016.
 */


public class Player{

    Context mContext;
    public Player (Context context)
    {
        mContext =context;
    }


    int happy;
    int sad;
    int mad;
    int neutral;
    public Player(int h, int s, int m, int n, Context curr){
        this.happy = h;
        this.sad = s;
        this.mad = m;
        this.neutral = n;

    }
    public void setEmotions(String c){
        happy = mContext.getResources().getIdentifier("char_a_win", "drawable", mContext.getPackageName());
        sad = mContext.getResources().getIdentifier("char_a_sad", "drawable", mContext.getPackageName());
        mad = mContext.getResources().getIdentifier("char_a_mad", "drawable", mContext.getPackageName());
        neutral = mContext.getResources().getIdentifier("char_a_neutral", "drawable", mContext.getPackageName());
        if(c==""){
            happy = mContext.getResources().getIdentifier("char_a_win", "drawable", mContext.getPackageName());
            sad = mContext.getResources().getIdentifier("char_a_sad", "drawable", mContext.getPackageName());
            mad = mContext.getResources().getIdentifier("char_a_mad", "drawable", mContext.getPackageName());
            neutral = mContext.getResources().getIdentifier("char_a_neutral", "drawable", mContext.getPackageName());
        }
        else if(c=="ap"){
            happy = mContext.getResources().getIdentifier("char_a_win", "drawable", mContext.getPackageName());
            sad = mContext.getResources().getIdentifier("char_a_sad", "drawable", mContext.getPackageName());
            mad = mContext.getResources().getIdentifier("char_a_mad", "drawable", mContext.getPackageName());
            neutral = mContext.getResources().getIdentifier("char_a_neutral", "drawable", mContext.getPackageName());
        }
        else if(c=="bp"){
            happy = mContext.getResources().getIdentifier("char_b_win", "drawable", mContext.getPackageName());
            sad = mContext.getResources().getIdentifier("char_b_sad", "drawable", mContext.getPackageName());
            mad = mContext.getResources().getIdentifier("char_b_mad", "drawable", mContext.getPackageName());
            neutral = mContext.getResources().getIdentifier("char_b_neutral", "drawable", mContext.getPackageName());
        }
        else if(c=="cp"){
            happy = mContext.getResources().getIdentifier("char_c_win", "drawable", mContext.getPackageName());
            sad = mContext.getResources().getIdentifier("char_c_sad", "drawable", mContext.getPackageName());
            mad = mContext.getResources().getIdentifier("char_c_mad", "drawable", mContext.getPackageName());
            neutral = mContext.getResources().getIdentifier("char_c_neutral", "drawable", mContext.getPackageName());
        }
        else if(c=="dp"){
            happy = mContext.getResources().getIdentifier("char_d_win", "drawable", mContext.getPackageName());
            sad = mContext.getResources().getIdentifier("char_d_sad", "drawable", mContext.getPackageName());
            mad = mContext.getResources().getIdentifier("char_d_mad", "drawable", mContext.getPackageName());
            neutral = mContext.getResources().getIdentifier("char_d_neutral", "drawable", mContext.getPackageName());
        }
        else if(c=="ep"){
            happy = mContext.getResources().getIdentifier("char_e_win", "drawable", mContext.getPackageName());
            sad = mContext.getResources().getIdentifier("char_e_sad", "drawable", mContext.getPackageName());
            mad = mContext.getResources().getIdentifier("char_e_mad", "drawable", mContext.getPackageName());
            neutral = mContext.getResources().getIdentifier("char_e_neutral", "drawable", mContext.getPackageName());
        }
        else if(c=="ai"){
            happy = mContext.getResources().getIdentifier("ai_win", "drawable", mContext.getPackageName());
            sad = mContext.getResources().getIdentifier("ai_sad", "drawable", mContext.getPackageName());
            mad = mContext.getResources().getIdentifier("ai_mad", "drawable", mContext.getPackageName());
            neutral = mContext.getResources().getIdentifier("ai_neutral", "drawable", mContext.getPackageName());
        }

    }

    public int getHappy(){
        return happy;
    }
    public int getSad(){
        return sad;
    }
    public int getMad(){
        return mad;
    }
    public int getNeutral(){
        return neutral;
    }

}