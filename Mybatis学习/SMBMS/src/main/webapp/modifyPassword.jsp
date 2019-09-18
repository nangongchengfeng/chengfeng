<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/22
  Time: 13:32
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
    <input type="hidden" id="referer" name="referer" value="http://localhost:8080jsp/useradd.jsp"/>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>密码修改页面</span>
        </div>
        <div class="providerAdd">
            <form id="userForm" name="userForm" method="post" action="${ctx}/user?method=modifyPwd">
                <input type="hidden" name="method" value="savepwd">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="info"></div>
                <div class="">
                    <label for="oldPassword">旧密码：</label>
                    <input type="password" name="oldPassword" id="oldpassword" value="">
                    <font color="red"></font>
                </div>
                <div>
                    <label for="newPassword">新密码：</label>
                    <input type="password" name="newPassword" id="newpassword" value="">
                    <font color="red"></font>
                </div>
                <div>
                    <label for="rnewpassword">确认新密码：</label>
                    <input type="password" name="rnewpassword" id="rnewpassword" value="">
                    <font color="red"></font>
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <input type="submit" name="save" id="save" value="保存" class="input-button">
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
<script type="text/javascript" src="${ctx}/layer/layer.js"></script>
<script>
    var msg = '${msg}';
    if(isNotEmpty(msg)){
        layer.msg(msg);
    }


    function isNotEmpty(obj) {
        if(obj != null && obj != '' && obj != undefined ){
            return true;
        }
        return false;
    }
</script>
</body>
</html>
