<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/23
  Time: 13:39
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
    <input type="hidden" id="referer" name="referer" value="http://localhost:8080jsp/pwdmodify.jsp"/>

    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面</span>
        </div>
        <div class="search">
            <form method="post" action="${ctx}/provider?method=query">
                <input name="method" value="query" type="hidden">
                <span>供应商编码：</span>
                <input name="proCode" type="text" value="${provider.proCode}">

                <span>供应商名称：</span>
                <input name="proName" type="text" value="${provider.proName}">

                <input value="查 询" type="submit" id="searchbutton">
                <a href="${ctx}/provider?method=toAdd">添加供应商</a>
            </form>
        </div>
        <!--供应商操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">供应商编码</th>
                <th width="20%">供应商名称</th>
                <th width="10%">联系人</th>
                <th width="10%">联系电话</th>
                <th width="10%">传真</th>
                <th width="10%">创建时间</th>
                <th width="30%">操作</th>
            </tr>
            <c:forEach items="${providers}" var="obj">
                <tr>
                    <td>${obj.proCode}</td>
                    <td>${obj.proName}</td>
                    <td>${obj.proContact}</td>
                    <td>${obj.proPhone}</td>
                    <td>${obj.proFax}</td>
                    <td><fmt:formatDate value="${obj.creationDate}"/></td>
                    <td>
                    <span><a class="viewProvider" href="${ctx}/provider?method=get&id=${obj.id}" proid=1 proname=北京三木堂商贸有限公司><img
                            src="images/read.png" alt="查看" title="查看"/></a></span>
                        <span><a class="modifyProvider" href="${ctx}/provider?method=toUpdate&id=${obj.id}"  ><img
                                src="images/xiugai.png" alt="修改" title="修改"/></a></span>
                        <span><a class="deleteProvider" href="javascript:void(0);"  onclick="del('${obj.id}')"><img
                                src="images/schu.png" alt="删除" title="删除"/></a></span>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>
</section>
<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeProv">
    <div class="removerChid">
        <h2>提示</h2>

        <div class="removeMain">
            <p>你确定要删除该供应商吗？</p>
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
            location.href='${ctx}/provider?method=delete&id='+id;
            layer.close(index);
        });
    }
    // 删除《《《《《《《《《《《《《《《《《《《《《《《
</script>
</body>
</html>