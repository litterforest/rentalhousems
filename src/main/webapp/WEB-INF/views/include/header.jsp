<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp"%>
<div class="header"><shiro:principal property="username"/>，普通会员&nbsp;&nbsp;&nbsp;&nbsp;<a href="${ctx }/logout">退出</a></div>