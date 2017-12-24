<%@ page language="java" pageEncoding="UTF-8"%>
<link href="${ctx}/resources/css/base.css" rel="stylesheet" />
<script src="${ctx}/resources/js/jquery/jquery-3.2.1.min.js"></script>
<!-- jqgrid 依懒库 -->
<link rel="stylesheet" href="${ctx}/resources/js/jqgrid/4.6/css/ui.jqgrid.css" >
<link rel="stylesheet" href="${ctx}/resources/js/jqgrid/4.6/css/default/jquery-ui-1.8.2.custom.css" >
<script type="text/javascript" src="${ctx}/resources/js/jqgrid/4.6/js/jquery.jqGrid.min.js" ></script>
<script type="text/javascript" src="${ctx}/resources/js/jqgrid/4.6/i18n/grid.locale-cn.js" ></script>
<!-- jqgrid 依懒库 -->
<%-- 
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<script type="text/javascript" >
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
</script> --%>