package com.example.checklist.model.entities;

public class ReportCodeHash {

    private String identifier;
    private String data;

    public ReportCodeHash() {
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ReportCodeHash(String identifier, String data) {
        this.identifier = identifier;
        this.data = data;
    }
}
