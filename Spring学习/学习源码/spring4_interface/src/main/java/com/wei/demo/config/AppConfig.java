package com.wei.demo.config;

import com.wei.demo.dao.UserDao;
import com.wei.demo.service.UserService;
import com.wei.demo.web.UserController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.wei.demo")
//@ComponentScan(basePackages = {"com.wei.demo.web","com.wei.demo.service"})
@ComponentScan(basePackageClasses = {UserController.class, UserService.class, UserDao.class})
public class AppConfig {
}
