package com.wei.demo.dao.impl;

import com.wei.demo.dao.UserDao;

public class UserDaoCache implements UserDao {
    @Override
    public void add() {
        System.out.println("添加用户到缓冲中。。。。");
    }
}
