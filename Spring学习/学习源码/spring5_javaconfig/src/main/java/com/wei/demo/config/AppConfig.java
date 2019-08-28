package com.wei.demo.config;

import com.wei.demo.dao.UserDao;
import com.wei.demo.dao.impl.UserDaoCache;
import com.wei.demo.dao.impl.UserDaoImpl;
import com.wei.demo.service.UserService;
import com.wei.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {
//    @Bean("impl")
//    @Qualifier("impl")
    @Bean
    public UserDao userDaoImpl(){
        System.out.println("创建UserDao对象");
        return new UserDaoImpl();
    }
//    @Primary//首选bean
//    @Bean("cache")
//    @Qualifier("cache")
    @Bean
    public UserDao userDaoCache(){
        System.out.println("创建UserDaoCache对象");
        return new UserDaoCache();
    }
    @Bean
    public UserService userServiceImpl(@Qualifier("userDaoImpl") UserDao userDao){
        System.out.println("创建UserService对象");
//        UserDao userDao=userDaoImpl();
        return new UserServiceImpl(userDao);
    }
}
