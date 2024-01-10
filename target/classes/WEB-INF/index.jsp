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
<title>Expenses View</title>
</head>
<body>
	<div class="container">
		<h1 class="text-primary">Save Travels</h1>
		
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${allExpenses}">
					<tr>
						<td><a href="/expense/${expense.id}"><c:out value="${expense.name}"></c:out></a></td>
						<td><c:out value="${expense.vendor}"></c:out></td>
						<td><c:out value="${expense.amount}"></c:out></td>
						<td><a class="btn btn-sm btn-primary" href="expense/edit/${expense.id}">Edit</a> |
							<form class="d-inline" action="/expense/delete/${expense.id}" method = "post">
							    <input type="hidden" name="_method" value="delete">
		    						<input class="btn btn-sm btn-danger" type="submit" value="Delete">
							</form>
						</td>
					</tr>	
				</c:forEach>
			</tbody>
		</table>
		<h2 class="text-primary">Add an Expense</h2>
		<div class="w-25">
			<form:form action="/expense/new" method="post" modelAttribute="expense" class="d-flex flex-column gap-3">
				<form:label path="name">Name</form:label>
				<form:errors path="name" class="text-danger"></form:errors>
				<form:input type="text" path="name" id="name" />
				<br />
				<form:label path="vendor">Vendor</form:label>
				<form:errors path="vendor" class="text-danger"></form:errors>
				<form:input type="text" path="vendor" id="vendor" />
				<br />
				<form:label path="amount">Amount</form:label>
				<form:errors path="amount" class="text-danger"></form:errors>
				<form:input type="number" step="0.01" path="amount" id="amount"/>
				<br />
				<form:label path="description">Description</form:label>
				<form:errors path="description" class="text-danger"></form:errors>
				<form:textarea rows="5" cols="20" path="description" id="description"></form:textarea>
				<div class="button text-end">
					<input class="btn btn-primary" type="submit" value="Add" />
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>