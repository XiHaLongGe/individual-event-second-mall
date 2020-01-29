$(function () {
    $("#columnSELECT").change(function () {
        var productCategoryLevel = $("#columnSELECT option:checked").attr("value");
        if(productCategoryLevel == 2 || productCategoryLevel == 4){
            $("#parentSELECT").removeAttr("disabled");
            $.ajax({
                url:"/mall/background/product/category/level/data?productCategoryLevel=" + parseInt(productCategoryLevel - 1),
                type:"GET",
                async: false,
                contentType: "application/json",
                success:function(data){
                    var resultValue = "<option hidden>请选择</option>";
                    $.each(data.data, function(index, element){
                        resultValue += "<option value='" + element.productCategoryId + "'>" + element.productCategoryName + "</option>"
                    })
                    $("#parentSELECT").empty().append(resultValue);
                }
            })
        }else{
            $("#parentSELECT").attr("disabled", "disabled");
        }
    })
})