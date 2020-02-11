$(function(){
    pageSearch(1);
    checkboxChecked();
    /*以下是条件查询的点击事件*/
    $("#searchBTN").click(function(){
        pageSearch(1);
        $("#parentDIV").removeClass("layui-form-checked");
    })
    /*刷新点击事件*/
    $("#refreshA").click(function(){
        $(".layui-input").val("");
        $("#stateSelect").next().children('dl').children('.layui-this').removeClass('layui-this');
        pageSearch(1);
        $("#parentDIV").removeClass("layui-form-checked");
    })
    clickLoader();
})

/*以下是查询条件多选框的相关处理*/
function checkboxChecked(){
    $("#activateDIV").click(function () {
        $(this).next().removeClass("layui-form-checked");
    })
    $("#notActivateDIV").click(function () {
        $(this).prev().removeClass("layui-form-checked");
    })
    $("#adminDIV").click(function () {
        $("#ordinaryDIV").removeClass("layui-form-checked");
    })
    $("#ordinaryDIV").click(function () {
        $("#adminDIV").removeClass("layui-form-checked");
    })
}

/*下面是查询用户订单信息以分页的形式展现*/
function customerCount(data){
    $("#countSPAN").empty().text("共有数据：" + data.total + " 条");
}
/*下面是处理对订单信息进行条件查询的操作*/
function pageSearch(pageNum){
    $.ajax({
        url:"/mall/background/product/order/condition/page/data?pageNum=" + pageNum,
        type:"GET",
        async: false,
        data:{
            "beginTime" : $("#start").val(),
            "endTime" : $("#end").val(),
            "productOrderState" : $("#stateSelect").next().children('dl').children('.layui-this').attr("lay-value"),
            "productOrderNumber" : $("#orderNumberINPUT").val()
        },
        contentType: "application/json",
        success:function (data) {
            customerPageList(data);
            pageData(data, pageNum);
            /*
                下面这一步是解绑事件操作，没有解绑会造成事件叠加的后果
                比如：
                    第一次执行 只执行一次
                    第二次执行 执行完本次还会会执行前一次
                    第三次执行 执行完本次还会会执行前两次
            */
            $(".layui-form-checkbox").unbind('click');
            tableCheck.init();
            checkboxChecked();
        }
    })
}
/*根据传入的data数据对象，将数据呈现到显示界面*/
function customerPageList(data){
    var resultValue = "";
    $.each(data.data.list,function(index, element){
        resultValue += "<tr>";
        resultValue += "<td>";
        resultValue += "<div class=\"layui-unselect layui-form-checkbox\" lay-skin=\"primary\" data-id='" + element.receivingInfId + "'><i class=\"layui-icon\">&#xe605;</i></div>";
        resultValue += "</td>";
        resultValue += "<td>" + parseInt(index + 1) + "</td>";
        resultValue += "<td>" + element.productOrderNumber + "</td>";
        resultValue += "<td>" + element.receivingInfName + "</td>";
        resultValue += "<td>" + element.receivingInfPhone + "</td>";
        resultValue += "<td>" + element.receivingInfProvince + "   " + element.receivingInfCity + "   " + element.receivingInfDistrict + "</td>";
        resultValue += "<td>" + element.productInfPrice * element.productNum + "</td>";
        resultValue += "<td>";
        var orderState = element.productOrderState;
        resultValue += orderState == 0 ? "交易关闭" :
                        orderState == 1 ? "待付款" :
                        orderState == 2 ? "待收货" :
                        orderState == 3 ? "已收货" : "交易成功";
        resultValue += "</td>";
        resultValue += "<td>" + element.paymentTime + "</td>";
        resultValue += "<td class=\"td-manage\">";
        resultValue += "<a onclick=\"resetPassword(" + element.loginId + " , '/mall/background/customer/login/reset/password')\" title='重置密码' href=\"javascript:;\">";
        resultValue += "<i class=\"layui-icon\">&#xe631;</i>";
        resultValue += "</a>";
        resultValue += "<a title=\"删除\" onclick=\"member_del(this," + element.loginId + ")\" href=\"javascript:;\">";
        resultValue += "<i class=\"layui-icon\">&#xe640;</i>";
        resultValue += "</a>";
        resultValue += "</td>";
        resultValue += "</tr>";
    })
    $("#customerTBODY").empty().append(resultValue);
}
/*根据传入的数据对象和当前页数，处理界面上分页页码的显示*/
function pageData(data, pageNum){
    customerCount(data.data);
    var resultVal = "";
    resultVal += "<a name='prevNextA' class=\"prev\" href=\"javascript:;\" num='1'>&lt;&lt;</a>";
    resultVal += "<a name='prevNextA' class=\"prev\" href=\"javascript:;\" num='" + (data.data.prePage == 0 ? 1 : data.data.prePage)  + "'>&lt;</a>";
    for(var i = 0; i < data.data.navigatepageNums.length; i ++){
        if(data.data.navigatepageNums[i] == pageNum){
            resultVal += "<span id='pageSPAN' class=\"current\" href=\"javascript:;\" num='" + data.data.navigatepageNums[i] + "'>" + data.data.navigatepageNums[i] + "</span>";
        }else{
            resultVal += "<a name='pageA' class=\"num\" href=\"javascript:;\" num='" + data.data.navigatepageNums[i] + "'>" + data.data.navigatepageNums[i] + "</a>";
        }
    }
    resultVal += "<a name='prevNextA' class=\"next\" href=\"javascript:;\" num='" + (data.data.nextPage == 0 ? data.data.pages : data.data.nextPage) + "'>&gt;</a>";
    resultVal += "<a name='prevNextA' class=\"next\" href=\"javascript:;\" num='" + data.data.pages + "'>&gt;&gt;</a>";
    $("#pageDIV").empty().append(resultVal);
    clickLoader();
}
/*界面上分页页码相关按钮的点击事件*/
function clickLoader(){
    $("a[name='pageA'],a[name='prevNextA']").click(function(){
        $("#parentDIV").removeClass("layui-form-checked");
        var pageNum;
        pageNum = $("#pageSPAN").attr("num");
        $("#pageSPAN").replaceWith("<a name='pageA' class=\"num\" href=\"javascript:;\" num='" + pageNum + "'>" + pageNum + "</a>");
        pageNum = $(this).attr("num");
        $(this).replaceWith("<span id='pageSPAN' class=\"current\" href=\"javascript:;\" num='" + pageNum + "'>" + pageNum + "</span>");
        pageSearch(pageNum);
        clickLoader();
    })
}

