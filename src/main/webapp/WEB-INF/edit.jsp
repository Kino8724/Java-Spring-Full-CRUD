<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<!-- path Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- path any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Edit Expense</title>
</head>
<body>
	<div class="container">
		<div class="header d-flex align-items-center justify-content-between">
		<h1 class="text-success">Edit Expense</h1>
		<a href="/expenses">Go Back</a>
		</div>
		<div class="w-25">
			<form:form action="/expense/${expense.id}" method="post" modelAttribute="expense">
				    <input type="hidden" name="_method" value="put">
				    <div>
				        <form:label class="form-label" path="name">Name</form:label>
				        <form:errors class="text-danger"  path="name"/>
				        <form:input class="form-control" path="name"/>
				    </div>
				    <div>
				        <form:label class="form-label" path="vendor">Vendor</form:label>
				        <form:errors class="text-danger"  path="vendor"/>
				        <form:input class="form-control" path="vendor"/>
				    </div>
				    <div>
				<form:label class="form-label" path="amount">Amount</form:label>
				<form:errors path="amount" class="text-danger"></form:errors>
				<form:input class="form-control" type="number" step="0.01" path="amount" id="amount"/>
				    </div>    
				    <div>
				        <form:label class="form-label" path="description">Description</form:label>
				        <form:errors class="text-danger"  path="description"/>
				        <form:textarea class="form-control" path="description"/>
				    </div>
				    <div class="mt-2 text-end">
				    	<input class="btn btn-sm btn-primary" type="submit" value="Submit"/>
				    </div>
				</form:form>
		</div>
	</div>
</body>
</html>