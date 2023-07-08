<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Cat Details</title>
</head>
<body>
    <c:if test="${not empty cat}">
        <h2>${cat.showAffection()}</h2>
    </c:if>
</body>
</html>
