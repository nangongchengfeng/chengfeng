package com.wei.demo.dao.impl;

import com.wei.demo.dao.UserDao;
import org.springframework.stereotype.Component;

@Component
public class UserDaoNormal implements UserDao {
    @Override
    public void add() {
        System.out.println("添加用户到数据库中");
    }
}
