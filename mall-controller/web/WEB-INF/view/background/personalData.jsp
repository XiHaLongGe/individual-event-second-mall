<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2020-01-19
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">
    <title>个人资料</title>
    <link href="https://cdn.bootcss.com/amazeui/2.5.1/css/amazeui.css" rel="stylesheet" type="text/css" />
    <link href="/static/background/personal-data/css/personal.css" rel="stylesheet" type="text/css">
    <link href="/static/background/personal-data/css/infstyle.css" rel="stylesheet" type="text/css">
    <script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
</head>
<body>
    <div class="center">
        <div class="col-main">
            <div class="main-wrap">

                <div class="user-info">
                    <!--标题 -->
                    <div class="am-cf am-padding">
                        <div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">个人资料</strong> / <small>Personal&nbsp;information</small></div>
                    </div>
                    <hr/>
                    <!--头像 -->
                    <div class="user-infoPic">

                        <div class="filePic">
                            <input type="file" class="inputPic" allowexts="gif,jpeg,jpg,png,bmp" accept="image/*">
                            <img class="am-circle am-img-thumbnail" src="/static/background/personal-data/images/getAvatar.do.jpg" alt="" />
                        </div>

                        <p class="am-form-help">头像</p>

                        <div class="info-m">
                            <div><b>用户名：<i>小叮当</i></b><i>&nbsp;</i><a style="color: #E60012;" href="javascript:;">修改</a></div>
                            <div class="u-level">
                                    <span class="rank r2">
                                         <s class="vip1"></s><a class="classes" href="#">铜牌会员</a>
                                    </span>
                            </div>
                            <div class="u-safety">
                                <a href="safety.html">
                                    账户安全
                                    <span class="u-profile"><i class="bc_ee0000" style="width: 60px;" width="0">60分</i></span>
                                </a>
                            </div>
                        </div>
                    </div>

                    <!--个人信息 -->
                    <div class="info-main">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name2" class="am-form-label">昵称</label>
                                <div class="am-form-content">
                                    <input type="text" id="user-name2" placeholder="nickname">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="user-name" class="am-form-label">姓名</label>
                                <div class="am-form-content">
                                    <input type="text" id="user-name" placeholder="name">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label class="am-form-label">性别</label>
                                <div class="am-form-content sex">
                                    <label class="am-radio-inline">
                                        <input type="radio" name="radio10" value="male" data-am-ucheck> 男
                                    </label>
                                    <label class="am-radio-inline">
                                        <input type="radio" name="radio10" value="female" data-am-ucheck> 女
                                    </label>
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="user-phone" class="am-form-label">电话</label>
                                <div class="am-form-content">
                                    <input id="user-phone" placeholder="telephonenumber" type="tel">

                                </div>
                            </div>
                            <div class="am-form-group">
                                <label for="user-email" class="am-form-label">电子邮件</label>
                                <div class="am-form-content">
                                    <input id="user-email" placeholder="Email" type="email">
                                </div>
                            </div>
                            <div class="info-btn">
                                <div class="am-btn am-btn-danger">保存修改</div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
