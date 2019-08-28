package com.wei.demo.soundsystem;

public class Music {
    private String title;
    private Integer date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Music() {
        super();
    }

    public Music(String title, Integer date) {
        this.title = title;
        this.date = date;
    }
}
