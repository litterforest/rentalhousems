<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收费订单列表</title>
</head>
<body>
	<p>
		<a href="${ctx }/rentalorder/form" >添加</a>
	</p>
	<table border="1">
		<tr>
			<th>操作</th>
			<th>收费日期</th>
			<th>租费</th>
			<th>电费</th>
			<th>扣减</th>
			<th>总费用</th>
			<th>审核状态</th>
			<th>创建日期</th>
		</tr>
		
		<c:choose>
			<c:when test="${ not empty rentalOrderList }">
				<c:forEach items="${rentalOrderList }" var="rentalOrder" >
					<tr>
						<td></td>
						<td>${rentalOrder.year }-${rentalOrder.month }</td>
						<td>${rentalOrder.rentalAmount }</td>
						<td>${rentalOrder.electricityAmount }</td>
						<td>${rentalOrder.deductionAmount }</td>
						<td>${rentalOrder.totalAmount }</td>
						<td>${rentalOrder.status }</td>
						<td>${rentalOrder.createDate }</td>
					</tr>
				</c:forEach>
			</c:when>
			
			<c:otherwise>
				<tr>
					<td colspan="8" align="center" >暂时还没有收费单数据</td>
				</tr>
			</c:otherwise>
			
		</c:choose>
	
	</table>
</body>
</html>