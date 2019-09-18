<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/23
  Time: 13:51
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
    <input type="hidden" id="referer" name="referer" value="http://localhost:8080jsp/provider.do?method=query"/>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面 >> 信息查看</span>
        </div>
        <div class="providerView">
            <p><strong>供应商编码：</strong><span>${provider.proCode}</span></p>
            <p><strong>供应商名称：</strong><span>${provider.proName}</span></p>
            <p><strong>联系人：</strong><span>${provider.proContact}</span></p>
            <p><strong>联系电话：</strong><span>${provider.proPhone}</span></p>
            <p><strong>传真：</strong><span>${provider.proFax}</span></p>
            <p><strong>描述：</strong><span>${provider.proDesc}</span></p>
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
