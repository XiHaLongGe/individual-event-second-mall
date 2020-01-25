$(document).ready(function(){
    //登录按钮点击事件
    $("#loginBtn").click(function(){
        if(formTextIsEmpty("#loginForm input")){
            ajaxIntoBackstage("/mall/login/verify","#loginForm", "登录");
        }else{
            alert("账号密码不可为空！");
        }
    })
    //注册按钮点击事件
    $("#registerBtn").click(function(){
        if(registerVerify("#registerForm input")){
            ajaxIntoBackstage("/mall/login/register","#registerForm", "注册");
        }else{
            alert("你输入的信息有误！");
        }
    })

    //生成验证码到指定id元素中，如下将验证码加载到id为verifyCodeDIV的元素中
    //这段代码写在函数外是为了程序加载完就执行
    var verifyCode = new GVerify("verifyCodeDIV");
    //注册的验证函数
    function registerVerify(formId){
        if(!formTextIsEmpty(formId)){return false;}
        var verifyResult = true;
        /*验证密码长度大于6位*/
        if($("#password").val().length < 6 || $("#password").val().length > 16){
            /*alert("密码长度6-16位！")*/
            $("#password").addClass('input-error');
            verifyResult = false;
            /*验证确认密码是否正确*/
        }else if($("#password").val() != $("#confirmPassword").val()){
            /*alert("两次输入密码不一致！")*/
            $("#confirmPassword").addClass('input-error');
            verifyResult = false;
        }
        /*验证手机号码格式*/
        if(!(/^1[3456789]\d{9}$/).test($("#for-phone").val())){
            /*alert("手机号码格式错误！")*/
            $("#for-phone").addClass('input-error');
            verifyResult = false;
        }
        /*验证邮箱格式*/
        if(!(/^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/).test($("#for-email").val())){
            /*alert("邮箱格式错误！")*/
            $("#for-email").addClass('input-error');
            verifyResult = false;
        }
        /*判断验证码输入是否正确*/
        if(!verifyCode.validate($("#for-verify-code").val())){
            $("#for-verify-code").addClass('input-error');
            verifyResult = false;
        }
        return verifyResult;
    }
    //验证表单文本框的数据非空
    function formTextIsEmpty(formId){
        var verifyResult = true;
        $(formId).each(function(i,e){
            if($(this).val() == ""){
                $(this).addClass('input-error');
                verifyResult = false;
            }
        })
        return verifyResult;
    }
    //将表单数据以json数据格式传输到后台
    //登录与注册共用的的Ajax
    function ajaxIntoBackstage(url, formId, ajaxType){
        $.ajax({
            url:url,
            type:"POST",
            data:JSON.stringify(transformJSON(formId)),
            dataType:"json",
            contentType: "application/json",
            success:function (data) {
                //获取到用户身份信息  是否为管理员
                if(ajaxType == "登录"){
                    if(data.code == 200){
                        //data.data == 1 , 为1的时候表示该用户是管理员
                        if(data.data == 1){
                            //管理员登录，打开前后台选择界面
                            window.location.href = "/mall/login/master/option";
                        }else{
                            //为普通用户的时候直接进入前台界面
                            window.location.href = "/foreground/home/";
                        }
                    }else{
                        alert("账号不存在或账号密码错误")
                    }
                }else if(ajaxType == "注册"){
                    //data.data 是用户注册成功后系统生成的帐号
                    window.location.href = "/mall/login/success/register?account=" + data.data;
                }
            }
        })
    }

    //将表单数据转换成json数据
    function transformJSON(formId){
        var $jsonData = {};
        /*下面是将form表单的数据转换成一个json的数据格式*/
        $.each($(formId).serializeArray(), function(i,e){
            $jsonData[e.name] = e.value;
        })
        return $jsonData;
    }
})