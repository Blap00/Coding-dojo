<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagination</title>
</head>
<body>
	<div id="ninjas">
		<h1>Ninjas</h1>

		<c:forEach begin="1" end="${totalPages}" var="index">
			<a href="/pages/${index}">${index}</a>
		</c:forEach>
		<table class="table">
			<thead>
				<th>First Name</th>
				<th>Last Name</th>
			</thead>
			<tbody>
				<c:forEach var="ninja" items="${ninjas.content}">
					<tr>
						<td><c:out value="${ninja.firstName}"></c:out></td>
						<td><c:out value="${ninja.lastName}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>