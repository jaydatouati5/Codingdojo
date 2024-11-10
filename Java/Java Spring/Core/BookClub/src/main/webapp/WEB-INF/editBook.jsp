<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
    <header class="container d-flex justify-content-between align-items-center">
        <h1>Change your Entry</h1>
        <a href="/books">Back to the shelves</a>
    </header>
    <main class="container">
        <form:form action="/books/${book.id}" method="post" modelAttribute="book" class="d-flex gap-2 flex-column">
            <input type="hidden" name="_method" value="put">
            <input type="hidden" name="user" value="${book.user.id}">
            <div class="form-group">
                <form:label path="title">Title</form:label>
                <form:input path="title" class="form-control" placeholder="Enter Title"></form:input>
                <small class="form-text text-danger"><form:errors path="title"></form:errors></small>
            </div>
            <div class="form-group">
                <form:label path="author">Author</form:label>
                <form:input path="author" class="form-control" placeholder="Enter Author"></form:input>
                <small class="form-text text-danger"><form:errors path="author"></form:errors></small>
            </div>
            <div class="form-group">
                <form:label path="thoughts">My Thoughts</form:label>
                <form:textarea path="thoughts" class="form-control" placeholder="Enter Thoughts"></form:textarea>
                <small class="form-text text-danger"><form:errors path="thoughts"></form:errors></small>
            </div>
            <input type="submit" value="Submit" class="btn btn-primary">
        </form:form>
    </main>
</body>
</html>