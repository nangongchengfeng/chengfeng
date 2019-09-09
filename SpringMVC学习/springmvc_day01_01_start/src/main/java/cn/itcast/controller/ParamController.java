package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 请求参数绑定
 */
@Controller
@RequestMapping("/param")
public class ParamController {
    /**
     * 请求参数绑定入门
     * @return
     */
    @RequestMapping(path = "/testParam")
    public String testParam(String username,String password){
        System.out.println("请求参数");
        System.out.println("用户名称："+username);
        System.out.println("用户密码："+password);
        return "success";
    }

    /**
     * 把数据封装到javabean里面
     * @return
     */
    @RequestMapping(path = "/saveAccount")
    public String saveParam(Account account){
        System.out.println("请求参数");
        System.out.println(account);
        return "success";
    }

    /**
     * 自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping(path = "/save")
    public String saveUser(User user){
        System.out.println("请求参数");
        System.out.println(user);
        return "success";
    }

/*    *//**
     * 原生的Servlet的API
     *//*
    @RequestMapping(path = "/save")
    public String saveAPI(HttpServletRequest request,HttpServletResponse response){
        System.out.println("请求参数");
        System.out.println(request);
        HttpSession session=request.getSession();
        System.out.println(session);
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);
        System.out.println(response);
        return "success";
    }*/

}
