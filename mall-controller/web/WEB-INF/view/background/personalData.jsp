<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2020-01-19
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <title>个人资料</title>
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
                        <div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">个人资料</strong> / <small>Personal&nbsp;information</small></div>
                    </div>
                    <hr/>
                    <!--头像 -->
                    <div class="user-infoPic">

                        <div class="filePic">
                            <input id="multipartFile" type="file" class="inputPic" allowexts="gif,jpeg,jpg,png,bmp">
                            <input id="headIconUrl" type="hidden" value="${customerLoginEntity.headIconUrl}" >
                            <img id="headIconIMG" class="am-circle am-img-thumbnail" src="${customerLoginEntity.headIconUrl}" alt="" />
                        </div>

                        <p class="am-form-help">头像</p>

                        <div class="info-m">
                            <div>
                                <b>昵称：<i>${customerLoginEntity.loginName}</i></b>
                                <i>&nbsp;</i>
                                <a style="color: #E60012;" href="javascript:;">修改</a>
                            </div>
                            <div>
                                <b>帐号：<i>${customerLoginEntity.loginAccount}</i></b>
                            </div>
                            <div>
                                <b>密码：<i>************</i></b>
                                <i>&nbsp;</i>
                                <a style="color: #E60012;" href="javascript:;">修改</a>
                            </div>
                            <div>
                                <b>
                                    用户身份：
                                    <c:choose>
                                        <c:when test="${customerLoginEntity.webmaster == 0}">
                                            <i>普通用户</i>
                                        </c:when>
                                        <c:when test="${customerLoginEntity.webmaster == 1}">
                                            <i>管理员</i>
                                        </c:when>
                                    </c:choose>
                                </b>
                            </div>
                        </div>
                    </div>

                    <!--个人信息 -->
                    <div class="info-main">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="customerIndividualName" class="am-form-label">姓名</label>
                                <div class="am-form-content">
                                    <input type="text" id="customerIndividualName" placeholder="真实姓名" value="${customerIndividualEntity.customerIndividualName}">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label class="am-form-label">性别</label>
                                <div class="am-form-content sex">
                                    <c:choose>
                                        <c:when test="${customerIndividualEntity.customerIndividualGender == 0}">
                                            <label class="am-radio-inline">
                                                <input type="radio" name="customerIndividualGender" value="0" checked> 男
                                            </label>
                                            <label class="am-radio-inline">
                                                <input type="radio" name="customerIndividualGender" value="1"> 女
                                            </label>
                                        </c:when>
                                        <c:when test="${customerIndividualEntity.customerIndividualGender == 1}">
                                            <label class="am-radio-inline">
                                                <input type="radio" name="customerIndividualGender" value="0"> 男
                                            </label>
                                            <label class="am-radio-inline">
                                                <input type="radio" name="customerIndividualGender" value="1" checked> 女
                                            </label>
                                        </c:when>
                                    </c:choose>
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="customerIndividualCard" class="am-form-label">身份证号</label>
                                <div class="am-form-content">
                                    <input id="customerIndividualCard" placeholder="18位身份证号码" type="tel" maxlength="18" value="${customerIndividualEntity.customerIndividualCard}">

                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="customerIndividualPhone" class="am-form-label">手机号</label>
                                <div class="am-form-content">
                                    <input id="customerIndividualPhone" placeholder="11位手机号码" type="tel" maxlength="11" value="${customerIndividualEntity.customerIndividualPhone}">

                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="customerIndividualEmail" class="am-form-label">电子邮箱</label>
                                <div class="am-form-content">
                                    <input id="customerIndividualEmail" placeholder="Email" type="email" value="${customerIndividualEntity.customerIndividualEmail}">
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
        //保存点击按钮
        $("#saveDIV").click(function(){
            var formData = new FormData();
            formData.append("customerIndividualName",$("#customerIndividualName").val());
            formData.append("customerIndividualGender",$("input[name = 'customerIndividualGender']:checked").val());
            formData.append("customerIndividualCard",$("#customerIndividualCard").val());
            formData.append("customerIndividualPhone",$("#customerIndividualPhone").val());
            formData.append("customerIndividualEmail",$("#customerIndividualEmail").val());
            formData.append("headIconUrl",$("#headIconUrl").val());
            formData.append("multipartFile",$("#multipartFile")[0].files[0]);
            $.ajax({
                url:"/mall/background/personal/head/update",
                type:'POST',
                data:formData,
                processData:false,		/*使数据不做处理*/
                contentType:false,		/*不要设置Content-Type请求头*/
                success:function(data){
                    if(data.code == 200){
                        alert("个人资料成功保存")
                    }
                }
            })
        })
        $("#multipartFile").change(function() {
            $("#headIconIMG").attr("src", getObjectURL(this.files[0]));
        });
        function getObjectURL(file){
            var url = null ;
            if (window.createObjectURL!=undefined)
            { // basic
                url = window.createObjectURL(file) ;
            }
            else if (window.URL!=undefined)
            {
                // mozilla(firefox)
                url = window.URL.createObjectURL(file) ;
            }
            else if (window.webkitURL!=undefined) {
                // webkit or chrome
                url = window.webkitURL.createObjectURL(file) ;
            }
            return url ;
        }
    })
</script>
</body>
</html>
