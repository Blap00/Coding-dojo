<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
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

<body>
    <header>
        <h1>New License</h1>
    </header>
    <main>
        <form:form accept-charset="UTF-8" action="/licenses/create" method="post" modelAttribute="license">
            <!-- <p>
                Person
                <select name="persons" id="persons">
                    <c:forEach items="${persons}" var="person">
                        <option value="${person.id}">${person.firstName} ${person.lastName}</option>
                    </c:forEach>
                </select>
            </p> -->
            <p>
                Person
                <select name="person" id="person">
                    <c:forEach items="${persons}" var="person">
                        <option value="${person.id}">${person.firstName} ${person.lastName}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <form:label path="state">State</form:label>
                <form:errors path="state" />
                <form:textarea path="state" />
            </p>
            <p>
                <form:label path="expirationDate">Expiration Date</form:label>
                <form:errors path="expirationDate" />
                <input type="date" id="expirationDate" name="expirationDate">
            </p>

            <input type="submit" value="Create" />
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