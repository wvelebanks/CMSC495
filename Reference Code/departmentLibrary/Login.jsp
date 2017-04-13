<?xml version="1.0" encoding="ISO-8859-1" ?>

//Remove the start tag to run!!
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login</title>
</head>
<body>
//the action calls Login.java, and the method utilized doPost()
<form action="Login" method="post">
Username: <input type="text" name="username" /> <br />
Password: <input type="password" name="password" /> <br />
<input type="submit" name="login" value="Login" />
</form>
</body>
</html>