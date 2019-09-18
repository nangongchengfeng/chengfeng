package com.smbms.servlet;

import com.smbms.model.SmbmsProvider;
import com.smbms.model.SmbmsUser;
import com.smbms.service.ProviderService;
import com.smbms.service.impl.ProviderServiceImpl;
import com.smbms.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@WebServlet(urlPatterns = "/provider")
public class ProviderServlet  extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String method = req.getParameter("method");
        switch (method){
            case "query":
                query(req,resp);
                break;
            case "delete":
                delete(req,resp);
                break;
            case "get":
                get(req,resp);
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

    private void add(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException   {
        SmbmsProvider provider = parseFull(req);
        ProviderService providerService = new ProviderServiceImpl();
        Object user = req.getSession().getAttribute("user");
        SmbmsUser u = (SmbmsUser) user;
        provider.setCreatedBy(u.getId());
        provider.setCreationDate(new Date());
        providerService.add(provider);
        resp.sendRedirect(getServletContext().getContextPath() + "/provider?method=query");
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        req.getRequestDispatcher("/providerAdd.jsp").forward(req,resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
        SmbmsProvider provider =  parseFull(req);
        ProviderService providerService = new ProviderServiceImpl();
        Object user = req.getSession().getAttribute("user");
        SmbmsUser u = (SmbmsUser) user;
        provider.setModifyBy(u.getId());
        provider.setModifyDate(new Date());
        providerService.update(provider);
        resp.sendRedirect(getServletContext().getContextPath() + "/provider?method=query");
    }

    private SmbmsProvider parseFull(HttpServletRequest req) {
        SmbmsProvider provider = parse(req);
        String id = req.getParameter("id");
        String proAddress = req.getParameter("proAddress");
        String proPhone = req.getParameter("proPhone");
        String proContact = req.getParameter("proContact");
        String proFax = req.getParameter("proFax");
        String proDesc = req.getParameter("proDesc");
        if(!StringUtil.isEmpty(id)){
            provider.setId(Long.parseLong(id));
        }
        provider.setProAddress(proAddress);
        provider.setProPhone(proPhone);
        provider.setProContact(proContact);
        provider.setProFax(proFax);
        provider.setProDesc(proDesc);
        return provider;
    }

    private void toUpdate(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
        String id = req.getParameter("id");
        ProviderService providerService = new ProviderServiceImpl();
        SmbmsProvider provider =  providerService.get(Long.parseLong(id));
        req.setAttribute("provider",provider);
        req.getRequestDispatcher("/providerModify.jsp").forward(req,resp);
    }

    private void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        String id = req.getParameter("id");
        ProviderService providerService = new ProviderServiceImpl();
        SmbmsProvider provider =  providerService.get(Long.parseLong(id));
        req.setAttribute("provider",provider);
        req.getRequestDispatcher("/providerDetail.jsp").forward(req,resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        String id = req.getParameter("id");
        ProviderService providerService = new ProviderServiceImpl();
        providerService.delete(Long.parseLong(id));
        query(req,resp);
    }

    /**
     * 简单查询（参数有供应商编码，供应商名称）
     * @param req
     * @param resp
     */
    private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SmbmsProvider provider = parse(req);
        // 处理
        ProviderService providerService = new ProviderServiceImpl();
        List<SmbmsProvider> l =  providerService.query(provider);
        req.setAttribute("providers",l);
        req.setAttribute("provider",provider);
        req.getRequestDispatcher("/providerList.jsp").forward(req,resp);
    }

    private SmbmsProvider parse(HttpServletRequest req) {
        SmbmsProvider provider = new SmbmsProvider();
        String proCode = req.getParameter("proCode");
        String proName = req.getParameter("proName");
        provider.setProCode(proCode);
        provider.setProName(proName);
        return provider;
    }
}
