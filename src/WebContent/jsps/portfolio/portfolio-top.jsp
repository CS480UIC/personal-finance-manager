<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Portfolio</title>
</head>
<body>
<h1>${sessionScope.session_user.username }'s Portfolio</h1>
	<a href="<c:url value='add-stock.jsp'/>" target="_parent">Add Portfolio Entry</a>  |
	<a href="<c:url value='all-portfolio.jsp'/>" target="_parent">View Portfolio</a> |
	<a href="<c:url value='edit-portfolio.jsp'/>" target="_parent">Update Portfolio Entry</a> |
	<a href="<c:url value='delete-portfolio.jsp'/>" target="_parent">Delete Portfolio Entry</a> 
</html>