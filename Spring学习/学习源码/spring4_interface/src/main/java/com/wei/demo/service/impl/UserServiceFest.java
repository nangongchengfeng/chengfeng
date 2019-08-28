package com.wei.demo.service.impl;

import com.wei.demo.service.UserService;
import org.springframework.stereotype.Component;



//    @Qualifier("fest")
@Component
public class UserServiceFest implements UserService {
    @Override
    public void add() {
        System.out.println("注册用户并且发送优惠券");
    }
}
