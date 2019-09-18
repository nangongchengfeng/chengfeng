package com.smbms.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionLoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 希望截取所有请求，都必须要先登录
        HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();
        String contextPath = req.getContextPath();
        String uri = requestURI.substring(contextPath.length());
        System.out.println(uri);
        if(uri.equals("/") || uri.equals("/login")){
            // 放行
            chain.doFilter(req,response);
        } else {
            Object user = req.getSession().getAttribute("user");
            if(user != null){
                chain.doFilter(req,response);
            } else {
                HttpServletResponse res = (HttpServletResponse) response;
                res.sendRedirect(req.getContextPath());
            }
        }
//        chain.doFilter(req,response);
    }
}
