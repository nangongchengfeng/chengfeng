package cn.itcast.controller;

import cn.itcast.damain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    /**
     * 返回值为Sting
     *
     * @param model
     * @return
     */
    @RequestMapping("/testSting")
    public String testString(Model model) {
        System.out.println("执行了TestString的方法");
        //模拟去数据库拿去User对象
        User user = new User();
        user.setUsername("妹妹");
        user.setPassword("123");
        user.setAge(30);
//        Model可以存取数据
        model.addAttribute("user", user);
        return "success";

    }

    /**
     * 返回值为空
     * 请求转发一次请求，不用写项目名称
     * 转发不会帮你找视图解析器，所以要手写
     *
     * @return
     */
    @RequestMapping("/testVoid")
    public void testString(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("执行了TestVoid的方法");
        //编写请求转发
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
//        重定向
//        response.sendRedirect(request.getContextPath()+"/response.jsp");
//        设中文乱码
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        直接响应
        response.getWriter().print("你好");


        return;

    }

    /**
     * 返回ModelAndView
     *
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("执行了testModelAndView的方法");
        //创建ModelAndView的对象
        ModelAndView mv = new ModelAndView();

        User user = new User();
        user.setUsername("小兄妹");
        user.setPassword("123");
        user.setAge(30);
//       把user的对象存到mv对象，也会把user对象存到request对象
        mv.addObject("user", user);
        mv.setViewName("success");
        return mv;

    }

    /**
     * 使用关键字的方式进行转发或者重定向
     *
     * @return
     */
    @RequestMapping("/testForwardOrRedircet")
    public String testForwardOrRedircet() {
        System.out.println("执行了testForwardOrRedircet的方法");
//请求的转发
        return "forward:/WEB-INF/pages/success.jsp";
//        重定向
        //     return "redircet:/response.jsp";
    }

    /**
     * 模拟异步处理数据
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(User user) {
        System.out.println("执行了testAjax的方法");
        //客户端发送ajax的请求，转的是json字符串，后端吧json字符串封装到user对象中

        //做响应，模拟查询数据库
        user.setUsername("haha");
        user.setPassword("123");
        user.setAge(12);
        System.out.println(user);
        //做响应
        return user;
    }

}

