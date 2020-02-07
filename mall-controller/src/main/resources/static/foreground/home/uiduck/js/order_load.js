orderDataLoad();
function orderDataLoad(){
    var resultValue = "";
    var resultIndex = 0;
    $.ajax({
        url:"/foreground/product/order/customer/list",
        data:JSON.stringify({"customerInfId" : $("#customerInfId").val()}),
        type:"POST",
        async:false,
        contentType: "application/json;charset=utf-8",
        success:function(data){
            $.each(data.data, function(i,e){
                resultValue += "<tr id=\"ud-tr-" + resultIndex + "\" ud-tr-num=\"" + resultIndex + "\" class=\"uiduck_tr \" style=\"visibility: visible;\">";
                resultValue += "<td class=\"\">" + (resultIndex+1) + "</td>";
                resultValue += "<td class=\"\">";
                resultValue += "<a style=\"font-weight: 900;color:#E6A23C;\"></a>" + e.productName + "</td>";
                resultValue += "<td class=\"\">268</td>";
                resultValue += "<td class=\"\"><img style=\"width:65px;height:65px\" src=\"" + e.pictureInfUrl + "\"></td>";
                resultValue += "<td class=\"\">" + e.productOrderNumber + "</td>";
                var payment = "";
                if(e.payment == 0){
                    payment = "未支付";
                }else if(e.payment == 1){
                    payment = "支付宝";
                }
                resultValue += "<td class=\"\">" + payment + "</td>";
                var productOrderState,buttonValue,disabled;
                if(e.productOrderState == 1){
                    productOrderState = "待付款";
                    buttonValue = "付款";
                }else if(e.productOrderState == 2){
                    productOrderState = "待收货";
                    buttonValue = "确认收货";
                }else{
                    productOrderState = "已收货";
                    buttonValue = "已收货";
                    disabled = "disabled";
                }
                resultValue += "<td class=\"\">" + productOrderState + "</td>";
                resultValue += "<td class=\"style='width:100px'\">";
                resultValue += "<div ud-index=\"" + resultIndex + "\">";
                resultValue += "<button " + disabled + " class=\"uiduck-btn\" proid=\"1\">" + buttonValue + "</button>";
                resultValue += "</div>";
                resultValue += "</td>";
                resultValue += "</tr>";
                resultIndex ++;
            })
        }
    })
    $("#uiduck_1577158080757").children("tbody").empty().append(resultValue);
}