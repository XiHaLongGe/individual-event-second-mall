var loginId = $("#loginIdINPUT").val();
categorySale();
function categorySale(){
    $.ajax({
        url:"/mall/foreground/product/category/level/data?productCategoryLevel=3",
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            var resultVal = "";
            var prefixIndex = 1;
            $.each(data.data, function(index,element) {
                if(element.productCategoryName != "热销商品"){
                    var suffixIndex = 1;
                    var resultDIV = "";
                    resultVal += "<span class=\"as blessing_package\">";
                    resultVal += "<a href=\"#\" style=\" color:#000\">";
                    resultVal += "<h3 style=\"float:left\">&nbsp;" + element.productCategoryName + "<font>" + element.sidebarCategoryDescribe + "</font>";
                    resultVal += "<img src=\"/static/home/images/zd.png\" style=\"display:block; float:left; margin-top:5px\">";
                    resultVal += "</h3>";
                    resultVal += "<div class=\"detailed_navigation\">";
                    resultVal += "<ul>";
                    $.ajax({
                        url:"/mall/foreground/product/category/parent/data?parentCategoryId=" + element.productCategoryId,
                        type:"GET",
                        async: false,//设置为同步
                        contentType: "application/json",
                        success:function(data){
                            $.each(data.data, function(index, element){
                                var checked = index == 0 ? " yadi" : "";
                                resultVal += "<li class=\"dog d-" + prefixIndex + "-lt" + suffixIndex + " " + checked + "\"  dg-floor=\"" + prefixIndex + "\"  dg-ct=\"lt" + suffixIndex + "\">" + element.productCategoryName + "</li>";
                                resultDIV += categoryProduct(element.productCategoryId, prefixIndex, suffixIndex);
                                suffixIndex ++;
                            })
                        }
                    })
                    resultVal += "</ul>";
                    resultVal += "</div>";
                    resultVal += "</a>";
                    resultVal += "</span>";
                    resultVal += "<div>" + resultDIV + "</div>";
                    prefixIndex ++;
                }
            })
            $("#spanProduct").empty().append(resultVal);
        }
    })
}
function categoryProduct(categoryId, prefixIndex, suffixIndex){
    var resultDIV = "";
    var styleDIV = suffixIndex == 1 ? "" : "style=\"display:none\"";
    resultDIV += "<div class=\"currency f-" + prefixIndex + "-lt" + suffixIndex + "\" " + styleDIV + ">";
    resultDIV += "<ul>";
    $.ajax({
        url:"/mall/foreground/product/inf/column?categoryId=" + categoryId,
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            $.each(data.data, function(index, element){
                resultDIV += "<li>";
                resultDIV += "<a href=\"/mall/foreground/product/inf/home?productInfId=" + element.productInfId + "\" target=\"_blank\"><img src=\"" + element.pictureInfUrl + "\" style=\" margin:0 auto; display:block; width:220px; height:220px\"></a>";
                resultDIV += "<light1><img src=\"/static/home/images/saoguang.png\"></light1>";
                resultDIV += "<span>￥" + element.productInfPrice + "</span>";
                resultDIV += "<a href=\"/mall/foreground/product/inf/home?productInfId=" + element.productInfId + "\" target=\"_blank\"><p>" + element.productInfName + "</p></a>";
                resultDIV += "<em>";
                resultDIV += "<a href=\"#\">收藏</a>";
                resultDIV += "<a onclick='addCart($(this))' productId=" + element.productInfId + " href=\"javascript:void(0)\" class=\"add_scar\">加入购物车</a>";
                resultDIV += "</em>";
                resultDIV += "</li>";
            })
        }
    })
    resultDIV += "</ul>";
    resultDIV += "</div>";
    return resultDIV;
}

function addCart($this){
    var productId = $this.attr("productId");
    var cartNum = $("#cartNumB").text();
    $.ajax({
        url:"/mall/foreground/product/cart/add/cart",
        type:"POST",
        data:JSON.stringify({"loginId" : loginId, "productInfId" : productId, "productCartNum" : 1}),
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            if(data.code == 200){
                $("#cartNumB").text(parseInt(cartNum) + 1)
            }else{
                alert(data.message);
            }
        }
    })
}