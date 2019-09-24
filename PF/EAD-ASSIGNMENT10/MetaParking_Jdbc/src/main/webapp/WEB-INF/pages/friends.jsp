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
		<h1 class="display-4">Showing Your Friends</h1>
	</div>
	<div id="card" class="space">
	<div class="container">
		<div class="row">
		 <c:if test="${not empty EmployeeFriend}">
    			 <c:forEach var="employeeFrnd" items="${EmployeeFriend}" varStatus="loopcounter">
			<div class="col-md-3 profileCARD">
    			<div class="userdetails text-center">
					<div class="img">
							  <img  src="/image/${employeeFrnd.profile}" class="rounded img-fluid" alt="${employeeFrnd.fullname}" heigth="150" width=""150">
					</div>
					<div class="name">
					 <a href="friendProfile/${employeeFrnd.id}"><h5>${employeeFrnd.fullname}</h5></a>
					</div>
				</div>	
			</div>
			</c:forEach>
	 	 </c:if>
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