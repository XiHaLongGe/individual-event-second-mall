navigation();
/*生成主界面左侧导航*/
function navigation(){
    var resultVal = "";
    $.ajax({
        url:"/mall/foreground/product/category/level/data?productCategoryLevel=3",
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            $.each(data.data, function(index,element) {
                resultVal += "<li>" + element.productCategoryName + "</li>";
            })
        }
    })
    $("#navigationUL").empty().append(resultVal);
}