productPictureData();
function productPictureData(){
    $.ajax({
        url:"/mall/foreground/picture/inf/product/data?productInfId=" + $("#productInfId").val(),
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json;charset=utf-8",
        success:function(data){
            var resultValue = "";
            var firstPicValue = "";
                $.each(data.data, function (index, element) {
                    if(index == 0){
                        firstPicValue = "<img src=\"" + element.pictureInfUrl + "\">"
                    }
                    resultValue += "<div class=\"Xcontent09\"><img src=\"" + element.pictureInfUrl + "\"></div>";
                })
            $("#firstPicDIV").empty().append(firstPicValue);
            $("#productPicOL").empty().append(resultValue);
        }
    })
}


productBuyData();
function productBuyData(){
    var $productId = $("#productInfId").val();
    $.ajax({
        url:"/mall/foreground/product/inf/single/data?productInfId=" + $productId,
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json;charset=utf-8",
        success:function(data){
            var resultValue = "";
            var $productId = data.data.productInfId;
            var $productName = data.data.productInfName;
            var $productDescribe = data.data.productInfDescribe;
            var $productPrice = data.data.productInfPrice;
            var $productSales = data.data.productInfSales;
            resultValue += "<input type='hidden' id='proIdINPUT' value='" + $productId + "' />"
            resultValue +="<div class=\"Xcontent14\"><a href=\"#\"><p>" + $productName + "</p></a></div>";
            //resultValue +="<div class=\"Xcontent15\"><img src=\"" + $pictureInfUrl + "\"></div>";
            resultValue +="<div class=\"Xcontent16\"><p>" + $productDescribe + "</p></div>";
            resultValue +="<div class=\"Xcontent17\">";
            resultValue +="<p class=\"Xcontent18\">售价</p>";
            resultValue +="<p class=\"Xcontent19\">￥<span>" + $productPrice + "</span></p>";


            /*促销一栏*/
            /*resultValue +="<div class=\"Xcontent20\">";
            resultValue +="<p class=\"Xcontent21\">促销</p>";
            resultValue +="<img src=\"/static/home/product-inf-list/images/shangpinxiangqing/X12.png\">";
            resultValue +="<p class=\"Xcontent22\">领610元新年礼券，满再赠好礼</p>";
            resultValue +="</div>";*/


            /*服务一栏*/
            /*resultValue +="<div class=\"Xcontent23\">";
            resultValue +="<p class=\"Xcontent24\">服务</p>";
            resultValue +="<p class=\"Xcontent25\">30天无忧退货&nbsp;&nbsp;&nbsp;&nbsp;       48小时快速退款 &nbsp;&nbsp;&nbsp;&nbsp;        满88元免邮</p>";
            resultValue +="</div>";*/
            resultValue +="<div class=\"Xcontent23\">";
            resultValue +="<p class=\"Xcontent24\">销量</p>";
            resultValue +="<p class=\"Xcontent25\">" + $productSales + "</p>";
            resultValue +="</div>";
            resultValue +="</div>";


            /*图片款式一栏*/
            /*resultValue +="<div class=\"Xcontent26\">";
            resultValue +="<p class=\"Xcontent27\">款式</p>";
            $.ajax({
                url:"/foreground/picture/type/main/list?pictureTypeId=6&productId=" + $productId,
                type:"GET",
                async: false,//设置为同步
                contentType: "application/json;charset=utf-8",
                success:function(data){
                    $.each(data.data, function(index, element){
                        resultValue +="<div class=\"Xcontent28\"><img  src=\"" + element.pictureInfUrl + "\"></div>";
                    })
                }
            })
            resultValue +="</div>";*/


            /*数量一栏*/
            resultValue +="<div class=\"Xcontent30\">";
            resultValue +="<p class=\"Xcontent31\">数量</p>";
            resultValue +="<div class=\"Xcontent32\"><img src=\"/static/home/product-inf-list/images/shangpinxiangqing/X15.png\"></div>";
            resultValue +="<input id='productNumINPUT' onkeyup='positive(this)' class=\"input\" value=\"1\">";
            resultValue +="<div class=\"Xcontent33\"><img src=\"/static/home/product-inf-list/images/shangpinxiangqing/16.png\"></div>";
            resultValue +="</div>";
            /*立即购买  &  加入购物车*/
            resultValue +="<div id=\"submitOrderDIV\" class=\"Xcontent34\"><a href=\"#\"><img src=\"/static/home/product-inf-list/images/shangpinxiangqing/X17.png\"></a></div>";
            resultValue +="<div id=\"addCartDIV\" class=\"Xcontent35\"><a href=\"javascript:;\"><img src=\"/static/home/product-inf-list/images/shangpinxiangqing/X18.png\"></a></div>";
            $("#title").empty().append($productName)
            $("#productBuyOL").empty().append(resultValue)
        }
    })

}
/*控制input只能输入正整数，大于0的数字*/
function positive($this){
    $this.value.length==1 ? $this.value=$this.value.replace(/[^1-9]/g,'') : $this.value=$this.value.replace(/\D/g,'');
    if($this.value == ""){$this.value = 1}
}

$(function(){
    $("#addCartDIV").click(function(){
        var proNum = $("#productNumINPUT").val();
        var proId = $("#productInfId").val();
        $.ajax({
            url:"/mall/foreground/product/cart/add/cart",
            type:"POST",
            data:JSON.stringify({"loginId" : $("#loginIdINPUT").val(), "productInfId" : proId, "productCartNum" : proNum}),
            async: false,//设置为同步
            contentType: "application/json",
            success:function(data){
                if(data.code == 200){
                    swal("成功加入购物车!", "成功加入" + proNum + "件商品到购物车!", "success");
                }else{
                    alert(data.message);
                }
            }
        })
    })
    $("#submitOrderDIV").click(function(){
        $.ajax({
            url:"/foreground/product/order/insert",
            type:"POST",
            data:JSON.stringify({"customerInfId" : $("#customerInfId").val(), "productId" : $("#productId").val(), "productNum" : $("#productNumINPUT").val()}),
            async: false,//设置为同步
            contentType: "application/json",
            success:function(data){
                if(data.data != ""){
                    window.location.href = "/foreground/product/order?productOrderNumber=" + data.data;
                }
            }
        })
    })
})