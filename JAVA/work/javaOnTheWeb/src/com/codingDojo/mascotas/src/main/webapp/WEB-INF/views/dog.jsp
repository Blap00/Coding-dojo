<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Dog Details</title>
</head>
<body>
    <!-- <h1>Dog Details</h1> -->
    <c:if test="${not empty dog}">
    	<h1>You created a ${dog.breed}!</h1>
        <p>${dog.showAffection()}</p>
    </c:if>
</body>
</html>
