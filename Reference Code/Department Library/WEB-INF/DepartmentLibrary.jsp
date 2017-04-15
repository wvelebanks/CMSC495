<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Department Library</title>
</head>
<body>
<c:if test="${empty sessionScope.username}">  
Welcome, Guest | <a href='Login'>Login</a>
</c:if>
<c:if test="${!empty sessionScope.username}">  
Welcome, ${username} | <a href='Logout'>Logout</a>
</c:if>

	<table border = '1'>
		<tr><th>ID</th><th>Type</th><th>Name</th><th>Additional Info</th><th>Available</th><th>Operation</th></tr>
			<c:forEach items="${libentries}" var="libentry" varStatus='index'>
			  <tr>
			    <td>${libentry.id}</td>
			    <td>${libentry.type}</td>
			    <td>${libentry.name}</td>
			    <td>${libentry.info}</td>
		    	<td <c:if test="${libentry.available == 'Yes'}"><c:out value = "bgcolor= #00FF00"/></c:if>
		    	<c:if test="${libentry.available == 'No' && libusers[index.index].overdue}"><c:out value = "bgcolor= #FF0000"/></c:if>
		    	<c:if test="${libentry.available == 'No' && !libusers[index.index].overdue}"><c:out value = "bgcolor= #FFFF00"/></c:if>		    
		    	>${libentry.available}</td>			    	    
			    <td><a href='ViewLog?index=${index.index}'>View</a> | <a href='EditEntry?index=${index.index}'>Edit</a></td>
			  </tr>
			  
			</c:forEach>

	</table>
	<a href='AddItem'>Add Items</a>

</body>
</html>
