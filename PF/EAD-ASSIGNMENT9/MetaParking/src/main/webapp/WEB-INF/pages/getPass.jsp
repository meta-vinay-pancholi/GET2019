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
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Get Pass</title>
</head>
<body>
<div class="p-3 mb-2 bg-primary text-white jumbotron" align="center">
		<h1 class="display-4">Choose Your Pass!!</h1>
	</div>
	<div class="container p-2" align='center'>
		<form:form modelAttribute="pass" action="/getPass" >
			<p>1. Select Plans in (USD)</p>
			<div class="form-group">
			<form:select path="plan" class="form-control">
				<form:options items="${passPrices}" />
			</form:select>
			<form:errors path="plan" />
			
			</div>
			

			<p>2. Do You Want To Change Currency</p>
		<div class="form-group">
			<form:select path="currency" align='center' class="form-control ">
				<form:option value="USD">USD</form:option>
				<form:option value="INR">INR</form:option>
				<form:option value="YEN">YEN</form:option>
			</form:select>
		</div>
			<input class="btn btn-primary" type='submit' value='GetPass' />
		</form:form>
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