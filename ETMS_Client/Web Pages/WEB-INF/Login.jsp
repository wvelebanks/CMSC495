<?xml version="1.0" encoding="ISO-8859-1" ?>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login</title>
<link rel="stylesheet" href="style.css"></link>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous"></link>
</head>

<body style="background-color: #f1f0f0;">
	<div class="panel panel-default" style='background: #428bca'>
		<h1>
			<font color="white">Employee Time Management System</font><small><font
				color="black"> sign on</font></small>
		</h1>
	</div>
	<form class="form-horizontal" action="Login" method="post">
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">Username</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="inputEmail3"
					placeholder="Username" name="username">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
			<div class="col-sm-4">
				<input type="password" class="form-control" id="inputPassword3"
					placeholder="Password" name="password">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-4">
				<div class="checkbox">
					<button type="submit" name="login" class="btn btn-primary">Sign
						in</button>
					<label> <input type="checkbox"> Remember me </label>
					<div style="float: right;">
						<a href="TestServlet"><i>I forgot my password</i></a>
					</div>

				</div>
			</div>
		</div>

	</form>
</body>
</html>
