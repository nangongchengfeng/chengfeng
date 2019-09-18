package com.smbms.servlet;

import com.smbms.model.SmbmsBill;
import com.smbms.model.SmbmsProvider;
import com.smbms.model.SmbmsUser;
import com.smbms.service.OrderService;
import com.smbms.service.ProviderService;
import com.smbms.service.impl.OrderServiceImpl;
import com.smbms.service.impl.ProviderServiceImpl;
import com.smbms.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@WebServlet(urlPatterns = "/bill")
public class BillServlet extends HttpServlet {


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

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SmbmsBill bill = parseFull(req);
        OrderService orderService = new OrderServiceImpl();
        Object user0 = req.getSession().getAttribute("user");
        if(user0 != null){
            SmbmsUser user = (SmbmsUser) user0;
            bill.setCreatedBy(user.getId());
            bill.setCreationDate(new Date());
        }
        orderService.add(bill);
        resp.sendRedirect(getServletContext().getContextPath()+"/bill?method=query");

    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
        ProviderService providerService = new ProviderServiceImpl();
        req.setAttribute("providers",providerService.queryAll());
        req.getRequestDispatcher("/billAdd.jsp").forward(req,resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
        SmbmsBill bill = parseFull(req);
        OrderService orderService = new OrderServiceImpl();
        orderService.update(bill);
        resp.sendRedirect(getServletContext().getContextPath() + "/bill?method=query");

    }

    private SmbmsBill parseFull(HttpServletRequest req) {
        SmbmsBill bill = parse(req);
        String id = req.getParameter("id");
        String productUnit = req.getParameter("productUnit");
        String productCount = req.getParameter("productCount");
        String totalPrice = req.getParameter("totalPrice");
        String billCode = req.getParameter("billCode");
        if(!StringUtil.isEmpty(id)){
            bill.setId(Long.parseLong(id));
        }
        bill.setBillCode(billCode);
        bill.setProductUnit(productUnit);
        // 金额
        bill.setProductCount(BigDecimal.valueOf(Double.parseDouble(productCount)));
        bill.setTotalPrice(BigDecimal.valueOf(Double.parseDouble(totalPrice)));
        return bill;
    }

    private void toUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        OrderService orderService = new OrderServiceImpl();
        SmbmsBill bill = orderService.get(Long.parseLong(id));
        ProviderService providerService = new ProviderServiceImpl();
        req.setAttribute("bill",bill);
        req.setAttribute("providers", providerService.queryAll());
        req.getRequestDispatcher("/billModify.jsp").forward(req,resp);

    }

    private void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        OrderService orderService = new OrderServiceImpl();
        SmbmsBill bill = orderService.get(Long.parseLong(id));
        req.setAttribute("bill",bill);
        req.getRequestDispatcher("/billDetail.jsp").forward(req,resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        OrderService orderService = new OrderServiceImpl();
        orderService.delete(Long.parseLong(id));
        resp.sendRedirect(getServletContext().getContextPath() + "/bill?method=query");
    }

    private void query(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
        OrderService orderService = new OrderServiceImpl();
        SmbmsBill bill = parse(req);
        List<SmbmsBill> l = orderService.query(bill);
        ProviderService providerService = new ProviderServiceImpl();
        List<SmbmsProvider> providers =  providerService.queryAll();
        req.setAttribute("bill",bill);
        req.setAttribute("bills",l);
        req.setAttribute("providers",providers);
        req.getRequestDispatcher("/billList.jsp").forward(req,resp);
    }

    private SmbmsBill parse(HttpServletRequest req) {
        // 供应商ID，产品名称 是否付款
        SmbmsBill bill = new SmbmsBill();
        String providerId = req.getParameter("providerId");
        String productName = req.getParameter("productName");
        String isPayment = req.getParameter("isPayment");
        if(!StringUtil.isEmpty(providerId)) {
            bill.setProviderId(Long.parseLong(providerId));
        }
        if(!StringUtil.isEmpty(isPayment)) {
            bill.setIsPayment(Integer.parseInt(isPayment));
        }

        bill.setProductName(productName);
        return bill;
    }
}
