<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty sessionScope.username}">
  <%-- redirect to Login.jsp --%>
  <c:redirect url="Login" />
</c:if>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Item</title>
</head>
<body>	
Welcome, ${username} | <a href='Logout'>Logout</a>
	<form action = 'EditEntry' method = 'post'>
	<input type ='hidden' name ='id' value ='${libentry.id}'/>
		<table border = '1'>
			<tr><td>ID: </td><td> ${libentry.id}</td></tr>
			<tr><td>Type: </td><td> <select name = 'type'>
				<option value='Book'>Book </option>
				<option value='Tablet' <c:if test="${libentry.type == 'Tablet'}"><c:out value = "selected" /></c:if>>Tablet</option>
				</select>
			</td></tr>
			<tr><td>Name: </td><td><input type = 'text' name = 'name' value = '${libentry.name}'/>
			<tr><td>Additional Info: </td><td><input type = 'text' name = 'info' value ='${libentry.info}'/></td></tr>
			<tr><td><input type = 'Submit' name = 'save' value = 'save' /></td></tr>		
		</table>
	</form>

</body>
</html>