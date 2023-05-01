package com.example.checklist.model.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReportCode {
    private String identifier;

    private List<String> valore;

    public ReportCode(String identifier, List<String> valore) {
        this.identifier = identifier;
        this.valore = valore;
    }

    public ReportCode() {}

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List<String> getValore() {
        return valore;
    }

    public void setValore(List<String> valore) {
        this.valore = valore;
    }
}