package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 控制器类
@Controller
@RequestMapping(path = "/user")
public class HelloController {

    /**
     * 入门案例
     * @return
     */
    @RequestMapping(path="/hello")
    public String sayHello(){
        System.out.println("Hello StringMVC");
        return "success";
    }
    @RequestMapping(path = "testRequest")
    public String testRequest(){
        System.out.println("Hello RequestMapping");
        return "success";
    }



}
