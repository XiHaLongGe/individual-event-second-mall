$(function () {
    downBoxData();
    if($("#confirmBTN").text() == "修改"){
        setTimeout('pitchOption()',250);
    }
    /*以下是添加或修改的点击事件*/
    $("#confirmBTN").click(function () {
        //添加数据不为空
        if(isNotEmpty()){
            var requestUrl = "";
            if($(this).text() == "添加"){
                requestUrl = "/mall/background/pbr/insert";
            }else{
                requestUrl = "/mall/background/pbr/update";
            }
            $.ajax({
                url:requestUrl,
                type:"POST",
                data:JSON.stringify({
                    "brandInfId" : $("#brandInfNameSELECT").next().children('dl').children('dd.layui-this').attr("lay-value"),
                    "productCategoryId" : $("#proCategorySELECT").next().children('dl').children('dd.layui-this').attr("lay-value"),
                    "pbrId" : $("#pbrIdIdINPUT").val()
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
    return $("#brandInfNameINPUT").val() != "";
}


/*将数据填充下拉框*/
function downBoxData() {
    var resultValue = "";
    /*品牌信息下拉框的数据填充*/
    $.ajax({
        url:"/mall/background/brand/inf/all/data",
        type:"GET",
        async: false,
        contentType: "application/json",
        success:function (data) {
            resultValue = "<option value=\"\">品牌信息：选择或输入搜索</option>";
            $.each(data.data, function(index, element){
                resultValue += "<option value=\"" + element.brandInfId + "\">" + element.brandInfName + "</option>";
            })
            $("#brandInfNameSELECT").empty().append(resultValue);
        }
    })
    /*商品类型下拉框的数据填充*/
    $.ajax({
        url:"/mall/background/product/category/level/data?productCategoryLevel=2",
        type:"GET",
        async: false,
        contentType: "application/json",
        success:function (data) {
            resultValue = "<option value=\"\">商品类型：选择或输入搜索</option>";
            $.each(data.data, function(index, element){
                resultValue += "<option value=\"" + element.productCategoryId + "\">" + element.productCategoryName + "</option>";
            })
            $("#proCategorySELECT").empty().append(resultValue);
        }
    })
}

/*以下是将要修改的值设为选中状态*/
function pitchOption() {
    var $biDD = $("#brandInfNameSELECT").next().children('dl').children('dd[lay-value="'+ $("#brandInfIdINPUT").val() +'"]');
    $biDD.addClass("layui-this");
    $biDD.parent().prev().children('input').val($biDD.text());

    var $pcDD = $("#proCategorySELECT").next().children('dl').children('dd[lay-value="'+ $("#productCategoryIdINPUT").val() +'"]');
    $pcDD.addClass("layui-this");
    $pcDD.parent().prev().children('input').val($pcDD.text());
}

