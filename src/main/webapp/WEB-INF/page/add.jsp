<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>青鸟租房 -发布房屋信息</title>
<link type="text/css" rel="stylesheet" href="${path}/css/style.css" />
<script type="text/javascript" src="${path}/scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="${path}/images/logo.gif" /></div>

</div>
<div id="regLogin" class="wrap">
	<div class="dialog">
		<dl class="clearfix">
			<dt>新房屋信息发布</dt>
			<dd class="past">填写房屋信息</dd>

		</dl>
		<div class="box">
			<s:form action="addHouse.action" method="POST">
				<div class="infos">
					<table class="field">
						<tr>

							<td class="field">标　　题：</td>
							<td>
								<s:fielderror><s:param>title</s:param></s:fielderror>
							<s:textfield cssClass="text" key="title" name="house.title"/>
							</td>
						</tr>
						<tr>
							<td class="field">户　　型：</td>
							<td>
								<s:fielderror><s:param>typeId</s:param></s:fielderror>
								<select  class="text" id="type" name="house.type.id"></select></td>
						</tr>
						<tr>
							<td class="field">面　　积：</td>
							<td>
								<s:fielderror><s:param>floorage</s:param></s:fielderror>
								<s:textfield cssClass="text" key="floorage" name="house.floorage"/></td>
						</tr>
						<tr>
							<td class="field">价　　格：</td>
							<td>
								<s:fielderror><s:param>price</s:param></s:fielderror>
							<s:textfield cssClass="text" key="price" name="house.price"/>
							</td>
						</tr>

						<tr>
							<td class="field">房产证日期：</td>
							<td>
								<s:fielderror><s:param>pubdate</s:param></s:fielderror>
								<s:textfield cssClass="text" key="houseDate" name="house.pubdate"/></td>
						</tr>

                        <tr>
							<td class="field">位　　置：</td>
							<td>
								<s:fielderror><s:param>streetId</s:param></s:fielderror>
							区：<select  class="text" id="disList" name="house.street.district.id">
							</select>
                            	街：<select  class="text" id="streetList" name="house.street.id">
								<option value="0">--请选择--</option>
                            	</select>

                            </td>
						</tr>
                        <tr>
							<td class="field">联系方式：</td>
							<td>
								<s:fielderror><s:param>contact</s:param></s:fielderror>
							<s:textfield cssClass="text" key="contact" name="house.contact"/>
							</td>
						</tr>
                        <tr>
							<td class="field">详细信息：</td>
							<td><textarea name="house.description"></textarea></td>
						</tr>
					</table>
					<div class="buttons">
					<s:submit value="立即发布"/>
					</div>
				</div>
			</s:form>
		</div>
	</div>
</div>
<div id="footer" class="wrap">
	<dl>
    	<dt>青鸟租房 &copy; 2010 北大青鸟 京ICP证1000001号</dt>
        <dd>关于我们 · 联系方式 · 意见反馈 · 帮助中心</dd>
    </dl>
</div>
</body>
</html>
<script src="${path}/scripts/jquery.min.js"></script>
<script src="${path}/scripts/House.js"></script>
