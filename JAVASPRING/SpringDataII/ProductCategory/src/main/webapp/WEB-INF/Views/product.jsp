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
		<h1>New product</h1>
		<div class="container">
		<form:form accept-charset="UTF-8" action="/products/new" method="post"
			modelAttribute="product">

			<p>
				<form:label path="name">Name:</form:label>
				<form:errors path="name" />
				<form:input id="input1" path="name" />
			</p>
			
			<p>
				<form:label path="description">Description:</form:label>
				<form:errors path="description" />
				<form:textarea id="input2" path="description" />
			</p>
			<p>
				<form:label path="price">Price:</form:label>
				<form:errors path="price" />
				<form:input id="input3" path="price" />
			</p>
			<input id="create" type="submit" value="Create" />
		</form:form>
	</div>
	</body>
</html>