<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2020-02-06
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>商城系统</title>
    <meta http-equiv="X-UA-Compatible" content="edge" />
    <link rel="stylesheet" type="text/css" href="/static/foreground/home/css/index.css?v=<%= System.currentTimeMillis()%>">
    <script src="/static/foreground/home/js/jquery-1.8.3.min.js?v=<%= System.currentTimeMillis()%>"></script>
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
<!--header-->
<div class="maxbj1">
    <header>
        <b class="logo"><img src="/static/foreground/home/images/logo.png"></b>
        <search>
            <form action="/mall/foreground/product/inf/query/product" type="POST">
                <input name="productInfName" type="text" placeholder="查询关键词..." required style=" width:440px; height:30px; text-indent:2em; float:left; box-shadow:none">
                <button><a>搜索</a></button>
            </form>
        </search>
    </header>
</div>
<!--导航-->
<section class="dao_hang">
    <nav>
        <!--全部商品分类-->
        <div class="important"><img src="/static/foreground/home/images/all_list.png" style=" margin-top:8px">&nbsp;全部商品分类
            <aside>
                <ul id="categoryUL">
                    <li class="cates"  mt-ct="list01">
                        <h3>卫生洁具</h3>
                        <p>
                            <a href="#">洗衣粉</a>
                            <a href="#">马桶刷</a>
                            <a href="#">不锈钢龙头</a>
                            <i style="font-family:'宋体';color:#666; line-height:23px; font-size:14px; float:left">></i>
                        </p>
                    </li>
                </ul>
            </aside>
            <div id="categorySpreadDIV">
                <div class="import_list b-list1">
                    <dt>与内容无关：</dt>
                    <dd>
                        <a href="#">T恤</a>
                        <a href="#">休闲裤</a>
                        <a href="#">条纹T</a>
                        <a href="#">牛仔裤</a>
                        <a href="#">针织运动裤</a>
                        <a href="#">潮T</a>
                        <a href="#">格子衬衫</a>
                        <a href="#">村棉印花T恤</a>
                        <a href="#">纯色衬衫</a>
                        <a href="#">牛仔夹克</a>
                        <a href="#">迷彩风</a>
                    </dd>
                </div>
            </div>
        </div>
        <!--结束-->
        <div class="dao_list">
            <a href="#">首页</a>
        </div>
    </nav>
</section>
<script src="/static/foreground/home/js/head.js?v=<%= System.currentTimeMillis()%>"></script>
<!--banner-->
<div id="banner_tabs" class="flexslider">
    <ul id="bannerUL" class="slides">
        <li style="display: list-item;">
            <a title="" target="_blank" href="#">
                <img width="1920" height="500" alt="" style="background: url(/static/foreground/home/images/banner1.png) no-repeat center;" src="/static/foreground/home/images/HUAWEI_P30_Pro.jpg">
            </a>
        </li>
        <li>
            <a title="" href="#">
                <img width="1920" height="500" alt="" style="background: url(/static/foreground/home/images/banner1.png) no-repeat center;" src="/static/foreground/home/images/ThinkBook.jpg">
            </a>
        </li>
    </ul>
    <ul class="flex-direction-nav">
        <li><a class="flex-prev" href="javascript:;">Previous</a></li>
        <li><a class="flex-next" href="javascript:;">Next</a></li>
    </ul>
    <ol id="bannerCtrl" class="flex-control-nav flex-control-paging">
        <li class="active"><a>1</a></li>
        <li><a>2</a></li>
    </ol>
</div>
<script src="/static/foreground/home/js/banner.js?v=<%= System.currentTimeMillis()%>"></script>
<script src="/static/foreground/home/js/slider.js?v=<%= System.currentTimeMillis()%>"></script>
<!--gong告-->
<script type="text/javascript">
    window.onload=function(){
        $("top").animate({'margin-top':'0'},2000)
        $(".advertisement").animate({'top':'30','opacity':'1'},200)
        $(".flexslider").animate({'margin-top':'0'},200)
        $("aside").animate({'top':'30','opacity':'1'},200)
        $("top").animate({'margin-top':'-400'},1000)

    }
