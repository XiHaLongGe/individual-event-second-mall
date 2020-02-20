productOrderData();
function productOrderData(){
    var resultValue = "";
    var totalValue = 0;
    $.ajax({
        url:"/mall/foreground/product/order/submit/data?productOrderNumber=" + $("input[name='productOrderNumber']").val(),
        type:"GET",
        async:false,
        contentType: "application/json;charset=utf-8",
        success:function(data){
            $.each(data.data, function (index,element){
                resultValue += "<dd productOrderId='" + element.productOrderId + "' class=\"item clearfix\">";
                resultValue += "<div class=\"item-row\">";
                resultValue += "<div class=\"col col-1\">";
                resultValue += "<div class=\"g-pic\">";
                resultValue += "<img src=\"" + element.pictureInfUrl + "\" width=\"40\" height=\"40\" />";
                resultValue += "</div>";
                resultValue += "<div class=\"g-info\">";
                resultValue += "<a href=\"#\">";
                resultValue += element.productInfName + "                                            </a>";
                resultValue += "</div>";
                resultValue += "</div>";
                resultValue += "<div class=\"col col-2\">" + element.productInfPrice + "元</div>";
                resultValue += "<div class=\"col col-3\">" + element.productNum + "</div>";
                resultValue += "<div class=\"col col-4\">" + (parseFloat(element.productNum) * parseFloat(element.productInfPrice)).toFixed(2) + "元</div>";
                resultValue += "</div>";
                resultValue += "</dd>";
                // totalValue = (parseFloat(totalValue) + parseFloat(element.productNum) * parseFloat(element.productPrice));
                totalValue = totalValue + (parseFloat(element.productNum) * parseFloat(element.productInfPrice))
            })
        }
    })
    $("#productSPAN").empty().append(resultValue);
    $("#totalPriceSPAN").empty().append(totalValue.toFixed(2) + "元");
    $("#totalPrice2").empty().append((totalValue.toFixed(2)));
}
$(function(){
    /*下单点击事件*/
    $("#checkoutToPay").on("click", function(){
        /*取消定时器*/
        // clearInterval(iCount);
        $.ajax({
            url:"/mall/foreground/product/order/submit/order",
            type:"POST",
            data:JSON.stringify({
                "receivingInfId" : $("input[name='receivingInfId']").val(),
                "leaveWord" : $("input[name='leaveWord']").val(),
                "productOrderNumber" : $("input[name='productOrderNumber']").val()
            }),
            async:false,
            contentType: "application/json;charset=utf-8",
            success:function(data){
                if(data.data){
                    window.location.href = "/mall/foreground/product/order/success/submit?productOrderNumber=" + $("input[name='productOrderNumber']").val();
                }
            }
        })
    })
/*如果用户没有在倒计时30分钟时间之内下单将自动删除该订单*/
// var iCount = setInterval(delCustomerOrder, 1800000);
/*取消下单点击事件*/
$("#cancelA").on("click", function(){
    window.location.href = "/mall/foreground/home";
    // delCustomerOrder()
})
    /*删除用户未下单数据*/
    function delCustomerOrder() {
        /*取消定时器*/
        clearInterval(iCount);
        $.ajax({
            url:"/mall/foreground/product/order/delete/order",
            type:"POST",
            data:$("input[name='productOrderNumber']").val(),
            async:false,
            contentType: "application/json;charset=utf-8",
            success:function(data){
                if(data.code === 200){
                    window.location.href = "/mall/foreground/home";
                }
            }
        })
    }
})