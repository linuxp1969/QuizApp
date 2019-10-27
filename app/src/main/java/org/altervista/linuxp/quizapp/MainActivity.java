package org.altervista.linuxp.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Quiz quiz[];
    private Button mRisposta1, mRisposta2, mRisposta3, mRisposta4, mAvanti;
    private TextView mDomanda;
    private int numTasto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inizializza();
        quiz = new Quiz[]{
          new Quiz(getString(R.string.questionText1),
                  getString(R.string.question1_1),
                  getString(R.string.question2_1),
                  getString(R.string.question3_1),
                  getString(R.string.question4_1),
                  R.integer.answer1),
        new Quiz(getString(R.string.questionText2),
                  getString(R.string.question1_2),
                  getString(R.string.question2_2),
                  getString(R.string.question3_2),
                  getString(R.string.question4_2),
                  R.integer.answer2),
        new Quiz(getString(R.string.questionText3),
                  getString(R.string.question1_3),
                  getString(R.string.question2_3),
                  getString(R.string.question3_3),
                  getString(R.string.question4_3),
                  R.integer.answer3)
        };
    }

    private void inizializza() {
        mRisposta1 = findViewById(R.id.question1);
        mRisposta2 = findViewById(R.id.question2);
        mRisposta3 = findViewById(R.id.question3);
        mRisposta4 = findViewById(R.id.question4);
        mAvanti = findViewById(R.id.avanti);
        mDomanda = findViewById(R.id.questionText);
    }

    public void clickButton(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.question1:
                numTasto = 1;
                break;
            case R.id.question2:
                numTasto = 2;
                break;
            case R.id.question3:
                numTasto = 3;
                break;
            case R.id.question4:
                numTasto = 4;
                break;
        }
    }
}
