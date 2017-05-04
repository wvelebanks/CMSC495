<?xml version="1.0" encoding="ISO-8859-1" ?>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>ETMS - Dashboard</title>
<link rel="stylesheet" href="style.css"></link>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous"></link>
<style>
.dynamic-content {
	display: none;
}

.navbar-default {
	background-color: #428bca;
	border-color: #428bca;
}

#imaginary_container {
	margin-top: 2%; /* Don't copy this */
	margin-bottom: 2%;
}

.stylish-input-group .input-group-addon {
	background: white !important;
}

.stylish-input-group .form-control {
	border-right: 0;
	box-shadow: 0 0 0;
	border-color: #ccc;
}

.stylish-input-group button {
	border: 0;
	background: transparent;
}
</style>
</head>

<body style="background-color: #ebeef4;">



	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false"></button>
			<a class="navbar-brand" href="#"><font color="white">ETMS</font></a>

			<button type="button" class="btn btn-default navbar-btn"
				onclick="window.location.href='?db=timesheet'">My Timesheet</button>
			<button type="button" class="btn btn-default navbar-btn"
				onclick="window.location.href='?db=account'">Account</button>
			<button type="button" class="btn btn-default navbar-btn"
				onclick="window.location.href='?db=manage'">Manage</button>


		</div>

		<p class="navbar-text navbar-right">
			<font color="white"> <c:if
					test="${empty sessionScope.currentUser}">  
				Welcome, empty
			</c:if> <c:if test="${!empty sessionScope.currentUser}">  
				Welcome, ${currentUser.firstName} 
			</c:if>
			</font> <a href="Logout" class="navbar-link"><small><font
					color="#70d6f4"><i>Sign Out</i></font></small></a>
		</p>
	</div>
	</nav>




	<!-- Default Dashboard -->
	<div id="default" class="dynamic-content">This is the Default
		Dashboard</div>

	<!-- Account -->
	<div id="account" class="dynamic-content">

		<div class="container">
			<h1 align="center">Edit User Profile</h1>
			<div class="row">
				<!-- left column -->
				<div class="col-md-3">
					<div class="text-center">
						<img src="//placehold.it/100" class="avatar img-circle"
							alt="avatar">
							<h6>Upload a different photo...</h6> <input class="form-control"
							type="file">
					</div>
				</div>
				<!-- edit form column -->
				<div class="container">

					<div class="pre-scrollable" style="max-height: 70vh;">
						<div class="panel panel-default">
							<div class="container-fluid">
								<form class="form-horizontal" role="form">
									<div class="form-group">
										<label class="col-lg-3 control-label">First name:</label>
										<div class="col-lg-8">
											<input class="form-control" value="John" type="text" disabled>
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-3 control-label">Last name:</label>
										<div class="col-lg-8">
											<input class="form-control" value="Doe" type="text" disabled>
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-3 control-label">Employee ID:</label>
										<div class="col-lg-8">
											<input class="form-control" value="111" type="text" disabled>
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-3 control-label">SSN (Last 4):</label>
										<div class="col-lg-8">
											<input class="form-control" value="1234" type="text" disabled>
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-3 control-label">Email:</label>
										<div class="col-lg-8">
											<input class="form-control" value="johndoe3l@gmail.com"
												type="text">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-3 control-label">Phone:</label>
										<div class="col-lg-8">
											<input class="form-control" value="123-456-7890" type="text">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-3 control-label">Address:</label>
										<div class="col-lg-8">
											<input class="form-control" value="123 Main St." type="text">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-3 control-label">City:</label>
										<div class="col-lg-8">
											<input class="form-control" value="Los Angeles" type="text">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-3 control-label">State:</label>
										<div class="col-lg-2">
											<div class="ui-select">
												<select select id="states" class="form-control">
													<option value="AL">AL</option>
													<option value="AK">AK</option>
													<option value="AZ">AZ</option>
													<option value="AR">AR</option>
													<option value="CA">CA</option>
													<option value="CO">CO</option>
													<option value="CT">CT</option>
													<option value="DE">DE</option>
													<option value="DC">DC</option>
													<option value="FL">FL</option>
													<option value="GA">GA</option>
													<option value="HI">HI</option>
													<option value="ID">ID</option>
													<option value="IL">IL</option>
													<option value="IN">IN</option>
													<option value="IA">IA</option>
													<option value="KS">KS</option>
													<option value="KY">KY</option>
													<option value="LA">LA</option>
													<option value="ME">ME</option>
													<option value="MD">MD</option>
													<option value="MA">MA</option>
													<option value="MI">MI</option>
													<option value="MN">MN</option>
													<option value="MS">MS</option>
													<option value="MO">MO</option>
													<option value="MT">MT</option>
													<option value="NE">NE</option>
													<option value="NV">NV</option>
													<option value="NH">NH</option>
													<option value="NJ">NJ</option>
													<option value="NM">NM</option>
													<option value="NY">NY</option>
													<option value="NC">NC</option>
													<option value="ND">ND</option>
													<option value="OH">OH</option>
													<option value="OK">OK</option>
													<option value="OR">OR</option>
													<option value="PA">PA</option>
													<option value="RI">RI</option>
													<option value="SC">SC</option>
													<option value="SD">SD</option>
													<option value="TN">TN</option>
													<option value="TX">TX</option>
													<option value="UT">UT</option>
													<option value="VT">VT</option>
													<option value="VA">VA</option>
													<option value="WA">WA</option>
													<option value="WV">WV</option>
													<option value="WI">WI</option>
													<option value="WY">WY</option>
												</select>
											</div>
										</div>
										<label class="col-lg-3 control-label">Zip Code:</label>
										<div class="col-lg-2">
											<input class="form-control" value="91010" type="text">
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">Username:</label>
										<div class="col-md-8">
											<input class="form-control" value="jdoe1" type="text"
												disabled>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">Password:</label>
										<div class="col-md-8">
											<input class="form-control" value="" type="password">
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">Confirm
											password:</label>
										<div class="col-md-8">
											<input class="form-control" value="" type="password">
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label"></label>
										<div class="col-md-8">
											<input class="btn btn-primary" value="Save Changes"
												type="button"> <span></span> <input
												class="btn btn-default" value="Cancel" type="reset">
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- Time Sheet -->
	<div id="timesheet" class="dynamic-content">
		<div class="container">
			<h1 align="center">My Timesheet</h1>
			<div class="row">
				<div class="panel">
					<div class="pre-scrollable" style="max-height: 90vh; height: 70vh">
						<div class="table">
							<table class="table table-striped">
								<tr>
									<th>#</th>
									<th>Date In</th>
									<th>Time In</th>									
									<th>Time Out</th>
									<th>Action</th>
								</tr>
								<c:set var="count" value="0" scope="page" />
								<c:set var="newEntry" value="true"/>
								<c:forEach items="${timeEntries}" var="timeEntry"
									varStatus='index'>
									<tr>
										<td><c:set var="count" value="${count + 1}" scope="page"/></td>
										<td>${timeEntry.clockDate}</td>
										<td>${timeEntry.timeIn}</td>	
										<td>
											<c:if test="${timeEntry.completed == true}">${timeEntry.timeOut}</c:if>
											<c:if test="${timeEntry.completed == false}"><c:set var="newEntry" value="false"/>-</c:if>
										
										</td>									
										<td>
											<c:if test="${timeEntry.completed == true}"><button type="button" class="btn btn-danger" 
											onclick="window.location.href='Delete?timeIndex=${timeEntry.timeID}'">
												<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
												Delete
											</button></c:if>
											<c:if test="${timeEntry.completed == false}"><button type="button" class="btn btn-warning" 
											onclick="window.location.href='ClockOut?timeIndex=${timeEntry.timeID}'">
												<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
												Clock Out
											</button></c:if>
										</td>										
									</tr>
								</c:forEach>
								<c:if test="${newEntry eq true}">
									<td></td><td></td><td></td><td></td>
									<td><button type="button" class="btn btn-success" 
									onclick="window.location.href='ClockIn'">
												<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
												Clock In
											</button></td>
									</c:if>
							</table>
						</div>
					</div>
				</div>
				<div class="container">

					<div class="row">
						<div class="col-md-3">
							<button type="button" class="btn btn-primary btn-lg btn-block"
								style="margin-bottom: 5px;">Submit Timesheet</button>
						</div>
						<div class="col-md-4">
							<label class="col-md-4 control-label"><h4>
									<b>Submission:</b>
								</h4></label>
							<div class="col-md-5">
								<input class="form-control" value="Not Submitted" type="text"
									disabled>
							</div>
						</div>

						<div class="col-md-4 ">
							<label class="col-md-3 control-label"><h4>
									<b>Status:</b>
								</h4></label>
							<div class="col-md-5">
								<input class="form-control" value="Pending" type="text" disabled>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<!-- Manage -->
	<div id="manage" class="dynamic-content">
		<h1 align="center">Manage Users</h1>

		<div class="row">
			<div class="container">

				<div class="row">

					<!-- left column -->

					<div class="col-md-4">
						<h3 align="center">User Actions</h3>
						<h4 align="center">Selected Employee</h4>
						<div class="panel panel-default">
							<br></br> <label class="col-lg-3 control-label">F. Name:</label>
							<div class="col-lg-8">
								<input class="form-control" value="John" type="text" disabled>
							</div>
							<br></br> <label class="col-lg-3 control-label">L. Name:</label>
							<div class="col-lg-8">
								<input class="form-control" value="Doe" type="text" disabled>
							</div>
							<br></br> <label class="col-lg-3 control-label">E. ID:</label>
							<div class="col-lg-8">
								<input class="form-control" value="123" type="text" disabled>
							</div>
							<br></br> <label class="col-lg-3 control-label">Status:</label>
							<div class="col-lg-8">
								<input class="form-control" value="Pending" type="text" disabled>
							</div>
							<br></br> <br></br>
						</div>

						<div class="col-md-12 text-center">
							<button type="button" class="btn btn-primary btn-lg btn-block"
								style="margin-bottom: 5px;">View Timesheet</button>
						</div>
						<br></br>
						<div class="col-md-12 text-center">
							<button type="button" class="btn btn-success btn-lg btn-block"
								style="margin-bottom: 5px;">Approve Timesheet</button>
						</div>
						<br></br>
						<div class="col-md-12 text-center">
							<button type="button" class="btn btn-danger btn-lg btn-block">Reject
								Timesheet</button>
						</div>

					</div>

					<!-- Right form column -->

					<div class="col-md-8 ">
						<h3 align="center">Subordinate User Table</h3>


						<div class="row">
							<div class="col-sm-6 col-sm-offset-3">
								<div id="imaginary_container">

									<div class="input-group stylish-input-group">
										<input type="text" class="form-control" placeholder="Search">
											<span class="input-group-addon">
												<button type="submit">
													<span class="glyphicon glyphicon-search"></span>
												</button>
										</span>
									</div>

								</div>
							</div>
						</div>


						<div class="panel panel-default">
							<div class="pre-scrollable"
								style="max-height: 60vh; height: 70vh">
								<div class="table">
									<table class="table table-hover">
										<thead>
											<tr>
												<th>ID</th>
												<th>First Name</th>
												<th>Last Name</th>
												<th>Email</th>
												<th>Submission</th>
												<th>TS Status</th>
												<th>View</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>1</td>
												<td>John</td>
												<td>Carter</td>
												<td>johncarter@mail.com</td>
												<td>Not Submitted</td>
												<td>Pending</td>
												<td><a href="#">View</a></td>
											</tr>
											<tr>
												<td>2</td>
												<td>Peter</td>
												<td>Parker</td>
												<td>peterparker@mail.com</td>
												<td>Submitted</td>
												<td>Denied</td>
												<td><a href="#">View</a></td>
											</tr>
											<tr>
												<td>3</td>
												<td>John</td>
												<td>Rambo</td>
												<td>johnrambo@mail.com</td>
												<td>Submitted</td>
												<td>Pending</td>
												<td><a href="#">View</a></td>
											</tr>
											<tr>
												<td>4</td>
												<td>Billy</td>
												<td>Doe</td>
												<td>jDoe@mail.com</td>
												<td>Submitted</td>
												<td>Approved</td>
												<td><a href="#">View</a></td>
											</tr>

										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
	<script type="text/javascript">
		// Parse the URL parameter
		function getParameterByName(name, url) {
			if (!url)
				url = window.location.href;
			name = name.replace(/[\[\]]/g, "\\$&");
			var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"), results = regex
					.exec(url);
			if (!results)
				return null;
			if (!results[2])
				return '';
			return decodeURIComponent(results[2].replace(/\+/g, " "));
		}
		// Give the parameter a variable name
		var dynamicContent = getParameterByName('db');

		$(document).ready(function() {

			// Check if the URL parameter is account
			if (dynamicContent == 'account') {
				$('#account').show();
			}
			// Check if the URL parameter is timesheet
			else if (dynamicContent == 'timesheet') {
				$('#timesheet').show();
			}
			// Check if the URL parameter is manage
			else if (dynamicContent == 'manage') {
				$('#manage').show();
			}
			// Check if the URL parmeter is empty or not defined, display default content
			else {
				window.location.href = '?db=timesheet';
			}
		});
	</script>
</body>
</html>