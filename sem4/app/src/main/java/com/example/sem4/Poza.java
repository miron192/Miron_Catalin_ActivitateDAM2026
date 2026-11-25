package com.example.sem4;

import android.graphics.Bitmap;

public class Poza {
    private String textAfisat;
    private String link;
    private Bitmap imagine;

    public Poza(String textAfisat, Bitmap imagine, String link) {
        this.textAfisat = textAfisat;
        this.imagine = imagine;
        this.link = link;
    }

    public String getTextAfisat() {
        return textAfisat;
    }

    public String getLink() {
        return link;
    }

    public Bitmap getImagine() {
        return imagine;
    }
}
