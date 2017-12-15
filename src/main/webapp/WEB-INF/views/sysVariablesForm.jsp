<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收费订单</title>
<%@ include file="include/pageResources.jsp" %>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<form action="${ctx }/sysVariables/save" method="post" >
		<input type="hidden" name="id" value="${sysVariables.id }" >
		<table border="1">
			
			<tr>
				<td>租房当前电费度数</td>
				<td><input name="currentRentingPowerConsumption" value="<fmt:formatNumber value="${sysVariables.currentRentingPowerConsumption }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber>" ></td>
			</tr>
			
			<tr>
				<td>铺位当前电费度数</td>
				<td><input name="currentBerthPowerConsumption" value="<fmt:formatNumber value="${sysVariables.currentBerthPowerConsumption }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber>" ></td>
			</tr>
			
			<tr>
				<td>房租每度电的收费标准</td>
				<td><input name="standardRentingElectricity" value="<fmt:formatNumber value="${sysVariables.standardRentingElectricity }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber>" ></td>
			</tr>
			
			<tr>
				<td>铺位每度电的收费标准</td>
				<td><input name="standardBerthElectricity" value="<fmt:formatNumber value="${sysVariables.standardBerthElectricity }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber>" ></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center" >
					<input type="submit" value="提交" >
					<input type="button"
				value="返回" onclick="location='${ctx }/home'">
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>