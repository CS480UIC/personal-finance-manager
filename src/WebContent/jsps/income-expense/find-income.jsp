<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> --%>
<%-- <%@ page import="java.sql.*;" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>Find Income by Tag</title>
</head>
<body>
	<h1>Find Income by Tag</h1>
	<h4>(1) Enter your user ID.</h4>
	<h4>(2) Enter the month for which you want to view income.</h4>
	<h4>(3) Pick a tag from the dropdown list.</h4>
	
	<form action="<c:url value='/FindIncomeTag'/>" method="post">
		<input type="hidden" name="method" value="view"/>
		<input type="hidden" name="user_id" value=${sessionScope.session_user.user_id }/>
		Income Month: <select name="income_month">
			<option value="01">01</option>
			<option value="02">02</option>
			<option value="03">03</option>
			<option value="04">04</option>
			<option value="05">05</option>
			<option value="06">06</option>
			<option value="07">07</option>
			<option value="08">08</option>
			<option value="09">09</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
		</select>
		<br/>
		Tag：<input type="text" name="tag" value="${form.tag }"/>
		<br/>
		<input type="submit" value="Find"/>
	</form>
</body>
</html>