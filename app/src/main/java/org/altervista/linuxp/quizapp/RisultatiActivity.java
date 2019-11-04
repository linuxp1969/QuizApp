package org.altervista.linuxp.quizapp;

import android.support.v8.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class RisultatiActivity extends AppCompatActivity {

    private static final String TAG = PointActivity.class.getSimpleName();
    private static final String RISPOSTE_KEY = "RISPOSTE_KEY" ;
    private static final String TOTDOMANDE_KEY = "TOTDOMANDE_KEY" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risultati);
    }

    public static Intent ottieniIntent(Context contesto, int risposte, int totdomande){
        Intent intento = new Intent(contesto, RisultatiActivity.class);

        intento.putExtra(RISPOSTE_KEY,risposte);
        intento.putExtra(TOTDOMANDE_KEY,totdomande);
        return intento;
    }
}
