<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2020-02-07
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title id="title">商品信息</title>
    <%--提示框的样式与脚本---------------------------------------------------------%>

    <link rel="stylesheet" href="/static/toosTips/example/example.css">
    <script src="/static/toosTips/lib/sweet-alert.js"></script>
    <link rel="stylesheet" href="/static/toosTips/lib/sweet-alert.css">

    <%----------------------------------------------------------------------------%>
    <link rel="stylesheet" href="/static/foreground/product-inf/css/shouye.css?v=<%= System.currentTimeMillis()%>">
    <script src="/static/foreground/product-inf/js/jquery-1.11.1.min.js"></script>
    <script   src="/static/foreground/product-inf/js/modernizr-custom-v2.7.1.min.js"></script>
    <script>
        $(document).ready(function(){
            var $miaobian=$('.Xcontent08>div');
            var $huantu=$('.Xcontent06>img');
            var $miaobian1=$('.Xcontent26>div');
            $miaobian.mousemove(function(){miaobian(this);});
            $miaobian1.click(function(){miaobian1(this);});
            function miaobian(thisMb){
                for(var i=0; i<$miaobian.length; i++){
                    $miaobian[i].style.borderColor = '#dedede';
                }
                thisMb.style.borderColor = '#cd2426';

                $huantu[0].src = thisMb.children[0].src;
            }
            function miaobian1(thisMb1){
                for(var i=0; i<$miaobian1.length; i++){
                    $miaobian1[i].style.borderColor = '#dedede';
                }
//		thisMb.style.borderColor = '#cd2426';
                $miaobian.css('border-color','#dedede');
                thisMb1.style.borderColor = '#cd2426';
                $huantu[0].src = thisMb1.children[0].src;
            }
            $(".Xcontent33").click(function(){
                var value=parseInt($('.input').val())+1;
                $('.input').val(value);
            })

            $(".Xcontent32").click(function(){
                var num = $(".input").val()
                if(num>1){
                    $(".input").val(num-1);
                }
            })
        })
    </script>
</head>
<body>
<input type="hidden" value="${productInfId}" id="productInfId"/>
<input type="hidden" value="${loginId}" id="loginIdINPUT"/>
<div id="headDIV" class="Xcontent14">
    <a href="/mall/foreground/home"><p>首页&nbsp;&nbsp;&nbsp;</p></a>
    <a href="javascript:;" onclick="self.location=document.referrer;"><p>返回&nbsp;&nbsp;&nbsp;</p></a>
    <a href="/mall/foreground/product/cart/home"><p>查看购物车&nbsp;&nbsp;&nbsp;</p></a>
</div>
<div class="Xcontent">
    <ul class="Xcontent01">
        <div id="firstPicDIV" class="Xcontent06"><img src="/static/foreground/product-inf/images/shangpinxiangqing/X1.png"></div>
        <ol class="Xcontent08" id="productPicOL">
            <div class="Xcontent07"><img src="/static/foreground/product-inf/images/shangpinxiangqing/X1.png"></div>
            <div class="Xcontent09"><img src="/static/foreground/product-inf/images/shangpinxiangqing/X7.png"></div>
            <div class="Xcontent10"><img src="/static/foreground/product-inf/images/shangpinxiangqing/X8.png"></div>
            <div class="Xcontent11"><img src="/static/foreground/product-inf/images/shangpinxiangqing/X9.png"></div>
            <div class="Xcontent12"><img src="/static/foreground/product-inf/images/shangpinxiangqing/X10.png"></div>
        </ol>
        <ol class="Xcontent13" id="productBuyOL">
            <div class="Xcontent14"><a href="#"><p>新物品</p></a></div>
            <div class="Xcontent15"><img src="/static/foreground/product-inf/images/shangpinxiangqing/X11.png"></div>
            <div class="Xcontent16"><p>充电5分钟，温暖2小时</p></div>
            <div class="Xcontent17">
                <p class="Xcontent18">售价</p>
                <p class="Xcontent19">￥<span>69.00</span></p>
                <div class="Xcontent20">
                    <p class="Xcontent21">促销</p>
                    <img src="/static/foreground/product-inf/images/shangpinxiangqing/X12.png">
                    <p class="Xcontent22">领610元新年礼券，满再赠好礼</p>
                </div>
                <div class="Xcontent23">
                    <p class="Xcontent24">服务</p>
                    <p class="Xcontent25">30天无忧退货&nbsp;&nbsp;&nbsp;&nbsp;       48小时快速退款 &nbsp;&nbsp;&nbsp;&nbsp;        满88元免邮</p>
                </div>
            </div>
            <div class="Xcontent26">
                <p class="Xcontent27">颜色</p>
                <div class="Xcontent28"><img  src="/static/foreground/product-inf/images/shangpinxiangqing/X14.png"></div>
                <div class="Xcontent29"><img  src="/static/foreground/product-inf/images/shangpinxiangqing/X1.png"></div>
            </div>
            <div class="Xcontent30">
                <p class="Xcontent31">数量</p>
                <div class="Xcontent32"><img src="/static/foreground/product-inf/images/shangpinxiangqing/X15.png"></div>
                <form><input class="input" value="1"></form>
                <div class="Xcontent33"><img src="/static/foreground/product-inf/images/shangpinxiangqing/16.png"></div>
            </div>
            <div class="Xcontent34"><a href="#"><img src="/static/foreground/product-inf/images/shangpinxiangqing/X17.png"></a></div>
            <div class="Xcontent35"><a href="#"><img src="/static/foreground/product-inf/images/shangpinxiangqing/X18.png"></a></div>
        </ol>
    </ul>
</div>
<script src="/static/foreground/product-inf/js/productBuy.js?v=<%= System.currentTimeMillis()%>"></script>
</body>
</html>
