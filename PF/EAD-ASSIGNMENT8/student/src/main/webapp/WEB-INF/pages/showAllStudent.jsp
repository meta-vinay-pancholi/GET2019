<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="pageTitle" scope="request" value="Users" />
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
<title>Show Student</title>
</head>
<body>

	<div class="p-3 mb-2 bg-warning text-dark jumbotron" align="center">
		<h1 class="display-4">Student Details</h1>
	</div>
	<div class="container" style="margin-top: 60px">
		<div class="card">
			<div class="card-header">
				<h3 class="card-title">Students</h3>
			</div>
			<div class="card-body">
				<c:if test="${not empty msg}">
					<div class="alert alert-success alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">x</span>
						</button>
					</div>
				</c:if>
				<div class="table-responsive">
					<table class="table table-striped table-dark">
						<thead>
							<tr>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Father Name</th>
								<th>Email</th>
								<th>Class</th>
								<th>Age</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${studentlist}" var="student">
								<tr>
									<td>${student.firstname}</td>
									<td>${student.lastname}</td>
									<td>${student.fathername}</td>
									<td>${student.email}</td>
									<td>${student.standard}</td>
									<td>${student.age}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
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