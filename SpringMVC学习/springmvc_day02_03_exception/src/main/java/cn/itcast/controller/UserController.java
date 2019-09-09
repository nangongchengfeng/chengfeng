package cn.itcast.controller;

import cn.itcast.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @RequestMapping("/testExecptin")
    public String testExecptin() throws  SysException {

        try {
            //    模拟异常
            int a = 10 / 0;
        } catch (Exception e) {
            //打印异常信息
            e.printStackTrace();
//            抛出自定义异常
            throw new SysException("查询所有用户出现问题");
        }

        System.out.println("testExecptin执行");
        return "success";
    }
}
