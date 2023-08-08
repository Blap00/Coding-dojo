<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>${eventData.name}</title>
	<!-- Bootstrap CSS v5.2.1 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
		<style>
			.comment-list {
				max-height: 15vw; /* Altura máxima deseada */
				overflow-y: auto; /* Scroll vertical si el contenido excede la altura */
				
			}
		</style>
</head>

<body class="container-fluid">
	<h1>${eventData.name}</h1>
	<div class="row container-fluid">
		<div class="col-6">
			<h2>Host ${eventData.host.firstName} ${eventData.host.lastName} </h2>
			<p>Date:
				<fmt:formatDate value="${eventData.date}" pattern="MMMM dd, yyyy" />
			</p>
			<p>Location: ${eventData.location}, ${eventData.state}</p>
			<p>People who are attending this event: ${attendeesCount}</p>

			<table>
				<thead>
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Location</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="confirmation" items="${confirmations}">
						<tr>
							<td>${confirmation.user.firstName} ${confirmation.user.lastName}</td>
							<td>${confirmation.user.location}, ${confirmation.user.state}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-6">
			<h3>Comentarios:</h3>
			<div class="comment-list">
				<ul class="list-group">
					<c:forEach var="comment" items="${comments}">
						<li class="list-group-item">${comment.content}- Por:
							${comment.user.firstName}</li>
					</c:forEach>
				</ul>
			</div>

			<h3>Agregar Comentario:</h3>
			<form:form modelAttribute="comment" action="${pageContext.request.contextPath}/events/${eventData.id}"
				method="post">
				<div class="form-group">
					<label for="commentContent">Contenido del Comentario:</label>
					<form:textarea class="form-control" id="commentContent" path="content" rows="4" required="true" />
				</div>
				<button type="submit" class="btn btn-primary">Enviar
					Comentario</button>
			</form:form>
		</div>
	</div>

	<!-- Bootstrap JavaScript Libraries -->
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous">

		</script>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
		integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous">

		</script>
</body>

</html>