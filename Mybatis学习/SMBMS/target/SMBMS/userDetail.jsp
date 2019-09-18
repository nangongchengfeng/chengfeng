<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/22
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<jsp:include page="fragment/nav2.jsp"/>
<!--主体内容-->
<section class="publicMian ">

    <jsp:include page="/fragment/nav.jsp"/>
    <input type="hidden" id="path" name="path" value="/SMBMS"/>
    <input type="hidden" id="referer" name="referer"
           value="http://localhost:8080jsp/user.do?method=query&queryname=&queryUserRole=0&pageIndex=1"/>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户信息查看页面</span>
        </div>
        <div class="providerView">
            <p><strong>用户编号：</strong><span>${queryUser.userCode}</span></p>
            <p><strong>用户名称：</strong><span>${queryUser.userName}</span></p>
            <p><strong>用户性别：</strong>
                <span>
					<c:choose>
                        <c:when test="${queryUser.gender eq 1}">女</c:when>
                        <c:when test="${queryUser.gender eq 2}">男</c:when>
                        <c:otherwise >未知性别</c:otherwise>
                    </c:choose>
				</span>
            </p>

            <p><strong>出生日期：</strong><span><fmt:formatDate value="${queryUser.birthday}"/></span></p>

            <p><strong>用户电话：</strong><span>${queryUser.phone}</span></p>

            <p><strong>用户地址：</strong><span>${queryUser.address}</span></p>

            <p><strong>用户角色：</strong><span>${queryUser.role.roleName}</span></p>

            <div class="providerAddBtn">
                <input type="button" id="back" name="back" value="返回" onclick="javascript:history.go(-1)">
            </div>
        </div>
    </div>
</section>


<footer class="footer">
    版权归北大青鸟
</footer>
<script type="text/javascript" src="${ctx}/js/time.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/common.js"></script>
<script type="text/javascript" src="${ctx}/calendar/WdatePicker.js"></script>
</body>
</html>
