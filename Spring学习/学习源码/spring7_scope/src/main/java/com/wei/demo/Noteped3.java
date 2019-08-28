package com.wei.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Noteped3 {
    public Noteped3() {
        super();
        System.out.println("Noteped3初始化"+this.toString());
    }
    @PostConstruct
    public void init(){
        System.out.println("3初始化开始");
    }
    @PreDestroy
    public void dec(){
        System.out.println("3容器销毁");
    }
}
