<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2019-12-02
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="/static/login/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/login/assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/login/assets/css/form-elements.css">
    <link rel="stylesheet" href="/static/login/assets/css/style.css?v=<%= System.currentTimeMillis()%>">
    <link rel="shortcut icon" href="/static/login/assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/static/login/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/static/login/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/static/login/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="/static/login/assets/ico/apple-touch-icon-57-precomposed.png">
</head>
<body>


<!-- Top content -->
<div class="top-content" style="width:100%;">
    <div class="container">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2 text">
                <h1>
                    <span class="show-login-form active">登录</span>
                    <span class="show-forms-divider">/</span>
                    <span class="show-register-form">注册</span>
                </h1>
                <div class="description">
                </div>
            </div>
        </div>
        <div class="row login-form">
            <div class="col-sm-4 col-sm-offset-4">
                <form id="loginForm" role="form" action="" method="post" class="l-form">
                    <div class="form-group">
                        <input type="text" name="loginAccount" placeholder="账号" class="l-form-username form-control" id="accountID"  onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
                    </div>
                    <div class="form-group">
                        <input type="password" name="loginPassword" placeholder="密码" class="l-form-password form-control" id="passwordID">
                    </div>
                    <button id="loginBtn" type="button" class="btn">登录</button>
                </form>
            </div>
        </div>
        <div class="row register-form">
            <div class="col-sm-4 col-sm-offset-4">
                <form id="registerForm" role="form" action="" method="post" class="l-form">
                    <div class="form-group">
                        <input type="text" name="loginName" placeholder="用户昵称" class="r-form-first-name form-control" id="for-name" maxlength='6' value="123456">
                    </div>
                    <div class="form-group">
                        <input type="password" name="loginPassword" placeholder="登录密码" class="r-form-first-name form-control" id="password" maxlength='16' value="123456">
                    </div>
                    <div class="form-group">
                        <input type="password" placeholder="确认密码" class="r-form-first-name form-control" id="confirmPassword" maxlength='16' value="123456">
                    </div>
                    <div class="form-group">
                        <input type="text" name="customerIndividualPhone" placeholder="手机号" class=" form-control" id="for-phone" maxlength='11' value="13526386954">
                    </div>
                    <div class="form-group">
                        <input type="text" name="customerIndividualEmail" placeholder="邮箱" class="r-form-email form-control" id="for-email"  maxlength='17' value="1530937232@qq.com">
                    </div>
                    <div class="form-group">
                        <div class="col-sm-7">
                            <input type="text"  placeholder="验证码" class=" form-control" id="for-verify-code"  maxlength='4'>
                        </div>
                        <div class="col-sm-5">
                            <div id="verifyCodeDIV" style="width: 200px;height: 50px;"></div>
                        </div>
                    </div>
                    <button id="registerBtn" type="button" class="btn">注册</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%--<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    登录提示
                </h4>
            </div>
            <div class="modal-body">
                登录失败，你输入的账号或密码可能存在问题！
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    确定
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>--%>
<script src="/static/js/jquery/jquery-3.3.1.min.js"></script>
<script src="/static/login/assets/js/verifyCode.js"></script>
<script src="/static/login/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="/static/login/assets/js/loginAJAX.js?v=<%= System.currentTimeMillis()%>"></script>
<script src="/static/login/assets/js/jquery.backstretch.min.js"></script>
<script src="/static/login/assets/js/scripts.js?v=<%= System.currentTimeMillis()%>"></script>
</body>
</html>
