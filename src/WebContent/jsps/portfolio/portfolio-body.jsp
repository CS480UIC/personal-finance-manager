<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Current Portfolio</title>
</head>
<body>
<h1>Current Portfolio as of <%= (new java.util.Date()).toLocaleString()%>  </h1>
   <c:set var = "username" value = "${sessionScope.session_user.username }/" />
   <jsp:include page="/findAllPortfolio" flush="true" >
	   <jsp:param name="username" value="${username }"/>
	   <jsp:param name="IncomeList" value="NULL" />
   </jsp:include>
</html>