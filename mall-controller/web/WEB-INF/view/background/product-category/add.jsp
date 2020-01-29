<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2020-01-29
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>商品类型添加界面</title>
    <script src="/static/js/jquery/jquery-3.3.1.min.js"></script>
    <script src="/static/background/backend/home/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/static/background/backend/home/js/xadmin.js?v=<%= System.currentTimeMillis()%>"></script>
</head>
<body>
    类型名称：
    <input type="text" placeholder="类型名称" />
    </br></br>
    类型描述：
    <textarea maxlength="60">

    </textarea>
    </br></br>
    类型层级：
    <select id="columnSELECT">
        <option hidden>请选择</option>
        <option value="1">商品父栏目</option>
        <option value="2">商品子栏目</option>
        <option value="3">主页父栏目</option>
        <option value="4">主页子栏目</option>
    </select>
    </br></br>
    父类型：
    <select id="parentSELECT">
        <option hidden>请选择</option>
        <option>1</option>
        <option>2</option>
        <option>3</option>
    </select>
    </br></br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="submit" value="添加"/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" onclick="x_admin_close()" value="取消"/>
<script src="/static/background/backend/product-category/js/productCategoryAdd.js"></script>
</body>
</html>
