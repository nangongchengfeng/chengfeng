package com.wei.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope("prototype")
//@Scope(scopeName = "prototype")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Lazy
public class Noteped2 {
    public Noteped2() {
        super();
        System.out.println("Noteped初始化" + this.toString());
    }
    @PostConstruct
    public void init(){
        System.out.println("2初始化开始");
    }
    @PreDestroy
    public void dec(){
        System.out.println("2容器销毁");
    }
}
