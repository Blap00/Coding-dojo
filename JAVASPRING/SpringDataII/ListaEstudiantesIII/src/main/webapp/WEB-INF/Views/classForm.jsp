<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New classes</title>
</head>
<body>
	<h1 class="text-center">Classes</h1>
	<form:form accept-charset="UTF-8" action="/api/classes/create" method="post" modelAttribute="classe" class="col">
		<p>
			<form:label path="name">name: </form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</p>
		<div class="text-center">
			<input class="btn btn-primary text-center my-2" type="submit" value="Submit" />
		</div>
	</form:form>
</body>
</html>