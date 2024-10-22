<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Omikuji Show</title>
</head>
<body class="body-container">
	<h1>Here's your omikuji!</h1>
	<p class="message-container"> 
		<c:out value="${message}"/>
	</p>
	<a href="/omikuji">Go Back</a>
</body>
</html>