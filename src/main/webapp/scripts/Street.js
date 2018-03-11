jQuery.noConflict();
jQuery(document).ready(function($) {
    $(function () {
        //动态加载街道
        $.ajax({
            type: "post",//请求类型
            url: "strList.action",//请求的url
            data: {did:null},//请求参数
            dataType: "json",//ajax接口（请求url）返回的数据类型
            success: function (streetList) {//data：返回数据（json对象）
                $("#street").html("");
                var obj = eval("(" + streetList + ")");
                var options = "<option value=\"0\">不限</option>";
                for (var i = 0; i < obj.length; i++) {
                    options += "<option value=\"" + obj[i].id + "\">" + obj[i].name + "</option>";
                }
                $("#street").html(options);
            },
            error: function (data) {//当访问时候，404，500 等非200的错误状态码
                alert("加载街道失败！");
            }
        });






    })

})