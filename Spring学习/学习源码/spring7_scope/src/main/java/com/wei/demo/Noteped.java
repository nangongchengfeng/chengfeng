package com.wei.demo;

public class Noteped {
    public Noteped() {
        super();
        System.out.println("初始化"+this.toString());
    }
    public void init(){
        System.out.println("初始化开始");
    }
    public void dec(){
        System.out.println("容器销毁");
    }
}
