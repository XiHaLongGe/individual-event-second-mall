<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2020-02-03
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加&修改关联信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/static/background/home/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/static/background/home/css/font.css">
    <link rel="stylesheet" href="/static/background/home/css/xadmin.css">
    <script src="/static/js/jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/static/background/home/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/static/background/home/js/xadmin.js?v=<%= System.currentTimeMillis()%>"></script>
    <script src="/static/background/home/lib/layui/lay/modules/initials.js"></script>
    <script src="/static/background/home/lib/layui/lay/modules/pinyin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


    <script src="/static/background/brand-inf/js/pbrAddEdit.js?v=<%= System.currentTimeMillis()%>"></script>
</head>

<body class="layui-anim layui-anim-up">
<div class="x-body">
    <div class="layui-row">
        <form id="searchFORM" class="layui-form layui-col-md12 x-so">
            <div class="layui-input-inline">
                <input id="pbrIdIdINPUT" type="hidden" value="${pbrEntity.pbrId}" />
                <input id="brandInfIdINPUT" type="hidden" value="${pbrEntity.brandInfId}" />
                <select id="brandInfNameSELECT" name="modules" lay-verify="required" lay-search=""></select>
            </div>
            <div class="layui-input-inline">
                <input id="productCategoryIdINPUT" type="hidden" value="${pbrEntity.productCategoryId}" />
                <select id="proCategorySELECT" name="modules" lay-verify="required" lay-search=""></select>
            </div>
            <button id="confirmBTN" type="button" class="layui-btn" lay-submit="">${addOrEditType}</button>
            <button type="button" class="layui-btn" onclick="x_admin_close()" >取消</button>
        </form>
    </div>
</div>
<script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });
        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });
</script>
</body>
</html>
