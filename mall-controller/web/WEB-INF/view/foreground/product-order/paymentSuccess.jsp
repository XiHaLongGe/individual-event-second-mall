<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2020-02-08
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>选择界面</title>
    <script type="text/javascript" src="/static/js/jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/static/js/bootstrap/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css"/>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <fieldset>
            <div class="col-md-12 column">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <div class="row clearfix">
                            <div class="col-md-3 column">
                            </div>
                            <div class="col-md-6 column">
                                <h2>
                                    付款成功，请选择您要进入的界面
                                </h2>
                            </div>
                            <div class="col-md-3 column">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row clearfix">
                    <div class="col-md-3 column"></div>
                    <div class="col-md-2 column">
                        <a class="btn btn-primary btn-lg" href="/mall/foreground/home">主界面继续购物</a>
                    </div>
                    <div class="col-md-1 column"></div>
                    <div class="col-md-1 column"></div>
                    <div class="col-md-2 column">
                        <a class="btn btn-primary btn-lg" href="/mall/foreground/personal/home">个人中心查看完成订单</a>
                    </div>
                    <div class="col-md-3 column"></div>
                </div>
            </div>
        </fieldset>
    </div>
</div>
<script type="text/javascript" src="/static/js/login/assets/js/masterOption.js"></script>
</body>
</html>
