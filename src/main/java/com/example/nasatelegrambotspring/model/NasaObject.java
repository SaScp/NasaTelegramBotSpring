package com.example.nasatelegrambotspring.model;

public class NasaObject {
    private final String copyright;
    private final String date;
    private final String explanation;
    private final String hdurl;


    public NasaObject(String copyright,
                      String date,
                      String explanation,
                      String hdurl) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
    }


    public String getCopyright() {
        return copyright;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

}