</script>
<!--楼层分布图-->
<div class="fixed_position">
    <div class="fixed_position_1">
        <ul id="navigationUL">
            <li>超级福包</li>
            <li>应季商品</li>
            <li>母婴之家</li>
            <li>厨房用品</li>
            <li>生活必备</li>
            <li>个性筛选</li>
            <li>推荐商品</li>
        </ul>
    </div>
</div>
<script src="/static/foreground/home/js/navigation.js?v=<%= System.currentTimeMillis()%>"></script>
<!--热销商品-->
<span class="as blessing_package">
	<h3 id="hotSaleH3">热销商品<font>热销商品，赶快来抢购</font><a href="#">更多热销商品</a></h3>
</span>
<div class="three_fb">
    <ul id="hotSaleUL">
        <li>
            <light>
                <img src="/static/foreground/home/images/saoguang1.png">
            </light>
            <a href="liebiao_page.html"><img src="/static/foreground/home/images/1.jpg"></a>
            <span>价值288元</span>
            <a href="#">查看福包</a>
            <em>200人已购买</em>
        </li>
        <li>
            <light>
                <img src="/static/foreground/home/images/saoguang1.png">
            </light>
            <a href="liebiao_page.html"><img src="/static/foreground/home/images/3.jpg"></a>
            <span>价值288元</span>
            <a href="#">查看福包</a>
            <em>200人已购买</em>
        </li>
        <li>
            <light>
                <img src="/static/foreground/home/images/saoguang1.png">
            </light>
            <a href="liebiao_page.html"><img src="/static/foreground/home/images/2.jpg"></a>
            <span>价值288元</span>
            <a href="#">查看福包</a>
            <em>200人已购买</em>
        </li>
    </ul>
</div>
<script src="/static/foreground/home/js/hot-sale.js?v=<%= System.currentTimeMillis()%>"></script>
<span id="spanProduct">
<!--应季商品-->
<span class="as blessing_package">
	<a href="#" style=" color:#000"><h3 style="float:left">&nbsp;应季商品<img src="/static/foreground/home/images/zd.png" style="display:block; float:left; margin-top:5px"></h3></a>
    <div class="detailed_navigation">
    	<ul>
        	<li class="dog d-1-lt01 yadi"  dg-floor="1"  dg-ct="lt01">春季</li>
            <li class="dog d-1-lt02"  dg-floor="1"  dg-ct="lt02">夏季</li>
            <li class="dog d-1-lt03"  dg-floor="1"  dg-ct="lt03">秋季</li>
            <li class="dog d-1-lt04"  dg-floor="1"  dg-ct="lt04">冬季</li>
        </ul>
    </div>
</span>
<div>
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
    <div class="currency f-1-lt02" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/574521dcN025c8825.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>

                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/574521dcN025c8825.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>

                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/574521dcN025c8825.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>

                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/574521dcN025c8825.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>

                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/574521dcN025c8825.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>

                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-1-lt03" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/571a4db9Neaf4826c.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/571a4db9Neaf4826c.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/571a4db9Neaf4826c.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/571a4db9Neaf4826c.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/571a4db9Neaf4826c.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-1-lt04" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/578c8bedNd80ce7f6.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/578c8bedNd80ce7f6.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/578c8bedNd80ce7f6.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/578c8bedNd80ce7f6.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/578c8bedNd80ce7f6.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
</div>
    <!--母婴专区-->
<span class="as blessing_package">
	<a href="#" style=" color:#000"><h3 style="float:left">&nbsp;母婴之家<img src="/static/foreground/home/images/zd.png" style="display:block; float:left; margin-top:5px"></h3></a>
    <div class="detailed_navigation">
    	<ul>
        	<li class="dog d-2-lt01 yadi"  dg-floor="2"  dg-ct="lt01">婴儿玩具</li>
            <li class="dog d-2-lt02"  dg-floor="2"  dg-ct="lt02">进口奶粉</li>
            <li class="dog d-2-lt03"  dg-floor="2"  dg-ct="lt03">婴儿套装</li>
            <li class="dog d-2-lt04"  dg-floor="2"  dg-ct="lt04">尿裤/湿巾</li>
            <li class="dog d-2-lt04"  dg-floor="2"  dg-ct="lt05">孕妈专区</li>
            <li class="dog d-2-lt04"  dg-floor="2"  dg-ct="lt06">安全防护</li>
        </ul>
    </div>
