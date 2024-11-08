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
<title>Edit Expense</title>
</head>
<body style="padding: 0 100px;">
	<div style="display:flex; justify-content: space-between;">
		<h1>Add an Expense</h1>
		<a href="/expenses">Back</a>
	</div>
	<form:form action="/expenses/${expense.id}" method="post" modelAttribute="expense">
		<input type="hidden" name="_method" value="put">
		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name" style="color:red; display: block;" />
			<form:input path="name" />
		</p>
		<p>
			<form:label path="vendor">Vendor</form:label>
			<form:errors path="vendor" style="color:red; display: block;" />
			<form:input path="vendor" />
		</p>
		<p>
			<form:label path="amount">Amount</form:label>
			<form:errors path="amount" style="color:red; display: block;" />
			<form:input path="amount" />
		</p>
		<p>
			<form:label path="description">Description</form:label>
			<form:errors path="description" style="color:red; display: block;" />
			<form:textarea path="description" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>