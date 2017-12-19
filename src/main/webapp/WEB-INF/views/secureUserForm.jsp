<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<%@ include file="include/pageResources.jsp" %>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<form action="${ctx }/SecureUser/save" method="post" >
		<input name="id" type="hidden" value="${user.id }" >
		<input name="username" type="hidden" value="${user.username }" >
		<table border="1">
			<tr>
				<td>用户名</td>
				<td>${user.username }</td>
			</tr>
			<tr>
				<td>真实名称</td>
				<td>${user.realname }</td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input name="password" value="" type="password" ></td>
			</tr>
			<tr>
				<td>手机号码</td>
				<td><input name="mobile" value="${user.mobile }" ></td>
			</tr>
			<tr>
				<td colspan="2" align="center" >
					<input type="submit" value="提交" >&nbsp;&nbsp;<input type="button" value="返回" onclick="location='${ctx }/home'" >
				</td>
			</tr>
		</table>
	</form>
</body>
</html>