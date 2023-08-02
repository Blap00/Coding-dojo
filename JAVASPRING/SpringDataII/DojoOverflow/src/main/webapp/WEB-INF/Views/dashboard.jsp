<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question Dashboard</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Question</th>
				<th>Tags</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${questions}" var="question">
				<tr>
					<td><a href="/questions/${question.id}"><c:out
								value="${question.quest}" /></a></td>
					<td><c:forEach items="${question.tags}" var="tag"
							varStatus="loop">
                        ${tag.subject}<c:if test="${not loop.last}">, </c:if>
						</c:forEach></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/questions/new">New question!</a>
</body>
</html>