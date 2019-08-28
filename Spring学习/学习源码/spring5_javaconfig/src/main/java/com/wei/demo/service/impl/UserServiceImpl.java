package com.wei.demo.service.impl;

import com.wei.demo.dao.UserDao;
import com.wei.demo.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        super();
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void add(){
        userDao.add();
    }
}
