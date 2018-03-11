jQuery.noConflict();
jQuery(document).ready(function($) {

    $(function () {
        //动态加载户型
        $.ajax({
            type: "post",//请求类型
            url: "typeList.action",//请求的url
            dataType: "json",//ajax接口（请求url）返回的数据类型
            success: function (typeList) {//data：返回数据（json对象）
                $("#type").html("");
                var obj = eval ("(" + typeList + ")");
                var options = "<option value=\"0\">--请选择--</option>";
                for (var i = 0; i < obj.length; i++) {
                    options += "<option value=\"" + obj[i].id + "\">" + obj[i].name + "</option>";
                }
                $("#type").html(options);
            },
            error: function (data) {//当访问时候，404，500 等非200的错误状态码
                alert("加载类型失败！");
            }
        });
        //动态加载一级分类列表
        $.ajax({
            type: "GET",//请求类型
            url: "disList.action",//请求的url
            dataType: "json",//ajax接口（请求url）返回的数据类型
            success: function (data) {//data：返回数据（json对象）
                $("#disList").html("");
                var obj=eval("("+data+")");
                var options = "<option value=\"0\">--请选择--</option>";
                for (var i = 0; i < obj.length; i++) {
                    options += "<option value=\"" + obj[i].id + "\">" + obj[i].name + "</option>";
                }
                $("#disList").html(options);
            },
            error: function (data) {//当访问时候，404，500 等非200的错误状态码
                alert("加载区县失败！");
            }
        });
        //动态加载街道列表
        $("#disList").change(function () {
            var disList = $("#disList").val();
            if (disList != "0") {
                $.ajax({
                    type: "GET",//请求类型
                    url: "strList.action",//请求的url
                    data: {did:disList},//请求参数
                    dataType: "json",//ajax接口（请求url）返回的数据类型
                    success: function (data) {//data：返回数据（json对象）
                        $("#streetList").html("");
                        var obj=eval("("+data+")");
                        var options = "<option value=\"0\">--请选择--</option>";
                        for (var i = 0; i < obj.length; i++) {
                            options += "<option value=\"" + obj[i].id + "\">" + obj[i].name + "</option>";
                        }
                        $("#streetList").html(options);
                    },
                    error: function (data) {//当访问时候，404，500 等非200的错误状态码
                        alert("加载街道失败！");
                    }
                });
            } else {
                $("#streetList").html("");
                var options = "<option value=\"0\">--请选择--</option>";
                $("#streetList").html(options);
            }
        });

        // //APP失去焦点验证的方法
        // appName.bind("blur", function () {
        //     verityfy(null,appName,"App名称",null);
        // });
        // //失去焦点验证的方法
        // rom.bind("blur", function () {
        //     verityfy(null,rom,"rom名称",null);
        // });
        //
        // //失去焦点验证的方法
        // viewLanguage.bind("blur", function () {
        //     verityfy(null,viewLanguage,"界面语言名称",null);
        // });
        //
        // //失去焦点验证的方法
        // appSize.bind("blur", function () {
        //     var patrn = /^[1-9]{1,}(.00|[1-9])$/;
        //     verityfy(patrn,appSize,"App大小","app软件大小必须是大于1的两位数字");
        // });
        //
        // //失去焦点验证的方法
        // flatformId.bind("blur", function () {
        //     verityfy(null,flatformId,"所属平台",null);
        // });
        // //失去焦点验证的方法
        // categoryLevel1.bind("blur", function () {
        //     verityfy(null,categoryLevel1,"一级菜单",null);
        // });
        // //失去焦点验证的方法
        // categoryLevel2.bind("blur", function () {
        //     verityfy(null,categoryLevel2,"二级菜单",null);
        // });
        // //失去焦点验证的方法
        // categoryLevel3.bind("blur", function () {
        //     verityfy(null,categoryLevel3,"三级菜单",null);
        // });
        //
        // $("#apkName").bind("blur", function () {
        //     //ajax后台验证--APKName是否已存在
        //     $.ajax({
        //         type: "GET",//请求类型
        //         url: "/sys/appInfo/apkexist",//请求的url
        //         data: {APKName: $("#apkName").val()},//请求参数
        //         dataType: "json",//ajax接口（请求url）返回的数据类型
        //         success: function (data) {//data：返回数据（json对象）
        //             if (data.aPKName == "empty") {//参数APKName为空，错误提示
        //                 validateTip($("#apkName"), {"color": "red"}, imgNo +"Apk名称不能为空", false);
        //             } else if (data.aPKName == "exist") {//账号不可用，错误提示
        //                 validateTip($("#apkName"), {"color": "red"}, imgNo +"Apk名称已经存在", false);
        //             } else if (data.aPKName == "noExist") {//账号可用，正确提示
        //                 var patrn = /^(com.){1,}\w{6,}$/;
        //                 verityfy(patrn,apkName,"apk名称","apk名称输入必须以com开头的6位以上..中英文或者汉字");
        //             }
        //         },
        //         error: function (data) {//当访问时候，404，500 等非200的错误状态码
        //             alert("请求错误！");
        //         }
        //     });
        // });
        //
        // /**
        //  * 添加app
        //  */
        // $("#addApp").on("click", function () {
        //     if(appName.attr("validateStatus") != "true") {
        //         appName.blur();
        //     }else if(apkName.attr("validateStatus") != "true"){
        //         apkName.blur();
        //     }else if(rom.attr("validateStatus") != "true"){
        //         rom.blur();
        //     }else if(viewLanguage.attr("validateStatus") != "true"){
        //         viewLanguage.blur();
        //     }else if(appSize.attr("validateStatus") != "true"){
        //         appSize.blur();
        //     }else if(flatformId.attr("validateStatus") != "true"){
        //         flatformId.blur();
        //     }else if(categoryLevel1.attr("validateStatus") != "true"){
        //         categoryLevel1.blur();
        //     }else if(categoryLevel2.attr("validateStatus") != "true"){
        //         categoryLevel2.blur();
        //     }else if(categoryLevel3.attr("validateStatus") != "true"){
        //         categoryLevel3.blur();
        //     }else{
        //         $("#addAppInfo").ajaxSubmit({
        //             type: 'post',
        //             url: "/sys/appInfo/addAppInfo",
        //             contentType: "application/x-www-form-urlencoded; charset=utf-8",
        //             success: function (data) {
        //                 if (data.count == "1") {
        //                     alert("上传成功啦");
        //                     location.href = "/sys/appInfo/appJsp";
        //                 } else {
        //                     alert("上传失败啦");
        //                     $("#logoPic").next().html(data.message);
        //                     return;
        //                 }
        //             }
        //         });
        //     }
        // })


        /**
         * 删除
         */
        $("#del").click(function(){
            var id=$(this).attr("hid");
            location.href="removeHouse.action?hid="+id;
        })
    });

})