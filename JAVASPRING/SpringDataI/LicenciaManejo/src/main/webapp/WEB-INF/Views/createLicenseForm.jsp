<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Crear Licencia</title>
</head>
<body>
    <h1>Crear Licencia</h1>
    <form action="/licenses/create" method="post">
        <label for="personId">ID de la Persona:</label>
        <select name="personId" id="personId">
            <c:forEach items="${persons}" var="person">
                <option value="${person.id}">${person.firstName} ${person.lastName}</option>
            </c:forEach>
        </select><br>

        <label for="state">Estado:</label>
        <input type="text" name="state" id="state" required><br>

        <label for="expirationDate">Fecha de Caducidad:</label>
        <input type="date" name="expirationDate" id="expirationDate" required><br>

        <input type="submit" value="Crear">
    </form>
</body>
</html>
