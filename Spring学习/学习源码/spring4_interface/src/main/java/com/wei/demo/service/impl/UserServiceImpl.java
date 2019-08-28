package com.wei.demo.service.impl;

import com.wei.demo.dao.UserDao;
import com.wei.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
//@Component
//@Qualifier("impl")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void add() {
       userDao.add();
    }
}
