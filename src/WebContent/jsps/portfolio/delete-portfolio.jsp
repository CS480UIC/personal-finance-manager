<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Portfolio</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Delete Portfolio</h1>

<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/StockServletDelete'/>" method="post">
	<input type="hidden" name="action" value="delete"/>
	<input type="hidden" name="username" value=${sessionScope.session_user.username }/>
	Symbol:   <input type="text" name="symbol" value="${form.symbol }"/>
	<br/>
	<input type="submit" value="Delete"/>
</form> 
  </body>
</html>