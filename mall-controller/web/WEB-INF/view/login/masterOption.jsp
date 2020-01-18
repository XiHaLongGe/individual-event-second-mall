<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2020-01-18
  Time: 10:12
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
                                    亲爱的管理员，请选择您要进入的界面
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
                        <a class="btn btn-primary btn-lg" href="/backstage/home/index">管理页面</a>
                    </div>
                    <div class="col-md-1 column"></div>
                    <div class="col-md-1 column"></div>
                    <div class="col-md-2 column">
                        <a class="btn btn-primary btn-lg" href="/frontstage/home/index">前台页面</a>
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
