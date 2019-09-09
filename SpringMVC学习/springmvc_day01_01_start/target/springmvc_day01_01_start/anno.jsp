<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/29
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--常用的注解--%>

<a href="anno/testRequestParam?name=haha">RequestParam</a>

<br>

<%--requestboy的注解--%>
<form action="anno/testRequestboy" method="post">
    姓名：<input type="text" name="username"/><br>
    密码：<input type="text" name="age"/><br>
    <input type="submit" value="提交"/><br>
</form>

</body>
</html>
