<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/22
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<jsp:include page="fragment/nav2.jsp"/>
<!--主体内容-->
<section class="publicMian ">
    <jsp:include page="/fragment/nav.jsp"/>
    <input type="hidden" id="path" name="path" value="" /> <input
        type="hidden" id="referer" name="referer"
        value="http://localhost:8080/jsp/frame.jsp" />
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong> <span>用户管理页面</span>
        </div>
        <div class="search">
            <form method="post" action="${ctx}/user?method=query">
                <input type="hidden" name="pageNum" value="1">
                <input type="hidden" name="pageSize" value="5">
                <input name="method" value="query" class="input-text" type="hidden">
                <span>用户名：</span> <input name="userName" class="input-text"
                                         type="text" value="${userName}"> <span>用户角色：</span> <select
                    name="userRole">
                <option value="0" <c:if test="${userRole eq 0}">selected</c:if>>--请选择--</option>
                <option value="1" <c:if test="${userRole eq 1}">selected</c:if>>系统管理员</option>
                <option value="2" <c:if test="${userRole eq 2}">selected</c:if>>经理</option>
                <option value="3" <c:if test="${userRole eq 3}">selected</c:if>>普通员工</option>
            </select> <input type="hidden" name="pageIndex" value="1" /> <input
                    value="查 询" type="submit" id="searchbutton"> <a
                    href="${ctx}/user?method=toAdd">添加用户</a>
            </form>
        </div>
        <!--用户-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">用户编码</th>
                <th width="20%">用户名称</th>
                <th width="10%">性别</th>
                <th width="10%">年龄</th>
                <th width="10%">电话</th>
                <th width="10%">用户角色</th>
                <th width="30%">操作</th>
            </tr>
            <c:forEach items="${pageInfo.list}" var="obj">
                <tr>
                    <td><span>${obj.userCode}</span></td>
                    <td><span>${obj.userName}</span></td>
                    <td><span><c:choose>
                        <c:when test="${obj.gender eq 1}">女</c:when>
                        <c:when test="${obj.gender eq 2}">男</c:when>
                        <c:otherwise >未知性别</c:otherwise>
                    </c:choose></span></td>
                    <td><span>${obj.age}</span></td>
                    <td><span>${obj.phone}</span></td>
                    <td><span>${obj.role.roleName}</span></td>
                    <td><span><a class="viewUser" href="${ctx}/user?method=queryById&id=${obj.id}"
                                 userid=11 username=孙兴><img src="images/read.png" alt="查看"
                                                            title="查看" /></a></span> <span><a class="modifyUser"
                                                                                              href="${ctx}/user?method=toUpdate&id=${obj.id}" userid=11 username=孙兴><img
                            src="images/xiugai.png" alt="修改" title="修改" /></a></span> <span><a
                            class="deleteUser" href="javascript:void(0);" onclick="del('${obj.id}')"><img
                            src="images/schu.png" alt="删除" title="删除" /></a></span>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <input type="hidden" id="totalPageCount" value="3" />
        <div class="page-bar">
            <ul class="page-num-ul clearfix">
                <li>共${pageInfo.total}条记录&nbsp;&nbsp; ${pageInfo.pageNum}/${pageInfo.pages}页</li>
                <a href="javascript:void(0)" page="first">首页</a>
                <a href="javascript:void(0)" page="prev">上一页</a>
                <a href="javascript:void(0)" page="next">下一页</a>
                <a href="javascript:void(0)" page="last">最后一页</a>
            </ul>
            <span class="page-go-form"><label>跳转至</label> <input
                    type="text" name="inputPage" id="inputPage" class="page-key" />页
					<button type="button" class="page-btn" id="go">GO</button>
				</span>
        </div>
    </div>

    <!--点击删除按钮后弹出的页面开始-->
    <div class="zhezhao"></div>
    <div class="remove" id="removeUse">
        <div class="removerChid">
            <h2>提示</h2>
            <div class="removeMain">
                <p>你确定要删除该用户吗？</p>
                <a href="#" id="yes">确定</a> <a href="#" id="no">取消</a>
            </div>
        </div>
    </div>
    <!--点击删除按钮后弹出的页面结束-->
</section>

<footer class="footer"> 版权归北大青鸟 </footer>
<script type="text/javascript" src="${ctx}/js/time.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/common.js"></script>
<script type="text/javascript" src="${ctx}/calendar/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/layer/layer.js"></script>
<script>
    $(function () {
        $('a[page]').click(function () {
            var v = $(this).attr('page');
            // 表单里面 pageNum
            var targetPageNum = 1;
            var pageNum = '${pageInfo.pageNum}';
            var pages = '${pageInfo.pages}';
            if(v == 'first'){
                targetPageNum = 1;
            } else if(v == 'prev'){
                if(pageNum <= 1)
                    return;
                targetPageNum = pageNum - 1;
            } else if (v == 'next'){
                if(pageNum >= pages)
                    return;
                targetPageNum = parseInt(pageNum) + 1;
            } else if (v == 'last'){
                if(pageNum >= pages)
                    return;
                targetPageNum = pages;
            }
            $('form input[name=pageNum]').val(targetPageNum);
            $('form').submit();
        })
        
        $('#go').click(function () {
            var pages = '${pageInfo.pages}';
            var inputPage = $('#inputPage').val();
            inputPage = parseInt(inputPage);
            if(inputPage < 1 || inputPage > pages)
                return;
            $('form input[name=pageNum]').val(inputPage);
            $('form').submit();

        })


    })

    // 删除》》》》》》》》》》》》》》》》》》》》》》》
    function  del(id) {
        layer.confirm('你确定要删除吗？', {icon: 3, title:'提示'}, function(index){
            location.href='${ctx}/user?method=delete&id='+id;
            layer.close(index);
        });
    }
    // 删除《《《《《《《《《《《《《《《《《《《《《《《
</script>
</body>
</html>

