$(function(){
    customerList(1);
    /*以下是查询条件多选框的相关处理*/
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

    /*以下是条件查询的点击事件*/
    $("#searchBTN").click(function(){
        (searchCondition()) ? pageSearch(1) : customerList(1);
        $("#parentDIV").removeClass("layui-form-checked");
    })
    /*刷新点击事件*/
    $("#refreshA").click(function(){
        $("#loginNameINPUT").val("");
        $("#activateDIV").removeClass("layui-form-checked");
        $("#notActivateDIV").removeClass("layui-form-checked");
        $("#adminDIV").removeClass("layui-form-checked");
        $("#ordinaryDIV").removeClass("layui-form-checked");
        customerList(1);
        $("#parentDIV").removeClass("layui-form-checked");
    })
    clickLoader();
})

/*下面是查询用户登录信息以分页的形式展现*/
function customerCount(data){
    $("#countSPAN").empty().text("共有数据：" + data.total + " 条");
}

/*根据传入的页数，获取到用户的登录信息*/
function customerList(pageNum){
    $.ajax({
        url:"/mall/background/customer/login/page/data?pageNum=" + pageNum,
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            customerPageList(data);
            pageData(data, pageNum);
        }
    })
}
/*根据传入的data数据对象，将数据呈现到显示界面*/
function customerPageList(data){
    var resultValue = "";
    $.each(data.data.list,function(index, element){
        resultValue += "<tr>";
        resultValue += "<td>";
        resultValue += "<div class=\"layui-unselect layui-form-checkbox\" lay-skin=\"primary\" data-id='" + element.loginId + "'><i class=\"layui-icon\">&#xe605;</i></div>";
        resultValue += "</td>";
        resultValue += "<td>" + parseInt(index + 1) + "</td>";
        resultValue += "<td><img style='width: 38px; height: 38px;' class=\"am-circle am-img-thumbnail\" src=\"" + element.headIconUrl + "\"></td>";
        resultValue += "<td>" + element.loginName + "</td>";
        resultValue += "<td>" + element.loginAccount + "</td>";
        resultValue += "<td>";
            if(element.webmaster == 0){
                resultValue += "普通用户";
            }else{
                resultValue += "管理员";
            }
        resultValue += "</td>";
        resultValue += "<td class=\"td-status\">";
            var userStats = "";
            var layuiIco = "";
            if(element.accountStats == 1){
                resultValue += "<span class=\"layui-btn layui-btn-normal layui-btn-sm\">已激活</span></td>";
                userStats = "注销激活";
                layuiIco = "&#xe601;";
            }else{
                resultValue += "<span class=\"layui-btn layui-btn-normal layui-btn-sm layui-btn-disabled\">未激活</span>";
                userStats = "激活";
                layuiIco = "&#xe62f;";
            }
        resultValue += "<td class=\"td-manage\">";
        resultValue += "<a onclick=\"member_stop(this," + element.loginId + ")\" href=\"javascript:;\"  title=\"" + userStats + "\">";
        resultValue += "<i class=\"layui-icon\">" + layuiIco + "</i>";
        resultValue += "</a>";
        resultValue += "<a title=\"编辑\" onclick=\"x_admin_show('编辑','/backend/customer/login/edit?id=" + element.loginId + "',600,400)\" href=\"javascript:;\">";
        resultValue += "<i class=\"layui-icon\">&#xe642;</i>";
        resultValue += "</a>";
        resultValue += "<a onclick=\"x_admin_show('重置密码','/backend/customer/login/edit/password?id=" + element.loginId + "',600,400)\" title=\"重置密码\" href=\"javascript:;\">";
        resultValue += "<i class=\"layui-icon\">&#xe631;</i>";
        resultValue += "</a>";
        resultValue += "<a title=\"删除\" onclick=\"member_del(this," + element.loginId + ")\" href=\"javascript:;\">";
        resultValue += "<i class=\"layui-icon\">&#xe640;</i>";
        resultValue += "</a>";
        resultValue += "</td>";
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
/*下面是处理对用户登录信息进行条件查询的操作*/
function pageSearch(pageNum){
    $.ajax({
        url:"/mall/background/customer/login/condition/page/data?pageNum=" + pageNum,
        type:"GET",
        data:{"loginName" : $("#loginNameINPUT").val(), "accountStats" : $("div[name='activate'].layui-form-checked").attr("value"), "webmaster" : $("div[name='identity'].layui-form-checked").attr("value")},
        contentType: "application/json",
        success:function (data) {
            customerPageList(data);
            pageData(data, pageNum);
        }
    })
}

/*界面上分页页码相关按钮的点击事件*/
function clickLoader(){
    $("a[name='pageA'],a[name='prevNextA']").click(function(){
        var pageNum;
        pageNum = $("#pageSPAN").attr("num");
        $("#pageSPAN").replaceWith("<a name='pageA' class=\"num\" href=\"javascript:;\" num='" + pageNum + "'>" + pageNum + "</a>");
        pageNum = $(this).attr("num");
        $(this).replaceWith("<span id='pageSPAN' class=\"current\" href=\"javascript:;\" num='" + pageNum + "'>" + pageNum + "</span>");
        searchCondition() ? pageSearch(pageNum) : customerList(pageNum);
        clickLoader();
    })
}
/*验证是否填写查询条件*/
function searchCondition(){
    return $("#loginNameINPUT").val() != "" || $("div[name='activate'].layui-form-checked").length > 0 || $("div[name='identity'].layui-form-checked").length > 0;
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
function updateState(id, state){
    var yn = false;
    $.ajax({
        url:"/backend/customer/login/update/state",
        type:"POST",
        data:JSON.stringify({"id" : id, "state" : state}),
        dataType:"json",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            yn = data.data;
        }
    })
    return yn;
}



/*用户登录信息的删除*/
/*用户-删除*/
function member_del(obj,id){
    layer.confirm('确认要删除吗？',function(index){
        //发异步删除数据
        if(singleDelete(id)){
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
            customerList(1);
        }else{
            layer.msg('删除失败!',{icon:2,time:1000});
        }
    });
}
function singleDelete(id){
    var yn = false;
    $.ajax({
        url:"/backend/customer/login/delete",
        type:"POST",
        data:JSON.stringify({"id" : id}),
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
    var batchId = tableCheck.getData();
    layer.confirm('确认要删除吗？',function(index){
        //捉到所有被选中的，发异步进行删除
        if(batchDelete(batchId)){
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
            customerList(1);
        }else{
            layer.msg('删除失败!',{icon:2,time:1000});
        }
    });
}

function batchDelete(batchId){
    var yn = false;
    $.ajax({
        url:"/backend/customer/login/batch/delete",
        type:"POST",
        data:JSON.stringify(batchId),
        dataType:"json",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            yn = data.data;
        }
    })
    return yn;
}

