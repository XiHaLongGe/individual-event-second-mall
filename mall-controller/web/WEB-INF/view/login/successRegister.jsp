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
    <!-- meta -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="renderer" content="webkit">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width" />
    <title>注册成功</title>
    <script type="text/javascript" src="/js/jquery/jquery-3.3.1.min.js" ></script>
    <link rel="stylesheet" type="text/css" href="/css/login/dmaku.css" />
</head>
<body>
<header id="header">
    <a href="javascript:;" class="logo"></a>
    <i class="icons">beta</i>
</header>
<!-- /header -->
<!-- 页面主体START -->
<input type="hidden" value="false" id="isVisiable_request_form_verifyCode" />
<input type="hidden" value="true" id="is_must_show_verify_code" />
<section id="main">
    <h2>注册成功</h2>
    <h2>请到填入的邮箱中激活该帐号，并记住此账号: ${account}</h2>
    <a href="/mall/login">直接回到登录界面</a>
    <h1 id="time"></h1>
</section>
<script>
    $(function(){
        var i = 5;
        //5秒后返回登录界面
        setTimeout(function (){window.location.href='/mall/login';},5000);
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
