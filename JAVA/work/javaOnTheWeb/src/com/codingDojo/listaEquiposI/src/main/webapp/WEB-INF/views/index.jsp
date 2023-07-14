<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">

	<head>
		<title>Roster</title>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<!-- Bootstrap CSS v5.2.1 -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
			integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
		<style>
			body{
				display: flex;
    			flex-direction: column;
    			align-items: center;
			}	
		</style>
	</head>

	<body>
		<header>
			<div class="row">
				<div class="col-md-6">
					<h4>Prototype Roster</h4>
				</div>
				<div class="col-md-6">
					<h4><a href = "/listaEquiposI/Teams">Add New Team</a></h4>
				</div>
			</div>
		</header>
		<main>
			<table>
				<thead>
					<tr>
						<th>
							<h4>Team</h4>
						</th>
						<th>
							<h4>Players</h4>
						</th>
						<th>
							<h4>Action</h4>
						</th>
					</tr>
				</thead>
				<tbody>
					<% int index = 0; %>
					<c:forEach var = "team" items = "${roster.getTeams()}">
					<tr>
						<td><c:out value = "${team.team_name}"/></td>
						<td><c:out value = "${fn:length(team.players)}"/></td>
						<td><a href = "/listaEquiposI/Teams?id=<%= index %>">Details</a>
						<a href = "/listaEquiposI/deleteteam?id=<%= index %>">Delete</a>
						</td>
					</tr>
					<% index++; %>
					</c:forEach>
				</tbody>
			</table>
		</main>
		<footer>
			<!-- place footer here -->
		</footer>
		<!-- Bootstrap JavaScript Libraries -->
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
			integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous">
			</script>

		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
			integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous">
			</script>
	</body>

	</html>