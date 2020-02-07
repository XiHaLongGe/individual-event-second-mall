afficheData();
/*生成右侧公告*/
function afficheData(){
    /*
        想要达到效果：
            <p><a href="#">【优选】金秋聚会，买一送一</a></p>
            <p><a href="#">【优选】中秋嘉年华，好礼钜惠</a></p>
            <p><a href="#">【优选】冰点破纪录，低价不猫腻</a></p>
    */
    $.ajax({
        url:"/foreground/affiche/list",
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            var resultVal = "";
            $.each(data.data, function(index,element) {
                resultVal += "<p>";
                resultVal += "<a href=\"javascript:;\">【" + element.afficheType + "】" + element.afficheInfTitle + "</a>";
                resultVal += "</p>";
            })
            $("#afficheDIV").empty().append(resultVal);
        }
    })
    afficheImageLoader();
}

function afficheImageLoader(){
    /*
        想要达到效果：
            <span id="afficheImageSPAN">
                <a href="#">
                    <div class="notice_img">
                        <img src="/static/home/images/activity.jpg" class="img1">
                        <img src="/static/home/images/activity.jpg" class="img2">
                    </div>
                </a>
            </span>
    */
    $.ajax({
        /*
            URIEncoding:"UTF-8",这个属性的设置，是当使用ajax进行请求的请求地址中有中文字符乱码的问题，可以使用这个属性来解决
            配置useBodyEncodingForURI="true"后，可以解决普通get请求的中文乱码问题，
            但是对于通过ajax发起的get请求中文依然会乱码，请把useBodyEncodingForURI="true"改为URIEncoding="UTF-8"即可。
        */
        url:"/foreground/picture/type/list?pictureTypeId=1",
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json;charset=utf-8",
        success:function(data){
            var resultVal = "";
            $.each(data.data, function(index,element) {
                if(index == 0){
                    resultVal += "<a href=\"/foreground/product?productId=" + element.productId + "\" target=\"_blank\">";
                    resultVal += "<div class=\"notice_img\">";
                    resultVal += "<img src=\"" + element.pictureInfUrl + "\" class=\"img1\">";
                    resultVal += "<img src=\"" + element.pictureInfUrl + "\" class=\"img2\">";
                    resultVal += "</div>";
                    resultVal += "</a>";
                }
            })
            $("#afficheImageSPAN").empty().append(resultVal);
        }
    })
    categoryName();
}
/*分类层次id  左侧分类列表显示数据层次*/
/*生成左侧分类名称*/
function categoryName(){
    /*
        想要达到效果：
            <li class="cates"  mt-ct="list01">
                <p>
                    <a href="#">家电</a>
                    <a href="#">数码</a>
                    <a href="#">手机</a>
                    <i style="font-family:'宋体';color:#666; line-height:23px; font-size:14px; float:left">></i>
                </p>
            </li>
    */
    $.ajax({
        url:"/foreground/product/category/list?levelNum=1",
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            var resultVal = "";
            var resultIndex = 1;
            var i = 1;
            $.each(data.data, function(index,element){
                /*判断当分类每生成3个，就创建上一个li标签的结束标签，换下一个li标签，一个li标签存放三个分类名称*/
                if(index % 3 == 0 && index != 0){
                    resultVal += "<i style=\"font-family:'宋体';color:#666; line-height:23px; font-size:14px; float:left\">&gt;</i>"
                    resultVal += "</p>";
                    resultVal += "</li>";
                    resultIndex ++;
                }
                /*当第一次进来直接创建li标签*/
                if(i % 3 == 0 || index == 0){
                    resultVal += "<li class='cates'  mt-ct='list" + resultIndex + "'>";
                    resultVal += "<p>";
                    i = 0;
                }
                i++;
                resultVal += "<a param='"+ element.categoryId +"' href='javascript:;'>" + element.categoryName + "</a>";
                if(index + 1 == data.data.length){
                    resultVal += "<i style=\"font-family:'宋体';color:#666; line-height:23px; font-size:14px; float:left\">&gt;</i>"
                    resultVal += "</p>";
                    resultVal += "</li>";
                }
            })
            $("#categoryUL").empty().append(resultVal);
        }
    })
    categorySpread();
}
/*写一个函数的作用是怕ajax的异步操作导致程序出错，现在在上面ajax完成后再调用该函数也就避免了ajax的异步操作带来的漏洞*/
function categorySpread(){
    /*
        想要达到效果：
            <div class="import_list b-list1">
                <dt>与内容无关：</dt>
                <dd>
                    <a href="#">T恤</a>
                    <a href="#">休闲裤</a>
                    <a href="#">条纹T</a>
                </dd>
             </div>
    */
    var resultVal = "";
    var resultIndex = 1;
    $("#categoryUL li").each(function(){
        resultVal += "<div class=\"import_list b-list"+ resultIndex +"\">";
        $(this).children("p").children("a").each(function(){
            /*获取到a标签的param属性*/
            var aParam = $(this).attr("param");
            resultVal += "<dt>" + $(this).text() + "</dt>";
            $.ajax({
                url:"/foreground/product/category/list?levelNum=2&parentId=" + aParam,
                type:"GET",
                async: false,//设置为同步
                contentType: "application/json",
                success:function(data){
                    resultVal += "<dd>";
                    $.each(data.data, function(index,element){
                        resultVal += "<a href=\"javascript:;\">" + element.categoryName + "</a>";
                    })
                    resultVal += "</dd>";
                }
            })
        })
        resultVal += "</div>";
        resultIndex ++;
    })
    $("#categorySpreadDIV").empty().append(resultVal);
}

