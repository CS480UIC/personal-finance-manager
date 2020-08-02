<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Income Expense Difference</title>
</head>
<body>
	<h1>Income Expense Difference</h1>
	<form action="<c:url value='/IncomeExpenseDiff'/>" method="post">
		<input type="hidden" name="method" value="view"/>
		<input type="hidden" name="user_id" value=${sessionScope.session_user.user_id }/>
		<br/><br/>
		<input type="submit" value="Show"/>
	</form>
</body>
</html>