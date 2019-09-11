<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<title>Add Student</title>
</head>
<body>
	<div class="p-3 mb-2 bg-warning text-dark jumbotron" align="center">
		<h1 class="display-4">Enter Student Details</h1>
	</div>

	<div class="container">
		<form:form modelAttribute="student">

			<form:errors cssClass="text-danger" />
			<div class="form-group">
				<form:label path="firstname">First Name</form:label>
				<form:input path="firstname" cssClass="form-control" id="firstname"
					placeholder="Enter Fisrt Name" />
				<form:errors path="firstname" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="lastname">Last Name</form:label>
				<form:input path="lastname" cssClass="form-control" id="lastname"
					placeholder="Enter Last Name" />
				<form:errors path="lastname" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="fathername">Father Name</form:label>
				<form:input path="fathername" cssClass="form-control"
					id="fathername" placeholder="Enter Father Name" />
				<form:errors path="fathername" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="email">Email address</form:label>
				<form:input path="email" type="email" cssClass="form-control"
					id="email" placeholder="Enter email" />
				<form:errors path="email" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="standard">Class</form:label>
				<form:input path="standard" cssClass="form-control" id="standard"
					placeholder="Enter Class of Student" />
				<form:errors path="standard" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="age">Age</form:label>
				<form:input path="age" cssClass="form-control" id="age"
					placeholder="Enter Age of Student" />
				<form:errors path="age" cssClass="text-danger" />
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>

</body>
</html>