navigation();
/*生成主界面左侧导航*/
function navigation(){
    /*
        想要达到效果：
            <li>超级福包</li>
            <li>应季商品</li>
            <li>母婴之家</li>
    */
    var resultVal = "";
    $.ajax({
        url:"/foreground/sidebar/category/list?levelNum=1",
        type:"GET",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            $.each(data.data, function(index,element) {
                resultVal += "<li>" + element.sidebarCategoryName + "</li>";
            })
        }
    })
    $("#navigationUL").empty().append(resultVal);
}