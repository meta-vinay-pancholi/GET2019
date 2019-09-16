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
		<h1 class="display-4">Showing Your Profile</h1>
	</div>
	<div class="container" style="margin-top: 60px">
		<div class="card">
			<div class="card-header">
				<h3 class="card-title">Employee</h3>
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
					<form:form>
						<table class="table table-striped table-dark">
							<thead>
								<tr>
									<th>Profile Picture</th>
									<th>Full Name</th>
									<th>Email</th>
									<th>Gender</th>
									<th>Organization</th>
									<th>Contact Number</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${emplist}" var="employee">
									<tr>
										<td><img src="/img/vinay.jpg" class="img-rounded"
											alt="Cinque Terre" width="100" height="100" /></td>
										<td>${employee.fullname}</td>
										<td>${employee.email}</td>
										<td>${employee.gender}</td>
										<td>${employee.organisation}</td>
										<td>${employee.contact}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="form-group" align="center">
							<input class="btn btn-primary  " name="submit" type="submit"
								value="Update Profile" />
						</div>
					</form:form>
				</div>

				<div class="form-group" align="center">
					<input type="button" class="btn btn-primary " value="Show Friends"
						onclick="window.location.href='/friends?email=${employee.email}'" />
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
	<%@include file="footer.jsp"%>
</body>
</html>