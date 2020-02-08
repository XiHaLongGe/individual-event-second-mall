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
            resultValue += "金额：<span class=\"pay-total\">" + (totalPrice = (parseFloat(data.data.productNum) * parseFloat(data.data.productInfPrice)).toFixed(2)) + "</span>元";
            resultValue += "</p>";
            resultValue += "<p>订单编号：" + data.data.productOrderNumber + "                    </p>";
            resultValue += "<p>";
            resultValue += "配送：" + data.data.receivingInfName + "                                    <span class=\"line\">/</span>";
            resultValue += data.data.receivingInfPhone + "                                    <span class=\"line\">/</span>";
            resultValue += "" + data.data.receivingInfProvince + " " + data.data.receivingInfCity + " " + data.data.receivingInfDistrict + " " + data.data.receivingInfAddress + "                                                                <span class=\"line\">/</span>";
            resultValue += "<input type='hidden' name='productName' value='" + data.data.productInfName + "' />";
            resultValue += "<input type='hidden' name='productOrderNumber' value='" + data.data.productOrderNumber + "' />";
            resultValue += "<input type='hidden' name='productPrice' value='" + totalPrice + "' />";
        }
    })
    $("#orderDIV").empty().append(resultValue);
}
