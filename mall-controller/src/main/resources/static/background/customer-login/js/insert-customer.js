$(function () {
    /*添加按钮点击事件*/
    $("#registerBtn").click(function(){
        if(registerVerify("#registerForm input")){
            $.ajax({
                url:"/mall/background/customer/login/insert/customer",
                type:"POST",
                data:JSON.stringify(transformJSON("registerForm")),
                dataType:"json",
                contentType: "application/json",
                success:function (data) {
                    //data.data 是用户注册成功后系统生成的帐号
                    if(data.code == 200){
                        alert("用户创建成功，账号是：" + data.data);
                        x_admin_close();
                    }else{
                        alert("发生错误")
                    }
                }
            })
        }else{
            alert("你输入的信息有误！");
        }
    })
})

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
//将表单数据转换成json数据
function transformJSON(formId){
    var $jsonData = {};
    /*下面是将form表单的数据转换成一个json的数据格式*/
    $.each($("#" + formId).serializeArray(), function(i,e){
        $jsonData[e.name] = e.value;
    })
    return $jsonData;
}