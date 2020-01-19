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

    <link rel="shortcut icon" href="/static/background/backend/home/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/static/background/backend/home/css/font.css">
    <link rel="stylesheet" href="/static/background/backend/home/css/xadmin.css">
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<%--    <script src="/static/background/backend/home/js/jquery.min.js"></script>--%>
    <script src="/static/background/backend/home/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/static/background/backend/home/js/xadmin.js?v=<%= System.currentTimeMillis()%>"></script>
</head>
<body>
<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="/static/background/backend/home/html/index.html">L-admin v2.0</a></div>
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe699;</i>
    </div>
    <ul class="layui-nav left fast-add" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">+新增</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a onclick="x_admin_show('资讯','http://www.baidu.com')"><i class="iconfont">&#xe6a2;</i>资讯</a></dd>
                <dd><a onclick="x_admin_show('图片','http://www.baidu.com')"><i class="iconfont">&#xe6a8;</i>图片</a></dd>
                <dd><a onclick="x_admin_show('用户','http://www.baidu.com')"><i class="iconfont">&#xe6b8;</i>用户</a></dd>
            </dl>
        </li>
    </ul>
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <%--这里获取到登录用户的昵称显示于系统左上侧--%>
            <a href="javascript:;">${sessionScope.loginName}</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a onclick="x_admin_show('个人信息','/mall/background/personal/data')">个人信息</a></dd>
                <dd><a id="logoutA" href="javascript:;">注销帐号</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item to-index"><a href="/static/background/backend/home/html/#">前台首页</a></li>
    </ul>
    <script>
        $("#logoutA").click(function(){
            $.ajax({
                url:"/mall/clear/session",
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
                    <li><a _href="/static/background/backend/home/html/welcome.html"><i class="iconfont">&#xe6a7;</i><cite>控制台</cite></a></li >
                </ul>
            </li>
            <li >
                <a href="javascript:;">
                    <i class="iconfont">&#xe6e4;</i>
                    <cite>基本元素</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li><a _href="/static/background/backend/home/html/unicode.html"><i class="iconfont">&#xe6a7;</i><cite>图标字体</cite></a></li>
                    <li><a _href="/static/background/backend/home/html/form1.html"><i class="iconfont">&#xe6a7;</i><cite>表单元素</cite></a></li>
                    <li> <a _href="/static/background/backend/home/html/form2.html"><i class="iconfont">&#xe6a7;</i><cite>表单组合</cite></a></li>
                    <li><a _href="/static/background/backend/home/html/buttons.html"><i class="iconfont">&#xe6a7;</i><cite>按钮</cite></a></li>
                    <li><a _href="/static/background/backend/home/html/nav.html"><i class="iconfont">&#xe6a7;</i><cite>导航/面包屑</cite></a></li>
                    <li><a _href="/static/background/backend/home/html/tab.html"><i class="iconfont">&#xe6a7;</i><cite>选项卡</cite></a></li>
                    <li><a _href="/static/background/backend/home/html/progress-bar.html"><i class="iconfont">&#xe6a7;</i><cite>进度条</cite></a></li>
                    <li><a _href="/static/background/backend/home/html/panel.html"><i class="iconfont">&#xe6a7;</i><cite>面板</cite></a></li>
                    <li><a _href="/static/background/backend/home/html/badge.html"><i class="iconfont">&#xe6a7;</i><cite>微章</cite></a></li>
                    <li><a _href="/static/background/backend/home/html/timeline.html"><i class="iconfont">&#xe6a7;</i><cite>时间线</cite></a></li>
                    <li><a _href="/static/background/backend/home/html/table-element.html"><i class="iconfont">&#xe6a7;</i><cite>静态表格</cite></a></li>
                    <li><a _href="/static/background/backend/home/html/anim.html"><i class="iconfont">&#xe6a7;</i><cite>动画</cite></a></li>
                </ul>
            </li>
            <li>
                <a href="javascript:;"><i class="iconfont">&#xe6f6;</i><cite>组件页面</cite><i class="iconfont nav_right">&#xe6a7;</i></a>
                <ul class="sub-menu">
                    <li><a _href="/static/background/backend/home/html/upload.html"><i class="iconfont">&#xe6a7;</i><cite>文件上传</cite></a></li>
                    <li><a _href="/static/background/backend/home/html/page.html"><i class="iconfont">&#xe6a7;</i><cite>分页</cite></a></li>
                    <li><a _href="/static/background/backend/home/html/cate.html"><i class="iconfont">&#xe6a7;</i><cite>多级分类</cite></a></li>
                    <li><a _href="/static/background/backend/home/html/carousel.html"><i class="iconfont">&#xe6a7;</i><cite>轮播图</cite></a></li>
                    <li><a _href="/static/background/backend/home/html/city.html"><i class="iconfont">&#xe6a7;</i><cite>城市三级联动</cite></a></li>
                </ul>
            </li>
            <li >
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b4;</i>
                    <cite>排版布局</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li><a _href="/static/background/backend/home/html/grid.html"><i class="iconfont">&#xe6a7;</i><cite>栅格</cite></a></li>
                    <li><a _href="/static/background/backend/home/html/welcome2.html"><i class="iconfont">&#xe6a7;</i><cite>排版</cite></a></li>
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
                        <a _href="/static/background/backend/home/html/order-list.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>订单列表</cite>
                        </a>
                    </li >
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe726;</i>
                    <cite>管理员管理</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/static/background/backend/home/html/admin-list.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>管理员列表</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="/static/background/backend/home/html/admin-role.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>角色管理</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="/static/background/backend/home/html/admin-cate.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>权限分类</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="/static/background/backend/home/html/admin-rule.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>权限管理</cite>
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
                        <a _href="/background/backend/home/customer/login/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>会员列表</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="/background/backend/home/member/add">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>会员删除</cite>
                        </a>
                    </li>
                    <%--下面是子集块--%>
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont">&#xe70b;</i>
                            <cite>会员管理</cite>
                            <i class="iconfont nav_right">&#xe6a7;</i>
                        </a>
                        <ul class="sub-menu">
                            <li>
                                <a _href="/static/background/backend/home/html/member-del.html">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>会员列表</cite>
                                </a>
                            </li >
                            <li>
                                <a _href="/static/background/backend/home/html/member-del.html">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>会员删除</cite>
                                </a>
                            </li>

                        </ul>
                    </li>
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
                        <a _href="/static/background/backend/home/html/echarts1.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>拆线图</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="/static/background/backend/home/html/echarts2.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>柱状图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/static/background/backend/home/html/echarts3.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>地图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/static/background/backend/home/html/echarts4.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>饼图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/static/background/backend/home/html/echarts5.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>雷达图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/static/background/backend/home/html/echarts6.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>k线图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/static/background/backend/home/html/echarts7.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>热力图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/static/background/backend/home/html/echarts8.html">
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
                <iframe src='/static/background/backend/home/html/welcome.html' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
        </div>
    </div>
</div>
<div class="page-content-bg"></div>
</body>
</html>