<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2020-02-04
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加&修改商品信息</title>
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

    <style type="text/css">
        .downpanel .layui-select-title span {
            line-height: 38px;
        }

        /*继承父类颜色*/
        .downpanel dl dd:hover {
            background-color: inherit;
        }
    </style>
    <style type="text/css">
        body {
            height: 100%;
            width: 100%;
            background-size: cover;
            margin: 0 auto;
        }
        td {
            font-size: 12px !important;
        }

        .layui-form-checkbox span {
            height: 30px;
        }
        .layui-field-title {
            border-top: 1px solid white;
        }
        table {
            width: 100% !important;
        }

    </style>
</head>

<body class="layui-anim layui-anim-up">
<input id="productInfIdINPUT" type="hidden" value="${productInfEntity.productInfId}"/>
<input id="brandInfIdINPUT" type="hidden" value="${productInfEntity.brandInfId}"/>
<input id="productCategoryNameINPUT" type="hidden" value="${productInfEntity.productCategoryName}"/>
<input id="productCategoryIdINPUT" type="hidden" value="${productInfEntity.productCategoryId}"/>

<div class="x-body">
    <div class="layui-row">
        <form id="searchFORM" class="layui-form layui-col-md12 x-so">
            <div class="layui-input-inline">
                <input type="text" id="productInfNameINPUT" placeholder="请输入商品名称" autocomplete="off" class="layui-input" value="${productInfEntity.productInfName}">
            </div>
            <br/><br/>
            <div class="layui-input-inline">
                <select id="brandInfSELECT" name="modules" lay-verify="required" lay-search=""></select>
            </div>
            <br/><br/>
            <div class="layui-input-inline">
                <div class="layui-unselect layui-form-select downpanel">
                    <div class="layui-select-title">
                        <span class="layui-input layui-unselect" id="treeclass">选择栏目</span>
                        <input type="hidden" name="selectID" value="">
                        <i class="layui-edge"></i>
                    </div>
                    <dl class="layui-anim layui-anim-upbit">
                        <dd>
                            <ul id="classtree"></ul>
                        </dd>
                    </dl>
                </div>
            </div>
            <br/><br/>
            <div class="layui-input-inline">
                <textarea id="proTEXTAREA" maxlength="50" style="width: 230px; height: 10px;" placeholder="商品描述" class="layui-textarea">${productInfEntity.productInfDescribe}</textarea>
            </div>
            <br/><br/>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" id="priceINPUT" placeholder="￥商品价格" value="${productInfEntity.productInfPrice}" autocomplete="off" class="layui-input">
            </div>
            <br/><br/>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" id="stockpileINPUT" placeholder="商品库存" value="${productInfEntity.productInfStockpile}" autocomplete="off" class="layui-input">
            </div>
            <br/><br/>
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
<script src="/static/background/product-inf/js/productInfAddEdit.js?v=<%= System.currentTimeMillis()%>"></script>
</body>
</html>
