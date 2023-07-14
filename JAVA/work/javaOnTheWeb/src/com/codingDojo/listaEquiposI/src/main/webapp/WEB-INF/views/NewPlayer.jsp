<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title><c:out value = "${team.getTeam_name()}"/> New Player</title>
			<!-- Bootstrap CSS v5.2.1 -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
			integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

		<style>
			#main {
				padding-left: 30px;
			}
		</style>
	</head>
	<body>
	<div id = "main">
		<% int index = Integer.parseInt(request.getParameter("id")); %>
		<h2>Add a new player to: <c:out value = "${team.getTeam_name()}"/> </h2>
		<br/>
		<form name = "guess" method = "post" action = "/listaEquiposI/Players?id=<%= index %>">
			<label for="first_name">First Name:</label>
			<input type = "text" name = "first_name"/>r
			<br/>
			<label for="last_name">Last Name:</label>
			<input type = "text" name = "last_name"/>
			<br/>
			<label for="age">Age:</label>
			<input type = "text" name = "age"/>
			<br/>
			<input type = "submit" value = "Añadir!"/>
		</form>
	</div>
</body>
</html>