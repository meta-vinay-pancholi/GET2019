<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
<title>SignUpPage</title>
</head>
<body>
	<div align="center">
		<div class="p-3 text-white jumbotron bg-primary " align="center">
			<h1 class="display-4">Meta-Parking</h1>
		</div>
		<div id="application">
			<h2 class="display-4">Employee Registration form</h2>
			<div class="container d-flex justify-content-center p-2">
				<form:form modelAttribute="employee">

					<div class="space">
						<c:if test="${ not empty duplicateEmail}">
							<div class="alert alert-warning alert-dismissible">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<strong>Warning!</strong> ${duplicateEmail }
							</div>
						</c:if>
						<c:if test="${ not empty sqlException}">
							<div class="alert alert-danger alert-dismissible">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<strong>Danger!</strong> ${sqlException }
							</div>
						</c:if>
					</div>
					<div class="form-group">
								<form:input size="50%" path="fullname" class="form-control"
									placeholder="Name" type="text" id="name" name="Name" />
								<form:errors path="fullname" cssClass="text-danger" />
							</div>

							<div class="form-group">
								<form:radiobutton path="gender" id="male" name="gender"
									value="male" checked="true" />
								<form:label path="gender" for="male" id="male">Male</form:label>
								<form:radiobutton path="gender" id="female" name="gender"
									value="female" />
								<form:label path="gender" for="female">Female</form:label>
								<form:errors path="gender" cssClass="text-danger" />
							</div>
							<div class="form-group">
								<form:input path="email" class="form-control"
									placeholder="Email" name="Email" type="email" />
								<form:errors path="email" cssClass="text-danger" />
							</div>

							<div class="form-group">
								<form:input path="contact" class="form-control"
									placeholder="Contact Number" />
								<form:errors path="contact" cssClass="text-danger" />
							</div>

							<div class="form-group">
								<form:select path="organisation" class="form-control"
									name="org_type" id="org_type">
									<form:option path="organisation" value="null">Choose organization</form:option>
									<form:option path="organisation" value="metacube">Metacube</form:option>
									<form:option path="organisation" value="tcs">Tcs</form:option>
									<form:option path="organisation" value="infosys">Infosys</form:option>
									<form:option path="organisation" value="samsung">Samsung</form:option>
									<form:option path="organisation" value="amazon">Amazon</form:option>
									<form:option path="organisation" value="microsoft">microsoft</form:option>

								</form:select>
								<form:errors path="organisation" cssClass="text-danger" />
							</div>
							<div class="form-group">
								<form:input path="password" class="form-control" type="password"
									placeholder="Password" name="Password" pattern=".{8,}" />
								<form:errors path="password" cssClass="text-danger" />
							</div>
							<div class="form-group">
								<form:input path="confirmPassword" class="form-control"
									type="password" placeholder="Confirm Password" />
								<form:errors path="confirmPassword" cssClass="text-danger" />
							</div>
							<div class="form-group">
								<input class="btn btn-primary form-control" name="submit"
									type="submit" value="Submit" />
							</div>
				</form:form>
			</div>
		</div>
	</div>
	<div align="center">
		<p>If Already Register</p>
		<input type="button" class="btn btn-primary " value="Login"
			onClick="window.location.href='home'" />
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