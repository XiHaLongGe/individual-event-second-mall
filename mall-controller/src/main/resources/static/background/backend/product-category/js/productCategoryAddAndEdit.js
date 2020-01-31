$(function () {
    /*如果是修改，直接发起对父类型的查询*/
    if($("#addOrEditBtn").val() == "修改"){selectParentData($("#parentId").val())}
    /*类型层级下拉框中的值发生变化时，更新父类型下拉框中的值*/
    $("#columnSELECT").change(function (){
        selectParentData($("#parentId").val())
    });
    /*添加或修改按钮的点击*/
    $("#addOrEditBtn").click(function(){
        /*如果添加数据不为空*/
        if(!isEmpty()){
            var requestUrl = "";
            if($("#addOrEditBtn").val() == "修改"){
                requestUrl = "/mall/background/product/category/update/product/category";
            }else {
                requestUrl = "/mall/background/product/category/insert/product/category";
            }
            $.ajax({
                url:requestUrl,
                type:"POST",
                data:JSON.stringify(transformJSON("addColumnForm")),
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

/*根据类型层次发起对父类型的查询*/
function selectParentData(parentId) {
    var productCategoryLevel = $("#columnSELECT option:checked").attr("value");
    if(productCategoryLevel == 2 || productCategoryLevel == 4){
        $("#parentSELECT").removeAttr("disabled");
        $.ajax({
            url:"/mall/background/product/category/level/data?productCategoryLevel=" + parseInt(productCategoryLevel - 1),
            type:"GET",
            async: false,
            contentType: "application/json",
            success:function(data){
                var resultValue = "";
                $.each(data.data, function(index, element){
                    if(parentId == element.productCategoryId){
                        resultValue += "<option value='" + element.productCategoryId + "' selected>" + element.productCategoryName + "</option>"
                    }else{
                        resultValue += "<option value='" + element.productCategoryId + "'>" + element.productCategoryName + "</option>"
                    }
                })
                $("#parentSELECT").empty().append(resultValue);
            }
        })
    }else{
        $("#parentSELECT").attr("disabled", "disabled");
    }
}

/*判断添加数据是否为空*/
function isEmpty(){
    /*放回类型名称是否为空的结果*/
    return $("#columnName").val() == ""
}




//将表单数据转换成json数据
function transformJSON(formId){
    var $jsonData = {};
    /*下面是将form表单的数据转换成一个json的数据格式*/
    $.each($("#" + formId).serializeArray(), function(i,e){
        $jsonData[e.name] = e.value;
    })
    return $jsonData;
}