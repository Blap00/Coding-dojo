<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">

<head>
    <title>New Dojo</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

</head>

<body>
    <header>
        <h1>New Dojo</h1>
    </header>
    <main>
        <form:form accept-charset="UTF-8" action="/dojos/new" method="post" modelAttribute="Dojo">
            <div class="quest" id="quest1">
                <div id="pregunta1">
                    <form:label path="name">Name: </form:label>
                    <form:input type="text" path="name" /> <!-- Añadido el / para que sea un tag vacío -->
                </div>
                <form:errors path="name" />
            </div>

            <input type="submit" value="Create" />
        </form:form>
    </main>
    <footer>
        <!-- TESTING AREA
        <h1>Test Sended dojos</h1>
        <table>
            <thead>
                <tr>
                    <th>
                        Name of the dojo created by user
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${dojoList}" var="dojo">
                    <tr>
                        <td>
                            ${dojo.name}
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table> -->
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