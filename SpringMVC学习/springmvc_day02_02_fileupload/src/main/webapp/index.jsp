<%--
  Created by IntelliJ IDEA.
  User: 长风破浪
  Date: 2019/9/5
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<h3>传统文件上传</h3>

<form action="/user/fileupload1" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"/><br/>
    <input type="submit" value="上传"/>
</form>
<br>
<h3>SpringMVC上传</h3>
<form action="/user/fileupload2" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"/><br/>
    <input type="submit" value="上传"/>
</form>
<br>
<h3>跨服务器上传</h3>
<form action="/user/fileupload3" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"/><br/>
    <input type="submit" value="上传"/>
</form>

</body>
</html>
