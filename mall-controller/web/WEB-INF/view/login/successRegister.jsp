<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2020-01-18
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
    <script type="text/javascript" src="/static/js/jquery/jquery-3.3.1.min.js" ></script>
</head>
<body>
<section id="main">
    <h2>注册成功</h2>
    <h2>请到填入的邮箱中激活该帐号，并记住此账号: ${param.account}</h2>
    <h1 id="time"></h1>
    <a href="/mall/login">直接回到登录界面</a>
</section>
<script>
    $(function(){
        var i = 10;
        //10秒后返回登录界面
        setTimeout(function (){window.location.href='/mall/login?account=' + ${param.account};},10000);
        after();
        function after(){
            $("#time").empty().append(i + "秒后自动返回登录界面");
            i -= 1;
            setTimeout(after,1000);
        }
    })
</script>
</body>
</html>
