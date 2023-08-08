<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">

<head>
	<title>Title</title>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS v5.2.1 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

</head>

<body class="container-fluid">
	<header>
		${event.name}
	</header>
	<main>

		<form:form class="container-fluid" style="width: 40%;" method="POST" action="/events/${event.id}/edit" modelAttribute="event" accept-charset="UTF-8">
			<div class="row">
				<div class="col-4">
					<form:label path="name">Name :</form:label>
				</div>
				<div class="col-8">
					<form:input path="name"></form:input>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<form:errors path="name"/>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<form:label path="date">Date :</form:label>
				</div>
				<div class="col-8">
					<form:input type="date" path="date"></form:input>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<form:errors path="date"/>
				</div>
			</div>
			<div class="row">
				<div class="col-3">
					<form:label path="Location">Location :</form:label>
				</div>
				<div class="col-5">
					<form:input path="Location"></form:input>
				</div>
				<div class="col-4">
					<form:select path="state">
						<form:options items="${stateOptions}" />
					</form:select>
					<form:input path="host" style="display: none;" value="${userId}" />
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<form:errors path="Location"/>
				</div>
			</div>
			<input type="submit" value="Edit">
		</form:form>
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