</span>
<div>
    <div class="currency f-2-lt01">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/578dc7f8Nfc1dae3b.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/578dc7f8Nfc1dae3b.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/578dc7f8Nfc1dae3b.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/578dc7f8Nfc1dae3b.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/578dc7f8Nfc1dae3b.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-2-lt02" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56ab1233N47cfb1c0.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56ab1233N47cfb1c0.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56ab1233N47cfb1c0.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56ab1233N47cfb1c0.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56ab1233N47cfb1c0.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-2-lt03" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/572eaa42N2a588fe2.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/572eaa42N2a588fe2.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/572eaa42N2a588fe2.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/572eaa42N2a588fe2.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/572eaa42N2a588fe2.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-2-lt04" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/5608b901N7f95121d.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/5608b901N7f95121d.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/5608b901N7f95121d.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/5608b901N7f95121d.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/5608b901N7f95121d.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-2-lt05" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57830108Nf5015ca6.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57830108Nf5015ca6.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57830108Nf5015ca6.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57830108Nf5015ca6.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57830108Nf5015ca6.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-2-lt06" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57b28416Nd51ed24d.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57b28416Nd51ed24d.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57b28416Nd51ed24d.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57b28416Nd51ed24d.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57b28416Nd51ed24d.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
</div>
    <!--厨房用品-->
<span class="as blessing_package">
	<a href="#" style=" color:#000"><h3 style="float:left">&nbsp;厨房用品<img src="/static/foreground/home/images/zd.png" style="display:block; float:left; margin-top:5px"></h3></a>
    <div class="detailed_navigation">
    	<ul>
        	<li class="dog d-3-lt01 yadi"  dg-floor="3"  dg-ct="lt01">烹饪锅具</li>
            <li class="dog d-3-lt02"  dg-floor="3"  dg-ct="lt02">刀剪菜板</li>
            <li class="dog d-3-lt03"  dg-floor="3"  dg-ct="lt03">厨房配件</li>
            <li class="dog d-3-lt04"  dg-floor="3"  dg-ct="lt04">水具酒具</li>
            <li class="dog d-3-lt04"  dg-floor="3"  dg-ct="lt05">餐具</li>
            <li class="dog d-3-lt04"  dg-floor="3"  dg-ct="lt06">茶具/咖啡具</li>
        </ul>
    </div>
</span>
<div>
    <div class="currency f-3-lt01">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/55cd5554N735d3035.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/55cd5554N735d3035.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/55cd5554N735d3035.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/55cd5554N735d3035.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/55cd5554N735d3035.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-3-lt02" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/576396a4N0126af00.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/576396a4N0126af00.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/576396a4N0126af00.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/576396a4N0126af00.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/576396a4N0126af00.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-3-lt03" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/55c07298N73ff4204.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/55c07298N73ff4204.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/55c07298N73ff4204.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/55c07298N73ff4204.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/55c07298N73ff4204.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-3-lt04" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/53b9fdabNb9255e0c.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/53b9fdabNb9255e0c.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/53b9fdabNb9255e0c.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/53b9fdabNb9255e0c.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/53b9fdabNb9255e0c.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-3-lt05" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57355c74N047d5f4d.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57355c74N047d5f4d.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57355c74N047d5f4d.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57355c74N047d5f4d.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57355c74N047d5f4d.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-3-lt06" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57bfa531Nceb9d696.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57bfa531Nceb9d696.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57bfa531Nceb9d696.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57bfa531Nceb9d696.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57bfa531Nceb9d696.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
</div>
    <!--生活必备-->
