<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2020-02-06
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

    <title>个人中心</title>
    <link href="/static/foreground/personal/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.bootcss.com/amazeui/2.5.1/css/amazeui.css" rel="stylesheet" type="text/css" />
    <link href="/static/foreground/personal/css/personal.css" rel="stylesheet" type="text/css">
    <link href="/static/foreground/personal/css/systyle.css" rel="stylesheet" type="text/css">

    <link rel="stylesheet" href="/static/background/home/css/font.css">
    <link rel="stylesheet" href="/static/background/home/css/xadmin.css">
    <script src="/static/js/jquery/jquery-3.3.1.min.js" charset="utf-8"></script>
    <script src="/static/background/home/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/static/background/home/js/xadmin.js?v=<%= System.currentTimeMillis()%>"></script>

</head>

<body>
<div class="center">
    <div class="col-main">
        <div class="main-wrap">
            <div class="wrap-left">
                <div class="wrap-list">
                    <div class="m-user">
                        <!--个人信息 -->
                        <div class="m-bg"></div>
                        <div class="m-userinfo">
                            <div class="m-baseinfo">
                                <a href="javascript:;"  onclick="x_admin_show('个人信息','/mall/foreground/personal/information/home')">
                                    <img src="${customerLoginEntity.headIconUrl}">
                                </a>
                                <em class="s-name">${loginName}</em>
                                <div class="s-prestige am-btn am-round">
                                    </div>
                            </div>
                            <div class="m-right">
                                <div class="m-address">
                                    <a href="/mall/foreground/receiving/home" class="i-trigger">我的收货地址</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="box-container-bottom"></div>

                    <!--订单 -->
                    <div class="m-order">
                        <div class="s-bar">
                            <i class="s-icon"></i>我的订单
                            <a class="i-load-more-item-shadow" href="order.html">全部订单</a>
                        </div>
                        <ul>
                            <li><a href="order.html"><i><img src="/static/foreground/personal/images/pay.png"/></i><span>待付款</span></a></li>
                            <li><a href="order.html"><i><img src="/static/foreground/personal/images/send.png"/></i><span>待发货<em class="m-num">1</em></span></a></li>
                            <li><a href="order.html"><i><img src="/static/foreground/personal/images/receive.png"/></i><span>待收货</span></a></li>
<%--                            <li><a href="order.html"><i><img src="/static/foreground/personal/images/comment.png"/></i><span>待评价<em class="m-num">3</em></span></a></li>--%>
<%--                            <li><a href="change.html"><i><img src="/static/foreground/personal/images/refund.png"/></i><span>退换货</span></a></li>--%>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <aside class="menu">
        <ul>
            <li class="person active">
                <a href="/mall/foreground/personal/home">个人中心</a>
            </li>
            <li class="person">
                <a>个人资料</a>
                <ul>
                    <li> <a href="javascript:;" onclick="x_admin_show('个人信息','/mall/foreground/personal/information/home')">个人信息</a></li>
                    <li> <a href="/mall/foreground/receiving/home">收货地址</a></li>
                </ul>
            </li>
            <li class="person">
                <a>我的交易</a>
                <ul>
                    <li><a href="order.html">订单管理</a></li>
                </ul>
            </li>
        </ul>
    </aside>
</div>
</body>
</html>
