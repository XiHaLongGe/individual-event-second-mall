orderInfLoad()
function orderInfLoad(){
    var resultValue = "";
    var totalPrice = 0;
    $.ajax({
        url:"/foreground/product/order/productOrderNumber/list?productOrderNumber=" + $("input[name='productOrderNumber']").val(),
        type:"GET",
        async:false,
        contentType: "application/json;charset=utf-8",
        success:function(data){
            $.each(data.data, function(index,element){
                resultValue += "<p>";
                resultValue += "金额：<span class=\"pay-total\">" + (totalPrice = (totalPrice + (parseFloat(element.productNum) * parseFloat(element.productPrice))).toFixed(2)) + "</span>元";
                resultValue += "</p>";
                resultValue += "<p>订单编号：" + element.productOrderNumber + "                    </p>";
                resultValue += "<p>";
                resultValue += "配送：" + element.receivingInfName + "                                    <span class=\"line\">/</span>";
                resultValue += element.receivingInfPhone + "                                    <span class=\"line\">/</span>";
                resultValue += "" + element.receivingInfProvince + " " + element.receivingInfCity + " " + element.receivingInfDistrict + " " + element.receivingInfAddress + "                                                                <span class=\"line\">/</span>";
                resultValue += "<input type='hidden' name='productName' value='" + element.productName + "' />";
                resultValue += "<input type='hidden' name='productOrderNumber' value='" + element.productOrderNumber + "' />";
                resultValue += "<input type='hidden' name='productPrice' value='" + totalPrice + "' />";
            })
        }
    })
    $("#orderDIV").empty().append(resultValue);
}
