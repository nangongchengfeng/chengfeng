package com.wei.demo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Note {
    /**
     * (1)无论我们是否去主动获取bean对象，spring上下文一加载就会创建bean对象
     * （2）无论我们获取多少次，拿到的都是同一个对象
     */
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Noteped note = (Noteped)context.getBean("note");
   /*     Noteped note2 = (Noteped)context.getBean("note");
        if (note==note2){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }*/
 //  context.destroy();
   context.close();
    }
}
