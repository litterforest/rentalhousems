<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<%@ include file="include/pageResources.jsp"%>
</head>
<body>
	<form action="${ctx }/doLogin" method="post" >
		<input type="hidden" name="_csrf" value="${_csrf.token}" >
		<div class="success" >${param.msg }</div>
		<div class="error" >${param.errorMsg }</div>
		<table>
			<tr>
				<td>用户名</td>
				<td><input name="username" type="text" ></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input name="password" type="password" ></td>
			</tr>
			<tr>
				<td>记住一周</td>
				<td><input name="isRememberMe" type="checkbox" value="1" ></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="登录" >&nbsp;&nbsp;<input type="button" value="免费注册" onclick="location='${ctx}/register'" ></td>
			</tr>
		</table>
	</form>
</body>
</html>