<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Log</title>
</head>
<body>
<c:if test="${empty sessionScope.username}">  
Welcome, Guest | <a href='Login'>Login</a>
</c:if>
<c:if test="${!empty sessionScope.username}">  
Welcome, ${username} | <a href='Logout'>Logout</a>
</c:if></br>
	ID: <b> ${libentry.id}</b></br>
	Name: <b>${libentry.name}</b></br>
	<a href='DepartmentLibraryServlet'>Back to Items</a> |	    		    
		    <c:if test="${libentry.available == 'Yes'}">
		    	<a href='CheckOut?index=${libentry.id-1}'> Check Out</a>		    
		    </c:if>
	
	<table border = '1'>
		<tr><th>CIN</th><th>Name</th><th>Date Borrowed</th><th>Date Back By</th><th>Date Returned</th></tr>
		<c:forEach items="${libusers}" var="libuser" varStatus='index'>
			<c:if test="${libentry.id == libuser.id}">
				<tr><td>${libuser.cin}</td><td>${libuser.name}</td><td>${libuser.dateBorrow}</td><td <c:if test="${libuser.overdue}"><c:out value = "bgcolor= #FF0000"/></c:if>>${libuser.dueBack}</td><td>${libuser.dateReturn}</td></tr>
			</c:if>
		
		</c:forEach>
		
		
		 
		
	</table>

</body>
</html>