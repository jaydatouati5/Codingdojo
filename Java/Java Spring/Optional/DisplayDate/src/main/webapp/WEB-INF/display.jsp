<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title><c:out value="${title}"/></title>
</head>
<body>
	<h1>
		<c:out value="${content}"></c:out>
	</h1>
	
	<script>
		alert(`This is the ${title} template`);
	</script>
</body>
</html>