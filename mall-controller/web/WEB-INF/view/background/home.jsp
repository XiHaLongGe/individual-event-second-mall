<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2020-01-19
  Time: 09:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商城后台</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="/static/background/home/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/static/background/home/css/font.css">
    <link rel="stylesheet" href="/static/background/home/css/xadmin.css">
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="/static/background/home/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/static/background/home/js/xadmin.js?v=<%= System.currentTimeMillis()%>"></script>
</head>
<body>
<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="/static/background/home/html/index.html">商城管理系统</a></div>
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe699;</i>
    </div>
    <ul class="layui-nav left fast-add" lay-filter="">
        <%--<li class="layui-nav-item">
            <a href="javascript:;">+新增</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a onclick="x_admin_show('资讯','http://www.baidu.com')"><i class="iconfont">&#xe6a2;</i>资讯</a></dd>
                <dd><a onclick="x_admin_show('图片','http://www.baidu.com')"><i class="iconfont">&#xe6a8;</i>图片</a></dd>
                <dd><a onclick="x_admin_show('用户','http://www.baidu.com')"><i class="iconfont">&#xe6b8;</i>用户</a></dd>
            </dl>
        </li>--%>
    </ul>
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <%--这里获取到登录用户的昵称显示于系统左上侧--%>
            <a href="javascript:;">${loginName}</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a onclick="x_admin_show('个人资料','/mall/background/personal/home')">个人资料</a></dd>
                <dd><a id="logoutA" href="javascript:;">注销帐号</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item to-index"><a href="/mall/foreground/home">前台首页</a></li>
    </ul>
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

</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<!-- 左侧菜单开始 -->
<div class="left-nav" style="overflow:auto;">
    <div id="side-nav">
        <ul id="nav">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6eb;</i>
                    <cite>主页</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li><a _href="/static/background/home/html/welcome.html"><i class="iconfont">&#xe6a7;</i><cite>控制台</cite></a></li >
                </ul>
            </li>
            <li >
                <a href="javascript:;">
                    <i class="iconfont">&#xe6e4;</i>
                    <cite>基本元素</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li><a _href="/static/background/home/html/unicode.html"><i class="iconfont">&#xe6a7;</i><cite>图标字体</cite></a></li>
                    <li><a _href="/static/background/home/html/form1.html"><i class="iconfont">&#xe6a7;</i><cite>表单元素</cite></a></li>
                    <li> <a _href="/static/background/home/html/form2.html"><i class="iconfont">&#xe6a7;</i><cite>表单组合</cite></a></li>
                    <li><a _href="/static/background/home/html/buttons.html"><i class="iconfont">&#xe6a7;</i><cite>按钮</cite></a></li>
                    <li><a _href="/static/background/home/html/nav.html"><i class="iconfont">&#xe6a7;</i><cite>导航/面包屑</cite></a></li>
                    <li><a _href="/static/background/home/html/tab.html"><i class="iconfont">&#xe6a7;</i><cite>选项卡</cite></a></li>
                    <li><a _href="/static/background/home/html/progress-bar.html"><i class="iconfont">&#xe6a7;</i><cite>进度条</cite></a></li>
                    <li><a _href="/static/background/home/html/panel.html"><i class="iconfont">&#xe6a7;</i><cite>面板</cite></a></li>
                    <li><a _href="/static/background/home/html/badge.html"><i class="iconfont">&#xe6a7;</i><cite>微章</cite></a></li>
                    <li><a _href="/static/background/home/html/timeline.html"><i class="iconfont">&#xe6a7;</i><cite>时间线</cite></a></li>
                    <li><a _href="/static/background/home/html/table-element.html"><i class="iconfont">&#xe6a7;</i><cite>静态表格</cite></a></li>
                    <li><a _href="/static/background/home/html/anim.html"><i class="iconfont">&#xe6a7;</i><cite>动画</cite></a></li>
                </ul>
            </li>
            <li>
                <a href="javascript:;"><i class="iconfont">&#xe6f6;</i><cite>组件页面</cite><i class="iconfont nav_right">&#xe6a7;</i></a>
                <ul class="sub-menu">
                    <li><a _href="/static/background/home/html/upload.html"><i class="iconfont">&#xe6a7;</i><cite>文件上传</cite></a></li>
                    <li><a _href="/static/background/home/html/page.html"><i class="iconfont">&#xe6a7;</i><cite>分页</cite></a></li>
                    <li><a _href="/static/background/home/html/cate.html"><i class="iconfont">&#xe6a7;</i><cite>多级分类</cite></a></li>
                    <li><a _href="/static/background/home/html/carousel.html"><i class="iconfont">&#xe6a7;</i><cite>轮播图</cite></a></li>
                    <li><a _href="/static/background/home/html/city.html"><i class="iconfont">&#xe6a7;</i><cite>城市三级联动</cite></a></li>
                </ul>
            </li>
            <li >
                <a href="javascript:;">
                    <i class="iconfont">&#xe6c5;</i>
                    <cite>品牌管理</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/mall/background/brand/inf/home">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>品牌信息</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/mall/background/pbr/home">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>关联信息</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe69e;</i>
                    <cite>订单管理</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/static/background/home/html/order-list.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>订单列表</cite>
                        </a>
                    </li >
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe83b;</i>
                    <cite>商品管理</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/mall/background/product/category/home">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>商品类型</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/mall/background/product/inf/home">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>商品信息</cite>
                        </a>
                    </li >
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>用户管理</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/mall/background/customer/login/home">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>登录信息</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="/mall/background/customer/individual/home">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>个人信息</cite>
                        </a>
                    </li>
                    <%--下面是子集块--%>
                    <%--<li>
                        <a href="javascript:;">
                            <i class="iconfont">&#xe70b;</i>
                            <cite>会员管理</cite>
                            <i class="iconfont nav_right">&#xe6a7;</i>
                        </a>
                        <ul class="sub-menu">
                            <li>
                                <a _href="/static/background/home/html/member-del.html">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>会员列表</cite>
                                </a>
                            </li >
                            <li>
                                <a _href="/static/background/home/html/member-del.html">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>会员删除</cite>
                                </a>
                            </li>

                        </ul>
                    </li>--%>
                </ul>
            </li>


            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6ae;</i>
                    <cite>系统统计</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/static/background/home/html/echarts1.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>拆线图</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="/static/background/home/html/echarts2.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>柱状图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/static/background/home/html/echarts3.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>地图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/static/background/home/html/echarts4.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>饼图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/static/background/home/html/echarts5.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>雷达图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/static/background/home/html/echarts6.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>k线图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/static/background/home/html/echarts7.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>热力图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/static/background/home/html/echarts8.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>仪表图</cite>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>
<!-- <div class="x-slide_left"></div> -->
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='/static/background/home/html/welcome.html' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
        </div>
    </div>
</div>
<div class="page-content-bg"></div>
</body>
</html>