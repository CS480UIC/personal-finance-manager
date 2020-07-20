<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${sessionScope.session_user.username } 's Income/Expense</h1>
	<a href="<c:url value='add-income.jsp'/>" target="_parent">Add Income</a>  |
	<a href="<c:url value='all-income.jsp'/>" target="_parent">View Income</a> |
	<a href="<c:url value='edit-income.jsp'/>" target="_parent">Update Income</a>  |
	<a href="<c:url value='delete-income.jsp'/>" target="_parent">Delete Income</a> |
	<%-- <a href="<c:url value='/jsps/user/initialize.jsp'/>" target="_parent">Add Expenses</a> --%>
</html>