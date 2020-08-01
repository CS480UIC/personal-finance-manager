<%-- <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Edit Income</title>
    
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
  <h1>Edit Income</h1>

<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/IncomeServletUpdate'/>" method="post">
	<input type="hidden" name="action" value="update"/>
	<input type="hidden" name="username" value=${sessionScope.session_user.username }/>
	
	Income ID:   <input type="text" name="income_id" value="${form.income_id }"/>
	<span style="color: red; font-weight: 900">${errors.description }</span>
	<br/>
	Income Date    :<input type="date" name="in_date"/>  
	<span class="smallText">(MM-DD-YYYY)</span>  
	<br/>
	Description    :<input type="text" name="description" value="${form.description }"/>
	<span style="color: red; font-weight: 900">${errors.description }</span>
	<br/>
	Amount：<input type="text" name="amount" value="${form.amount }"/>
	<span style="color: red; font-weight: 900">${errors.amount }</span>
	<br/>
	Tags	：<input type="text" name="tags" value="${form.tags }"/>
	<span style="color: red; font-weight: 900">${errors.tags }</span>
	<br/>
	<input type="submit" value="Update"/>
</form> 
  </body>
</html>





<%-- <form action="<c:url value='/IncomeServletUpdate'/>" method="get">
	<input type="hidden" name="action" value="update"/>
	<input type="submit" value="Update"/>
</form> --%>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Income</h1>
	<p style="color: red; font-weight: 900">${msg }</p>
	<form action="<c:url value='/IncomeServletUpdate'/>" method="post">
		<input type="hidden" name="action" value="edit"/>
		Income ID	:<input type="text" name="income_id" value="${form.income_id }"/>
		Income Date:    :<input type="text" name="in_date" value="<fmt:formatDate pattern="mm/dd/yyyy" value="${form.in_date}" />" />   
		
		Description    :<input type="text" name="description" value="${form.description }"/>
		<span style="color: red; font-weight: 900">${errors.description }</span>
		<br/>
		Amount：<input type="text" name="amount" value="${form.amount }"/>
		<span style="color: red; font-weight: 900">${errors.amount }</span>
		<br/>
		Tags	：<input type="text" name="tags" value="${form.tags }"/>
		<span style="color: red; font-weight: 900">${errors.tags }</span>
		<br/>
		<input type="submit" value="Update"/>
	</form> 
	
</body>
</html> --%>