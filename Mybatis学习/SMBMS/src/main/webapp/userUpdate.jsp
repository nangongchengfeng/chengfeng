<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/22
  Time: 15:48
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
    <input type="hidden" id="referer" name="referer" value="http://localhost:8080jsp/user.do?method=query&queryname=&queryUserRole=0&pageIndex=1"/>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
            <form id="userForm" name="userForm" method="post" action="${ctx}/user?method=update">
                <input type="hidden" name="id" value="${queryUser.id}"/>
                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" value="${queryUser.userName}">
                    <font color="red"></font>
                </div>
                <div>
                    <label >用户性别：</label>
                    <select name="gender" id="gender">
                        <option value="1"  <c:if test="${queryUser.gender  eq 1}">selected</c:if>>女</option>
                        <option value="2"  <c:if test="${queryUser.gender  eq 2}">selected</c:if>>男</option>
                    </select>
                </div>
                <div>
                    <label for="data">出生日期：</label>

                    <input type="text" Class="Wdate" id="birthday" name="birthday" value='<fmt:formatDate value="${queryUser.birthday}"/>'
                           readonly="readonly" onclick="WdatePicker();">
                    <font color="red"></font>
                </div>

                <div>
                    <label for="userphone">用户电话：</label>
                    <input type="text" name="phone" id="phone" value="${queryUser.phone}">
                    <font color="red"></font>
                </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="address" id="address" value="${queryUser.address}">
                </div>
                <div>
                    <label >用户角色：</label>
                    <!-- 列出所有的角色分类 -->
                    <input type="hidden" value="3" id="rid" />
                    <select name="userRole" id="userRole">
                        <option value="1" <c:if test="${queryUser.role.id eq 1}">selected</c:if>>超级管理员</option>
                        <option value="2" <c:if test="${queryUser.role.id eq 2}">selected</c:if>>经理</option>
                        <option value="3" <c:if test="${queryUser.role.id eq 3}">selected</c:if>>普通员工</option>
                    </select>
                    <font color="red"></font>
                </div>
                <div class="providerAddBtn">
                    <input type="submit" name="save" id="save" value="保存" />
                    <input type="button" id="back" name="back" value="返回" onclick="javascript:history.go(-1)"/>
                </div>
            </form>
        </div>
    </div>
</section>


<footer class="footer">
    版权归北大青鸟
</footer>
<script type="text/javascript" src="js/time.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="calendar/WdatePicker.js"></script>
</body>
</html>
