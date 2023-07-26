<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <title>Detalles de la Persona</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>

<body>
    <h1>Detalles de la Persona</h1>
    <p><strong>Nombre:</strong> ${person.firstName} ${person.lastName}</p>
    <p><strong>License Number:</strong> ${license.id}</p>
    <p><strong>State:</strong> ${license.state}</p>
    <p><strong>Expiration Date:</strong> ${license.expirationDate}</p>
    
</body>

</html>