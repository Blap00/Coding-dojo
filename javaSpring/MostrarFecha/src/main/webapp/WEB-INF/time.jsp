<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Time</title>
    <script src="js/scriptTime.js"></script>
    <link rel="stylesheet" href="css/stylefiles.css">
</head>
<body>
    <p id="time">
        <c:out value="${dateTime}"/>    
    </p>

</body>
</html>