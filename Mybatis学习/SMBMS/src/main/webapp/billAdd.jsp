<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/24
  Time: 14:15
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
    <input type="hidden" id="referer" name="referer" value="http://localhost:8080jsp/bill.do?method=query"/>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>订单管理页面 >> 订单添加页面</span>
        </div>
        <div class="providerAdd">
            <form id="billForm" name="billForm" method="post" action="${ctx}/bill?method=add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="billCode">订单编码：</label>
                    <input type="text" name="billCode" id="billCode" value="" >
                </div>
                <div>
                    <label for="productName">商品名称：</label>
                    <input type="text" name="productName" id="productName" value="">
                    <font color="red"></font>
                </div>
                <div>
                    <label for="productUnit">商品单位：</label>
                    <input type="text" name="productUnit" id="productUnit" value="">
                    <font color="red"></font>
                </div>
                <div>
                    <label for="productCount">商品数量：</label>
                    <input type="text" name="productCount" id="productCount" value="">
                    <font color="red"></font>
                </div>
                <div>
                    <label for="totalPrice">总金额：</label>
                    <input type="text" name="totalPrice" id="totalPrice" value="">
                    <font color="red"></font>
                </div>
                <div>
                    <label for="providerId">供应商：</label>
                    <input type="hidden" value="13" id="pid" />
                    <select name="providerId" id="providerId">
                        <c:forEach items="${providers}" var="obj" >
                            <option value="${obj.id}"  >${obj.proName}</option>
                        </c:forEach>
                    </select>
                    <font color="red"></font>
                </div>
                <div>
                    <label >是否付款：</label>
                    <input type="radio" name="isPayment" value="1">未付款
                    <input type="radio" name="isPayment" value="2" >已付款

                </div>
                <div class="providerAddBtn">
                    <input type="submit" name="save" id="save" value="保存">
                    <input type="button" id="back" name="back" value="返回" >
                </div>
            </form>
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
