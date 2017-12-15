<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收费订单列表</title>
<%@ include file="include/pageResources.jsp" %>
<script type="text/javascript" >
	
	$(document).ready(function() {
		
		
		
	});
	
	function create_onclick()
	{
		// 检查是否有订单未审核通过
		$.ajax({
		   type: "POST",
		   url: "${ctx }/rentalorder/isCreatePermission",
		   data: {rentalType : $("#rentalType").val()},
		   success: function(data){
		      if (data.status == "success")
	    	  {
		    	  location='${ctx }/rentalorder/form';
	    	  }
		      else
	    	  {
	    	  	  alert(data.msg);
	    	  }
		   }
		});
		
		
		return false;
		
	}
	
</script>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<form action="${ctx }/rentalorder/list" method="get" >
	<p>
		收租类型:<select id="rentalType" name="rentalType" >
					<option value="">全部</option>
					<option value="0">房租</option>
					<option value="1">铺租</option>
				</select>
		年份:<input name="year" type="text" value="${rentalOrder.year }" >
	</p>
	<p>
		<input type="button" value="添加" onclick="create_onclick();" > <input type="submit" value="查询" >
	</p>
	</form>
	<table border="1">
		<tr>
			<th>操作</th>
			<th>收费日期</th>
			<th>收租类型</th>
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
						<td> 
							<input type="button" value="查看" onclick="location='${ctx}/rentalorder/detail/${rentalOrder.id}'" >
							<c:if test="${rentalOrder.status ne 100 }">
								<input type="button" value="审核" onclick="location='${ctx}/rentalorder/detail/${rentalOrder.id};q=1'" >
							</c:if>
						</td>
						<td>${rentalOrder.year }-${rentalOrder.month }</td>
						<td>${rentalOrder.rentalTypeDesc }</td>
						<td>${rentalOrder.rentalAmount }</td>
						<td>${rentalOrder.electricityAmount }</td>
						<td>${rentalOrder.deductionAmount }</td>
						<td>${rentalOrder.totalAmount }</td>
						<td>${rentalOrder.statusDesc }</td>
						<td><fmt:formatDate value="${rentalOrder.createDate }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
				</c:forEach>
			</c:when>
			
			<c:otherwise>
				<tr>
					<td colspan="9" align="center" >暂时还没有收费单数据</td>
				</tr>
			</c:otherwise>
			
		</c:choose>
	
	</table>
</body>
</html>