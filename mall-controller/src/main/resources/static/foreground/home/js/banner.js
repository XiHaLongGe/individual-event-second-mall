mainPicture();
function mainPicture(){
    /*
        想要达到效果：
            <li>
                <a title="" target="_blank" href="#">
                    <img width="1920" height="500" alt="" style="background: url(/static/home/images/banner1.png) no-repeat center;" src="/static/home/images/alpha.png">
                </a>
            </li>
            <li>
                <a title="" href="#">
                    <img width="1920" height="500" alt="" style="background: url(/static/home/images/banner1.png) no-repeat center;" src="/static/home/images/alpha.png">
                </a>
            </li>
            <li>
                <a title="" href="#">
                    <img width="1920" height="500" alt="" style="background: url(/static/home/images/banner1.png) no-repeat center;" src="/static/home/images/alpha.png">
                </a>
            </li>
        */
    var resultVal = "";
    var picIndex = 0;
    $.ajax({
        url:"/foreground/picture/type/list?pictureTypeId=1",
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json;charset=utf-8",
        success:function(data){
            $.each(data.data, function(index,element) {
                resultVal += "<li>";
                resultVal += (picIndex == 0) ? "<a title=\"\" target=\"_blank\" href=\"/foreground/product?productId=" + element.productId + "\">" : "<a title=\"\" target=\"_blank\" href=\"/foreground/product?productId=" + element.productId + "\">";
                resultVal += "<img width=\"1920\" height=\"500\" alt=\"\" style=\"background: url(/static/home/images/banner1.png) no-repeat center;\" src=\"" + element.pictureInfUrl + "\">";
                resultVal += "</a>";
                resultVal += "</li>";
                picIndex ++;
            })
        }
    })
    $("#bannerUL").empty().append(resultVal);
    cutButton(picIndex);
}
function cutButton(picIndex){
    /*
        想要达到效果：
            <li class="active"><a>1</a></li>
            <li><a>2</a></li>
            <li><a>3</a></li>
    */
    var resultVal = "";
    for(var i = 1; i <= picIndex; i++){
        resultVal += i == 1 ? "<li class=\"active\"><a>" + i + "</a></li>" : "<li><a>" + i + "</a></li>";
    }
    $("#bannerCtrl").empty().append(resultVal);
}