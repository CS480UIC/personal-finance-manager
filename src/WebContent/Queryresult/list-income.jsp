<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> All Income </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Income ID</th>
		<th>User ID</th>
		<th>Date</th>
		<th>Description</th>
		<th>Amount</th>
		<th>Tags</th>
	</tr>
<c:forEach items="${IncomeList}" var="user">
	<tr>
		<td>${income.income_id }</td>
		<td>${income.user_id }</td>
		<td>${income.date }</td>
		<td>${income.description }</td>
		<td>${income.amount }</td>
		<td>${income.tags }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>