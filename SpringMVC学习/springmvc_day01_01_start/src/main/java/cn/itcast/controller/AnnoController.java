package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 常用的注解
 */
@Controller
@RequestMapping("/anno")
public class AnnoController {
    @RequestMapping(path = "/testRequestParam")
    public String testRequestParam(@RequestParam(name ="name" ) String username){
        System.out.println("执行了");
        System.out.println(username);
        return "success";
    }
    @RequestMapping(path = "/testRequestboy")
    public String testRequestboy(@RequestBody String boy){
        System.out.println("执行了");
        System.out.println(boy);
        return "success";
    }
}
