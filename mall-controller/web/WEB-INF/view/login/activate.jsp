<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2019-12-04
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0" />
    <title>激活界面</title>
    <link rel="stylesheet" href="/static/toolTip/example/example.css">
    <script src="/static/toolTip/lib/sweet-alert.js"></script>
    <link rel="stylesheet" href="/static/toolTip/lib/sweet-alert.css">
    <script src="/static/js/jquery/jquery-3.3.1.min.js"></script>
</head>
<body>
<h1 id="time"></h1>
<c:if test="${activate == true}">
    <p hidden id="activateResult">激活成功！</p>
</c:if>
<c:if test="${activate == false}">
    <p hidden id="activateResult">激活失败！请你确保激活码是否已过期(激活码有效期：----)，如果出现其他问题 请联系管理员：QQ:1530937232 Email:1530937232@qq.com</p>
</c:if>

<script>
    $(function(){
        var i = 5;
        swal({
            title: $("#activateResult").text(),
            text: i + "秒后跳转到登录界面",
            timer: 5000
        });
        //5秒后返回首页
        setTimeout(function (){window.location.href='/foreground/customer/login/index';},5000);
        after();
        function after(){
            $("#time").empty().append(i);
            i -= 1;
            setTimeout(after,1000);
        }
    })
</script>
</body>
</html>
