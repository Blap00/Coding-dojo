<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employer</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Nombre del empleado</th>
                <th>¿Es manager?</th>
                <c:if test="${row[1] eq 'No'}">
                    <th>Nombre del manager</th>
                </c:if>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${employeeData}" var="row">
                <tr>
                    <td>${row[0].firstName} ${row[0].lastName}</td>
                    <td>${row[1]}</td>
                    <c:if test="${row[1] eq 'No'}">
                        <td>${manager.firstName} ${manager.lastName}</td>
                    </c:if>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
