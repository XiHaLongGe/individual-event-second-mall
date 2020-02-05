<%--
  Created by IntelliJ IDEA.
  User: LJP
  Date: 2020-02-05
  Time: 07:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="/static/background/product-inf/css/upload.css?v=<%= System.currentTimeMillis()%>" rel="stylesheet">
    <title>修改&上传图片</title>
    <script src="/static/background/product-inf/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="/static/background/home/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/static/background/home/js/xadmin.js?v=<%= System.currentTimeMillis()%>"></script>
</head>

<body>
<input id="productInfIdINPUT" type="hidden" value="${productInfId}" />
<div id="T_upload"></div>
</body>
<script src="/static/background/product-inf/js/T_upload.js?v=<%= System.currentTimeMillis()%>"></script>
<script type="text/javascript">
    $(function() {
//			var md = "product";
//			var pid = "asdasdasdasdasd";
        $.Tupload.init({
            url: "/mall/background/picture/inf/batch/upload",
            title: "第一张图片为商品的主图，请选择5张照片之后再进行上传",
            fileNum: 5, // 上传文件数量
            divId: "T_upload", // div  id
            accept: "image/jpeg,image/x-png", // 上传文件的类型
            //fileSize  :51200000,     // 上传文件的大小
            onSuccess: function(data) {
                alert(data.message);
                x_admin_close();
                /*var temp =eval('(' + data.currentTarget.response + ')')
    if(temp.fileName != undefined){
        $("#img_src"+i).attr('value',temp.fileName);
        $("#img_src"+i).attr('name',"upload_img");
    }*/
            },
            onDelete: function(i) {
                /*var img_val = $("#img_src"+i).attr("value");
                if(img_val != '' && img_val != undefined){
                    var md = "product";
                    var img= $.page.getImgUrl(img_val);
                    $.ajax({
                        type:"POST",
                        url: "base/delPic" ,
                        data : {img:img,id: pid,md:md},
                        success: function(rel){}
                    });
                }*/
            }
        });
    })
</script>
<%--<script src="/static/background/product-inf/js/editPicture.js?v=<%= System.currentTimeMillis()%>"></script>--%>
</html>
