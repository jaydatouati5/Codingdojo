<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Show Dojo</title>
</head>
<body>
    <h1><c:out value="${dojo.name}"></c:out></h1>
    <table class="table">
        <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="ninja" items="${dojo.ninjas}">
                <tr>
                    <td><c:out value="${ninja.firstName}"></c:out></td>
                    <td><c:out value="${ninja.lastName}"></c:out></td>
                    <td><c:out value="${ninja.age}"></c:out></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>