<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Class</title>
</head>
<body>
	<h1>${classe.name}</h1>
	<h2>Students taking this class:</h2>
	<table>
		<thead>
			<tr>
				<th>Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${classe.students}" var="student">
				<tr>
					<td>
						<h4>
							<c:out value="${student.firstName}" />
							<c:out value="${student.lastName}" />
						</h4>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tbody>
		</tbody>
	</table>
</body>
</html>
