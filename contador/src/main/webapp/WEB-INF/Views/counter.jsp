<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome, again</title>
</head>
<body>
    <h2>You have visited <a href="/">www.localhost:8080/</a><span id="times"> <c:out value="${counter}"/></span></h2>
    <h3><a href="/">Test another visit?</a></h3>
    <h3><a href="/plustTwo">Add 2 visits more!</a></h3>
    <h3><a href="/reset">Reset your visits ;D</a></h3>
</body>
</html>