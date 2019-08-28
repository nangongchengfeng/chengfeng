package com.wei.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PersonTest {
    @Autowired
    Person person;
    @Autowired
    Person person2;

    @Test
    public void test(){
        System.out.println(person);
        System.out.println(person2);

    }
}
