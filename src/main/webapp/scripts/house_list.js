jQuery.noConflict();
jQuery(document).ready(function($) {

    /**
     * 分页的方法
     */
    function page(pageNo) {
        $("#sform").ajaxSubmit({
            type: 'post',
            url: "pageHouse.action",
            data:{pageIndex:pageNo},
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function (page) {
                var dataJson=page;
                var data = eval("(" + dataJson + ")");
                var houseList=data.pageList;  //获得页的集合
                $("#tableInfo").html("");
                $(".page").remove();
                //循环遍历集合
                for(var i=0;i<houseList.length;i++){
                    var house=houseList[i];
                    $("#tableInfo").append("<tr><td class=\"house-thumb\"><span><a href='#'>" +
                        "<img src=\"/images/thumb_house.gif\" /></a></span></td><td><dl><dt>"+house.title+"</dt><dd>"+house.street.district.name+"区--" +
                        "---"+house.street.name+"----"+house.floorage+"平米<br/>联系方式"+house.contact+"</dd></dl></td><td class=\"house-type\">"+house.type.name+"</td>" +
                        "<td class=\"house-price\"><span>"+house.price+"</span>元/月</td></tr>");
                }
                var $div=$("<div class='page'></div>").appendTo($(".main"));
                var $operArea=$("<p align='center'>共"+data.totalCount+"条记录&nbsp;&nbsp;&nbsp;当前页数:["+data.currentPage+"/"+data.totalPage+"]&nbsp;</p>").appendTo($div);
                if(data.currentPage>1){
                    var $first=$("<a href=\"javascript:;\" id='1' class=\"first\" >首页</a>");
                    var $perv=$("<a href=\"javascript:;\" class='pre' id='"+(data.currentPage-1)+"'>上一页</a>");
                    $div.append($first).append("&nbsp;").append($perv);   //添加到元素里面
                }
                //如果当前页数小于总页数
                if(data.currentPage<data.totalPage){
                    var $thred=$("<a href=\"javascript:;\" class='next'  id='"+(data.currentPage+1)+"'>下一页</a>");
                    var $last=$("<a href=\"javascript:;\" class='last'  id='"+data.totalPage+"'>末页</a>");
                    $div.append($thred).append("&nbsp;").append($last);   //添加到元素里面
                }
                var $go=$("<span style='float: right'><label>跳转至</label>\n" +
                    "\t<input type=\"text\" name=\"inputPage\" totalPage='"+data.totalPage+"' id=\"inputPage\" value='' class=\"page-key\" />页\n" +
                    "\t<button type=\"button\" class=\"page-btn\">GO</button>\n" +
                    "\t\t</span>");
                $div.append($go);
            }
        });
    }
    page(1);  //初始化页面的用户

    /**
     * 点击上下页来显示列表
     */
    $(".main").on("click",".last,.first,.pre,.next",function(){
        var pageNo=this.id;
        page(pageNo);
    })

    /**
     * 搜索的方法
     */
    $("#search").click(function(){
        page(1);
    })


    //点击go去的页面
    $(".main").on("click",".page-btn",function(){
        var inputPage=$("#inputPage").val();
        var tatalPage= $("#inputPage").attr("totalPage");
        jump_to(inputPage,tatalPage);
    });

    //验证输入的是否合法
    function jump_to(num,totalPage){
        //alert(num);
        //验证用户的输入
        var regexp=/^[1-9]\d*$/;
        if(!regexp.test(num)){
            alert("请输入大于0的正整数！");
            return false;
        }else if((num-totalPage) > 0){
            alert("请输入小于总页数的页码");
            return false;
        }else{
            page(num);
        }
    }

})
