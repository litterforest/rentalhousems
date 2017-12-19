<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收费订单明细</title>
<%@ include file="include/pageResources.jsp" %>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<table border="1">

		<tr>
			<td>收费年月</td>
			<td>${rentalOrder.year }-${rentalOrder.month }</td>
		</tr>
		<tr>
			<td>出租类型</td>
			<td>${rentalOrder.rentalTypeDesc }</td>
		</tr>
		<tr>
			<td>月租金</td>
			<td><fmt:formatNumber value="${rentalOrder.rentalAmount }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber></td>
		</tr>
		<tr>
			<td>上月电度数</td> 
			<td><fmt:formatNumber value="${rentalOrder.lastPowerConsumption }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber></td>
		</tr>
		<tr>
			<td>当月电度数</td>
			<td><fmt:formatNumber value="${rentalOrder.powerConsumption }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber></td>
		</tr>
		
		<tr>
			<td>实用电度数</td>
			<td><fmt:formatNumber value="${rentalOrder.diffPowerConsumption }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber></td>
		</tr>
		
		<tr>
			<td>电费标准(度/元)</td>
			<td>
				<c:choose>
					<c:when test="${rentalOrder.rentalType eq 0 }">
						<fmt:formatNumber value="${rentalOrder.secureUser.sysVariables.standardRentingElectricity }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" />
					</c:when>
					<c:when test="${rentalOrder.rentalType eq 1 }">
						<fmt:formatNumber value="${rentalOrder.secureUser.sysVariables.standardBerthElectricity }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" />
					</c:when>
				</c:choose>
			</td>
		</tr>
		
		<tr>
			<td>电费</td>
			<td><fmt:formatNumber value="${rentalOrder.electricityAmount }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber></td>
		</tr>
		
		<tr>
			<td>扣减费用</td>
			<td><fmt:formatNumber value="${rentalOrder.deductionAmount }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber></td>
		</tr>
		
		<tr>
			<td>总费用</td> 
			<td><fmt:formatNumber value="${rentalOrder.totalAmount }" groupingUsed="false" maxFractionDigits="2" minFractionDigits="2" ></fmt:formatNumber></td>
		</tr>
		
		<tr>
			<td>收租人</td> 
			<td>${rentalOrder.secureUser.realname }</td>
		</tr>
		
		<tr>
			<td>审核状态</td> 
			<td>${rentalOrder.statusDesc }</td>
		</tr>
		
		<tr>
			<td>备注</td>
			<td>${rentalOrder.remarks }</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center" >
			<c:if test="${q eq 1 }">
				<input type="button"
				value="审核" onclick="location='${ctx }/rentalorder/audit/${rentalOrder.id }'" >
			</c:if>
			<input type="button"
				value="返回" onclick="location='${ctx }/rentalorder/list'"></td>
		</tr>

	</table>
</body>
</html>