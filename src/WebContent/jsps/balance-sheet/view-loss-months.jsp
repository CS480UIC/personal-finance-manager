<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>View Loss Months</title>
    
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
    <h1>View Loss Months</h1>
    <h3>Shows all the months for which the AVERAGE balance decreased from the previous month.</h3>
    <br>
    <form action="<c:url value='/ViewLossMonths'/>" method="post">
    	<input type="hidden" name="user_id"   value=${sessionScope.session_user.user_id }/>
    	<input type="submit" value="Show Loss Months"/>
    </form>
    <%-- <a href="<c:url value='/findAllIncome'/>" target="body">List All My Income</a>&nbsp;&nbsp; --%>
  </body>
</html>
