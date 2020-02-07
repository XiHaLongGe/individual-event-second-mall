/*获取到当前用户的id*/
var loginId = $("#loginIdINPUT").val();
productData();
function productData(){
    $.ajax({
        url:"/mall/foreground/product/cart/all/data?loginId=" + loginId,
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json;charset=utf-8",
        success:function(data){
            /* resultValue用来保存拼接的字符串 */
            var resultValue = "";
            /* eqBrandId 用来保存每次的品牌id */
            var eqBrandId = 0;
            /*  brandOrder 用来记录每一个品牌内商品的序号*/
            var brandOrder = 1;
            /* eachIndex 用来记录循环的次数， 通过不同的操作利用*/
            // var eachIndex = 1;
            $.each(data.data, function(index, element){
                if(element.brandInfId != eqBrandId){
/*  </div>              根据品牌分类  结束  添加商品数据*/
                    /*这里的结束标签，表示在第一次循环不加*/
                    resultValue += eqBrandId == 0 ? "" : "</div></div>";
                    /*以每一个品牌对商品进行分类，下面是生成商品的头部品牌标题*/
                    eqBrandId = element.brandInfId;
                    resultValue += "<div class=\"cartBox\">";
                    resultValue += "<div class=\"shop_info\">";
                    resultValue += "<div class=\"all_check\">";
                    resultValue += "<input type=\"checkbox\" id=\"shop_" + eqBrandId + "\" class=\"shopChoice\">";
                    resultValue += "<label for=\"shop_" + eqBrandId + "\" class=\"shop\"></label>";
                    resultValue += "</div>";
                    resultValue += "<div class=\"shop_name\">";
                    resultValue += "品牌：<a href=\"javascript:;\">" + element.brandInfName + "</a>";
                    resultValue += "</div>";
                    resultValue += "</div>";

/*  <div>              根据品牌分类  开始  添加商品数据*/
                    resultValue += "<div class=\"order_content\">";
                    resultValue += productJoint(element, brandOrder);
                    brandOrder ++;
                }else{
                    resultValue += productJoint(element, brandOrder);
                    brandOrder ++;
                }
            })
/*  </div>              根据品牌分类  结束  添加商品数据*/
            resultValue += "</div>";
            resultValue += "</div>";
            $("#proInfSPAN").empty().append(resultValue);
        }
    })
}


function productJoint(element, brandOrder){
    var resultValue = "";
    resultValue += "<ul class=\"order_lists\">";
    resultValue += "<li class=\"list_chk\">";
    resultValue += "<input type=\"checkbox\" productCartId='" + element.productCartId + "' productId='" + element.productInfId + "' id=\"checkbox_" + brandOrder + "\" class=\"son_check\">";
    resultValue += "<label for=\"checkbox_" + brandOrder + "\"></label>";
    resultValue += "</li>";
    resultValue += "<li class=\"list_con\">";
    resultValue += "<div class=\"list_img\"><a href=\"/mall/foreground/product/inf/home?productInfId=" + element.productInfId + "\"><img src=\"" + element.pictureInfUrl + "\" alt=\"\"></a></div>";
    resultValue += "<div class=\"list_text\"><a href=\"/mall/foreground/product/inf/home?productInfId=" + element.productInfId + "\">" + element.productInfName + "</a></div>";
    resultValue += "</li>";
    resultValue += "<li class=\"list_info\">";
    /*描述*/
    resultValue += "<p>" + element.productInfDescribe + "</p>";
    /*resultValue += "<p>规格：默认</p>";
    resultValue += "<p>尺寸：16*16*3(cm)</p>";*/
    resultValue += "</li>";
    resultValue += "<li class=\"list_price\">";
    resultValue += "<p class=\"price\">￥" + element.productInfPrice.toFixed(2) + "</p>";
    resultValue += "</li>";
    resultValue += "<li class=\"list_amount\">";
    resultValue += "<div class=\"amount_box\">";
    resultValue += "<a productId='" + element.productInfId + "' href=\"javascript:;\" class=\"reduce reSty\">-</a>";
    resultValue += "<input type=\"text\" value=\"" + element.productCartNum + "\" class=\"sum\">";
    resultValue += "<a productId='" + element.productInfId + "' href=\"javascript:;\" class=\"plus\">+</a>";
    resultValue += "</div>";
    resultValue += "</li>";
    resultValue += "<li class=\"list_sum\">";
    resultValue += "<p class=\"sum_price\">￥" + (element.productInfPrice * element.productCartNum).toFixed(2) + "</p>";
    resultValue += "</li>";
    resultValue += "<li class=\"list_op\">";
    resultValue += "<p class=\"del\"><a productId='" + element.productInfId + "' href=\"javascript:;\" class=\"delBtn\">移除商品</a></p>";
    resultValue += "</li>";
    resultValue += "</ul>";
    return resultValue;
}
/*修改购物车中商品的数量*/
function productCartEdit(productId,productCartNum){
    var yn = false;
    $.ajax({
        url:"/mall/foreground/product/cart/update/cart",
        type:"POST",
        data:JSON.stringify({"loginId" : loginId, "productInfId" : productId, "productCartNum" : productCartNum}),
        // async: false,//设置为同步
        contentType: "application/json;charset=utf-8",
        success:function(data){
            yn = data.data;
        }
    })
    return yn;
}
/*删除购物车中的商品 + 批量删除*/
function productCartDelete(productIds){
    var productInfIdArray = [];
    productIds instanceof Array ? productInfIdArray = productIds : productInfIdArray.push(productIds);
    var yn = false;
    $.ajax({
        url:"/mall/foreground/product/cart/batch/delete/cart",
        type:"POST",
        data:JSON.stringify({"productInfIdArray" : productInfIdArray, "loginId" : loginId}),
        contentType: "application/json;charset=utf-8",
        success:function(data){
            yn = data.data;
        }
    })
    return yn;
}

