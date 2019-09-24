<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>HomePage</title>
</head>
<body>

	<div class="p-3 mb-5 text-white jumbotron bg-primary " align="center">
		<h1 class="display-4">Welcome to Meta Parking System</h1>
	</div>
	<div
		class="container border border-success rounded d-flex justify-content-center  p-5">
		<form:form modelAttribute="employeeLogin" action="home" method="POST">
			<form:errors path="${authenticatedFailed}" class="error"  cssClass="text-danger"/>
			<h1 class="display-4 p-0 text-primary" align="center">Login</h1>
			<div class="form-group">
				<form:label path="email" for="exampleInputEmail1">Email address</form:label>
				<form:input path="email" size="50%" type="email"
					class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter email" />
				<form:errors path="email" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="password" for="exampleInputPassword1">Password</form:label>
				<form:input path="password" type="password" class="form-control"
					id="exampleInputPassword1" placeholder="Password" />
				<form:errors path="password" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary form-control">Submit</button>
			</div>
		</form:form>
	</div>
	<div class="p-3 mb-5 " align="center">
		<p>If not Register</p>
		<input type="button" class="btn btn-primary " value="Register"
			onClick="window.location.href='signUp'" />
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
</body>
</html>