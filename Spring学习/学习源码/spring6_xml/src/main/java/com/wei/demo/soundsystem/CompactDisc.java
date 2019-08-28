package com.wei.demo.soundsystem;

import java.util.List;

public class CompactDisc {
    private String title;

    private String name;
    private List<Music> track;

    public CompactDisc(String title, String name) {
        this.title = title;
        this.name = name;
        System.out.println("函数" + this.toString());
    }

    public CompactDisc() {
        super();
        System.out.println("CompactDisc构造函数" + this.toString());
    }

    public CompactDisc(String title, String name, List<Music> track) {
        this.title = title;
        this.name = name;
        this.track = track;
        System.out.println("CompactDisc有三个构造函数" + this.toString());
    }

    public void play() {
        System.out.println("播放CD音乐" + this.toString() + this.title + "by" + this.name);
        for (Music track : this.track) {
            System.out.println("音乐:" +track.getTitle()+"时长"+track.getDate());
        }
    }
}
