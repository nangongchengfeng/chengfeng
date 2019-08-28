package com.wei.demo.soundsystem;

public class CdPlay {
    private CompactDisc cd;

    public CdPlay() {
        super();
        System.out.println("cdplay的构造函数" + this.toString());
    }

    public CdPlay(CompactDisc cd) {
        this.cd = cd;
        System.out.println("cdplay有参构造函数" + this.toString());
    }

    public void play() {
        System.out.println("cdplay函数" + this.toString());
        cd.play();
    }
}
