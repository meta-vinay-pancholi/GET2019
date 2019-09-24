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
		<h1 class="display-4">Showing Your Profile</h1>
	</div>
	<div  id="card" class="space">
	<div class="container">
		<div class="row">
			<div class="col-md-3 space imageshape">
				<div class="userdetails text-center">
					<div class="img">
							  <img src="/img/${EmployeeDetails.profile}" class="rounded img-fluid" alt="${ProfileImformation.name}"> 
					</div>
					<div class="name">
					 <a href="Profile"><h5>${EmployeeDetails.fullname}</h5></a>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<a href="update"><button type="button" class="btn btn-primary btn-block">Edit Profile</button></a>
			`		</div>
			<div class="col-sm-12">
						<a href="friends"><button type="button" class="btn btn-primary btn-block">Show Friends</button></a>
			`		</div>
				</div>
			</div>	
			
			<div class="col-md-8 space details">
				<div class="card">
					<div class="container">
						<h4>
							<b>Employee Id</b>
						</h4>
						<p>${EmployeeDetails.id}</p>
					</div>
					<hr>
					<div class="container">
						<h4>
							<b>Email</b>
						</h4>
						<p>${EmployeeDetails.email}</p>
					</div>
					<hr>
					<div class="container">
						<h4>
							<b>Gender</b>
						</h4>
						<p>${EmployeeDetails.gender}</p>
					</div>
					<hr>
					<div class="container">
						<h4>
							<b>Contact Number</b>
						</h4>
						<p>+91 ${EmployeeDetails.contact}</p>
					</div>
					<hr>
					<div class="container">
						<h4>
							<b>Organization</b>
						</h4>
						<p>${EmployeeDetails.organisation}</p>
					</div>
					<hr>
				</div>
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