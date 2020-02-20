hotProductHead();
function hotProductHead(){
    $.ajax({
        url:"/mall/foreground/product/category/level/data?productCategoryLevel=3",
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            var resultVal = "";
            $.each(data.data, function(index,element) {
                if(element.productCategoryName == "热销商品"){
                    resultVal += element.productCategoryName;
                    resultVal += "<font>" + element.sidebarCategoryDescribe + "</font>";
                    resultVal += "<a href=\"#\">更多热销商品</a>";
                }
            })
            $("#hotSaleH3").empty().append(resultVal);
            hotProductBody();
        }
    })
}
function hotProductBody(){
    $.ajax({
        url:"/mall/foreground/product/inf/column?categoryId=3-1",
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            var resultVal = "";
            $.each(data.data, function(index,element) {
                resultVal += "<li>";
                resultVal += "<light>";
                resultVal += "<img src=\"/static/foreground/home/images/saoguang1.png\">";
                resultVal += "</light>";
                resultVal += "<a href=\"/mall/foreground/product/inf/home?productInfId=" + element.productInfId + "\" target=\"_blank\"><img src=\"" + element.pictureInfUrl + "\"></a>";
                resultVal += "<span>价值" + element.productInfPrice + "元</span>";
                resultVal += "<a href=\"/mall/foreground/product/inf/home?productInfId=" + element.productInfId + "\" target=\"_blank\">查看商品</a>";
                resultVal += "<em>" + element.productInfSales + "人已购买</em>";
                resultVal += "</li>";
            })
            $("#hotSaleUL").empty().append(resultVal);
        }
    })
}