<span class="as blessing_package">
	<a href="#" style=" color:#000"><h3 style="float:left">&nbsp;生活必备<img src="/static/foreground/home/images/zd.png" style="display:block; float:left; margin-top:5px"></h3></a>
    <div class="detailed_navigation">
    	<ul>
        	<li class="dog d-4-lt01 yadi"  dg-floor="4"  dg-ct="lt01">收纳用品</li>
            <li class="dog d-4-lt02"  dg-floor="4"  dg-ct="lt02">雨伞雨具</li>
            <li class="dog d-4-lt03"  dg-floor="4"  dg-ct="lt03">净化除味</li>
            <li class="dog d-4-lt04"  dg-floor="4"  dg-ct="lt04">浴室用品</li>
            <li class="dog d-4-lt04"  dg-floor="4"  dg-ct="lt05">洗晒/熨烫</li>
            <li class="dog d-4-lt04"  dg-floor="4"  dg-ct="lt06">缝纫/针织用品</li>
            <li class="dog d-4-lt04"  dg-floor="4"  dg-ct="lt07">清洁工具</li>
        </ul>
    </div>
</span>
<div>
    <div class="currency f-4-lt01">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57417377N429e10fc.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57417377N429e10fc.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57417377N429e10fc.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57417377N429e10fc.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57417377N429e10fc.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-4-lt02" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56f74e97Na5dee145.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56f74e97Na5dee145.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56f74e97Na5dee145.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56f74e97Na5dee145.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56f74e97Na5dee145.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-4-lt03" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56f0d58bN4871ee89.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56f0d58bN4871ee89.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56f0d58bN4871ee89.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56f0d58bN4871ee89.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56f0d58bN4871ee89.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-4-lt04" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/54c9f2a3N59b95f29.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/54c9f2a3N59b95f29.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/54c9f2a3N59b95f29.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/54c9f2a3N59b95f29.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/54c9f2a3N59b95f29.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-4-lt05" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56892577Nb9cb53be.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56892577Nb9cb53be.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56892577Nb9cb53be.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56892577Nb9cb53be.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56892577Nb9cb53be.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-4-lt06" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/rBEIC0_gRMoIAAAAAACg0Wi1QEwAAAykgFTBlIAAKDp775.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/rBEIC0_gRMoIAAAAAACg0Wi1QEwAAAykgFTBlIAAKDp775.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/rBEIC0_gRMoIAAAAAACg0Wi1QEwAAAykgFTBlIAAKDp775.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/rBEIC0_gRMoIAAAAAACg0Wi1QEwAAAykgFTBlIAAKDp775.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/rBEIC0_gRMoIAAAAAACg0Wi1QEwAAAykgFTBlIAAKDp775.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-4-lt07" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57ac4b58N1aa51ca8.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57ac4b58N1aa51ca8.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57ac4b58N1aa51ca8.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57ac4b58N1aa51ca8.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/57ac4b58N1aa51ca8.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
</div>
    <!--个性筛选-->
<span class="as blessing_package">
	<a href="#" style=" color:#000"><h3 style="float:left">&nbsp;个性筛选<img src="/static/foreground/home/images/zd.png" style="display:block; float:left; margin-top:5px"></h3></a>
    <div class="detailed_navigation">
    	<ul>
        	<li class="dog d-5-lt01 yadi"  dg-floor="5"  dg-ct="lt01">一人空间</li>
            <li class="dog d-5-lt02"  dg-floor="5"  dg-ct="lt02">二人世界</li>
            <li class="dog d-5-lt03"  dg-floor="5"  dg-ct="lt03">三口之家</li>
            <li class="dog d-5-lt04"  dg-floor="5"  dg-ct="lt04">四人之家</li>
            <li class="dog d-5-lt04"  dg-floor="5"  dg-ct="lt05">五口大家</li>
        </ul>
    </div>
