<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/24
  Time: 14:09
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
            <span>订单管理页面 >> 信息查看</span>
        </div>
        <div class="providerView">
            <p><strong>订单编号：</strong><span>${bill.billCode}</span></p>
            <p><strong>商品名称：</strong><span>${bill.productName}</span></p>
            <p><strong>商品单位：</strong><span>${bill.productUnit}</span></p>
            <p><strong>商品数量：</strong><span>${bill.productCount}</span></p>
            <p><strong>总金额：</strong><span>${bill.totalPrice}</span></p>
            <p><strong>供应商：</strong><span>${bill.provider.proName}</span></p>
            <p><strong>是否付款：</strong>
                <span>
				<c:if test="${bill.isPayment eq 1}">未支付</c:if>
				<c:if test="${bill.isPayment eq 2}">已支付</c:if>
			</span>
            </p>
            <div class="providerAddBtn">
                <input type="button" id="back" name="back" value="返回" onclick="javascript:history.go(-1)" >
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
