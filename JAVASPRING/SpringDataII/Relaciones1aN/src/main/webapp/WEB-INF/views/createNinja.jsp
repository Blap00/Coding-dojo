<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!doctype html>
<html lang="en">

<head>
    <title>New Ninja</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

</head>

<body>
    <header>
        <h1>New Ninja</h1>
    </header>
    <main>
        <form:form accept-charset="UTF-8" action="/ninjas/new" method="post" modelAttribute="ninja">
            <p>
                <div class="labelQuest">
                    Dojo:
                    <select name="dojo" id="dojo">
                    <c:forEach items="${dojos}" var="dojo">
                          <option value="${dojo.id}">${dojo.name} </option>
                     </c:forEach>
                   </select>     
                </div>
                <div class="errorQuest">

                </div>
            </p>
            <p>
                <div class="labelQuest">
                    <form:label path="firstName">First Name:</form:label>
                    <form:errors path="firstName"/>    
                </div>
                <div class="errorQuest">
                    <form:input path="firstName"/>
                </div>
            </p>
           <p>
                <div class="labelQuest">
                    <form:label path="lastName">Last Name:</form:label>
                    <form:input path="lastName"/>
                </div>
                <div class="errorQuest">
                    <form:errors path="lastName"/>
                </div>
            </p>
              <p>
                <div class="labelQuest">
                    <form:label path="age">Age:</form:label>
                    <form:input type="number" path="age"/>
                </div>
                <div class="errorQuest">
                    <form:errors path="age"/>
                </div>
            </p>
        
            <input type="submit" value="Create"/>
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