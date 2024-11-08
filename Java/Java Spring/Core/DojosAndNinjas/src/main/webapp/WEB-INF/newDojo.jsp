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
<title>New Dojo</title>
</head>
<body>  
    <h1>New Dojo</h1>
    <form:form action="/dojos" method="post" modelAttribute="dojo">
        <p>
            <form:label path="name">Name</form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p>
        <input type="submit" value="Create" class="btn btn-primary">
    </form:form>
</body>
</html>