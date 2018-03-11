<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
    <table border="2">
        <tr>
            <td>用户名</td>
            <td>密码</td>
            <td>电话</td>
        </tr>

            <s:if test="usersList.size>0">
                <%--此usersList是Action那边申明的属性集合--%>
                <s:iterator value="usersList">
        <tr>
            <%--此username表示userList集合中的每一个User对象的属性值--%>
                <td><s:property value="username"/></td>
                <td><s:property value="password"/></td>
                <td><s:property value="telephone"/></td>
        </tr>
                </s:iterator>
            </s:if>
            <s:else>
        <tr>
                <td>不存在用户对象</td>
        </tr>
            </s:else>
    </table>
</body>
</html>
