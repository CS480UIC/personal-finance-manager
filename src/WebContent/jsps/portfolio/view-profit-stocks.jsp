<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>View Profitable Stocks</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
  </head>
  
  <body>
  <h1>View Profitable Stocks</h1>
  <h4>View all those stocks in your portfolio which yield a profit of more than x%</h4>
  <h4>Enter the threshold profit percentage x% below</h4>
	<p style="color: red; font-weight: 900">${msg }</p>
	<form action="<c:url value='/viewProfitableStocks'/>" method="post">
		<input type="hidden" name="method" value="view"/>
		<input type="hidden" name="user_id" value=${sessionScope.session_user.user_id }/>
		x%:    :<input type="text" name="x" value="${form.x }"/>% 
		<br/>
		<input type="submit" value="View"/>
	</form> 
  </body>
</html>
