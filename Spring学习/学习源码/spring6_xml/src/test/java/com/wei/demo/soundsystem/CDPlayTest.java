package com.wei.demo.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CDPlayTest {
    @Autowired
    protected CdPlay cdplayer1;
    @Autowired
    private CdPlay cdplay2;

    @Test
    public void addtest() {
        cdplayer1.play();
    }

    @Test
    public void addtest2() {
        cdplay2.play();
    }
}
