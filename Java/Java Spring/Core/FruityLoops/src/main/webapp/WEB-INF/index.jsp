<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/style.css">
<title>Fruit Store</title>
</head>
<body>
	<h1>Fruit Store</h1>
	
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="fruit" items="${fruits}">
				<tr>
					<td><c:out value="${fruit.name}" /></td>
					<td><c:out value="${fruit.price}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>