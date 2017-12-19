<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp"%>
<div class="header"><a href="${ctx }/SecureUser/form/<shiro:principal property="id"/>"><shiro:principal property="username"/></a>，普通会员&nbsp;&nbsp;&nbsp;&nbsp;<a href="${ctx }/home">我的主页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="${ctx }/logout">退出</a></div>