<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="container">
			<h1>New Category</h1>
			<form:form action="/categories/new" method="post" modelAttribute="category">
				<p>
					<form:label path="name">Name:</form:label>
					<form:errors path="name" />
					<form:input class="input1" path="name" />
				</p>
				
				<input type="submit" value="Create" id="create1" />
			</form:form>
		</div>
	</body>
</html>