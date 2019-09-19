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
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Show Student</title>
</head>
<body>

	<div class="p-3 mb-2 bg-primary text-white jumbotron" align="center">
		<h1 class="display-4">Update Employee Profile</h1>
	</div>
	<div class="container space">
		<div class="row">
			<div class="col-md-3">
			</div>
			<div class="col-md-6 formPart">
				<div class="space">
					<h5 class="text-center text-muted">Parking Registration From</h5>
				</div>
				<div class="container">
					<form:form modelAttribute="EmployeeDetails" enctype="multipart/form-data">
						<div class="form-group">
							<form:label path="fullname">Name:</form:label>
							<form:input path="fullname" cssClass="form-control" id="fullname"
								value="${EmployeeDetails.fullname }" placeholder="Enter Your Name" />
							<form:errors cssClass="error text-danger" path="fullname" />
						</div>
						<div class="form-group">
							<form:label path="profile">Profile:</form:label>
							<form:input path="profile" type="file" cssClass="form-control"
								id="email" placeholder="Enter Your Name" />
							<form:errors cssClass="error text-danger" path="profile" />
							<br>
							<div>
								<img src="/img/${EmployeeDetails.profile}"
									class="rounded img-fluid" alt="${ProfileImformation.name}"
									height="100" width="100">
							</div>
						</div>
						<div class="form-group">
							<form:label path="password">Password:</form:label>
							<form:input path="password" value="${EmployeeDetails.password}"
								cssClass="form-control" id="password"
								placeholder="Enter Your Name" />
							<form:errors cssClass="error text-danger" path="password" />
						</div>
						<div class="form-group">
							<form:label path="confirmPassword">Confirm Password:</form:label>
							<form:input path="confirmPassword"
								value="${EmployeeDetails.password}" cssClass="form-control"
								id="confirmPassword" placeholder="Enter Your Name" />
							<form:errors cssClass="error text-danger" path="confirmPassword" />
							<br>
							<form:errors path="${confirmPassword}" class="error" />
						</div>
						<div class="form-group">
							<form:label path="contact">Mobile Number</form:label>
							<form:input path="contact"
								value="${EmployeeDetails.contact}" cssClass="form-control"
								id="contact" placeholder="Enter Your Name" />
							<form:errors cssClass="error text-danger" path="contact" />
						</div>
						<div class="form-group">
							<form:label path="organisation">Organization</form:label>
							<form:select id="organisation" path="organisation"
								class="form-control">
								<form:option value="none" disabled="true">Select Your Organization</form:option>
								<form:option value="metacube">MetaCube</form:option>
								<form:option value="tcs">TCS</form:option>
								<form:option value="infosys">INFOSYS</form:option>
								<form:option value="samsung">Samsung</form:option>
								<form:errors cssClass="error text-danger" path="organisation" />
							</form:select>
						</div>
						<button type="submit" class="btn btn-primary form-control">Update</button>
					</form:form>
				</div>
			</div>
			<div class="col-md-3">
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