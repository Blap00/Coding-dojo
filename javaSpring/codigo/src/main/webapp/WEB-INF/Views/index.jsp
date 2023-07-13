<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Secret Code</title>
    <link rel="stylesheet" href="css/styleindex.css">
</head>
<body>
    <div class="container" id="msgErrorA">
        <c:out value="${error}"/>
    </div>
    <div class="container" id="FormsArea">
        <form action="/checkCode" method="post">
            <label for="textAdd">What is the code?</label><br/>
            <input type="text" name="textAdd" id="secretCode"><br/>
            <button type="submit">Try Code</button>
        </form>
    </div>
</body>
</html>