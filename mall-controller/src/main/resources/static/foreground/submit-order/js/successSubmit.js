orderInfLoad()
function orderInfLoad(){
    var resultValue = "";
    var totalPrice = 0;
    $.ajax({
        url:"/mall/foreground/product/order/receiving/data?productOrderNumber=" + $("input[name='productOrderNumber']").val(),
        type:"GET",
        async:false,
        contentType: "application/json;charset=utf-8",
        success:function(data){
            resultValue += "<p>";
            resultValue += "金额：<span class=\"pay-total\">";
            $.ajax({
                url:"/mall/foreground/product/order/order/sum/price?productOrderNumber=" + $("input[name='productOrderNumber']").val(),
                type:"GET",
                async:false,
                contentType: "application/json;charset=utf-8",
                success:function (sumPrice) {
                    totalPrice = (sumPrice.data).toFixed(2);
                    resultValue += totalPrice;
                }
            })
            resultValue += "</span>元";
            resultValue += "</p>";
            resultValue += "<p>订单编号：" + data.data.productOrderNumber + "                    </p>";
            resultValue += "<p>";
            resultValue += "配送：" + data.data.receivingInfName + "                                    <span class=\"line\">/</span>";
            resultValue += data.data.receivingInfPhone + "                                    <span class=\"line\">/</span>";
            resultValue += "" + data.data.receivingInfProvince + " " + data.data.receivingInfCity + " " + data.data.receivingInfDistrict + " " + data.data.receivingInfAddress + "                                                                <span class=\"line\">/</span>";
            var infName = data.data.productInfName;
            if(infName.length >= 13){
                infName = infName.substring(0,13) + "...";
            }
            resultValue += "<input type='hidden' name='productName' value='" + infName + "' />";
            resultValue += "<input type='hidden' name='productOrderNumber' value='" + data.data.productOrderNumber + "'/>";
            resultValue += "<input type='hidden' name='productPrice' value='" + totalPrice + "' />";
        }
    })
    $("#orderDIV").empty().append(resultValue);
}
