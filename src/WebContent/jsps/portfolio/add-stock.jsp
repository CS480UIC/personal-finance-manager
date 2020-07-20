<%-- <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Add Stock</title>
    
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
  <h1>Add Stock</h1>

<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/StockServletAdd'/>" method="post">
	<input type="hidden" name="method" value="add"/>
	<input type="hidden" name="username" value=${sessionScope.session_user.username }/>
	
	User ID:    :<input type="text" name="user_id" value="${form.user_id }"/> 
	<br/>
	Symbol    :<input type="text" name="symbol" value="${form.symbol }"/>
	<span style="color: red; font-weight: 900">${errors.symbol }</span>
	<br/>
	Quantity  £º<input type="text" name="quantity" value="${form.quanttity }"/>
	<span style="color: red; font-weight: 900">${errors.quantity }</span>
	<br/>
	Buy Price	£º<input type="text" name="buy_price" value="${form.buy_price }"/>
	<span style="color: red; font-weight: 900">${errors.buy_price }</span>
	<br/>
	Current Price	£º<input type="text" name="current_price" value="${form.current_price }"/>
	<span style="color: red; font-weight: 900">${errors.current_price }</span>
	<br/>
	<input type="submit" value="Add"/>
</form> 
  </body>
</html>
