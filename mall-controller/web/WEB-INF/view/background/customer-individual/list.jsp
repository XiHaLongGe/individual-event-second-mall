<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2020-01-28
  Time: 06:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户信息表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/static/background/backend/home/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/static/background/backend/home/css/font.css">
    <link rel="stylesheet" href="/static/background/backend/home/css/xadmin.css">
    <script src="/static/js/jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/static/background/backend/home/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/static/background/backend/home/js/xadmin.js?v=<%= System.currentTimeMillis()%>"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body class="layui-anim layui-anim-up">
<div class="x-nav">
      <%--<span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>--%>
    <a id="refreshA" class="layui-btn layui-btn-primary layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:;" title="刷新">
        <i class="layui-icon" style="line-height:38px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form id="searchFORM" class="layui-form layui-col-md12 x-so">
            <input class="layui-input" placeholder="开始出生日" id="start">
            <input class="layui-input" placeholder="结束出生日" id="end">
            <input type="text" id="IndividualNameINPUT"  placeholder="请输入用户姓名" autocomplete="off" class="layui-input">
            <button id="searchBTN" type="button" class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
            男：<div id="manDIV" name="sex" value="0" class="layui-unselect layui-form-checkbox" lay-skin=""><i class="layui-icon"></i></div>
            女：<div id="womanDIV" name="sex" value="1" class="layui-unselect layui-form-checkbox" lay-skin=""><i class="layui-icon"></i></div>
        </form>
    </div>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <span id="countSPAN" class="x-right" style="line-height:40px">共有数据：${pageInfo.total} 条</span>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div id="parentDIV" class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>序号</th>
            <th>用户姓名</th>
            <th>用户性别</th>
            <th>用户身份证号</th>
            <th>用户手机号</th>
            <th>用户邮箱</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="customerTBODY">
            <c:forEach var="customerIndividualEntity" items="${pageInfo.list}" varStatus="thisObject">
                <tr>
                    <td>
                        <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${customerIndividualEntity.customerIndividualId}'><i class="layui-icon">&#xe605;</i></div>
                    </td>
                    <td>${thisObject.index + 1}</td>
                    <td>${customerIndividualEntity.customerIndividualName}</td>
                    <td>
                        <c:if test="${customerIndividualEntity.customerIndividualGender == 0}">
                            男
                        </c:if>
                        <c:if test="${customerIndividualEntity.customerIndividualGender == 1}">
                            女
                        </c:if>
                    </td>
                    <td>${customerIndividualEntity.customerIndividualCard}</td>
                    <td>${customerIndividualEntity.customerIndividualPhone}</td>
                    <td>${customerIndividualEntity.customerIndividualEmail}</td>
                    <td class="td-manage">
                        <a title="删除" onclick="member_del(this,'要删除的id')" href="javascript:;">
                            <i class="layui-icon">&#xe640;</i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="page">
        <div id="pageDIV">
            <a class="prev"  href="/mall/background/customer/individual/home?pageNum=1">&lt;&lt;</a>
            <a class="prev"  href="/mall/background/customer/individual/home?pageNum=${pageInfo.prePage}">&lt;</a>
                <c:forEach begin="1" end="${pageInfo.pages}" var="num">
                    <c:choose>
                        <c:when test="${num == pageInfo.pageNum}">
                            <span class="current">${num}</span>
                        </c:when>
                        <c:otherwise>
                            <a class="num"  href="/mall/background/customer/individual/home?pageNum=${num}">${num}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            <a class="next"  href="/mall/background/customer/individual/home?pageNum=${pageInfo.nextPage}">&gt;</a>
            <a class="next"  href="/mall/background/customer/individual/home?pageNum=${pageInfo.pages}">&gt;&gt;</a>
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
<script src="/static/background/backend/customer-individual/customerIndividual.js?v=<%= System.currentTimeMillis()%>"></script>
</body>

</html>
