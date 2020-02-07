$(function () {
    load();
})

/*获取到收货数据*/
function load() {
    $.ajax({
        url:"/mall/foreground/receiving/customer/data?loginId=" + $("#loginIdINPUT").val(),
        type:"GET",
        async: false,
        contentType: "application/json",
        success:function (data) {
            fillData(data);
            defaultClick();
        }
    })
}

/*设为默认地址点击事件*/
function defaultClick() {
    $("span.new-option-r").click(function () {
        $(".defaultAddr").removeClass("defaultAddr").children("span").text("设为默认");
        $(this).parent().addClass("defaultAddr").children("span").text("默认地址");

        $.ajax({
            url:"/mall/foreground/receiving/update/default",
            type:"POST",
            data:JSON.stringify({
                "receivingInfId" : $(this).attr("receivingInfId"),
                "loginId" :  $("#loginIdINPUT").val()
            }),
            async: false,
            contentType: "application/json",
            success:function (data) {
                if(!data.data){
                    alert(data.message);
                    console.log(data.message);
                }
            }
        })
    })
}

/*填充收货信息*/
function fillData(data) {
    var html = "";
    $.each(data.data, function (index, element) {
        /*为1 代表默认地址*/
        if(element.receivingInfDefault == 1){
            html += "<li class=\"user-addresslist defaultAddr\">";
            html += "<span class=\"new-option-r\" receivingInfId='" + element.receivingInfId + "'><i class=\"am-icon-check-circle\"></i>默认地址</span>";
        }else{
            html += "<li class=\"user-addresslist\">";
            html += "<span class=\"new-option-r\" receivingInfId='" + element.receivingInfId + "'><i class=\"am-icon-check-circle\"></i>设为默认</span>";
        }
        html += "<p class=\"new-tit new-p-re\">";
        html += "<span class=\"new-txt\">" + element.receivingInfName + "</span>";
        html += "<span class=\"new-txt-rd2\">" + element.receivingInfPhone + "</span>";
        html += "</p>";
        html += "<div class=\"new-mu_l2a new-p-re\">";
        html += "<p class=\"new-mu_l2cw\">";
        html += "<span class=\"title\">地址：</span>";
        html += "<span class=\"province\">" + element.receivingInfProvince + "省 </span>";
        html += "<span class=\"city\">" + element.receivingInfCity + " </span>";
        html += "<span class=\"dist\">" + element.receivingInfDistrict + " </span>";
        html += "<span class=\"street\">" + element.receivingInfAddress + " </span></p>";
        html += "</div>";
        html += "<div class=\"new-addr-btn\">";
        html += "<a href=\"javascript:;\" onclick='editClick(this)' receivingInfId='" + element.receivingInfId + "'><i class=\"am-icon-edit\"></i>编辑</a>";
        html += "<span class=\"new-addr-bar\">|</span>";
        html += "<a href=\"javascript:void(0);\" onclick=\"delClick(this," + element.receivingInfId + ");\"><i class=\"am-icon-trash\"></i>删除</a>";
        html += "</div>";
        html += "</li>";
    })
    $("#receivingUL").empty().append(html);
}

/*添加或修改点击事件*/
function addAndEditClick(btnElement) {
    var url,message;
    if($("#editAndAddA").text() === "修改"){
        url = "/mall/foreground/receiving/update/receiving";
        message = "修改";
    }else{
        url = "/mall/foreground/receiving/insert/receiving";
        message = "添加";
    }
    if(!isEmpty()){
        $.ajax({
            url:url,
            type:"POST",
            data:JSON.stringify({
                "loginId" :  $("#loginIdINPUT").val(),
                "receivingInfId" : $(btnElement).attr("receivingInfId"),
                "receivingInfName" : $("form [name='receivingInfName']").val() ,
                "receivingInfPhone" : $("form [name='receivingInfPhone']").val(),
                "receivingInfProvince" : $("span[name='receivingInfProvince']").text(),
                "receivingInfCity" : $("span[name='receivingInfCity']").text() ,
                "receivingInfDistrict" : $("span[name='receivingInfDistrict']").text(),
                "receivingInfAddress" : $("form [name='receivingInfAddress']").val()
            }),
            async: false,
            contentType: "application/json",
            success:function (data) {
                if(data.data){
                    load();
                    dataEmpty();
                    $("#editAndAddA").text("添加");
                }else{
                    alert(data.message);
                }
            }
        })
    }else{
        alert(message + "数据不可为空！");
    }
}

/*将数据删为空*/
function dataEmpty() {
    $("form [name='receivingInfName']").val("");
    $("form [name='receivingInfPhone']").val("");
    $("form [name='receivingInfAddress']").val("");
    $("#editAndAddA").text("添加");
}

/*判断添加数据是否为空*/
function isEmpty(){
    return  $("form [name='receivingInfName']").val() == "" ||
            $("form [name='receivingInfPhone']").val() == "" ||
            $("span[name='receivingInfProvince']").text() == "" ||
            $("span[name='receivingInfCity']").text() == "" ||
            $("span[name='receivingInfDistrict']").text() == "" ||
            $("form [name='receivingInfAddress']").val() == "";
}

/*修改点击事件*/
function editClick(editElement) {
    $.ajax({
        url: "/mall/foreground/receiving//receiving/data?receivingInfId=" + $(editElement).attr("receivingInfId"),
        type: "GET",
        async: false,
        contentType: "application/json",
        success: function (data) {
            if (data.code == 200){
                $("form [name='receivingInfName']").val(data.data.receivingInfName);
                $("form [name='receivingInfPhone']").val(data.data.receivingInfPhone);
                var html = "";
                html += "<span class=\"select-item\" name=\"receivingInfProvince\" data-count=\"province\">" + data.data.receivingInfProvince + "</span>/";
                html += "<span class=\"select-item\" name=\"receivingInfCity\" data-count=\"city\" data-code=\"1898\">" + data.data.receivingInfCity + "</span>/";
                html += "<span class=\"select-item\" name=\"receivingInfDistrict\" data-count=\"district\" data-code=\"1899\">" + data.data.receivingInfDistrict + "</span>/";
                $("#fourLinkageINPUT").next().children('span:eq(0)').text("").next().removeAttr("style").empty().append(html);
                $("form [name='receivingInfAddress']").val(data.data.receivingInfAddress);
                $("#editAndAddA").text("修改").attr("receivingInfId", $(editElement).attr("receivingInfId"))
            }else{
                alert(data.message);
            }
        }
    })
}

/*删除点击事件*/
function delClick(delElement, receivingInfId) {
    if (confirm("确定要删除！")){
        $.ajax({
            url:"/mall/foreground/receiving/delete/receiving",
            type:"POST",
            data:JSON.stringify({
                "receivingInfId" : receivingInfId,
            }),
            async: false,
            contentType: "application/json",
            success:function (data) {
                if(data.data){
                    $(delElement).parent('div').parent('li').remove();
                }else{
                    alert(data.message);
                    console.log(data.message);
                }
            }
        })
    }
}