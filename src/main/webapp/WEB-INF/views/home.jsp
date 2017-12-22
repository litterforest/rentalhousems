<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出租房管理系统</title>
<%@ include file="include/pageResources.jsp" %>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<div class="success" >${param.msg }</div>
	<div class="error" >${param.errorMsg }</div>
	
	
	${menus.webContent }
	
	
	<%-- <table>
		<tr>
			<td>
			<shiro:hasRole name="admin">
				<a href="${ctx }/rentalorder/list">二手房收租管理</a>
			</shiro:hasRole>
			</td>
			<td><a href="${ctx }/sysVariables/form">租房参数设定</a></td>
		</tr>
	</table> --%>
</body>
</html>