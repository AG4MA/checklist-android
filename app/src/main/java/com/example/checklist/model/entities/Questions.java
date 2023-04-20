package com.example.checklist.model.entities;

import com.example.checklist.QuestionsTypes;

public class Questions {
    private String domanda;
    private Object risposta;
    private QuestionsTypes types;

    public Questions() {
    }

    public Questions(String domanda, Object risposta, QuestionsTypes types) {
        this.domanda = domanda;
        this.risposta = risposta;
        this.types = types;
    }

    public String getDomanda() {
        return domanda;
    }

    public void setDomanda(String domanda) {
        this.domanda = domanda;
    }

    public Object getRisposta() {
        return risposta;
    }

    public void setRisposta(Object risposta) {
        this.risposta = risposta;
    }

    public QuestionsTypes getTypes() {
        return types;
    }

    public void setTypes(QuestionsTypes types) {
        this.types = types;
    }
}
