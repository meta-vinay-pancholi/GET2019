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
	src="https://stackpath.bootstrapcdn.com/boots trap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Vehicle Registration</title>
</head>
<body>
	<div align="center">
		<div class="p-3 text-white jumbotron bg-primary " align="center">
			<h1 class="display-4">Meta-Parking</h1>
		</div>
		<div id="application">
			<h2 class="display-4">Vehicle Registration Form</h2>

			<div class="container d-flex justify-content-center p-2">

				<form:form modelAttribute="vehicle">

					<div class="form-group">
						<form:input size="50%" path="vehicleName" class="form-control"
							placeholder="Vehicle Name" />
						<form:errors path="vehicleName" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<form:select path="vehicleType" class="form-control">
							<form:option path="vehicleType" value="null">Choose Vehicle Type:</form:option>
							<form:option path="vehicleType" value="cycle">Cycle</form:option>
							<form:option path="vehicleType" value="bike">Bike</form:option>
							<form:option path="vehicleType" value="car">Car</form:option>

						</form:select>
						<form:errors path="vehicleType" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<form:input path="vehicleNumber" class="form-control" type="text"
							placeholder="Vehicle Number" />
						<form:errors path="vehicleNumber" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<form:input path="empId" class="form-control" type="number"
							placeholder="Employee Id" />
						<form:errors path="empId" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<form:textarea path="identification" class="form-control"
							type="text" placeholder="Identification" />
						<form:errors path="identification" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<input class="btn btn-primary form-control" name="submit"
							type="submit" value="Submit" />
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<div class="container" align="center">
		<button class="btn btn-primary"
			onclick="window.location.href='showProfile'">Show Profile</button>
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