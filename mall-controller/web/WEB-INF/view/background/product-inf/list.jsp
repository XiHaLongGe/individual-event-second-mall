<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2020-02-02
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品信息</title>
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
<div class="x-nav">
    <a id="refreshA" class="layui-btn layui-btn-primary layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:;" title="刷新">
        <i class="layui-icon" style="line-height:38px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form id="searchFORM" class="layui-form layui-col-md12 x-so">
            <div class="layui-input-inline">
                <input type="text" id="productInfNameINPUT"  placeholder="请输入商品名称" autocomplete="off" class="layui-input">
            </div>

            <div class="layui-input-inline">
                <select id="brandInfSELECT" name="modules" lay-search="">
                    <option value="">品牌:选择或输入搜索</option>
                </select>
            </div>

            <div class="layui-input-inline">
                <div class="layui-unselect layui-form-select downpanel">
                    <div class="layui-select-title">
                        <span class="layui-input layui-unselect" id="treeclass">选择栏目</span>
                        <input type="hidden" name="selectID" value="0">
                        <i class="layui-edge"></i>
                    </div>
                    <dl class="layui-anim layui-anim-upbit">
                        <dd>
                            <ul id="classtree"></ul>
                        </dd>
                    </dl>
                </div>
            </div>
            <button id="searchBTN" type="button" class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加商品','/mall/background/brand/inf/add/edit',300,300)"><i class="layui-icon"></i>添加商品</button>
        <span id="countSPAN" class="x-right" style="line-height:40px">共有数据：88 条</span>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div id="parentDIV" class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>序号</th>
            <th>名称</th>
            <th>品牌</th>
            <th>栏目</th>
            <th>描述</th>
            <th>价格<%--<a name="topAndBottom" href="javascript:;"><i class="iconfont nav_right">&#xe6a5;</i></a>--%></th>
            <th>销量<%--<a name="topAndBottom" href="javascript:;"><i class="iconfont nav_right">&#xe6a5;</i></a>--%></th>
            <th>库存<%--<a name="topAndBottom" href="javascript:;"><i class="iconfont nav_right">&#xe6a5;</i></a>--%></th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="customerTBODY"></tbody>
    </table>
    <div class="page">
        <div id="pageDIV">
            <a class="prev" href="">&lt;&lt;</a>
            <a class="num" href="">1</a>
            <span class="current">2</span>
            <a class="num" href="">3</a>
            <a class="num" href="">489</a>
            <a class="next" href="">&gt;&gt;</a>
        </div>
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
<script src="/static/background/product-inf/js/productInf.js?v=<%= System.currentTimeMillis()%>"></script>
</body>
</html>
