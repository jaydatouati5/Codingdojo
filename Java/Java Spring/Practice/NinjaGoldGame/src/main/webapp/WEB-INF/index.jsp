<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/style.css">
<title>Ninja Gold Game</title>
</head>
<body>
	<div class="score">
        <h2>Your gold: </h2>
        <span><c:out value="${gold}" /> <span>🥇</span> </span>
    </div>

    <div class="dung-container">
        <div class="box">
            <div class="title">Farm</div>
            <p>(Earn 10-20 Gold!)</p>
            <form action="/play" method="post">
            	<input type="hidden" name="maxAmount" value="20">
            	<input type="hidden" name="minAmount" value="10">
            	<input type="hidden" name="name" value="farm">
                <input type="submit" value="Find Gold!">
            </form>
        </div>

        <div class="box">
            <div class="title">Cave</div>
            <p>(Earn 5-10 Gold!)</p>
            <form action="/play" method="post">
            	<input type="hidden" name="maxAmount" value="10">
            	<input type="hidden" name="minAmount" value="5">
            	<input type="hidden" name="name" value="cave">
                <input type="submit" value="Find Gold!">
            </form>
        </div>

        <div class="box">
            <div class="title">House</div>
            <p>(Earn 2-5 Gold!)</p>
            <form action="/play" method="post">
            	<input type="hidden" name="maxAmount" value="5">
            	<input type="hidden" name="minAmount" value="2">
            	<input type="hidden" name="name" value="house">
                <input type="submit" value="Find Gold!">
            </form>
        </div>

        <div class="box">
            <div class="title">Quest</div>
            <p>(Earn/Takes 0-50 Gold!)</p>
            <form action="/play" method="post">
            	<input type="hidden" name="maxAmount" value="50">
            	<input type="hidden" name="minAmount" value="0">
            	<input type="hidden" name="name" value="quest">
                <input type="submit" value="Find Gold!">
            </form>
        </div>
    </div>

    <div>
        <h2>Activities: </h2>
        <div class="history">
			<c:forEach var="log" items="${logs}">
				<p style="color: ${log[0]}"> <c:out value="${log[1]}" /> </p>
			</c:forEach>
        </div>
    </div>	
</body>
</html>