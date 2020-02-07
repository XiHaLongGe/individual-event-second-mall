
productOrderData();
function productOrderData(){
    /*
          想要达到效果：
                <dd class="item clearfix">
                    <div class="item-row">
                        <div class="col col-1">
                            <div class="g-pic">
                                <img src="http://i1.mifile.cn/a1/T11lLgB5YT1RXrhCrK!40x40.jpg" srcset="http://i1.mifile.cn/a1/T11lLgB5YT1RXrhCrK!80x80.jpg 2x" width="40" height="40" />
                            </div>
                            <div class="g-info">
                                <a href="#">
                                    小米T恤 忍者米兔双截棍 军绿 XXL                                            </a>
                            </div>
                        </div>

                        <div class="col col-2">39元</div>
                        <div class="col col-3">1</div>
                        <div class="col col-4">39元</div>
                    </div>
                </dd>
    */

    /*

    */
    var resultValue = "";
    var totalValue = 0;
    $.ajax({
        url:"/foreground/product/order/productOrderNumber/list?productOrderNumber=" + $("input[name = 'productOrderNumber']").val(),
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
                resultValue += element.productName + "                                            </a>";
                resultValue += "</div>";
                resultValue += "</div>";
                resultValue += "<div class=\"col col-2\">" + element.productPrice + "元</div>";
                resultValue += "<div class=\"col col-3\">" + element.productNum + "</div>";
                resultValue += "<div class=\"col col-4\">" + (parseFloat(element.productNum) * parseFloat(element.productPrice)).toFixed(2) + "元</div>";
                resultValue += "</div>";
                resultValue += "</dd>";
                // totalValue = (parseFloat(totalValue) + parseFloat(element.productNum) * parseFloat(element.productPrice));
                totalValue = totalValue + (parseFloat(element.productNum) * parseFloat(element.productPrice))
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
        clearInterval(iCount);
        $.ajax({
            url:"/foreground/product/order/submit/update",
            type:"POST",
            data:JSON.stringify(transformJSON("checkoutForm")),
            async:false,
            contentType: "application/json;charset=utf-8",
            success:function(data){
                if(data.data){
                    window.location.href = "/foreground/product/order/success/submit?productOrderNumber=" + $("input[name='productOrderNumber']").val();
                }
            }
        })
    })
/*如果用户没有在倒计时30分钟时间之内下单将自动删除该订单*/
var iCount = setInterval(delCustomerOrder, 1800000);
/*取消下单点击事件*/
$("#cancelA").on("click", function(){
    delCustomerOrder()
})
    /*删除用户未下单数据*/
    function delCustomerOrder() {
        clearInterval(iCount);
        var productOrderIds = [];
        $("#productSPAN").children("dd").each(function(i,e){
            productOrderIds.push($(this).attr("productOrderId"))
        })
        $.ajax({
            url:"/foreground/product/order/delete",
            type:"POST",
            data:JSON.stringify({"productOrderIds" : productOrderIds}),
            async:false,
            contentType: "application/json;charset=utf-8",
            success:function(data){
                if(data.data){
                    window.history.go(-1);
                }
            }
        })
    }
})

//将表单数据转换成json数据
function transformJSON(formID){
    var $jsonData = {};
    /*下面是将form表单的数据转换成一个json的数据格式*/
    $.each($("#"+ formID).serializeArray(), function(i,e){
        $jsonData[e.name] = e.value;
    })
    return $jsonData;
}