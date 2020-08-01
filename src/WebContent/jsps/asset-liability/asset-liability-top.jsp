<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Asset-liability</title>
</head>
<body>
<h1>${sessionScope.session_user.username } 's Assets/Liabilities</h1>
	<a href="<c:url value='/jsps/asset-liability/add-liability.jsp'/>" target="_parent">Add Liability</a>  |
	<a href="<c:url value='all-liability.jsp'/>" target="_parent">View Liability</a> |
	<%-- <a href="<c:url value='edit-income.jsp'/>" target="_parent">Update Liability</a>  |
	<a href="<c:url value='delete-income.jsp'/>" target="_parent">Delete Liability</a> | --%>
	<%-- <a href="<c:url value='/jsps/user/initialize.jsp'/>" target="_parent">Add Expenses</a> --%>
</html>