<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Burger Tracker</title>
</head>
<body>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Burger Name</th>
				<th>Restaurant Name</th>
				<th>Rating (out of 5)</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="burger" items="${burgers}">
				<tr>
					<td><c:out value="${burger.burgerName}"></c:out></td>
					<td><c:out value="${burger.restaurantName}"></c:out></td>
					<td><c:out value="${burger.rating}"></c:out></td>
					<td><a href="/burgers/${burger.id}/edit">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h1>Add a Burger</h1>
	<form:form action="/" method="post" modelAttribute="burger">
		<p>
			<form:label path="burgerName">Burger Name</form:label>
			<form:errors path="burgerName" />
			<form:input path="burgerName" />
		</p>
		<p>
			<form:label path="restaurantName">Restaurant Name</form:label>
			<form:errors path="restaurantName" />
			<form:input path="restaurantName" />
		</p>
		<p>
			<form:label path="rating">Rating</form:label>
			<form:errors path="rating" />
			<form:input path="rating" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>