/*用户账号状态的修改*/
function member_stop(obj,id){
    var state = $(obj).attr("title");
    layer.confirm("确认要" + state + "吗？",function(index){
        if(state == '注销激活'){
            if(updateState(id,0)){
                //发异步把用户状态进行更改
                $(obj).attr('title','激活')
                $(obj).find('i').html('&#xe62f;');
                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('未激活');
                layer.msg('已注销激活!',{icon: 2,time:1000});
            }else{
                alert("注销激活失败！")
            }
        }else{
            if(updateState(id,1)){
                $(obj).attr('title','注销激活')
                $(obj).find('i').html('&#xe601;');
                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已激活');
                layer.msg('已激活!',{icon: 1,time:1000});
            }else{
                alert("激活失败！")
            }
        }
    });
}
//更新账号状态
function updateState(id, state){
    var yn = false;
    $.ajax({
        url:"/mall/background/customer/login/update/state",
        type:"POST",
        data:JSON.stringify({"loginId" : id, "accountStats" : state}),
        dataType:"json",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            yn = data.data;
        }
    })
    return yn;
}
//重置密码
function resetPassword(loginId, url) {
    $.ajax({
        url:url,
        type:"POST",
        data:JSON.stringify({"loginId" : loginId}),
        dataType:"json",
        async: false,//设置为同步
        contentType: "application/json",
        success:function (data) {
            if(data.code == 200){
                alert("密码以重置为：111111")
            }else{
                alert("密码重置失败")
            }
        }
    })
}



/*用户订单信息的删除*/
function member_del(obj,loginId){
    layer.confirm('确认要删除吗？',function(index){
        //发异步删除数据
        if(singleDelete(loginId)){
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
            var pageNum = $("#pageSPAN").attr("num");
            pageSearch(pageNum);
        }else{
            layer.msg('删除失败!',{icon:2,time:1000});
        }
    });
}
function singleDelete(loginId){
    var yn = false;
    $.ajax({
        url:"/mall/background/customer/login/delete/customer",
        type:"POST",
        data:JSON.stringify({"loginId" : loginId}),
        dataType:"json",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            yn = data.data;
        }
    })
    return yn;
}


/*批量删除*/
function delAll (argument) {
    /*获取到所有被选中的id*/
    var loginIdArray = tableCheck.getData();
    layer.confirm('确认要删除吗？',function(index){
        //捉到所有被选中的，发异步进行删除
        if(batchDelete(loginIdArray)){
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
            $("#parentDIV").removeClass("layui-form-checked");
            var pageNum = $("#pageSPAN").attr("num");
            pageSearch(pageNum);
        }else{
            layer.msg('删除失败!',{icon:2,time:1000});
        }
    });
}

function batchDelete(loginIdArray){
    var result = false;
    $.ajax({
        url:"/mall/background/customer/login/batch/delete/customer",
        type:"POST",
        data:JSON.stringify(loginIdArray),
        dataType:"json",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            result = data.code == 200;
        }
    })
    return result;
}

