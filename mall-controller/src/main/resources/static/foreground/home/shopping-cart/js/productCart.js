/*获取到当前用户的id*/
var $customerInfId = $("#customerInfId").val();
productData();
function productData(){
    /*
        想要达到效果：
                <div class="cartBox">
                    <div class="shop_info">
                        <div class="all_check">
                            <!--店铺全选-->
                            <input type="checkbox" id="shop_a" class="shopChoice">
                            <label for="shop_a" class="shop"></label>
                        </div>
                        <div class="shop_name">
                            店铺：<a href="javascript:;">搜猎人艺术生活</a>
                        </div>
                    </div>
                    <div class="order_content">
                        <ul class="order_lists">
                            <li class="list_chk">
                                <input type="checkbox" id="checkbox_2" class="son_check">
                                <label for="checkbox_2"></label>
                            </li>
                            <li class="list_con">
                                <div class="list_img"><a href="javascript:;"><img src="/static/home/shopping-cart/images/1.png" alt=""></a></div>
                                <div class="list_text"><a href="javascript:;">夏季男士迷彩无袖T恤圆领潮流韩版修身男装背心青年时尚打底衫男</a></div>
                            </li>
                            <li class="list_info">
                                <p>规格：默认</p>
                                <p>尺寸：16*16*3(cm)</p>
                            </li>
                            <li class="list_price">
                                <p class="price">￥980</p>
                            </li>
                            <li class="list_amount">
                                <div class="amount_box">
                                    <a href="javascript:;" class="reduce reSty">-</a>
                                    <input type="text" value="1" class="sum">
                                    <a href="javascript:;" class="plus">+</a>
                                </div>
                            </li>
                            <li class="list_sum">
                                <p class="sum_price">￥980</p>
                            </li>
                            <li class="list_op">
                                <p class="del"><a href="javascript:;" class="delBtn">移除商品</a></p>
                            </li>
                        </ul>
                        <ul class="order_lists">
                            <li class="list_chk">
                                <input type="checkbox" id="checkbox_3" class="son_check">
                                <label for="checkbox_3"></label>
                            </li>
                            <li class="list_con">
                                <div class="list_img"><a href="javascript:;"><img src="/static/home/shopping-cart/images/2.png" alt=""></a></div>
                                <div class="list_text"><a href="javascript:;">夏季男士迷彩无袖T恤圆领潮流韩版修身男装背心青年时尚打底衫男</a></div>
                            </li>
                            <li class="list_info">
                                <p>规格：默认</p>
                                <p>尺寸：16*16*3(cm)</p>
                            </li>
                            <li class="list_price">
                                <p class="price">￥780</p>
                            </li>
                            <li class="list_amount">
                                <div class="amount_box">
                                    <a href="javascript:;" class="reduce reSty">-</a>
                                    <input type="text" value="1" class="sum">
                                    <a href="javascript:;" class="plus">+</a>
                                </div>
                            </li>
                            <li class="list_sum">
                                <p class="sum_price">￥780</p>
                            </li>
                            <li class="list_op">
                                <p class="del"><a href="javascript:;" class="delBtn">移除商品</a></p>
                            </li>
                        </ul>
                        <ul class="order_lists">
                            <li class="list_chk">
                                <input type="checkbox" id="checkbox_6" class="son_check">
                                <label for="checkbox_6"></label>
                            </li>
                            <li class="list_con">
                                <div class="list_img"><a href="javascript:;"><img src="/static/home/shopping-cart/images/3.png" alt=""></a></div>
                                <div class="list_text"><a href="javascript:;">夏季男士迷彩无袖T恤圆领潮流韩版修身男装背心青年时尚打底衫男</a></div>
                            </li>
                            <li class="list_info">
                                <p>规格：默认</p>
                                <p>尺寸：16*16*3(cm)</p>
                            </li>
                            <li class="list_price">
                                <p class="price">￥180</p>
                            </li>
                            <li class="list_amount">
                                <div class="amount_box">
                                    <a href="javascript:;" class="reduce reSty">-</a>
                                    <input type="text" value="1" class="sum">
                                    <a href="javascript:;" class="plus">+</a>
                                </div>
                            </li>
                            <li class="list_sum">
                                <p class="sum_price">￥180</p>
                            </li>
                            <li class="list_op">
                                <p class="del"><a href="javascript:;" class="delBtn">移除商品</a></p>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="cartBox">
                    <div class="shop_info">
                        <div class="all_check">
                            <!--店铺全选-->
                            <input type="checkbox" id="shop_b" class="shopChoice">
                            <label for="shop_b" class="shop"></label>
                        </div>
                        <div class="shop_name">
                            店铺：<a href="javascript:;">卷卷旗舰店</a>
                        </div>
                    </div>
                    <div class="order_content">
                        <ul class="order_lists">
                            <li class="list_chk">
                                <input type="checkbox" id="checkbox_4" class="son_check">
                                <label for="checkbox_4"></label>
                            </li>
                            <li class="list_con">
                                <div class="list_img"><a href="javascript:;"><img src="/static/home/shopping-cart/images/4.png" alt=""></a></div>
                                <div class="list_text"><a href="javascript:;">夏季男士迷彩无袖T恤圆领潮流韩版修身男装背心青年时尚打底衫男</a></div>
                            </li>
                            <li class="list_info">
                                <p>规格：默认</p>
                                <p>尺寸：16*16*3(cm)</p>
                            </li>
                            <li class="list_price">
                                <p class="price">￥1980</p>
                            </li>
                            <li class="list_amount">
                                <div class="amount_box">
                                    <a href="javascript:;" class="reduce reSty">-</a>
                                    <input type="text" value="1" class="sum">
                                    <a href="javascript:;" class="plus">+</a>
                                </div>
                            </li>
                            <li class="list_sum">
                                <p class="sum_price">￥1980</p>
                            </li>
                            <li class="list_op">
                                <p class="del"><a href="javascript:;" class="delBtn">移除商品</a></p>
                            </li>
                        </ul>
                        <ul class="order_lists">
                            <li class="list_chk">
                                <input type="checkbox" id="checkbox_5" class="son_check">
                                <label for="checkbox_5"></label>
                            </li>
                            <li class="list_con">
                                <div class="list_img"><a href="javascript:;"><img src="/static/home/shopping-cart/images/5.png" alt=""></a></div>
                                <div class="list_text"><a href="javascript:;">夏季男士迷彩无袖T恤圆领潮流韩版修身男装背心青年时尚打底衫男</a></div>
                            </li>
                            <li class="list_info">
                                <p>规格：默认</p>
                                <p>尺寸：16*16*3(cm)</p>
                            </li>
                            <li class="list_price">
                                <p class="price">￥480</p>
                            </li>
                            <li class="list_amount">
                                <div class="amount_box">
                                    <a href="javascript:;" class="reduce reSty">-</a>
                                    <input type="text" value="1" class="sum">
                                    <a href="javascript:;" class="plus">+</a>
                                </div>
                            </li>
                            <li class="list_sum">
                                <p class="sum_price">￥480</p>
                            </li>
                            <li class="list_op">
                                <p class="del"><a href="javascript:;" class="delBtn">移除商品</a></p>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="cartBox">
                    <div class="shop_info">
                        <div class="all_check">
                            <!--店铺全选-->
                            <input type="checkbox" id="shop_c" class="shopChoice">
                            <label for="shop_c" class="shop"></label>
                        </div>
                        <div class="shop_name">
                            店铺：<a href="javascript:;">卷卷旗舰店</a>
                        </div>
                    </div>
                    <div class="order_content">
                        <ul class="order_lists">
                            <li class="list_chk">
                                <input type="checkbox" id="checkbox_8" class="son_check">
                                <label for="checkbox_8"></label>
                            </li>
                            <li class="list_con">
                                <div class="list_img"><a href="javascript:;"><img src="/static/home/shopping-cart/images/1.png" alt=""></a></div>
                                <div class="list_text"><a href="javascript:;">夏季男士迷彩无袖T恤圆领潮流韩版修身男装背心青年时尚打底衫男</a></div>
                            </li>
                            <li class="list_info">
                                <p>规格：默认</p>
                                <p>尺寸：16*16*3(cm)</p>
                            </li>
                            <li class="list_price">
                                <p class="price">￥1980</p>
                            </li>
                            <li class="list_amount">
                                <div class="amount_box">
                                    <a href="javascript:;" class="reduce reSty">-</a>
                                    <input type="text" value="1" class="sum">
                                    <a href="javascript:;" class="plus">+</a>
                                </div>
                            </li>
                            <li class="list_sum">
                                <p class="sum_price">￥1980</p>
                            </li>
                            <li class="list_op">
                                <p class="del"><a href="javascript:;" class="delBtn">移除商品</a></p>
                            </li>
                        </ul>
                        <ul class="order_lists">
                            <li class="list_chk">
                                <input type="checkbox" id="checkbox_9" class="son_check">
                                <label for="checkbox_9"></label>
                            </li>
                            <li class="list_con">
                                <div class="list_img"><a href="javascript:;"><img src="/static/home/shopping-cart/images/1.png" alt=""></a></div>
                                <div class="list_text"><a href="javascript:;">夏季男士迷彩无袖T恤圆领潮流韩版修身男装背心青年时尚打底衫男</a></div>
                            </li>
                            <li class="list_info">
                                <p>规格：默认</p>
                                <p>尺寸：16*16*3(cm)</p>
                            </li>
                            <li class="list_price">
                                <p class="price">￥480</p>
                            </li>
                            <li class="list_amount">
                                <div class="amount_box">
                                    <a href="javascript:;" class="reduce reSty">-</a>
                                    <input type="text" value="1" class="sum">
                                    <a href="javascript:;" class="plus">+</a>
                                </div>
                            </li>
                            <li class="list_sum">
                                <p class="sum_price">￥480</p>
                            </li>
                            <li class="list_op">
                                <p class="del"><a href="javascript:;" class="delBtn">移除商品</a></p>
                            </li>
                        </ul>
                    </div>
                </div>

    */
    $.ajax({
        url:"/foreground/product/cart/list?customerInfId=" + $customerInfId,
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
                if(element.brandId != eqBrandId){
/*  </div>              根据品牌分类  结束  添加商品数据*/
                    /*这里的结束标签，表示在第一次循环不加*/
                    resultValue += eqBrandId == 0 ? "" : "</div></div>";
                    /*以每一个品牌对商品进行分类，下面是生成商品的头部品牌标题*/
                    eqBrandId = element.brandId;
                    resultValue += "<div class=\"cartBox\">";
                    resultValue += "<div class=\"shop_info\">";
                    resultValue += "<div class=\"all_check\">";
                    resultValue += "<input type=\"checkbox\" id=\"shop_" + eqBrandId + "\" class=\"shopChoice\">";
                    resultValue += "<label for=\"shop_" + eqBrandId + "\" class=\"shop\"></label>";
                    resultValue += "</div>";
                    resultValue += "<div class=\"shop_name\">";
                    resultValue += "品牌：<a href=\"javascript:;\">" + element.brandName + "</a>";
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
    resultValue += "<input type=\"checkbox\" productCartId='" + element.productCartId + "' productId='" + element.productId + "' id=\"checkbox_" + brandOrder + "\" class=\"son_check\">";
    resultValue += "<label for=\"checkbox_" + brandOrder + "\"></label>";
    resultValue += "</li>";
    resultValue += "<li class=\"list_con\">";
    resultValue += "<div class=\"list_img\"><a href=\"/foreground/product?productId=" + element.productId + "\"><img src=\"" + element.pictureInfUrl + "\" alt=\"\"></a></div>";
    resultValue += "<div class=\"list_text\"><a href=\"/foreground/product?productId=" + element.productId + "\">" + element.productName + "</a></div>";
    resultValue += "</li>";
    resultValue += "<li class=\"list_info\">";
    /*描述*/
    resultValue += "<p>" + element.productDescribe + "</p>";
    /*resultValue += "<p>规格：默认</p>";
    resultValue += "<p>尺寸：16*16*3(cm)</p>";*/
    resultValue += "</li>";
    resultValue += "<li class=\"list_price\">";
    resultValue += "<p class=\"price\">￥" + element.productPrice.toFixed(2) + "</p>";
    resultValue += "</li>";
    resultValue += "<li class=\"list_amount\">";
    resultValue += "<div class=\"amount_box\">";
    resultValue += "<a productId='" + element.productId + "' href=\"javascript:;\" class=\"reduce reSty\">-</a>";
    resultValue += "<input type=\"text\" value=\"" + element.productCartNum + "\" class=\"sum\">";
    resultValue += "<a productId='" + element.productId + "' href=\"javascript:;\" class=\"plus\">+</a>";
    resultValue += "</div>";
    resultValue += "</li>";
    resultValue += "<li class=\"list_sum\">";
    resultValue += "<p class=\"sum_price\">￥" + (element.productPrice * element.productCartNum).toFixed(2) + "</p>";
    resultValue += "</li>";
    resultValue += "<li class=\"list_op\">";
    resultValue += "<p class=\"del\"><a productId='" + element.productId + "' href=\"javascript:;\" class=\"delBtn\">移除商品</a></p>";
    resultValue += "</li>";
    resultValue += "</ul>";
    return resultValue;
}
/*修改购物车中商品的数量*/
function productCartEdit(productId,productCartNum){
    var yn = false;
    $.ajax({
        url:"/foreground/product/cart/update",
        type:"POST",
        data:JSON.stringify({"productId" : productId, "productCartNum" : productCartNum, "customerInfId" : $customerInfId}),
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
    var productArray = [];
    productIds instanceof Array ? productArray = productIds : productArray.push(productIds);
    var yn = false;
    $.ajax({
        url:"/foreground/product/cart/delete",
        type:"POST",
        data:JSON.stringify({"productIds" : productArray, "customerInfId" : $customerInfId}),
        contentType: "application/json;charset=utf-8",
        success:function(data){
            yn = data.data;
        }
    })
    return yn;
}

