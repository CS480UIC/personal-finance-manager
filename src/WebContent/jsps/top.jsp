<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		background: #4682B4; 
	}
	a {
		text-transform:none;
		text-decoration:none;
	} 
	a:hover {
		text-decoration:underline;
	}
</style>
  </head>
  
  <body>
<h1 style="text-align: center;">Personal Finance Manager</h1>
<div style="font-size: 15pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">
			<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">Login</a> |
			<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">Register</a>  |
			<a href="<c:url value='/jsps/user/initialize.jsp'/>" target="_parent">Initialize Database</a>		
		</c:when>
		<c:otherwise>
			Hello ${sessionScope.session_user.username }  (User ID: ${sessionScope.session_user.user_id } )<br>
			<a href="<c:url value='/jsps/income-expense/income-expense-main.jsp'/>" target="body">Income/Expense</a> |
			<a href="<c:url value='/jsps/portfolio/portfolio-main.jsp'/>" target="body">Portfolio</a> |
			<a href="<c:url value='/jsps/portfolio/portfolio-script.jsp'/>" target="body">Live Portfolio</a> |
			<a href="<c:url value='/UserServletLogout'/>" target="_parent">Logout</a> |
			<a href="<c:url value='/jsps/item.jsp'/>" target="body">Query ALL USERS</a><br>
			<a href="<c:url value='/jsps/balance-sheet/balance-sheet-main.jsp'/>" target="_parent">Balance Sheet</a> |
			<a href="<c:url value='/jsps/asset-liability/asset-liability-main.jsp'/>" target="body">Assets/Liabilities</a>&nbsp;&nbsp;
		</c:otherwise>
	</c:choose>

</div>
  </body>
</html>
