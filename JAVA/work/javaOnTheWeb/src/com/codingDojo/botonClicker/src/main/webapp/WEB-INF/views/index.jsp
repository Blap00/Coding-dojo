<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Button Clicker</title>
    <style type="text/css">
        body {
            text-align: center;
        }

        h1 {
            margin-top: 8vh;
        }

        p {
            margin-bottom: 7vh;
        }

        button {
            background: aqua;
            width: 8vw;
            height: 6vh;
            font-size: 3vh;
            margin-bottom: 4vh;
        }
    </style>
</head>
<body>
    <h1>Button Clicker</h1>
    <p>Clicks: <%= request.getAttribute("counter") %></p>
    <form action="BotonClickerServlet" method="get">
        <button type="submit">Click me</button>
    </form>
    <a href="ClickerResultServlet">See Results</a>
</body>
</html>
