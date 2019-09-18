package com.smbms.servlet;

import com.smbms.model.SmbmsUser;
import com.smbms.pojo.PageInfo;
import com.smbms.pojo.UserPojo;
import com.smbms.service.UserService;
import com.smbms.service.impl.UserServiceImpl;
import com.smbms.util.DateUtil;
import com.smbms.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;


@WebServlet(urlPatterns = "/user")
public class UserServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method){
            case "toModifyPwd":
                toModifyPwd(req,resp);
                break;
            case "modifyPwd":
                modifyPwd(req,resp);
                break;
            case "query":
                query(req,resp);
                break;
            case "delete":
                delete(req,resp);
                break;
            case "queryById":
                queryById(req,resp);
                break;
            case "toUpdate":
                toUpdate(req,resp);
                break;
            case "update":
                update(req,resp);
                break;
            case "toAdd":
                toAdd(req,resp);
                break;
            case "add":
                add(req,resp);
                break;
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        SmbmsUser user = parse(req);
        Object user_ = req.getSession().getAttribute("user");
        SmbmsUser sessionUser = (SmbmsUser) user_;
        user.setCreatedBy(sessionUser.getId());
        user.setCreationDate(new Date());
        UserService userService = new UserServiceImpl();
        String userCode = req.getParameter("userCode");
        user.setUserCode(userCode);
        userService.insert(user);
        resp.sendRedirect(getServletContext().getContextPath()+"/user?method=query");
    }


    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getRequestDispatcher("/userAdd.jsp").forward(req,resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SmbmsUser user = parse(req);
        // 谁改的
        Object user_ = req.getSession().getAttribute("user");
        SmbmsUser sessionUser = (SmbmsUser) user_;
        String id = req.getParameter("id");
        user.setId(Long.parseLong(id));
        user.setModifyBy(sessionUser.getId());
        UserService userService = new UserServiceImpl();
        userService.update(user);
        resp.sendRedirect(getServletContext().getContextPath()+"/user?method=query");
    }

    /**
     * 更新前，组装User对象
     * @param req
     * @return
     */
    private SmbmsUser parse(HttpServletRequest req) {
        SmbmsUser u = new SmbmsUser();

        String userName = req.getParameter("userName");
        String birthday = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String userRole = req.getParameter("userRole");
        String gender = req.getParameter("gender");

        u.setUserName(userName);
        u.setBirthday(DateUtil.str2Date(birthday));
        u.setPhone(phone);
        u.setAddress(address);
        u.setUserRole(Long.parseLong(userRole));
        u.setGender(Integer.parseInt(gender));
        return u;
    }

    private void toUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if(StringUtil.isEmpty(id)){
            // todo  没传递ID值
        } else {
            UserService userService = new UserServiceImpl();
            SmbmsUser u = userService.queryById(Long.parseLong(id));
            req.setAttribute("queryUser",u);
            req.getRequestDispatcher("/userUpdate.jsp").forward(req,resp);
        }
    }

    private void queryById(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException  {
        String id = req.getParameter("id");
        if(StringUtil.isEmpty(id)){

            // todo  没传递ID值
        } else {
            UserService userService = new UserServiceImpl();
            SmbmsUser u = userService.queryById(Long.parseLong(id));
            req.setAttribute("queryUser",u);
            req.getRequestDispatcher("/userDetail.jsp").forward(req,resp);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException  {
        String id = req.getParameter("id");
        if(StringUtil.isEmpty(id)){

            // todo  没传递ID值
        } else {
            UserService userService = new UserServiceImpl();
            userService.deleteById(Long.parseLong(id));
            query(req,resp);
        }

    }

    private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        // 4 个条件

        String pageNum = req.getParameter("pageNum");
        String pageSize = req.getParameter("pageSize");
        String userName = req.getParameter("userName");
        String userRole = req.getParameter("userRole");

        UserPojo userPojo = new UserPojo();
        userPojo.setUserName(userName);
        if(!StringUtil.isEmpty(userRole)){
            userPojo.setUserRole(Integer.parseInt(userRole));
        }
        if(!StringUtil.isEmpty(pageNum)){
            userPojo.setPageNum(Integer.parseInt(pageNum));
        } else {
            userPojo.setPageNum(1);
        }
        if(!StringUtil.isEmpty(pageSize)){
            userPojo.setPageSize(Integer.parseInt(pageSize));
        } else {
            userPojo.setPageSize(5);
        }
        UserService userService = new UserServiceImpl();
        PageInfo<SmbmsUser> pageInfo = userService.query(userPojo);
        req.setAttribute("pageInfo",pageInfo);
        req.setAttribute("userName",userName);
        req.setAttribute("userRole",userRole);
        req.getRequestDispatcher("/userList.jsp").forward(req,resp);

    }

    private void modifyPwd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        // 根据旧的密码去查询一下
        HttpSession session = req.getSession();
        UserService userService = new UserServiceImpl();
        Object user = session.getAttribute("user");

        if(user == null){
            // todo 没资格
            resp.sendRedirect(getServletContext().getContextPath());
        } else {
            //  有
            SmbmsUser u = (SmbmsUser) user;
            SmbmsUser queryUser = userService.queryByCodePwd(u.getUserCode(),oldPassword);
            if(queryUser != null){
                // 可以改了
                userService.updatePwd(u.getUserCode(),newPassword);
                // 重新登录
                session.removeAttribute("user");
                session.invalidate();
                resp.sendRedirect(getServletContext().getContextPath());
            } else {
                // 密码错了
                req.setAttribute("msg","旧密码输入错误，无法修改！");
                toModifyPwd(req,resp);
            }
        }
    }

    private void toModifyPwd(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
        req.getRequestDispatcher("/modifyPassword.jsp").forward(req,resp);

    }
}
