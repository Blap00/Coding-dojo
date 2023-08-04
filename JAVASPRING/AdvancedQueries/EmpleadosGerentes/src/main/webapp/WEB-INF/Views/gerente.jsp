<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gerencias</title>
</head>
<body>
	<table>
		<thead>

			<tr>
				<th>Nombre del personal:</th>
				<th>Id del manager:</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${employees}" var="row">
			<tr>
				<td>${row[0].firstName} ${row[0].lastName}</td>
				<td>${row[1]}</td>
			</tr>
		</c:forEach>					
		</tbody>
	</table>
</body>
</html>