$(function () {
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
                    "brandInfName" : $("#brandInfNameINPUT").val()
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