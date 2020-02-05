$(function () {
    $.ajax({
        url:"/mall/background/picture/inf/product/picture?productInfId=" + $("#productInfIdINPUT").val(),
        type:"GET",
        dataType:"json",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            var i = 4;
            $.each(data.data,function (index, element) {
                var pictureURL = element.pictureInfUrl;

                var image = new Image();
                image.crossOrigin = '';
                image.src = pictureURL;
                image.onload = function(){
                    var base64 = getBase64Image(image);
                    console.log(base64);
                    /*
                     打印信息如下：
                     {
                      dataURL: "data:image/png;base64,xxx"
                      type: "image/jpg"
                     }
                     */
                    var img2 = convertBase64UrlToBlob(base64);
                    console.log(img2);
                    /*
                     打印信息如下：
                     Blob {size: 9585, type: "image/jpg"}
                     */
                    if(element.pictureInfMaster == 1){
                        $.Tupload.imgLoad(0,img2)
                    }else{
                        $.Tupload.imgLoad(i--,img2)
                    }
                    var num = parseInt($("#fileNum").val())+parseInt('1');
                    $("#fileNum").val(num);
                    $("#fileText").val("选中"+num+"张图片");
                }
            })
        }
    })
})



/**
 * 将以base64的图片url数据转换为Blob
 * @param urlData
 * 用url方式表示的base64图片数据
 */
function convertBase64UrlToBlob(base64){
    var urlData =  base64.dataURL;
    var type = base64.type;
    var bytes = window.atob(urlData.split(',')[1]); //去掉url的头，并转换为byte
    //处理异常,将ascii码小于0的转换为大于0
    var ab = new ArrayBuffer(bytes.length);
    var ia = new Uint8Array(ab);
    for (var i = 0; i < bytes.length; i++) {
        ia[i] = bytes.charCodeAt(i);
    }
    return new Blob( [ab] , {type : type});
}
/*
 * 图片的绝对路径地址 转换成base64编码 如下代码：
 */
function getBase64Image(img) {
    var canvas = document.createElement("canvas");
    canvas.width = img.width;
    canvas.height = img.height;
    var ctx = canvas.getContext("2d");
    ctx.drawImage(img, 0, 0, img.width, img.height);
    var ext = img.src.substring(img.src.lastIndexOf(".")+1).toLowerCase();
    var dataURL = canvas.toDataURL("image/"+ext);
    return {
        dataURL: dataURL,
        type: "image/"+ext
    };
}