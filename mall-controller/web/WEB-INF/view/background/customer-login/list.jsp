<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2020-01-25
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/static/background/backend/home/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/static/background/backend/home/css/font.css">
    <link rel="stylesheet" href="/static/background/backend/home/css/xadmin.css">
    <script src="/static/js/jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/static/background/backend/home/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/static/background/backend/home/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body class="layui-anim layui-anim-up">
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
    <a id="refreshA" class="layui-btn layui-btn-primary layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:;" title="刷新">
        <i class="layui-icon" style="line-height:38px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form id="searchFORM" class="layui-form layui-col-md12 x-so">
            <%--<input class="layui-input" placeholder="开始日" name="startTime" id="start">
            <input class="layui-input" placeholder="截止日" name="endTime" id="end">--%>
            <input type="text" id="loginNameINPUT"  placeholder="请输入用户昵称" autocomplete="off" class="layui-input">
            <button id="searchBTN" type="button" class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
            激活：<div id="activateDIV" name="activate" value="1" class="layui-unselect layui-form-checkbox" lay-skin=""><i class="layui-icon"></i></div>
            未激活：<div id="notActivateDIV" name="activate" value="0" class="layui-unselect layui-form-checkbox" lay-skin=""><i class="layui-icon"></i></div>
            管理员：<div id="adminDIV" name="identity" value="1" class="layui-unselect layui-form-checkbox" lay-skin=""><i class="layui-icon"></i></div>
            普通用户：<div id="ordinaryDIV" name="identity" value="0" class="layui-unselect layui-form-checkbox" lay-skin=""><i class="layui-icon"></i></div>
        </form>
    </div>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加用户','/mall/background/customer/login/add/customer',800,525)"><i class="layui-icon"></i>添加用户</button>
        <span id="countSPAN" class="x-right" style="line-height:40px">共有数据：88 条</span>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div id="parentDIV" class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>序号</th>
            <th>头像</th>
            <th>用户昵称</th>
            <th>登录账号</th>
            <th>账号状态</th>
            <th>用户身份</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="customerTBODY">
        <tr>
            <td>
                <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
            </td>
            <td>1</td>
            <td>小明</td>
            <td>男</td>
            <td>13000000000</td>
            <td>admin@mail.com</td>
            <td>北京市 海淀区</td>
            <td class="td-status">
                <span class="layui-btn layui-btn-normal layui-btn-sm">已启用</span></td>
            <td class="td-manage">
                <a onclick="member_stop(this,'10001')" href="javascript:;"  title="启用">
                    <i class="layui-icon">&#xe601;</i>
                </a>
                <a title="编辑"  onclick="x_admin_show('编辑','member-edit.html',600,400)" href="javascript:;">
                    <i class="layui-icon">&#xe642;</i>
                </a>
                <a onclick="x_admin_show('重置密码','member-password.html',600,400)" title="重置密码" href="javascript:;">
                    <i class="layui-icon">&#xe631;</i>
                </a>
                <a title="删除" onclick="member_del(this,'要删除的id')" href="javascript:;">
                    <i class="layui-icon">&#xe640;</i>
                </a>
            </td>
        </tr>
        </tbody>
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
<script src="/static/background/backend/home/js/customerLoginList.js?v=<%= System.currentTimeMillis()%>"></script>
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
