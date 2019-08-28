package com.wei.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Notede {
    /*
     *scope=prototype
     * (1)无论我们是否去主动获取bean对象，spring上下文一加载就会创建bean对象
     * （2）无论我们获取多少次，拿到的都是同一个对象
     *
     * scope="singleton"
     */
    @Autowired
    private Noteped noteped1;
    @Autowired
    private Noteped noteped2;

    @Test
    public void test() {
        System.out.println(noteped1 == noteped2);

    }
}
