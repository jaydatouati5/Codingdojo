<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous">
            <title>Insert title here</title>
        </head>

        <body>
            <header class="container d-flex justify-content-between align-items-center">
                <h1>
                    <c:out value="${book.title}"></c:out>
                </h1>
                <a href="/books">Back to the shelves</a>
            </header>
            <main class="container">
                <h4>
                    <span style="color: red;">
                        <c:out value="${book.user.userName}"></c:out>
                    </span> read <span style="color: purple;">
                        <c:out value="${book.title}"></c:out>
                    </span> by 
                    <span style="color:green;">
                        <c:out value="${book.author}"></c:out>
                    </span>
                </h4>
                <h5>Here are <c:out value="${book.user.userName}"></c:out> thoughts:</h5>
                <hr>
                <p>
                    <c:out value="${book.thoughts}"></c:out>
                </p>
                <hr>
                <c:if test="${user.id == book.user.id}">
                    <a href="/books/${book.id}/edit" class="btn btn-primary">Edit</a>
                    <form action="/books/${book.id}" method="post">
                        <input type="hidden" name="_method" value="delete">
                        <input type="submit" value="Delete" class="btn btn-danger">
                    </form>
                </c:if>
            </main>
        </body>

        </html>