package com.smbms.servlet;

import com.smbms.model.SmbmsUser;
import com.smbms.service.UserService;
import com.smbms.service.impl.UserServiceImpl;
import com.smbms.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/login")
public class LoginServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         // 登录业务
        SmbmsUser user = handle(req);
        if(user == null){
            resp.sendRedirect(getServletContext().getContextPath());
        }else{
            // 调用业务层处理登录业务
            UserService userService = new UserServiceImpl();
            SmbmsUser u = userService.login(user);
            if(u == null){
                resp.sendRedirect(getServletContext().getContextPath());
            } else {
                u.setUserPassword(null);
                req.getSession().setAttribute("user",u);
                resp.sendRedirect(getServletContext().getContextPath() + "/frame.jsp");
            }
        }
    }

    private SmbmsUser handle(HttpServletRequest req) {
        SmbmsUser user = new SmbmsUser();
        String userCode = req.getParameter("userCode");
        if(StringUtil.isEmpty(userCode))
            return null;
        String userPassword = req.getParameter("userPassword");
        if(StringUtil.isEmpty(userPassword))
            return null;
        user.setUserCode(userCode);
        user.setUserPassword(userPassword);
        return user;
    }
}
