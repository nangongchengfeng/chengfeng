package com.wei.demo.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CompactDiscText {

    @Autowired
    private CompactDisc compactDisc;
    @Autowired
    private CompactDisc compactDisc2;

    @Test
    public void test() {
        compactDisc.play();
    }

    @Test
    public void test2() {
        compactDisc2.play();
    }

}

