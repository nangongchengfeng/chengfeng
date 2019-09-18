<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/24
  Time: 13:42
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
    <input type="hidden" id="referer" name="referer" value="http://localhost:8080/SMBMS/jsp/provider.do?method=query"/>

    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>订单管理页面</span>
        </div>
        <div class="search">
            <form method="post" action="${ctx}/bill?method=query">
                <input name="method" value="query" class="input-text" type="hidden">
                <span>商品名称：</span>
                <input name="productName" type="text" value="${bill.productName}">
                <span>供应商：</span>
                <select name="providerId">
                    <option value="0">--请选择--</option>
                    <c:forEach items="${providers}" var="obj">
                        <option value="${obj.id}" <c:if test="${bill.providerId eq obj.id}">selected</c:if>>${obj.proName}</option>
                    </c:forEach>
                </select>
                <span>是否付款：</span>
                <select name="isPayment">
                    <option value="0">--请选择--</option>
                    <option value="1" <c:if test="${bill.isPayment eq 1}">selected</c:if>>未支付</option>
                    <option value="2" <c:if test="${bill.isPayment eq 2}">selected</c:if>>已支付</option>
                </select>

                <input	value="查 询" type="submit" id="searchbutton">
                <a href="${ctx}/bill?method=toAdd">添加订单</a>
            </form>
        </div>
        <!--账单表格 样式和供应商公用-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">订单编码</th>
                <th width="20%">商品名称</th>
                <th width="10%">供应商</th>
                <th width="10%">订单金额</th>
                <th width="10%">是否付款</th>
                <th width="10%">创建时间</th>
                <th width="30%">操作</th>
            </tr>
            <c:forEach items="${bills}" var="obj">
                <tr>
                    <td>
                        <span>${obj.billCode}</span>
                    </td>
                    <td>
                        <span>${obj.productName}</span>
                    </td>
                    <td>
                        <span>${obj.provider.proName}</span>
                    </td>
                    <td>
                        <span>${obj.totalPrice}</span>
                    </td>
                    <td>
                        <span>
                            <c:if test="${obj.isPayment eq 1}" >
                                未支付
                            </c:if>
                            <c:if test="${obj.isPayment eq 2}" >
                                已支付
                            </c:if>
                        </span>
                    </td>
                    <td>
                        <span>
                            <fmt:formatDate value="${obj.creationDate}"/>
                        </span>
                    </td>
                    <td>
                        <span><a class="viewBill" href="${ctx}/bill?method=get&id=${obj.id}" ><img src="${ctx}/images/read.png" alt="查看" title="查看"/></a></span>
                        <span><a class="modifyBill" href="${ctx}/bill?method=toUpdate&id=${obj.id}" billid=1 billcc=BILL2016_001><img src="${ctx}/images/xiugai.png" alt="修改" title="修改"/></a></span>
                        <span><a class="deleteBill" href="javascript:void(0);"  onclick="del('${obj.id}')"><img src="${ctx}/images/schu.png" alt="删除" title="删除"/></a></span>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>
<footer class="footer">
    版权归北大青鸟
</footer>
<script type="text/javascript" src="${ctx}/js/time.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/common.js"></script>
<script type="text/javascript" src="${ctx}/calendar/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/layer/layer.js"></script>
<script>
    // 删除》》》》》》》》》》》》》》》》》》》》》》》
    function  del(id) {
        layer.confirm('你确定要删除吗？', {icon: 3, title:'提示'}, function(index){
            location.href='${ctx}/bill?method=delete&id='+id;
            layer.close(index);
        });
    }
    // 删除《《《《《《《《《《《《《《《《《《《《《《《
</script>
</body>
</html>
