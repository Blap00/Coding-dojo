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
        <div class="row">
            <div class="col-6">
                <h3>
                    Welcome,
                    <c:out value="${user.firstName}" />
                </h3>
            </div>
            <div class="col-6">
                <a href="logout">Logout!</a>
            </div>
        </div>
    </header>
    <main>
        <div class="row">
            <h5>Here are some of the events in your state!</h5>
        </div>
        <div class="row">
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Date</th>
                        <th>Location</th>
                        <th>Host</th>
                        <th>Action/status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${estadosEventos}" var="row">
                        <tr>
                            <td><a href="${row[5]}">${row[0]}</a></td>
                            <td>${row[1]}</td>
                            <td>${row[2]}</td>
                            <td>${row[3]}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${user.firstName eq row[3]}">
                                        <a href="${row[5]}/edit">edit</a>
                                        <a href="${row[5]}/delete">delete</a>
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${row[6] eq true}">
                                                <span>Joining</span>
                                                <a href="${row[5]}/cancel">cancel</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="${row[5]}/join">Join</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>

                    </c:forEach>

                </tbody>
            </table>
            <h5>Here are some of the events in other states</h5>
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Date</th>
                        <th>Location</th>
                        <th>State</th>
                        <th>Host</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${eventosDiferentes}" var="row">
                        <tr>
                            <td>${row[0]}</td>
                            <td>${row[1]}</td>
                            <td>${row[2]}</td>
                            <td>${row[3]}</td>
                            <td>${row[4].firstName}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${user.firstName eq row[3]}">
                                        <a href="${row[5]}/edit">edit</a>
                                        <a href="${row[5]}/delete">delete</a>
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${row[6] eq true}">
                                                <span>Joining</span>
                                                <a href="${row[5]}/cancel">cancel</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="${row[5]}/join">Join</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="row mx-4">
            <div class="col-lg-6 container-fluid">
                <form:form method="POST" action="/events/" modelAttribute="events" accept-charset="UTF-8">
                    <div class="row">
                        <form:label path="name">Name:</form:label>
                        <form:input path="name" />
                    </div>
                    <div class="row">
                        <form:label path="date">FDate:</form:label>
                        <form:input id="eventDate" type="date" path="date" />
                    </div>
                    <div class="row">
                        <div class="col-3">
                            <form:label path="location">Location:</form:label>
                        </div>
                        <div class="col-5">
                            <form:input path="location" />
                        </div>
                        <div class="col-4">
                            <form:select path="state">
                                <form:options items="${stateOptions}" />
                            </form:select>
                            <form:input path="host" style="display: none;" value="${userId}" />

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-4">
                            <input type="submit" value="Add an EVENT">
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </main>
    <footer class="container-fluid"> </footer>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous">

        </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
        integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous">

        </script>
</body>

</html>