<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Save Travels</title>
</head>
<body>
	<h1>Save Travels</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="expense" items="${expenses}">
				<tr>
					<td><a href="/expenses/${expense.id}"><c:out value="${expense.name}"></c:out></a></td>
					<td><c:out value="${expense.vendor}"></c:out></td>
					<td><c:out value="${expense.amount}"></c:out></td>
					<td class="d-flex gap-3 align-items-center">
						<a href="/expenses/edit/${expense.id}">Edit</a>
						<form action="/expenses/${expense.id}" method="post">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="delete" class="btn btn-danger">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h1>Add an Expense</h1>
	<form:form action="/expenses" method="post" modelAttribute="expense">
		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name" style="color:red; display: block;"/>
			<form:input path="name" />
		</p>
		<p>
			<form:label path="vendor">Vendor</form:label>
			<form:errors path="vendor" style="color:red; display: block;"/>
			<form:input path="vendor" />
		</p>
		<p>
			<form:label path="amount">Amount</form:label>
			<form:errors path="amount" style="color:red; display: block;"/>
			<form:input path="amount" />
		</p>
		<p>
			<form:label path="description">Description</form:label>
			<form:errors path="description" style="color:red; display: block;"/>
			<form:textarea path="description" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>