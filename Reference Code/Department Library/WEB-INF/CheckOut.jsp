<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${empty sessionScope.username}">
  <%-- redirect to Login.jsp --%>
  <c:redirect url="Login" />
</c:if>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check Out</title>
</head>
<body>
Welcome, ${username} | <a href='Logout'>Logout</a></br>
	ID: <b> ${libentry.id}</b></br>
	Name: <b>${libentry.name}</b></br>
	<form action = 'CheckOut' method = 'post'>
		<input type ='hidden' name ='index' value ='${libentry.id}'/>
		<table border = '1'>
			<tr><td>Date Borrowed:</td><td> <fmt:formatDate value="<%=new java.util.Date()%>" pattern="MM/dd/yyyy" /></td></tr>
			<tr><td>Due Back By (Optional):</td><td><input type = 'text' name = 'due' /></tr>
			<tr><td>CIN:</td><td><input type = 'text' name = 'cin' /></tr>
			<tr><td>Name:</td><td><input type = 'text' name = 'name' /></tr>
			<tr><td><input type = 'Submit' name = 'checkOut' value = 'Check Out' /></td></tr>
		</table>
	</form>


</body>
</html>