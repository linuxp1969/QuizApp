package org.altervista.linuxp.quizapp;

public class Quiz {
    private String domanda;
    private String risposta1;
    private String risposta2;
    private String risposta3;
    private String risposta4;

    private int rispostaesatta;

    public Quiz(String domanda, String risposta1, String risposta2, String risposta3, String risposta4, int rispostaesatta) {
        this.domanda = domanda;
        this.risposta1 = risposta1;
        this.risposta2 = risposta2;
        this.risposta3 = risposta3;
        this.risposta4 = risposta4;
        if (rispostaesatta > 0 && rispostaesatta < 5) {
            this.rispostaesatta = rispostaesatta;
        }else {
            System.out.println("Valore di rispostaesatta errato");
        }
    }

    public String getDomanda() {
        return domanda;
    }

    public String getRisposta1() {
        return risposta1;
    }

    public String getRisposta2() {
        return risposta2;
    }

    public String getRisposta3() {
        return risposta3;
    }

    public String getRisposta4() {
        return risposta4;
    }

    public int getRispostaesatta() {
        return rispostaesatta;
    }

    public int rispostaGiusta() {
        int ris = 0;
        switch (rispostaesatta) {
            case 1:
                ris = 1;
                break;
            case 2:
                ris = 2;
                break;
            case 3:
                ris = 3;
                break;
            case 4:
                ris = 4;
                break;
        }
        return ris;
    }

    public boolean isGiusta(int risposta) {
        if (risposta == rispostaGiusta()) {
            return true;
        }else {
            return false;
        }

    }
}
