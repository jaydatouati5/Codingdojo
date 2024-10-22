<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji</title>
</head>
<body>
<h1>Send one omikuji!</h1>
<form action="/omikuji/form" method="POST" style="display: flex; flex-direction: column; width: 30%">
	<label>Pick any number from 5 to 25</label>
	<input type="number" name="number" min="5" max="25">

	<label>Enter a name for any city</label>
	<input type="text" name="city">
	
	<label>Enter the name of any real person</label>
	<input type="text" name="person">
	
	<label>Enter a professional endeavor or hobby</label>
	<input type="text" name="hobby">
	
	<label>Enter any type of living thing</label>
	<input type="text" name="living">
	
	<label>Say something nice to someone</label>
	<textarea rows="5" name="message"></textarea>


	<label>Send and show a friend</label>
	<input type="submit" value="Send">	
	
</form>

</body>
</html>