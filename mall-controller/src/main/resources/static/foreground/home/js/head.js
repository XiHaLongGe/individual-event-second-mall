categoryName();
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
        url:"/mall/foreground/product/category/level/data?productCategoryLevel=1",
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
                resultVal += "<a param='"+ element.productCategoryId +"' href='javascript:;'>" + element.productCategoryName + "</a>";
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
                url:"/mall/foreground/product/category/parent/data?parentCategoryId=" + aParam,
                type:"GET",
                async: false,//设置为同步
                contentType: "application/json",
                success:function(data){
                    resultVal += "<dd>";
                    $.each(data.data, function(index,element){
                        resultVal += "<a href=\"javascript:;\">" + element.productCategoryName + "</a>";
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

