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


@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //  登出
        req.getSession().removeAttribute("user");
        req.getSession().invalidate();
        resp.sendRedirect(getServletContext().getContextPath());
    }


}
