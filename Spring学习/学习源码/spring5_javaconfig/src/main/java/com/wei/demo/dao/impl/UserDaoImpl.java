package com.wei.demo.dao.impl;

import com.wei.demo.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("添加用户到数据库中。。。。");
    }
}
