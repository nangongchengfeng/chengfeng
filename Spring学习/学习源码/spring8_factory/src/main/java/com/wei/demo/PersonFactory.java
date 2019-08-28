package com.wei.demo;

public class PersonFactory {
    /**
     * j静态工厂方法
     * @return
     */
    public static Person createPerson(){
        System.out.println("静态工厂方法");
        return new Person();
    }
    public Person createPerson2(){
        System.out.println("示例工厂方法");
        return new Person();
    }
}
