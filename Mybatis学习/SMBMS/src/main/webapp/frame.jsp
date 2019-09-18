<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/18
  Time: 15:00
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
    <input type="hidden" id="referer" name="referer" value="http://localhost:8080login.do"/>
    <div class="right">
        <!-- 主体内容发生变化的地方开始-->
        <div>
            <img class="wColck" src="images/clock.jpg" alt=""/>
            <div class="wFont">
                <h2>系统管理员</h2>
                <p>欢迎来到超市订单管理系统!</p>
            </div>
        </div>
        <!-- 主体内容发生变化的地方结束-->
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
