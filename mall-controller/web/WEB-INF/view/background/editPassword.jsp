<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2020-01-23
  Time: 08:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>修改密码</title>
    <link href="https://cdn.bootcss.com/amazeui/2.5.1/css/amazeui.css" rel="stylesheet" type="text/css" />
    <link href="/static/background/personal-data/css/personal.css" rel="stylesheet" type="text/css">
    <link href="/static/background/personal-data/css/infstyle.css" rel="stylesheet" type="text/css">
    <script src="/static/js/jquery/jquery-3.3.1.min.js"></script>
    <script src="/static/background/backend/home/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/static/background/backend/home/js/xadmin.js?v=<%= System.currentTimeMillis()%>"></script>
</head>
<body>
    <div class="center">
        <div class="col-main">
            <div class="main-wrap">

                <div class="user-info">
                    <!--标题 -->
                    <div class="am-cf am-padding">
                        <div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">修改密码</strong> / <small>Edit&nbsp;Password</small></div>
                    </div>
                    <hr/>
                </div>

                    <!--个人信息 -->
                    <div class="info-main">
                        <form class="am-form am-form-horizontal">

                            <div class="am-form-group">
                                <label for="frontPassword" class="am-form-label">原密码</label>
                                <div class="am-form-content">
                                    <input type="password" id="frontPassword" placeholder="原密码">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="newPassword" class="am-form-label">新密码</label>
                                <div class="am-form-content">
                                    <input type="password" id="newPassword" placeholder="新密码">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="confirmPassword" class="am-form-label">确认密码</label>
                                <div class="am-form-content">
                                    <input type="password" id="confirmPassword" placeholder="确认密码">
                                </div>
                            </div>
                        </form>
                        <div class="info-btn">
                            <div id="saveDIV" class="am-btn am-btn-danger">保存</div>
                            <div id="cancelDIV" onclick="x_admin_close()" class="am-btn am-btn-danger">取消</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<script>
    $(function(){
        $("#saveDIV").click(function(){
            if(inputVerify()){
                $.ajax({
                    url:"/mall/background/personal/equals/password",
                    type:"POST",
                    async:false,
                    data:{"frontPassword" : $("#frontPassword").val()},
                    success:function(data){
                        if(data.data){
                            $.ajax({
                                url:"/mall/background/personal/update/password",
                                type:"POST",
                                async:false,
                                data:{"password" : $("#newPassword").val()},
                                success:function(data){
                                    if (data.data){
                                        alert(data.message + "即将跳到登录界面重新登录")
                                        //清除会话信息
                                        $.ajax({
                                            url:"/mall/clear/session",
                                            type:"POST",
                                            async:false,
                                            success:function(data){
                                                if (data.data){
                                                    var i = 4;
                                                    //4秒后返回登录界面
                                                    setTimeout(function (){window.location.href='/mall/login';},4000);
                                                }else{
                                                    alert(data.message);
                                                }
                                            }
                                        })
                                    }
                                }
                            })
                        }else{
                            alert(data.message)
                        }
                    }
                })
            }
        })
        function inputVerify() {
            if(inputIsEmpty()){
                if(passwordCoherence()){
                    return true;
                }else{
                    alert("新密码的两次输入不一致")
                }
            }else{
                alert("文本框不可为空")
            }
            return false;
        }
        //验证文本框不可为空
        function inputIsEmpty(){
            return ($("#frontPassword").val() && $("#newPassword").val() && $("#confirmPassword").val());
        }
        //验证两次密码输入的一致性
        function passwordCoherence(){
            return ($("#newPassword").val() == $("#confirmPassword").val());
        }
    })
</script>
</body>
</html>
