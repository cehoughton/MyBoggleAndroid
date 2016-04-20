package com.epicodus.myboggle;

import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class BoggleRoundActivity extends AppCompatActivity {
    public static final String TAG = BoggleRoundActivity.class.getSimpleName();
    private String[] consonants = {"q", "w", "r", "t", "y", "p", "s", "d", "f", "g", "g", "h",
            "j", "k", "l", "z", "x", "c", "v", "b", "n", "m"};
    private String[] vowels = {"a", "e", "i", "o", "u"};
    private ArrayList<String> boggleArray;
    private ArrayList<String> words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        boggleArray = new ArrayList<String>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boggle_round);
        for (int i=0; i<6; i++) {
            int index = (int) (Math.random()*consonants.length);
            boggleArray.add(consonants[index]);
        }
     Log.d(TAG, "this is my letter: " + boggleArray.get(5));

        for (int i=0; i<2; i++) {
            int index = (int) (Math.random()*vowels.length);
            boggleArray.add(vowels[index]);

        }
        Log.d(TAG, "this is my new letter: " + boggleArray.get(7));
    }
}
