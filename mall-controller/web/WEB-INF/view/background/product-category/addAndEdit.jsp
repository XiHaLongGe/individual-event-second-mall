<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2020-01-29
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>商品类型添加修改界面</title>
    <script src="/static/js/jquery/jquery-3.3.1.min.js"></script>
    <script src="/static/background/backend/home/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/static/background/backend/home/js/xadmin.js?v=<%= System.currentTimeMillis()%>"></script>
</head>
<body>
<form id="addColumnForm">
    <input id="productCategoryId" type="hidden" name="productCategoryId" value="${productCategoryEntity.productCategoryId}" />
    类型名称：
    <input name="productCategoryName" id="columnName" type="text" placeholder="类型名称" value="${productCategoryEntity.productCategoryName}" />
    </br></br>
    类型描述：
    <textarea name="sidebarCategoryDescribe" maxlength="60">${productCategoryEntity.sidebarCategoryDescribe}</textarea>
    </br></br>
    类型层级：
    <select name="productCategoryLevel" id="columnSELECT">
        <c:choose>
            <c:when test="${productCategoryEntity.productCategoryLevel == 1}">
                <option value="1" selected>商品父栏目</option>
                <option value="2">商品子栏目</option>
                <option value="3">主页父栏目</option>
                <option value="4">主页子栏目</option>
            </c:when>
            <c:when test="${productCategoryEntity.productCategoryLevel == 2}">
                <option value="1">商品父栏目</option>
                <option value="2" selected>商品子栏目</option>
                <option value="3">主页父栏目</option>
                <option value="4">主页子栏目</option>
            </c:when>
            <c:when test="${productCategoryEntity.productCategoryLevel == 3}">
                <option value="1">商品父栏目</option>
                <option value="2">商品子栏目</option>
                <option value="3" selected>主页父栏目</option>
                <option value="4">主页子栏目</option>
            </c:when>
            <c:when test="${productCategoryEntity.productCategoryLevel == 4}">
                <option value="1">商品父栏目</option>
                <option value="2">商品子栏目</option>
                <option value="3">主页父栏目</option>
                <option value="4" selected>主页子栏目</option>
            </c:when>
            <c:otherwise>
                <option value="1">商品父栏目</option>
                <option value="2">商品子栏目</option>
                <option value="3">主页父栏目</option>
                <option value="4">主页子栏目</option>
            </c:otherwise>
        </c:choose>
    </select>
    </br></br>
    <input id="parentId" type="hidden" value="${productCategoryEntity.parentId}"/>
    父类型：
    <select id="parentSELECT" name="parentId" disabled>
        <option hidden>请选择</option>
    </select>
    </br></br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input id="addOrEditBtn" type="button" value="${addOrEditType}"/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" onclick="x_admin_close()" value="取消"/>
</form>
<script src="/static/background/backend/product-category/js/productCategoryAddAndEdit.js?v=<%= System.currentTimeMillis()%>"></script>
</body>
</html>
