categoryDownBoxLogin();
$(function () {
    pageSearch(1);
    downBoxData();
    setTimeout('downBoxClass()',250);
    /*以下是条件查询的点击事件*/
    $("#searchBTN").click(function () {
        pageSearch(1);
        $("#parentDIV").removeClass("layui-form-checked");
    })
    /*刷新点击事件*/
    $("#refreshA").click(function(){
        $(".layui-input").val("");
        $("dd.layui-this").removeClass("layui-this")
        pageSearch(1);
        $("#parentDIV").removeClass("layui-form-checked");
    })
})


/*以下是处理下拉框的样式问题*/
function downBoxClass() {
    $("select[name='modules']").next().children().children('input').attr("style", "width:185px");
}

/*以下是用户信息的查询*/
function pageSearch(pageNum){
    $.ajax({
        url:"/mall/background/product/inf/condition/page/data?pageNum=" + pageNum,
        type:"GET",
        async: false,
        data:{
            "productInfName" : $("#productInfNameINPUT").val(),
            "brandInfId" : $("#brandInfSELECT").next().children('dl').children('dd.layui-this').attr("lay-value"),
            "productCategoryId" : $("#categorySELECT").next().children('dl').children('dd.layui-this').attr("lay-value")
        },
        contentType: "application/json",
        success:function (data) {
            customerPageList(data);
            pageData(data, pageNum);
            /*
                下面这一步是解绑事件操作，没有解绑会造成事件叠加的后果
                比如：
                    第一次执行 只执行一次
                    第二次执行 执行完本次还会会执行前一次
                    第三次执行 执行完本次还会会执行前两次
            */
            $(".layui-form-checkbox").unbind('click');
            tableCheck.init();
        }
    })
}

