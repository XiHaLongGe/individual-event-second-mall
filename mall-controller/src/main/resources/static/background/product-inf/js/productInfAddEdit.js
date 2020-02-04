categoryDownBoxLogin();
$(function () {
    downBoxData();
    setTimeout('downBoxClass()',250);
    if($("#confirmBTN").text() == "修改"){
        setTimeout('pitchOption()',250);
    }
    /*以下是添加或修改的点击事件*/
    $("#confirmBTN").click(function () {
        //添加数据不为空
        if(isNotEmpty()){
            var requestUrl = "";
            if($(this).text() == "添加"){
                requestUrl = "/mall/background/product/inf/insert";
            }else{
                requestUrl = "/mall/background/product/inf/update";
            }
            $.ajax({
                url:requestUrl,
                type:"POST",
                data:JSON.stringify({
                    "productInfId" : $("#productInfIdINPUT").val(),
                    "brandInfId" : $("#brandInfSELECT").next().children('dl').children('dd.layui-this').attr("lay-value"),
                    "productCategoryId" : $("#treeclass").next().val(),
                    "productInfName" : $("#productInfNameINPUT").val(),
                    "productInfDescribe" : $("#proTEXTAREA").val(),
                    "productInfPrice" : $("#priceINPUT").val(),
                    "productInfStockpile" : $("#stockpileINPUT").val()
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

/*以下是处理下拉框的样式问题*/
function downBoxClass() {
    $("select[name='modules']").next().children().children('input').attr("style", "width:185px");
}

/*将数据填充下拉框*/
function downBoxData() {
    brandDataFill();
}

/*品牌信息填充*/
function brandDataFill() {
    var resultValue = "";
    $.ajax({
        url:"/mall/background/product/inf/exist/brand/inf/data",
        type:"GET",
        async: false,
        contentType: "application/json",
        success:function (data) {
            resultValue += "<option value=\"\">品牌:选择或输入搜索</option>";
            $.each(data.data, function(index, element){
                resultValue += "<option value=\"" + element.brandInfId + "\">" + element.brandInfName + "</option>";
            })
        }
    })
    $("#brandInfSELECT").empty().append(resultValue);
}

/*栏目树下拉框加载*/
function categoryDownBoxLogin(){
    layui.use(['element', 'tree', 'layer', 'form', 'upload'], function () {
        var $ = layui.jquery, tree = layui.tree;
        tree({
            elem: "#classtree",
            nodes: categoryDataFill(),
            click: function (node) {
                var $select = $($(this)[0].elem).parents(".layui-form-select");
                $select.removeClass("layui-form-selected").find(".layui-select-title span").html(node.name).end().find("input:hidden[name='selectID']").val(node.id);
            }
        });
        $(".downpanel").on("click", ".layui-select-title", function (e) {
            $(".layui-form-select").not($(this).parents(".layui-form-select")).removeClass("layui-form-selected");
            $(this).parents(".downpanel").toggleClass("layui-form-selected");
            layui.stope(e);
        }).on("click", "dl i", function (e) {
            layui.stope(e);
        });
    });
}
/*栏目信息填充, 返回栏目信息json*/
function categoryDataFill() {
    var $jsonArrays = [{"name":"选择栏目","id":''}];
    var $jsonData = {};
    $.ajax({
        url:"/mall/background/product/category/level/data?productCategoryLevel=3",
        type:"GET",
        async: false,
        contentType: "application/json",
        success:function (data) {
            $.each(data.data, function(index, element){
                if(element.productCategoryName == "热销商品"){
                    $jsonData = {
                        "name":element.productCategoryName,
                        "id":element.productCategoryId
                    }
                }else {
                    $jsonData = {
                        "name":element.productCategoryName,
                        "id":element.productCategoryId
                    }
                    $.ajax({
                        url:"/mall/background/product/category/child/data?parentCategoryId=" + element.productCategoryId,
                        type:"GET",
                        async: false,
                        contentType: "application/json",
                        success:function (data2) {
                            var $jsonData2 = {};
                            $jsonData["children"] = [];
                            $.each(data2.data, function(index2, element2){
                                $jsonData2 = {
                                    "name":element2.productCategoryName,
                                    "id":element2.productCategoryId
                                }
                                if(!$.isEmptyObject($jsonData2)){
                                    $jsonData["children"].push($jsonData2);
                                }
                            })
                        }
                    })
                }
                $jsonArrays.push($jsonData);
            })
        }
    })
    return $jsonArrays;
}


function isNotEmpty(){
    /*判断添加数据是否为空*/
    return $("#brandInfNameINPUT").val() != "" &&
        $("#treeclass").text() != "选择栏目" &&
        $("#priceINPUT").val() != "" &&
        $("#stockpileINPUT").val() != "";
}

/*以下是将要修改的值设为选中状态*/
function pitchOption() {
    var $biDD = $("#brandInfSELECT").next().children('dl').children('dd[lay-value="'+ $("#brandInfIdINPUT").val() +'"]');
    $biDD.addClass("layui-this");
    $biDD.parent().prev().children('input').val($biDD.text());

    $("#treeclass").text($("#productCategoryNameINPUT").val()).next().val($("#productCategoryIdINPUT").val())
}