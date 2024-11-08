<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Expense</title>
</head>
<body style="padding: 0 100px;">
	<div style="display: flex; justify-content: space-between;">
		<h1>Expense Details</h1>
		<a href="/expenses">Back</a>
	</div>
	<p>Expense Name: <c:out value="${expense.name}"></c:out></p>
	<p>Expense Description: <c:out value="${expense.description}"></c:out></p>
	<p>Expense Vendor: <c:out value="${expense.vendor}"></c:out></p>
	<p>Expense Amount: <c:out value="${expense.amount}"></c:out></p>
</body>
</html>