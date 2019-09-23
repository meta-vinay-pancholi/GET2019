<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>HomePage</title>
</head>
<body>

	<div class="p-3 mb-2 bg-warning text-dark jumbotron" align="center">
		<h1 class="display-4">${message}</h1>
	</div>

	<div class="container " align="center">
		<div class="card " style="width: 18rem;">
			<div class="card-body .bg-danger">
				<h5 class="card-title">Add Students</h5>
				<p class="card-text">This is to add student into database</p>
				<a href="/addStudent" class="btn btn-primary">Add Students</a>
			</div>
		</div>
		<div class="card" style="width: 18rem;">
			<div class="card-body .bg-danger">
				<h5 class="card-title">Show Students</h5>
				<p class="card-text">To show all student present in database</p>
				<a href="/showAllStudent" class="btn btn-primary">Show Students</a>
			</div>
		</div>
			<div class="card" style="width: 18rem;">
			<div class="card-body .bg-danger">
				<h5 class="card-title">Search Students</h5>
				<p class="card-text">To search student present in database</p>
				<a href="/search" class="btn btn-primary">Search Students</a>
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