<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration and Login Page</title>

</head>
<body>
	<!----------------- REGISTRATION-------------------->
	<div>
		<h1>Register!</h1>
		<p>
			<form:errors path="user.*" />
		</p>
		<form:form method="POST" action="/log" modelAttribute="user">
			<p>
				<form:label path="firstName">First Name:</form:label>
				<form:input type="text" path="firstName" />
			</p>
			<p>
				<form:label path="lastName">Last Name:</form:label>
				<form:input type="text" path="lastName" />
			</p>
			<p>
				<form:label path="email">Email:</form:label>
				<form:input type="email" path="email" />
			</p>

			<p>
				<form:label path="password">Password:</form:label>
				<form:password path="password" />
			</p>
			<p>
				<form:label path="passwordConfirmation">Password Confirmation:</form:label>
				<form:password path="passwordConfirmation" />
			</p>
			<input style="display: none" name="action" value="action">
			<button type="submit" name="action" value="register">Register!</button>
		</form:form>
	</div>
	<!------------------------LOGIN---------------------------->
	<div>
		<h1>Login</h1>
		<p>
			<c:out value="${error}" />
		</p>
		<form:form method="POST" action="/log" modelAttribute="user">
			<p>
				<form:label path="email">Email: </form:label>
				<form:input path="email" />
			</p>
			<p>
				<form:label path="password">Password: </form:label>
				<form:input path="password" type="password" />
			</p>
			<button type="submit" name="action" value="login">Login!</button>
		</form:form>
	</div>
</body>
</html>
