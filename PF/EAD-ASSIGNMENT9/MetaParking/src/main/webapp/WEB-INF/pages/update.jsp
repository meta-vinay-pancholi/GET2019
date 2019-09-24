<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

	<div class="p-3 mb-2 bg-primary text-white jumbotron" align="center">
		<h1 class="display-4">Update Employee Profile</h1>
	</div>
	<div class="container" style="margin-top: 60px">
		<div class="card">
			<div class="card-header">
				<h3 class="card-title">Update your details here</h3>
			</div>
			<div class="card-body">
				<c:forEach items="${emplist}" var="employee">
					<div class="form-group">
						<input class="form-control" placeholder="profile image"
							type="file" name="pic" accept="image/*">
					</div>
					<div class="form-group">
						<input class="form-control" type="text"
							value="${employee.fullname}">
					</div>
					<div class="form-group">
						<input class="form-control" value="${employee.email}">
					</div>
					<div class="form-group">
						<input class="form-control" value="${employee.gender}">
					</div>
					<div class="form-group">
						<input class="form-control" value="${employee.organisation}">
					</div>
					<div class="form-group">
						<input class="form-control" value="${employee.contact}">
					</div>
				</c:forEach>
			</div>
			<div class="form-group" align="center">
				<input class="btn btn-primary " name="submit" type="submit"
					value="Edit" />
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
	<%@include file="footer.jsp"%>

</body>

</html>