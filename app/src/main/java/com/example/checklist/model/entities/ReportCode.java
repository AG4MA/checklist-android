package com.example.checklist.model.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReportCode {

    private String key;
    private List<String> value;

    public ReportCode(){}

    public ReportCode(String key, List<String> value){
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }
}
