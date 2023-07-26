<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Detalles de la Licencia</title>
</head>
<body>
    <h1>Detalles de la Licencia</h1>
    <p><strong>Número de Licencia:</strong> ${license.number}</p>
    <p><strong>Estado:</strong> ${license.state}</p>
    <p><strong>Fecha de Caducidad:</strong> ${license.expirationDate}</p>
</body>
</html>
