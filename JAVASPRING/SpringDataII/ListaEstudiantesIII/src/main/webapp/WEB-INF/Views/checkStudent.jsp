<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Student</title>
</head>
<body>

	<form:form accept-charset="UTF-8"
		action="/api/students/${student.id}/add" method="post"
		modelAttribute="student">
		<form:label path="classes">Classes:</form:label>
		<form:select path="classes">
			<c:forEach var="classNotInStudent" items="${classesNotInStudent}">
				<form:option value="${classNotInStudent.id}">${classNotInStudent.name}</form:option>
			</c:forEach>
		</form:select>
		<input type="submit" value="Add" />
	</form:form>
	<script>
		// Define una función para quitar el atributo "multiple" del select
		function disableMultipleAttribute() {
			// Obtiene el elemento select por su ID
			var classSelect = document.getElementById("classes");
			// Verifica si el elemento select existe
			if (classSelect) {
				// Deshabilita el atributo "multiple" del elemento select
				classSelect.removeAttribute("multiple");
			}
		}

		// Llama a la función para quitar el atributo "multiple" al cargar el documento
		disableMultipleAttribute();
	</script>


	<h3>Your shedule; </h3	>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${student.classes}" var="classe">
				<tr>
					<td><c:out value="${classe.name}" /></td>
					<td>
						<form action="/api/students/${student.id}/remove" method="POST">
							<input type="hidden" name="classeId" value="${classe.id}" />
							<button type="submit">Eliminar</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
