<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2020-02-07
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>uiduck demo</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="/static/foreground/uiduck/css/uiduck.css" type="text/css" rel="stylesheet">
    <link href="/static/foreground/uiduck/css/table.css" type="text/css" rel="stylesheet">
    <script src="/static/js/jquery/jquery-3.3.1.min.js"></script>
</head>
<body>
<input id="loginIdINPUT" hidden value="${loginId}" >
<div style="width: 80%;padding: 0 10%;padding-bottom: 200px;">
    <div id="ud-top" style="display: block;">
        <input id="search" ud-keyWord="productName" class="uiduck-input" /><button class="uiduck-btn" onClick=setData()>搜索</button>
    </div>
    <div id="table">
        <table id="uiduck_1577158080757" class="uiduck-table">
            <thead>
            <tr>
                <th class="" style="font-weight: bold">序号</th>
                <th class="" style="font-weight:bold">商品名称</th>
                <th class="" style="font-weight:bold">商品价格</th>
                <th class="" style="width:65px;font-weight:bold">商品图片</th>
                <th class="" style="font-weight:bold">订单编号</th>
                <th class="" style="font-weight:bold">支付方式</th>
                <th class="" style="font-weight:bold">订单状态</th>
                <th class="" style="width:100px">操作</th>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
        <script src="/static/foreground/uiduck/js/orderLoad.js?v=<%= System.currentTimeMillis()%>"> </script>
        <br>
        <%--<div class="uiduck-page noselect">
            <a class="uiduck-page-disable">首页</a>
            <a class="uiduck-page-disable">上一页</a>
            <span class="uiduck-page-its">
        <em class="uiduck-page-em"></em>
        <em>1</em>
    </span>
            <a onclick="uiduck.skipPage(1)">2</a>
            <a class="layui-laypage-next" onclick="uiduck.nextPage();">下一页</a>
            <a onclick="uiduck.lastPage();">尾页</a>
            <span>共 7 条</span>
            <span class="uiduck-page-limits">
        <select id="ud-page-select" onchange="uiduck.changeLimit(this.value)">
            <option value="5" selected="">5 条/页</option>
            <option value="10">10 条/页</option>
            <option value="15">15 条/页</option>
            <option value="20">20 条/页</option>
            <option value="25">25 条/页</option>
            <option value="30">30 条/页</option>
        </select>
    </span>
            <span class="uiduck-page-skip">前往
        <input id="ud-page-skip-text" type="text" min="1" value="1" class="uiduck-page-input">页
            <button type="button" class="uiduck-page-btn" onclick="uiduck.skipPage()">确定</button>
    </span>
        </div>--%>
        <img id="ud-loading" style="position: absolute; left: 674.297px; top: 309.313px; width: 21.32px; height: 21.32px; z-index: 1003; display: none;" src="/static/foreground/uiduck/assets/uiduck-loading-6.gif">
    </div>
</div>
</body>
<script language="Javascript" src="/static/foreground/uiduck/js/json2.js"></script>
<script language="Javascript" src="/static/foreground/uiduck/js/uiduck.js"></script>
</html>