</span>
<div>
    <div class="currency f-5-lt01">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/578f96e3Ne953ac32.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/578f96e3Ne953ac32.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/578f96e3Ne953ac32.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/578f96e3Ne953ac32.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/578f96e3Ne953ac32.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-5-lt02" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/rBEhU1Kvv8gIAAAAAAcDR5hr6hkAAG4SwPB6yAABwNf577.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/rBEhU1Kvv8gIAAAAAAcDR5hr6hkAAG4SwPB6yAABwNf577.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/rBEhU1Kvv8gIAAAAAAcDR5hr6hkAAG4SwPB6yAABwNf577.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/rBEhU1Kvv8gIAAAAAAcDR5hr6hkAAG4SwPB6yAABwNf577.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/rBEhU1Kvv8gIAAAAAAcDR5hr6hkAAG4SwPB6yAABwNf577.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-5-lt03" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/5688f53dN144e3333.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/5688f53dN144e3333.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/5688f53dN144e3333.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/5688f53dN144e3333.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/5688f53dN144e3333.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-5-lt04" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56e3bdf0N6b0aa4a7.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56e3bdf0N6b0aa4a7.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56e3bdf0N6b0aa4a7.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56e3bdf0N6b0aa4a7.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/56e3bdf0N6b0aa4a7.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
    <div class="currency f-5-lt05" style="display:none">
        <ul>
            <li>
                <a href="#"><img src="/static/foreground/home/images/577f624eN2e3465e5.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/577f624eN2e3465e5.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/577f624eN2e3465e5.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/577f624eN2e3465e5.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
            <li>
                <a href="#"><img src="/static/foreground/home/images/577f624eN2e3465e5.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                <light1>
                    <img src="/static/foreground/home/images/saoguang.png">
                </light1>
                <span>￥59</span>
                <a href="#"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                <em>
                    <a href="#">收藏</a>
                    <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                </em>
            </li>
        </ul>
    </div>
</div>
    <!--猜你喜欢-->
<div class="as kongzhianniu">
    <div class="lunbobanner">
        <ul class="lunboimg">
            <li>
                <a href="#">
                    <b><img src="/static/foreground/home/images/577f624eN2e3465e5.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></b>
                    <span>￥59</span>
                    <p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p>
                </a>
                <a href="#">
                    <b><img src="/static/foreground/home/images/578c8bedNd80ce7f6.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></b>
                    <span>￥59</span>
                    <p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p>
                </a>
                <a href="#">
                    <b><img src="/static/foreground/home/images/578dc7f8Nfc1dae3b.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></b>
                    <span>￥59</span>
                    <p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p>
                </a>
                <a href="#">
                    <b><img src="/static/foreground/home/images/57355c74N047d5f4d.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></b>
                    <span>￥59</span>
                    <p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p>
                </a>
                <a href="#">
                    <b><img src="/static/foreground/home/images/57830108Nf5015ca6.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></b>
                    <span>￥59</span>
                    <p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p>
                </a>
            </li>
            <li>
                <a href="#">
                    <b><img src="/static/foreground/home/images/56ab1233N47cfb1c0.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></b>
                    <span>￥59</span>
                    <p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p>
                </a>
                <a href="#">
                    <b><img src="/static/foreground/home/images/572eaa42N2a588fe2.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></b>
                    <span>￥59</span>
                    <p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p>
                </a>
                <a href="#">
                    <b><img src="/static/foreground/home/images/576396a4N0126af00.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></b>
                    <span>￥59</span>
                    <p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p>
                </a>
                <a href="#">
                    <b><img src="/static/foreground/home/images/56892577Nb9cb53be.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></b>
                    <span>￥59</span>
                    <p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p>
                </a>
                <a href="#">
                    <b><img src="/static/foreground/home/images/5688f53dN144e3333.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></b>
                    <span>￥59</span>
                    <p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p>
                </a>
            </li>
        </ul>
    </div>
    <div class="btnl"><</div>
    <div class="btnr">></div>
    <h4 class="guanfangremai">推荐商品</h4>
</div>
</span>
<!--页脚-->
<!--侧边栏   // target="_blank"-->
<div class="toolbar">
    <a href="/mall/foreground/product/cart/home" class="toolbar-item toolbar-item-weixin" style=" position:relative">
        <em style=" position:absolute; display:block; line-height:20px; font-size:12px; color:#f00; top:-20px; left:0">(<b id="cartNumB">0</b>)</em>
        <!--<span class="toolbar-layer"></span>-->
    </a>
   <%-- <a href="###" class="toolbar-item toolbar-item-feedback"></a>
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
<script src="/static/foreground/home/js/category-sale.js?v=<%= System.currentTimeMillis()%>"></script>
<!--购物车fly插件-->
</body>
</html>
