var customerInfId = $("#customerInfId").val();
categorySale();
function categorySale(){
    /*
        想要达到效果：
            <span class="as blessing_package">
                <a href="#" style=" color:#000">
                    <h3 style="float:left">&nbsp;应季商品
                        <img src="/static/home/images/zd.png" style="display:block; float:left; margin-top:5px">
                    </h3>
                </a>
                <div class="detailed_navigation">
                    <ul>
                        <li class="dog d-1-lt01 yadi"  dg-floor="1"  dg-ct="lt01">春季</li>
                        <li class="dog d-1-lt02"  dg-floor="1"  dg-ct="lt02">夏季</li>
                        <li class="dog d-1-lt03"  dg-floor="1"  dg-ct="lt03">秋季</li>
                        <li class="dog d-1-lt04"  dg-floor="1"  dg-ct="lt04">冬季</li>
                    </ul>
                </div>
            </span>
    */
    $.ajax({
        url:"/foreground/sidebar/category/list?levelNum=1",
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            var resultVal = "";
            var prefixIndex = 1;
            $.each(data.data, function(index,element) {
                if(element.sidebarCategoryName == "热销商品"){
                    hotProductHead();
                }else{
                    var suffixIndex = 1;
                    var resultDIV = "";
                    resultVal += "<span class=\"as blessing_package\">";
                    resultVal += "<a href=\"#\" style=\" color:#000\">";
                    resultVal += "<h3 style=\"float:left\">&nbsp;" + element.sidebarCategoryName + "<font>" + element.sidebarCategoryDescribe + "</font>";
                    resultVal += "<img src=\"/static/home/images/zd.png\" style=\"display:block; float:left; margin-top:5px\">";
                    resultVal += "</h3>";
                    resultVal += "<div class=\"detailed_navigation\">";
                    resultVal += "<ul>";
                    $.ajax({
                        url:"/foreground/sidebar/category/list?levelNum=" + (element.sidebarCategoryLevel + 1) + "&parentId=" + element.sidebarCategoryId,
                        type:"GET",
                        async: false,//设置为同步
                        contentType: "application/json",
                        success:function(data){
                            $.each(data.data, function(index, element){
                                var checked = index == 0 ? " yadi" : "";
                                resultVal += "<li class=\"dog d-" + prefixIndex + "-lt" + suffixIndex + " " + checked + "\"  dg-floor=\"" + prefixIndex + "\"  dg-ct=\"lt" + suffixIndex + "\">" + element.sidebarCategoryName + "</li>";
                                resultDIV += categoryProduct(element.sidebarCategoryId, prefixIndex, suffixIndex);
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
    /*
        想要达到效果：
        <div>
            <div class="currency f-1-lt01">
                <ul>
                    <li>
                        <a href="Blessingpackage.html"><img src="/static/home/images/56da66aeN557ae881.jpg" style=" margin:0 auto; display:block; width:220px; height:220px"></a>
                        <light1>
                            <img src="/static/home/images/saoguang.png">
                        </light1>
                        <span>￥59</span>
                        <a href="Blessingpackage.html"><p>罗技 G402 有线光电发光游戏鼠标宏笔记本电脑电竞CF专用LOL </p></a>
                        <em>
                            <a href="#">收藏</a>
                            <a href="javascript:void(0)" class="add_scar">加入购物车</a>
                        </em>
                    </li>
                </ul>
            </div>
        </div>
    */
    var resultDIV = "";
    var styleDIV = suffixIndex == 1 ? "" : "style=\"display:none\"";
    resultDIV += "<div class=\"currency f-" + prefixIndex + "-lt" + suffixIndex + "\" " + styleDIV + ">";
    resultDIV += "<ul>";
    $.ajax({
        url:"/foreground/product/sidebar/category/list?sidebarCategoryId=" + categoryId,
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            $.each(data.data, function(index, element){
                resultDIV += "<li>";
                resultDIV += "<a href=\"/foreground/product?productId=" + element.productId + "\" target=\"_blank\"><img src=\"" + element.pictureInfUrl + "\" style=\" margin:0 auto; display:block; width:220px; height:220px\"></a>";
                resultDIV += "<light1><img src=\"/static/home/images/saoguang.png\"></light1>";
                resultDIV += "<span>￥" + element.productPrice + "</span>";
                resultDIV += "<a href=\"/foreground/product?productId=" + element.productId + "\" target=\"_blank\"><p>" + element.productName + "</p></a>";
                resultDIV += "<em>";
                resultDIV += "<a href=\"#\">收藏</a>";
                resultDIV += "<a onclick='addCart($(this))' productId=" + element.productId + " href=\"javascript:void(0)\" class=\"add_scar\">加入购物车</a>";
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
        url:"/foreground/product/cart/insert",
        type:"POST",
        data:JSON.stringify({"customerInfId" : customerInfId, "productId" : productId, "productCartNum" : 1}),
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            if(data.data){
                $("#cartNumB").text(parseInt(cartNum) + 1)
            }
        }
    })
}