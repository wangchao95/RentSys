<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
</head>
<body>
<p>欢迎你:${sessionScope.user.name}</p>
    你的房屋信息如下:<br/>
    <s:if test="users.houseSet.size>0">
        <s:iterator value="users.houseSet">
            <s:property value="description"/>
            <s:property value="price"/>
            <s:date name="pubdate" format="dd/MM/yyyy"/>
            <s:property value="floorage"/><br/>
        </s:iterator>
    </s:if>
    你已经是第${applicationScope.get("count")}个登录的用户<br/>
    <a href="userInfo.action">用户列表</a>



</body>
</html>
