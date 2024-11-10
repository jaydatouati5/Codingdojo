<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Welcome!</h1>
    <p>Join our community.</p>
    <form:form action="/register" method="post" modelAttribute="newUser">
        <table>
            <tr>
                <td colspan="2">Register</td>
            </tr>
            <tr>
                <td>
                    <form:label path="userName">Username</form:label>
                    <form:errors path="userName"></form:errors>
                </td>
                <td>
                    <form:input path="userName"></form:input>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="email">Email</form:label>
                    <form:errors path="email"></form:errors>
                </td>
                <td>
                    <form:input path="email"></form:input>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="password">Password</form:label>
                    <form:errors path="password"></form:errors>
                </td>
                <td>
                    <form:input path="password"></form:input>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="confirm">Confirm Password</form:label>
                    <form:errors path="confirm"></form:errors>
                </td>
                <td>
                    <form:input path="confirm"></form:input>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit">
                </td>
            </tr>
        </table>
    </form:form>

    <form:form action="/login" method="post" modelAttribute="newLogin">
        <table>
            <tr>
                <td colspan="2">Login</td>
            </tr>
            <tr>
                <td>
                    <form:label path="email">Email</form:label>
                    <form:errors path="email"></form:errors>
                </td>
                <td>
                    <form:input path="email"></form:input>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="password">Password</form:label>
                    <form:errors path="password"></form:errors>
                </td>
                <td>
                    <form:input path="password"></form:input>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit">
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>