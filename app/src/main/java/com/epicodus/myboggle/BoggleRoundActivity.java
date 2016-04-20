package com.epicodus.myboggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class BoggleRoundActivity extends AppCompatActivity {
    public static final String TAG = BoggleRoundActivity.class.getSimpleName();
    private String[] consonants = {"q", "w", "r", "t", "y", "p", "s", "d", "f", "g", "g", "h",
            "j", "k", "l", "z", "x", "c", "v", "b", "n", "m"};
    private String[] vowels = {"a", "e", "i", "o", "u"};
    private ArrayList<String> mBoggleArray;
    private ArrayList<String> mWords;
    private ArrayList<String> mGuessLetters;
    private TextView mTextView;
    private Button mAddWordButton;
    private Button mEndRoundButton;
    private EditText mGuessWord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mBoggleArray = new ArrayList<String>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boggle_round);
        for (int i=0; i<6; i++) {
            int index = (int) (Math.random()*consonants.length);
            mBoggleArray.add(consonants[index]);
        }
        for (int i=0; i<2; i++) {
            int index = (int) (Math.random()*vowels.length);
            mBoggleArray.add(vowels[index]);
        }
        mTextView = (TextView) findViewById(R.id.newWord);
        String letters = mBoggleArray.toString().replace("[", "").replace("]", "").replace(",", "" +
                " " +
                "").toUpperCase();
        mTextView.setText(letters);


        mGuessWord = (EditText) findViewById(R.id.guessWord);
        mAddWordButton = (Button) findViewById(R.id.addWordButton);
        mAddWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String guess = mGuessWord.getText().toString();
                mGuessLetters = new ArrayList<String>(Arrays.asList(guess.split("")));
                mGuessLetters.remove(0);

                Toast.makeText(BoggleRoundActivity.this, "Word has been added", Toast
                        .LENGTH_SHORT)
                        .show();

            }

        });
    }
}
