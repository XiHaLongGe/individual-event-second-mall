$(function(){
    pageSearch(1);
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
        }
    })
}
/*根据传入的data数据对象，将数据呈现到显示界面*/
function customerPageList(data){
    var resultValue = "";
    $.each(data.data.list,function(index, element){
        resultValue += "<tr>";
        resultValue += "<td>";
        resultValue += "<div class=\"layui-unselect layui-form-checkbox\" lay-skin=\"primary\" data-id='" + element.productOrderId + "'><i class=\"layui-icon\">&#xe605;</i></div>";
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
                        orderState == 2 ? "待发货" :
                        orderState == 3 ? "待收货" : "交易成功";
        resultValue += "</td>";
        resultValue += "<td>" + element.paymentTime + "</td>";
        resultValue += "<td class=\"td-manage\">";
        if(orderState == 2){
            resultValue += "<a onclick=\"deliver('" + element.productOrderNumber + "')\" title='发货' href=\"javascript:;\">";
            resultValue += "<i class=\"iconfont\">&#xe828;</i>";
            resultValue += "</a>";
        }
        resultValue += "<a title=\"删除\" onclick=\"member_del(this," + element.productOrderId + ")\" href=\"javascript:;\">";
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

/*发货*/
function deliver(productOrderNumber){
    $.ajax({
        url:"/mall/background/product/order/confirm/deliver",
        type:"POST",
        data:{"productOrderNumber" : productOrderNumber},
        dataType:"json",
        async: false,//设置为同步
        success:function(data){
            if(data.code === 200){
                pageSearch(1);
            }else{
                alert(data.message);
            }
        }
    })
}


/*以下是单条数据的删除*/
function member_del(obj,productOrderId){
    layer.confirm('确认要删除吗？',function(index){
        var arr = [];
        arr.push(productOrderId)
        //发异步删除数据
        if(batchDelete(arr)){
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
            $("#parentDIV").removeClass("layui-form-checked");
            var pageNum = $("#pageSPAN").attr("num");
            pageSearch(pageNum);
        }else{
            layer.msg('删除失败!',{icon:2,time:1000});
        }
    });
}

/*批量删除*/
function delAll () {
    /*获取到所有被选中的id*/
    var productOrderId = tableCheck.getData();
    layer.confirm('确认要删除吗？',function(index){
        //捉到所有被选中的，发异步进行删除
        if(batchDelete(productOrderId)){
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

function batchDelete(productOrderIdArray){
    var result = false;
    $.ajax({
        url:"/mall/background/product/order/batch/delete",
        type:"POST",
        data:JSON.stringify(productOrderIdArray),
        dataType:"json",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            result = data.code == 200;
        }
    })
    return result;
}

