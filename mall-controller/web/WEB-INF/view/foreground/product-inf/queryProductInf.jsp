<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2020-02-09
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>商品查询</title>
    <meta http-equiv="X-UA-Compatible" content="edge" />
    <link rel="stylesheet" type="text/css" href="/static/foreground/product-inf/css/style.css">
    <link rel="stylesheet" type="text/css" href="/static/foreground/home/css/index.css?v=<%= System.currentTimeMillis()%>">
    <script src="/static/foreground/home/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/static/foreground/product-inf/js/script.js?v=<%= System.currentTimeMillis()%>"></script>
    <script src="/static/foreground/home/js/jquery.fly.min.js?v=<%= System.currentTimeMillis()%>"></script>
    <script src="/static/foreground/home/js/public.js?v=<%= System.currentTimeMillis()%>"></script>
    <script src="/static/foreground/home/js/base.js?v=<%= System.currentTimeMillis()%>"></script>
    <script>document.createElement("top")</script>
    <script>document.createElement("search")</script>
    <script>document.createElement("light")</script>
    <script>document.createElement("light1")</script>
</head>
<body>
<input type="hidden" value="${loginId}" id="loginIdINPUT"/>
<!--头部-->
<top>
    <section class="seck">
        <div class="register_login">
            <em>您好，${loginName}</em>
            <a id="logoutA" href="javascript:;">注销登录</a>
        </div>
        <script>
            $("#logoutA").click(function(){
                $.ajax({
                    url:"/mall/login/clear/session",
                    type:"POST",
                    success:function(data){
                        if(data.code == 200){
                            window.location = data.data;
                        }else{
                            alert(data.message);
                            console.log(data.message);
                        }
                    }
                })
            })
        </script>
        <div class="vip_center">
            <a target="_blank" href="/mall/foreground/personal/home">个人中心</a>
        </div>
    </section>
</top>

<div id="headDIV" class="Xcontent14">
    <a href="/mall/foreground/home"><p>首页&nbsp;&nbsp;&nbsp;</p></a>
    <a href="javascript:;" onclick="self.location=document.referrer;"><p>返回&nbsp;&nbsp;&nbsp;</p></a>
</div>
<!--header-->
<div class="maxbj1">
    <header>
        <b class="logo"><img src="/static/foreground/home/images/logo.png"></b>
        <search>
            <form>
                <input id="queryINPUT" type="text" placeholder="查询关键词..." value="${productInfName}" required style=" width:440px; height:30px; text-indent:2em; float:left; box-shadow:none">
                <a id="seacrhBtn" href="javascript:;"><button style="pointer-events: none;">搜索</button></a>
            </form>
        </search>
    </header>
</div>
<script>
    $("#seacrhBtn").click(function () {
        if($("#queryINPUT").val() != ""){
            searchProduct();
            searchBrandInf();
        }else{
            alert("查询字段不可为空");
        }
    })
</script>
<ul class="select">
    <li class="select-list">
        <dl id="select1">
            <dt>品牌：</dt>
            <dd class="select-all selected"><a href="#">全部</a></dd>
            <dd><a href="#">针织衫</a></dd>
            <dd><a href="#">毛呢外套</a></dd>
            <dd><a href="#">T恤</a></dd>
            <dd><a href="#">羽绒服</a></dd>
            <dd><a href="#">棉衣</a></dd>
            <dd><a href="#">卫衣</a></dd>
            <dd><a href="#">风衣</a></dd>
        </dl>
    </li>
    <li class="select-list">
        <dl id="select2">
            <dt>价格：</dt>
            <dd class="select-all selected" beginPrice="0" endPrice="0"><a href="#">全部</a></dd>
            <dd beginPrice="0" endPrice="100"><a href="#">0-100</a></dd>
            <dd beginPrice="100" endPrice="200"><a href="#">100-200</a></dd>
            <dd beginPrice="200" endPrice="500"><a href="#">200-500</a></dd>
            <dd beginPrice="500" endPrice="1000"><a href="#">500-1000</a></dd>
            <dd beginPrice="1000" endPrice="0"><a href="#">1000以上</a></dd>
        </dl>
    </li>
    <li class="select-result">
        <dl>
            <dt>已选条件：</dt>
            <dd id="filterDD" class="select-no">暂时没有选择过滤条件</dd>
        </dl>
    </li>
</ul>
<script>
    searchBrandInf();
    /*查询对应商品的品牌信息*/
    function searchBrandInf(){
        $.ajax({
            url: "/mall/foreground/brand/inf/belong?productInfName=" + $("#queryINPUT").val(),
            type: "GET",
            async: false,//设置为同步
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                var html = "<dt>品牌：</dt>";
                html += "<dd class=\"select-all selected\" brandId=\"0\"><a href=\"#\">全部</a></dd>";
                $.each(data.data,function (index, element) {
                    html += "<dd brandId=\"" + element.brandInfId + "\"><a href=\"#\">" + element.brandInfName + "</a></dd>";
                })
                $("#select1").empty().append(html);
            }
        })
    }
