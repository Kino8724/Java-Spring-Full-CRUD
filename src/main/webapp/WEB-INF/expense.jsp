<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<!-- path Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- path any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Expense View</title>
</head>
<body>
<div class="container">
	<div class="header d-flex align-items-center justify-content-between">
		<h1>Edit Expense</h1>
		<a href="/expenses">Go Back</a>
	</div>
	<div class="w-25">
		<div class="d-flex flex-column gap-3">
			<div class="d-flex align-items-center justify-content-between">
				<h2>Name:</h2>
				<p class="h3"><c:out value="${expense.name}"></c:out></p>
			</div>
			<div class="d-flex align-items-center justify-content-between">
				<h2>Vendor:</h2>
				<p class="h3"><c:out value="${expense.vendor}"></c:out></p>
			</div>
			<div class="d-flex align-items-center justify-content-between">
				<h2>Amount:</h2>
				<p class="h3"><c:out value="${expense.amount}"></c:out></p>
			</div>
				</div>
		</div>
				<div class="w-50 mt-3">
				<div class="d-flex flex-column">
					<h2 class="text-decoration-underline">Description:</h2>
					<p class="h3"><c:out value="${expense.description}"></c:out></p>
				</div>
				</div>
</div>
</body>
</html>