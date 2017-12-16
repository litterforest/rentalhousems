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
	<form action="${ctx }/doRegister" method="post" >
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
				<td>手机号码</td>
				<td><input name="mobile" type="text" ></td>
			</tr>
			<tr>
				<td>真实姓名</td>
				<td><input name="realname" type="text" ></td>
			</tr>
			<tr>
				<td colspan="2" align="center" ><input type="submit" value="提交" >&nbsp;&nbsp;<input type="button" value="返回" onclick="location='${ctx}/login'" ></td>
			</tr>
		</table>
	</form>
</body>
</html>