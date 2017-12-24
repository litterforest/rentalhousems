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
		
		// $("#rentalType").val("${rentalOrder.rentalType}");
		// 渲染表格和分页栏
        jQuery("#grid-table").jqGrid({
        	url : '${ctx}/rentalorder/list/data?' + $("#searchForm").serialize(), //组件创建完成之后请求数据的url
				datatype : "json", //请求数据返回的类型。可选json,xml,txt
				colNames : [ '操作', '收费日期', '收租类型', '租费', '电费', '扣减', '总费用', '审核状态', '创建日期'],//表格标题
				colModel : [ //表格每一列的配置信息。包括名字，索引，宽度,对齐方式.....
		             {name : '', width : 110, align : "left", sortable : false, formatter:function(cellvalue, options, rowObject){
		            	 var resultStr = "";
		            	 resultStr += "<input type=\"button\" value=\"查看\" onclick=\"location='${ctx}/rentalorder/detail/"+ rowObject.id +"'\" >";
		            	 if (rowObject.status != 100)
	            		 {
		            		 resultStr += "<input type=\"button\" value=\"审核\" onclick=\"location='${ctx}/rentalorder/detail/"+ rowObject.id +";q=1'\" >";
	            		 }
		            	 return resultStr;
		             }},
		             {name : 'yearAndMonth',index : '',width : 140,align : "center", sortable : false},
		             {name : 'rentalTypeDesc',index : '',width : 140,align : "center", sortable : false},
				 	 {name : 'rentalAmount',index : '',width : 120, align : "center", sortable : false},
		          	 {name : 'electricityAmount',index : '',width : 100, sortable : false, align : "center", sortable : false},
		          	 {name : 'deductionAmount',index : '',width : 100, sortable : false, align : "center", sortable : false},
		          	 {name : 'totalAmount',index : '',width : 100, sortable : false, align : "center", sortable : false},
		          	 {name : 'statusDesc',index : '',width : 100, sortable : false, align : "center", sortable : false},
		          	 {name : 'createDate',index : '',width : 120, sortable : false, align : "center", sortable : false},
		           ],
				rowNum : 10,//一页显示多少条
				rowList : [ 10, 20, 50, 100 ],//可供用户选择一页显示多少条
				pager : '#grid-pager',//表格页脚的占位符(一般是div)的id
				mtype : "get",//向后台请求数据的ajax的类型。可选post,get
				viewrecords : true,
				autowidth: true,
				multiselect: false,
				altRows: true,
				height: 330,
				shrinkToFit: false,
				prmNames: { page: "pageRequest.currentPage", rows: "pageRequest.pageSize" },
				jsonReader: {repeatitems: false, userdata: "userdata" },
				loadComplete: function(data){
					
				},
				
    	});
    	/*创建jqGrid的操作按钮容器*/
    	/*可以控制界面上增删改查的按钮是否显示*/
    	jQuery("#grid-table").jqGrid('navGrid', '#grid-pager', {edit : false, add : false, del : false, refresh: false, search: false});
		
	});
	
	function create_onclick()
	{
		// 检查是否有订单未审核通过
		$.ajax({
		   type: "GET",
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
	
	function searchData()
	{
		jQuery("#grid-table").jqGrid('setGridParam', 
				{ url : '${ctx}/rentalorder/list/data?' + $("#searchForm").serialize(), page : 1 }).trigger("reloadGrid");
	}
	
</script>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<form id="searchForm" action="" method="get" >
	<p>
		收租类型:<select id="rentalType" name="rentalType" >
					<option value="">全部</option>
					<option value="0">房租</option>
					<option value="1">铺租</option>
				</select>
		年份:<input id="year" name="year" type="text" value="${rentalOrder.year }" >
	</p>
	<p>
		<input type="button" value="添加" onclick="create_onclick();" > <input type="reset" value="重置" > <input type="button" value="查询" onclick="searchData();" >
	</p>
	</form>
	
	<!-- 表格 -->
	<table id="grid-table"></table>
	<!-- 分页栏 -->
	<div id="grid-pager"></div>
	
</body>
</html>