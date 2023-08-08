<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!doctype html>
<html lang="en">

<head>
    <title>Login</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

    <style>
        .row > .container-fluid{
            border: 1px solid black;
        }
        .container-fluid > .row{
            margin-left: 1vw;
            margin-right: 1vw;
        }
    </style>
</head>

<body>
    <main>
        <div class="row container-fluid ">
            Welcome!
        </div>
        <br>
        <div class="row mx-4">
            <div class="col-lg-6 container-fluid">
                REGISTER
            	<form:form method="POST" action="/register" modelAttribute="user" accept-charset="UTF-8">
            		<div class="row">
	            		<form:label path="firstName">First Name:</form:label>
						<form:input path="firstName"/>
                    </div>
                    <div class="row">
	            		<form:label path="lastName">Last Name:</form:label>
						<form:input path="lastName"/>
                    </div>
                    <div class="row">
	            		<form:label path="email">email:</form:label>
						<form:input path="email"/>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <form:label path="location">Location:</form:label>
                            <form:input path="location"/>
                        </div>
                        <div class="col-6">
                            <div class="col-6">
                                <form:label path="state">State:</form:label>
                                <form:select path="state">
                                    <form:options items="${stateOptions}" />
                                </form:select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
	            		<form:label path="password">Password:</form:label>
						<form:input type="password" path="password"/>
                    </div>
                    <div class="row">
	            		<form:label path="passwordConfirmation">PW Conf.</form:label>
						<form:input type="password" path="passwordConfirmation"/>
                    </div>
                    <div class="row">
                        <input type="submit" value="Register!"/>                                            
                    </div>
            	</form:form>

            </div>
            <div class="col-lg-6 container-fluid">
                Login
                <form:form method="POST" action="/" modelAttribute="user" accept-charset="UTF-8">
                    <div class="row">
                        <form:label path="email">Email :</form:label>
                        <form:input path="email"/>
                    </div>
                    <div class="row">
                        <form:label path="password">Password :</form:label>
                        <form:input path="password"/>
                    </div>
                    <div class="row">
                        <input type="submit" value="Login!">
                    </div>
                </form:form>
            </div>
            
        </div>
    </main>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous">
        </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
        integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous">
        </script>
</body>

</html>