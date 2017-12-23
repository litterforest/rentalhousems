<%@ page language="java" pageEncoding="UTF-8"%>
<link href="${ctx}/resources/css/base.css" rel="stylesheet" />
<script src="${ctx}/resources/js/jquery/jquery-3.2.1.min.js"></script>
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