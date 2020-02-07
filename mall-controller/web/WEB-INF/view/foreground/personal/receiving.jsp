<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2020-02-06
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

    <title>地址管理</title>

    <link href="/static/foreground/personal/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.bootcss.com/amazeui/2.5.1/css/amazeui.css" rel="stylesheet" type="text/css" />

    <link href="/static/foreground/personal/css/personal.css" rel="stylesheet" type="text/css">
    <link href="/static/foreground/personal/css/addstyle.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="/static/foreground/personal/css/city-picker.css">
    <link rel="stylesheet" type="text/css" href="/static/foreground/personal/css/main.css">

    <script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="https://cdn.bootcss.com/amazeui/2.5.1/js/amazeui.min.js"></script>
    <script src="/static/js/jquery/jquery-3.3.1.min.js" charset="utf-8"></script>
    <script src="/static/background/home/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/static/background/home/js/xadmin.js?v=<%= System.currentTimeMillis()%>"></script>

    <script src="/static/foreground/personal/js/city-picker.data.js"></script>
    <script type="text/javascript" src="/static/foreground/personal/js/city-picker.js?v=<%= System.currentTimeMillis()%>"></script>

</head>

<body>
<div class="center" style="overflow: visible">
    <div class="col-main">
        <div class="main-wrap">
            <div class="user-address">
                <!--标题 -->
                <div class="am-cf am-padding">
                    <div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">地址管理</strong> / <small>Address&nbsp;list</small></div>
                </div>
                <hr/>
                <ul id="receivingUL" class="am-avg-sm-1 am-avg-md-3 am-thumbnails">
                    <li class="user-addresslist defaultAddr">
                        <span class="new-option-r"><i class="am-icon-check-circle"></i>默认地址</span>
                        <p class="new-tit new-p-re">
                            <span class="new-txt">小叮当</span>
                            <span class="new-txt-rd2">159****1622</span>
                        </p>
                        <div class="new-mu_l2a new-p-re">
                            <p class="new-mu_l2cw">
                                <span class="title">地址：</span>
                                <span class="province">湖北</span>省
                                <span class="city">武汉</span>市
                                <span class="dist">洪山</span>区
                                <span class="street">雄楚大道666号(中南财经政法大学)</span></p>
                        </div>
                        <div class="new-addr-btn">
                            <a href="#"><i class="am-icon-edit"></i>编辑</a>
                            <span class="new-addr-bar">|</span>
                            <a href="javascript:void(0);" onclick="delClick(this);"><i class="am-icon-trash"></i>删除</a>
                        </div>
                    </li>
                    <li class="user-addresslist">
                        <span class="new-option-r"><i class="am-icon-check-circle"></i>设为默认</span>
                        <p class="new-tit new-p-re">
                            <span class="new-txt">小叮当</span>
                            <span class="new-txt-rd2">159****1622</span>
                        </p>
                        <div class="new-mu_l2a new-p-re">
                            <p class="new-mu_l2cw">
                                <span class="title">地址：</span>
                                <span class="province">湖北</span>省
                                <span class="city">武汉</span>市
                                <span class="dist">洪山</span>区
                                <span class="street">雄楚大道666号(中南财经政法大学)</span></p>
                        </div>
                        <div class="new-addr-btn">
                            <a href="#"><i class="am-icon-edit"></i>编辑</a>
                            <span class="new-addr-bar">|</span>
                            <a href="javascript:void(0);" onclick="delClick(this);"><i class="am-icon-trash"></i>删除</a>
                        </div>
                    </li>
                    <li class="user-addresslist">
                        <span class="new-option-r"><i class="am-icon-check-circle"></i>设为默认</span>
                        <p class="new-tit new-p-re">
                            <span class="new-txt">小叮当</span>
                            <span class="new-txt-rd2">159****1622</span>
                        </p>
                        <div class="new-mu_l2a new-p-re">
                            <p class="new-mu_l2cw">
                                <span class="title">地址：</span>
                                <span class="province">湖北</span>省
                                <span class="city">武汉</span>市
                                <span class="dist">洪山</span>区
                                <span class="street">雄楚大道666号(中南财经政法大学)</span></p>
                        </div>
                        <div class="new-addr-btn">
                            <a href="#"><i class="am-icon-edit"></i>编辑</a>
                            <span class="new-addr-bar">|</span>
                            <a href="javascript:void(0);" onclick="delClick(this);"><i class="am-icon-trash"></i>删除</a>
                        </div>
                    </li>
                </ul>
                <!--例子-->
                <div class="am-modal am-modal-no-btn" id="doc-modal-1">
                    <div class="add-dress">
                        <!--标题 -->
                        <div class="am-cf am-padding">
                            <div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add&nbsp;address</small></div>
                        </div>
                        <hr/>

                        <div class="am-u-md-12 am-u-lg-8" style="margin-top: 20px;">
                            <form id="receivingFORM" class="am-form am-form-horizontal">
                                <input id="loginIdINPUT" name="loginId" type="hidden" value="${loginId}" />
                                <div class="am-form-group">
                                    <label for="user-name" class="am-form-label">收货人</label>
                                    <div class="am-form-content">
                                        <input type="text" id="user-name" name="receivingInfName" placeholder="收货人">
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-phone" class="am-form-label">手机号码</label>
                                    <div class="am-form-content">
                                        <input id="user-phone" name="receivingInfPhone" placeholder="手机号必填">
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label class="am-form-label">所在地</label>
                                    <div style="position: relative; margin: 5px 0px 0px 108px;">
                                        <input readonly id="fourLinkageINPUT" type="text" data-toggle="city-picker" placeholder="点击从下拉面板中选择省/市/区县/镇">
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-intro" class="am-form-label">详细地址</label>
                                    <div class="am-form-content">
                                        <textarea class="" rows="3" name="receivingInfAddress" id="user-intro" placeholder="输入详细地址"></textarea>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <a id="editAndAddA" class="am-btn am-btn-danger" onclick="addAndEditClick(this)">添加</a>
                                        <a href="javascript: void(0)" class="am-close am-btn am-btn-danger" onclick="dataEmpty()" data-am-modal-close>取消</a>
                                    </div>
                                </div>
                            </form>
                        </div>

                    </div>

                </div>

            </div>

            <script type="text/javascript">
                $(document).ready(function() {
                    $(".new-option-r").click(function() {
                        $(this).parent('.user-addresslist').addClass("defaultAddr").siblings().removeClass("defaultAddr");
                    });

                    var $ww = $(window).width();
                    if($ww>640) {
                        $("#doc-modal-1").removeClass("am-modal am-modal-no-btn")
                    }

                })
            </script>

            <div class="clear"></div>
            <br/><br/><br/><br/><br/>
            <br/><br/><br/><br/><br/>
        </div>
    </div>

    <aside class="menu">
        <ul>
            <li class="person active">
                <a href="/mall/foreground/personal/home">个人中心</a>
            </li>
            <li class="person">
                <a>个人资料</a>
                <ul>
                    <li> <a href="javascript:;" onclick="x_admin_show('个人信息','/mall/foreground/personal/information/home')">个人信息</a></li>
                    <li> <a href="/mall/foreground/receiving/home">收货地址</a></li>
                </ul>
            </li>
            <li class="person">
                <a>我的交易</a>
                <ul>
                    <li><a href="order.html">订单管理</a></li>
                </ul>
            </li>
        </ul>
    </aside>
</div>
<script src="/static/foreground/personal/js/receiving.js?v=<%= System.currentTimeMillis()%>"></script>
</body>
</html>