/*返回列表条目数*/
function customerCount(data){
    $("#countSPAN").empty().text("共有数据：" + data.total + " 条");
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
    var $jsonArrays = [{"name":"选择栏目","id":0}];
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


/*根据传入的data数据对象，将数据填充到table*/
function customerPageList(data){
    var resultValue = "";
    $.each(data.data.list,function(index, element){
        resultValue += "<tr>";
        resultValue += "<td>";
        resultValue += "<div class=\"layui-unselect layui-form-checkbox\" lay-skin=\"primary\" data-id='" + element.productInfId + "'><i class=\"layui-icon\">&#xe605;</i></div>";
        resultValue += "</td>";
        resultValue += "<td>" + parseInt(index + 1) + "</td>";
        resultValue += "<td>" + element.productInfName + "</td>";
        resultValue += "<td>" + element.brandInfName + "</td>";



        resultValue += "<td>";
        if(element.productCategoryName != '热销商品'){
            $.ajax({
                url:"/mall/background/product/inf/parent/category/data?childCategoryId=" + element.productCategoryId,
                type:"GET",
                async: false,
                contentType: "application/json",
                success:function (data) {
                    resultValue += "<b>" + data.data.parentCategoryName + "</b>>" + element.productCategoryName;
                }
            })
        }else{
            resultValue += element.productCategoryName
        }
        resultValue += "</td>";



        resultValue += "<td>" + element.productInfDescribe + "</td>";
        resultValue += "<td>" + element.productInfPrice + "</td>";
        resultValue += "<td>" + element.productInfSales + "</td>";
        resultValue += "<td>" + element.productInfStockpile + "</td>";
        resultValue += "<td class=\"td-manage\">";
        resultValue += "<a title=\"修改\" onclick=\"x_admin_show('修改商品', '/mall/background/brand/inf/add/edit?productInfId=" + element.productInfId + "',300,300)\" href=\"javascript:;\">";
        resultValue += "<i class=\"iconfont\">&#xe69e;</i>";
        resultValue += "</a>";
        resultValue += "<a title=\"删除\" onclick=\"member_del(this,'" + element.productInfId + "')\" href=\"javascript:;\">";
        resultValue += "<i class=\"layui-icon\">&#xe640;</i>";
        resultValue += "</a>";
        resultValue += "</td>";
        resultValue += "</tr>";
    })
    $("#customerTBODY").empty().append(resultValue);
}


/*根据传入的数据对象和当前页数，处理界面上分页页码的显示*/
function pageData(data, pageNum){
    customerCount(data.data);
    var resultVal = "";
    resultVal += "<a name='prevNextA' class=\"prev\" href=\"javascript:;\" num='1'>&lt;&lt;</a>";
    resultVal += "<a name='prevNextA' class=\"prev\" href=\"javascript:;\" num='" + (data.data.prePage == 0 ? 1 : data.data.prePage)  + "'>&lt;</a>";
    for(var i = 0; i < data.data.navigatepageNums.length; i ++){
        if(data.data.navigatepageNums[i] == pageNum){
            resultVal += "<span id='pageSPAN' class=\"current\" href=\"javascript:;\" num='" + data.data.navigatepageNums[i] + "'>" + data.data.navigatepageNums[i] + "</span>";
        }else{
            resultVal += "<a name='pageA' class=\"num\" href=\"javascript:;\" num='" + data.data.navigatepageNums[i] + "'>" + data.data.navigatepageNums[i] + "</a>";
        }
    }
    resultVal += "<a name='prevNextA' class=\"next\" href=\"javascript:;\" num='" + (data.data.nextPage == 0 ? data.data.pages : data.data.nextPage) + "'>&gt;</a>";
    resultVal += "<a name='prevNextA' class=\"next\" href=\"javascript:;\" num='" + data.data.pages + "'>&gt;&gt;</a>";
    $("#pageDIV").empty().append(resultVal);
    clickLoader();
}


/*界面上分页页码相关按钮的点击事件*/
function clickLoader(){
    $("a[name='pageA'],a[name='prevNextA']").click(function(){
        $("#parentDIV").removeClass("layui-form-checked");
        var pageNum = $("#pageSPAN").attr("num");
        $("#pageSPAN").replaceWith("<a name='pageA' class=\"num\" href=\"javascript:;\" num='" + pageNum + "'>" + pageNum + "</a>");
        pageNum = $(this).attr("num");
        $(this).replaceWith("<span id='pageSPAN' class=\"current\" href=\"javascript:;\" num='" + pageNum + "'>" + pageNum + "</span>");
        pageSearch(pageNum);
        clickLoader();
    })
}


/*以下是单条数据的删除*/
function member_del(obj,productCategoryId){
    layer.confirm('确认要删除吗？',function(index){
        var arr = [];
        arr.push(productCategoryId)
        //发异步删除数据
        if(dataDelete(arr)){
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
            var pageNum = $("#pageSPAN").attr("num");
            pageSearch(pageNum);
        }else{
            layer.msg('删除失败!',{icon:2,time:1000});
        }
    });
}

/*以下是批量删除*/
function delAll () {
    /*获取到所有被选中的id*/
    var productCategoryIdArray = tableCheck.getData();
    layer.confirm('确认要删除吗？',function(index){
        //捉到所有被选中的，发异步进行删除
        if(dataDelete(productCategoryIdArray)){
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
            $("#parentDIV").removeClass("layui-form-checked");
            var pageNum = $("#pageSPAN").attr("num");
            pageSearch(pageNum);
        }else{
            layer.msg('删除失败!',{icon:2,time:1000});
        }
    });
}


//异步对数据删除
function dataDelete(productCategoryIdArray){
    var yn = false;
    $.ajax({
        url:"/mall/background/brand/inf/batch/delete",
        type:"POST",
        data:JSON.stringify(productCategoryIdArray),
        dataType:"json",
        async: false,//设置为同步
        contentType: "application/json",
        success:function(data){
            yn = data.code == 200;
        }
    })
    return yn;
}