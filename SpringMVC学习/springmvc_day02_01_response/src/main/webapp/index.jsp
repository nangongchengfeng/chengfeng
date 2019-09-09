<%--
  Created by IntelliJ IDEA.
  User: 长风破浪
  Date: 2019/9/4
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功</title>
    <script src="js/jquery.min.js"></script>
    <script>
        //界面加载,绑定单击事件
        $(function () {
            $("#btn").click(function () {
                //alert("nihao")
                // 编写json格式，设置属性和值
                $.ajax({
                    url: "user/testAjax",
                    contentType: "application/json;charset=Utf-8",
                    data: '{"username":"hehe","password":"123","age":12}',
                    dataType: "json",
                    type: "post",
                    success: function (data) {
                        // data服务器端响应的json的数据，进行分析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });
            });


        });
    </script>
</head>
<body>
<a href="user/testSting">testSting</a>
<br>
<a href="user/testVoid">testVoid</a>
<br>
<a href="user/testModelAndView">testModelAndView</a>
<br>
<a href="user/testForwardOrRedircet">testForwardOrRedircet</a>

<br>
<button id="btn">发送ajax的请求</button>
</body>
</html>
