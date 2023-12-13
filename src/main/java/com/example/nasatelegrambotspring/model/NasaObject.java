package com.example.nasatelegrambotspring.model;

public class NasaObject {
    private final String copyright;
    private final String date;
    private final String explanation;
    private final String media_type;
    private final String hdurl;
    private final String url;

    public NasaObject(String copyright,
                      String date,
                      String explanation,
                      String mediaType, String hdurl, String url) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        media_type = mediaType;
        this.hdurl = hdurl;
        this.url = url;
    }

    public String getUrl() {
        return url;
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

    public String getMedia_type() {
        return media_type;
    }
}
