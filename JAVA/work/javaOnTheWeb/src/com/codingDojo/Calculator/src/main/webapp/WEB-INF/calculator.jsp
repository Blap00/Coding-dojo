<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calculator</title>
</head>
<body>
    <h1>Calculator</h1>

	<form action="${pageContext.request.contextPath}/calculator" method="POST">
    	<input type="text" name="currentNumber" value="${currentNumber}" readonly><br>

        <button name="character" value="7">7</button>
        <button name="character" value="8">8</button>
        <button name="character" value="9">9</button>
        <button name="character" value="+">+</button><br>

        <button name="character" value="4">4</button>
        <button name="character" value="5">5</button>
        <button name="character" value="6">6</button>
        <button name="character" value="-">-</button><br>

        <button name="character" value="1">1</button>
        <button name="character" value="2">2</button>
        <button name="character" value="3">3</button>
        <button name="character" value="*">*</button><br>

        <button name="character" value="0">0</button>
        <button name="character" value=".">.</button>
        <button name="character" value="=">=</button>
        <button name="character" value="/">/</button><br>

        <button name="character" value="C">C</button>
    </form>

    <h2>Results:</h2>
    <ul>
    <% List<String> results = (List<String>) request.getAttribute("results"); %>
    <% if (results != null) { %>
        <% for (String result : results) { %>
            <li><%= result %></li>
        <% } %>
    <% } %>
    </ul>
</body>
</html>
