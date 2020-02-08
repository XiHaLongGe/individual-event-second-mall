receivingInfData();
/*加载收货信息*/

var firstReceivingInfId = 0;
function receivingInfData(){
    var resultValue = "";
    var resultIndex = 0;
    $.ajax({
        url:"/mall/foreground/receiving/customer/data?loginId=" + $("input[name='loginId']").val(),
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json;charset=utf-8",
        success:function(data){
            $.each(data.data, function(index, element){
                resultIndex ++;
                if(index == 0){
                    firstReceivingInfId = element.receivingInfId;
                }
                resultValue += "<dl receivingInfId='" + element.receivingInfId + "' class=\"item " + (index == 0 ? "selected" : "") + "\"style=\"display: line;\">";
                resultValue += "<dt>";
                resultValue += "<strong class=\"itemConsignee\">" + element.receivingInfName + "</strong>";
                resultValue += "</dt>";
                resultValue += "<dd>";
                resultValue += "<p class=\"tel itemTel\">" + element.receivingInfPhone + "</p>";
                resultValue += "<p class=\"itemRegion\">" + element.receivingInfProvince + " " + element.receivingInfCity + " " + element.receivingInfDistrict + "</p>";
                resultValue += "<p class=\"itemStreet\">" + element.receivingInfAddress + "</p>";
                resultValue += "</dd>";
                resultValue += "<dd style=\"display:none\">";
                resultValue += "</dd>";
                resultValue += "</dl>";
            })
        }
    })
    /*限制用户只能拥有3个收货地址，当用户已存在3个收货地址就不加载添加收获地址的选项*/
    /*if(resultIndex < 3){
        resultValue += "<div class=\"item use-new-addr\"  id=\"J_useNewAddr\" data-state=\"off\">";
        resultValue += "<span class=\"iconfont icon-add\"><img src=\"/static/home/submit-order/images/add_cart.png\" /></span>";
        resultValue += "新增地址";
        resultValue += "</div>";
    }*/
    $("input[name='receivingInfId']").val(firstReceivingInfId);
    $("#checkoutAddrList").empty().append(resultValue)
    eventsRefresh();
}
function eventsRefresh(){
/*刷新选中框事件，选中一个li给其加上selected*/
    $(".item").on("click",function(){
        $(".item").each(function(){
            $(this).removeClass('selected');
        })
        $(this).addClass('selected');
        $("input[name='receivingInfId']").val($(this).attr("receivingInfId") != "" ? $(this).attr("receivingInfId") : firstReceivingInfId);
    })
}

