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
	<h4>Enter a month below to find the difference between total income and total expense for that month.</h4>
	<form action="<c:url value='/IncomeExpenseDiff'/>" method="post">
		<input type="hidden" name="method" value="view"/>
		<input type="hidden" name="user_id" value=${sessionScope.session_user.user_id }/>
		<input type="hidden" name="IncomeExpenseList" value=NULL/>
		Select Month: <select name="month">
			<option value="1">01</option>
			<option value="2">02</option>
			<option value="3">03</option>
			<option value="4">04</option>
			<option value="5">05</option>
			<option value="6">06</option>
			<option value="7">07</option>
			<option value="8">08</option>
			<option value="9">09</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
		</select>
		<br/><br/>
		<input type="submit" value="Find"/>
	</form>
</body>
</html>