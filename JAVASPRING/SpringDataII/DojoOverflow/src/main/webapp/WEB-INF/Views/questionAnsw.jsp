<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question Details</title>
</head>
<body>
	<h1>${question.quest}</h1>
	<h2>Select Tags:</h2>
	<ul>
		<c:forEach var="tag" items="${question.tags}">
			<li>${tag.subject}</li>
		</c:forEach>
	</ul>

	<c:if test="${not empty answers}">
		<table>
			<thead>
				<tr>
					<th>Answers</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${answers}" var="answer">
					<tr>
						<td>${answer.answerText}</td>
						<!-- Cambio aquí -->
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>

	<h2>Add your answer</h2>
	<form:form action="/questions/${question.id}/post" method="post"
		modelAttribute="answer">
		<div>
			<label for="answerText">Your Answer:</label>
			<form:input type="text" path="answerText" required="true" />
		</div>
		<div>
			<input type="submit" value="Answer It">
		</div>
	</form:form>
</body>
</html>
