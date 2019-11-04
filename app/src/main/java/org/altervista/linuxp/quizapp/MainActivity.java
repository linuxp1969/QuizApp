package org.altervista.linuxp.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    Quiz quiz[];
    private Button mRisposta1, mRisposta2, mRisposta3, mRisposta4, mAvanti;
    private TextView mDomanda;
    private int numTasto;
    private static int mDomandaCorrente = 0;
    private boolean eSelezionato;

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
                  4),
        new Quiz(getString(R.string.questionText2),
                  getString(R.string.question1_2),
                  getString(R.string.question2_2),
                  getString(R.string.question3_2),
                  getString(R.string.question4_2),
                  3),
        new Quiz(getString(R.string.questionText3),
                  getString(R.string.question1_3),
                  getString(R.string.question2_3),
                  getString(R.string.question3_3),
                  getString(R.string.question4_3),
                  3)
        };

        impostaDomande();

        mAvanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eSelezionato) {
                    mDomandaCorrente++;
                    if (mDomandaCorrente < quiz.length) {
                        impostaDomande();
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"Selezionare una risposta",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void inizializza() {
        mRisposta1 = findViewById(R.id.question1);
        mRisposta2 = findViewById(R.id.question2);
        mRisposta3 = findViewById(R.id.question3);
        mRisposta4 = findViewById(R.id.question4);
        mAvanti = findViewById(R.id.avanti);
        mDomanda = findViewById(R.id.questionText);
        eSelezionato = false;
        freezaRisposte(true,mRisposta1, mRisposta2, mRisposta3, mRisposta4);
        resetSfondiButton(mRisposta1, mRisposta2, mRisposta3, mRisposta4);
    }

    public void clickButton(View view) {
        freezaRisposte(false,mRisposta1, mRisposta2, mRisposta3, mRisposta4);
        eSelezionato = true;
        int id = view.getId();
        Button b = findViewById(id);

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

        verificaRisposta(numTasto, b);
    }

    private void verificaRisposta(int num, Button b) {
        if (quiz[mDomandaCorrente].isGiusta(numTasto)) {
            Toast.makeText(getApplicationContext(),"Risposta esatta",Toast.LENGTH_SHORT).show();
            b.setBackgroundColor(Color.GREEN);

        }else {
            Toast.makeText(getApplicationContext(),"Risposta sbagliata",Toast.LENGTH_SHORT).show();
            b.setBackgroundColor(Color.RED);
            bottoneEsatto(mDomandaCorrente).setBackgroundColor(Color.GREEN);
        }

    }


    public void impostaDomande() {
        mDomanda.setText(quiz[mDomandaCorrente].getDomanda());
        mRisposta1.setText(quiz[mDomandaCorrente].getRisposta1());
        mRisposta2.setText(quiz[mDomandaCorrente].getRisposta2());
        mRisposta3.setText(quiz[mDomandaCorrente].getRisposta3());
        mRisposta4.setText(quiz[mDomandaCorrente].getRisposta4());
        eSelezionato = false;
        freezaRisposte(true,mRisposta1, mRisposta2, mRisposta3, mRisposta4);
        resetSfondiButton(mRisposta1, mRisposta2, mRisposta3, mRisposta4);
    }

    public void freezaRisposte (boolean freeza, Button... bottoni) {
        for (int i=0; i<bottoni.length;i++) {
            bottoni[i].setEnabled(freeza);
        }
    }

    public void resetSfondiButton (Button... bottoni) {
        for (int i=0; i<bottoni.length;i++) {
            bottoni[i].setBackgroundColor(Color.TRANSPARENT);
        }
    }

    public Button bottoneEsatto(int domanda)  {
        Button c = null;
        switch (quiz[domanda].getRispostaesatta()){
            case(1):
            c = findViewById(R.id.question1);
            break;
            case(2):
                c = findViewById(R.id.question2);
                break;
            case(3):
                c = findViewById(R.id.question3);
                break;
            case(4):
                c = findViewById(R.id.question4);
                break;

        }
        return c;
    }
}
