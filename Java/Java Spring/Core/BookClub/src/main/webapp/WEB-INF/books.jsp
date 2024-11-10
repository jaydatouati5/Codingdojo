<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>All Books</title>
</head>
<body>
    <header class="container d-flex justify-content-between align-items-center">
        <h1>Welcome, <c:out value="${user.userName}"></c:out></h1>
        <a href="/logout" class="btn btn-danger">Logout</a>
    </header>
    <main class="container">
        <div class="d-flex justify-content-between align-items-center">
            <p>Books from everyone's shelves:</p>
            <a href="/books/new">+ Add a book to my shelf</a>
        </div>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Author Name</th>
                    <th>Posted By</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <th><c:out value="${book.id}"></c:out></th>
                        <th><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></th>
                        <th><c:out value="${book.author}"></c:out></th>
                        <th><c:out value="${book.user.userName}"></c:out></th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </main>
</body>
</html>