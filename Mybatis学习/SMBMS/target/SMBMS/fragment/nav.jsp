<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/22
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="left">
    <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
    <nav>
        <ul class="list">
            <li ><a href="${ctx}/bill?method=query">订单管理</a></li>
            <li><a href="${ctx}/provider?method=query">供应商管理</a></li>
            <li><a href="${ctx}/user?method=query">用户管理</a></li>
            <li><a href="${ctx}/user?method=toModifyPwd">密码修改</a></li>
            <li><a href="${ctx}/logout">退出系统</a></li>
        </ul>
    </nav>
</div>