package com.wei.demo.service;

import com.wei.demo.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
/**
 * 这个是jdk本身自带的
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class UserServiceTest {
   // @Autowired
    /**
     * （1）限定符，可以选择使用的对象，比较方便简洁
     * （2）可以向@Component("fest")添加id，在使用@Qualifier("fest")指定
     * （3）系统可以默认在@Component生成id，第一个首字符小写的id userServiceImpl
     * （5）解决首选bean的问题
     *      只能设置一个
     *      @Primary
     *  （6）Resource可以同时替代Autowired和Qualifier
     *      但Resource是jdk的特性，不属于spring的。
    *  */
  //  @Qualifier("userServiceImpl")
    @Resource(name ="userServiceImpl" )
    private UserService userService;
    @Test
    public void testAdd(){
        userService.add();
    }

}
