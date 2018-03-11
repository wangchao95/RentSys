jQuery.noConflict();
jQuery(document).ready(function($) {
    $(function () {
        $.ajax({
            type: "post",//请求类型
            url: "typeList.action",//请求的url
            dataType: "json",//ajax接口（请求url）返回的数据类型
            success: function (typeList) {//data：返回数据（json对象）
                $("#type").html("");
                var obj = eval ("(" + typeList + ")");
                var options = "<option value=\"0\">不限</option>";
                for (var i = 0; i < obj.length; i++) {
                    options += "<option value=\"" + obj[i].id + "\">" + obj[i].name + "</option>";
                }
                $("#type").html(options);
            },
            error: function (data) {//当访问时候，404，500 等非200的错误状态码
                alert("加载类型失败！");
            }
        });
    })
})