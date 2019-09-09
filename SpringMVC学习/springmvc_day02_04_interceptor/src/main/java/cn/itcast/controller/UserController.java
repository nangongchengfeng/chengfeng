package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @RequestMapping("/testinterceptor")
    public String testinterceptor(){

        System.out.println("testinterceptor执行");
        return "success";
    }

}