</script>
<div id="productInfDIV">
    <div class="currency f-1-lt01">
        <ul>
            <li>
                <a href="Blessingpackage.html"><img src="/static/foreground/home/images/56da66aeN557ae881.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="Blessingpackage.html"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>

            </li>
            <li>

                <a href="Blessingpackage.html"><img src="/static/foreground/home/images/56da66aeN557ae881.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="Blessingpackage.html"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="Blessingpackage.html"><img src="/static/foreground/home/images/56da66aeN557ae881.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="Blessingpackage.html"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>

                <a href="Blessingpackage.html"><img src="/static/foreground/home/images/56da66aeN557ae881.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="Blessingpackage.html"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>

                <a href="Blessingpackage.html"><img src="/static/foreground/home/images/56da66aeN557ae881.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="Blessingpackage.html"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-1-lt01">
        <ul>
            <li>
                <a href="Blessingpackage.html"><img src="/static/foreground/home/images/56da66aeN557ae881.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="Blessingpackage.html"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>

            </li>
            <li>

                <a href="Blessingpackage.html"><img src="/static/foreground/home/images/56da66aeN557ae881.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="Blessingpackage.html"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="Blessingpackage.html"><img src="/static/foreground/home/images/56da66aeN557ae881.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="Blessingpackage.html"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>

                <a href="Blessingpackage.html"><img src="/static/foreground/home/images/56da66aeN557ae881.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="Blessingpackage.html"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="Blessingpackage.html"><img src="/static/foreground/home/images/56da66aeN557ae881.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="Blessingpackage.html"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
</div>
<script>
    searchProduct();
    /*查询商品信息*/
    function searchProduct(){
        $.ajax({
            url: "/mall/foreground/product/inf/name/data",
            type: "GET",
            data: "productInfName=" + $("#queryINPUT").val() +
                "&brandInfId=" + $("#select1").children('dd.selected').attr("brandId") +
                "&beginPrice=" + $("#select2").children('dd.selected').attr("beginPrice") +
                "&endPrice=" + $("#select2").children('dd.selected').attr("endPrice"),
            async: false,//设置为同步
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                var html = "";
                html += "<div class=\"currency f-1-lt01\">";
                html += "<ul>";
                var i = 0;
                $.each(data.data,function (index, element) {
                    if(i++%5 === 0){
                        html += "</ul>";
                        html += "</div>";
                        html += "<div class=\"currency f-1-lt01\">";
                        html += "<ul>";
                    }

                    html += "<li>";
                    html += "<a href=\"/mall/foreground/product/inf/home?productInfId=" + element.productInfId + "\" target=\"_blank\"><img src=\"" + element.pictureInfUrl + "\" style=\" margin:0 auto; display:block; width:220px; height:220px\"></a>";
                    html += "<light1>";
                    html += "<img src=\"/static/foreground/home/images/saoguang.png\">";
                    html += "</light1>";
                    html += "<span>￥" + element.productInfPrice + "</span>";
                    html += "<a href=\"/mall/foreground/product/inf/home?productInfId=" + element.productInfId + "\" target=\"_blank\"><p>" + element.productInfName + "</p></a>";
                    html += "<em>";
                    html += "<a href=\"#\">收藏</a>";
                    html += "<a onclick='addCart($(this))' productId=" + element.productInfId + " href=\"javascript:void(0)\" class=\"add_scar\">加入购物车</a>";
                    html += "</em>";
                    html += "</li>";


                    if (index === Object.keys(data.data).length - 1){
                        html += "</ul>";
                        html += "</div>";
                    }
                })
                $("#productInfDIV").empty().append(html);
            }
        })
    }

    function addCart($this){
        var productId = $this.attr("productId");
        var cartNum = $("#cartNumB").text();
        $.ajax({
            url:"/mall/foreground/product/cart/add/cart",
            type:"POST",
            data:JSON.stringify({"loginId" : $("#loginIdINPUT").val(), "productInfId" : productId, "productCartNum" : 1}),
            async: false,//设置为同步
            contentType: "application/json",
            success:function(data){
                if(data.code == 200){
                    $("#cartNumB").text(parseInt(cartNum) + 1)
                }else{
                    alert(data.message);
                }
            }
        })
    }
</script>

<div class="toolbar">
    <a href="/mall/foreground/product/cart/home" class="toolbar-item toolbar-item-weixin" style=" position:relative">
        <em style=" position:absolute; display:block; line-height:20px; font-size:12px; color:#f00; top:-20px; left:0">(<b id="cartNumB">0</b>)</em>
        <!--<span class="toolbar-layer"></span>-->
    </a>
    <%--<a href="###" class="toolbar-item toolbar-item-feedback"></a>
    <a href="###" class="toolbar-item toolbar-item-app">
        <span class="toolbar-layer"></span>
    </a>--%>
    <a href="javascript:scroll(0,0)" id="top" class="toolbar-item toolbar-item-top"></a>
</div>
<script>
    $.ajax({
        url:"/mall/foreground/product/cart/data/count?loginId=" + $("#loginIdINPUT").val(),
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            if(data.data != null){
                $("#cartNumB").text(data.data)
            }else{
                $("#cartNumB").text(0)
            }
        }
    })
</script>
</body>
</html>
