mainPicture();
function mainPicture(){
    var resultVal = "";
    var picIndex = 0;
    $.ajax({
        url:"/mall/foreground/picture/inf/carousel",
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json;charset=utf-8",
        success:function(data){
            $.each(data.data, function(index,element) {
                resultVal += "<li>";
                resultVal += (picIndex == 0) ? "<a title=\"\" target=\"_blank\" href=\"/mall/foreground/product/inf/home?productInfId=" + element.productInfId + "\">" : "<a title=\"\" target=\"_blank\" href=\"/mall/foreground/product/inf/home?productInfId=" + element.productInfId + "\">";
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
    var resultVal = "";
    for(var i = 1; i <= picIndex; i++){
        resultVal += i == 1 ? "<li class=\"active\"><a>" + i + "</a></li>" : "<li><a>" + i + "</a></li>";
    }
    $("#bannerCtrl").empty().append(resultVal);
}