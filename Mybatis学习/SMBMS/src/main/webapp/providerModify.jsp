<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/23
  Time: 13:59
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
            <span>供应商管理页面 >> 供应商修改页</span>
        </div>
        <div class="providerAdd">
            <form id="providerForm" name="providerForm" method="post" action="${ctx}/provider?method=update">
                <input type="hidden" name="id" value="${provider.id}">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="proCode">供应商编码：</label>
                    <input type="text" name="proCode" id="proCode" value="${provider.proCode}" readonly="readonly">
                </div>
                <div>
                    <label for="proName">供应商名称：</label>
                    <input type="text" name="proName" id="proName" value="${provider.proName}">
                    <font color="red"></font>
                </div>

                <div>
                    <label for="proContact">联系人：</label>
                    <input type="text" name="proContact" id="proContact" value="${provider.proContact}">
                    <font color="red"></font>
                </div>

                <div>
                    <label for="proPhone">联系电话：</label>
                    <input type="text" name="proPhone" id="proPhone" value="${provider.proPhone}">
                    <font color="red"></font>
                </div>

                <div>
                    <label for="proAddress">联系地址：</label>
                    <input type="text" name="proAddress" id="proAddress" value="${provider.proAddress}">
                </div>

                <div>
                    <label for="proFax">传真：</label>
                    <input type="text" name="proFax" id="proFax" value="${provider.proFax}">
                </div>

                <div>
                    <label for="proDesc">描述：</label>
                    <input type="text" name="proDesc" id="proDesc" value="${provider.proDesc}">
                </div>
                <div class="providerAddBtn">
                    <input type="submit" name="save" id="save" value="保存">
                    <input type="button" id="back" name="back" value="返回"  onclick="javascript:history.go(-1)">
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
