$(function () {
    downBoxData();
    setTimeout('isUpdate()',100);
    /*当 DOM（文档对象模型） 已经加载，并且页面（包括图像）已经完全呈现时，会发生 ready 事件。*/
    $(document).ready(isUpdate())
    /*以下是添加或修改的点击事件*/
    $("#confirmBTN").click(function () {
        //添加数据不为空
        if(isNotEmpty()){
            var requestUrl = "";
            if($(this).text() == "添加"){
                requestUrl = "/mall/background/brand/inf/insert";
            }else{
                requestUrl = "/mall/background/brand/inf/update";
            }
            $.ajax({
                url:requestUrl,
                type:"POST",
                data:JSON.stringify({
                    "brandInfId" : $("#brandInfIdINPUT").val(),
                    "brandInfName" : $("#brandInfNameINPUT").val(),
                    "productCategoryId" : $("dd.layui-this").attr("lay-value")
                }),
                async: false,
                contentType: "application/json",
                success:function (data) {
                    if (data.code == 200){
                        alert(data.message);
                        x_admin_close();
                    }else{
                        alert(data.message);
                    }
                }
            })
        }
    })
})



function isNotEmpty(){
    /*判断添加数据是否为空*/
    return $("#brandInfNameINPUT").val() != "" && $("dd.layui-this").length > 0;
}

/*将数据填充下拉框*/
function downBoxData() {
    var resultValue = "";
    $.ajax({
        url:"/mall/background/brand/inf/product/category/data",
        type:"GET",
        async: false,
        contentType: "application/json",
        success:function (data) {
            resultValue += "<option value=\"\">直接选择或输入搜索</option>";
            $.each(data.data, function(index, element){
                resultValue += "<option value=\"" + element.productCategoryId + "\">" + element.productCategoryName + "</option>";
            })
        }
    })
    $("#proCategorySELECT").empty().append(resultValue);
}

/*判断如果是修改需要做的操作*/
function isUpdate() {
    if($("#confirmBTN").text() == "修改"){
        var $dd = $("dd[lay-value='" + $("#productCategoryIdINPUT").val() + "']");
        $dd.addClass("layui-this");
        $dd.parent().prev().children('input').val($dd.text());


    }
}

