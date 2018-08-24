package com.groot.test.models;

import org.springframework.stereotype.Component;


@Component
public class Groot {
    private String recieved;
    private String translated;

    public Groot() {
    }

    public Groot(String recieved, String translated) {
        this.recieved = recieved;
        this.translated = translated;
    }

    public String getRecieved() {
        return recieved;
    }

    public void setRecieved(String recieved) {
        this.recieved = recieved;
    }

    public String getTranslated() {
        return translated;
    }

    public void setTranslated(String translated) {
        this.translated = translated;
    }
}