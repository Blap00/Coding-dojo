<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Random Word Generator</title>
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
    <h1>Random Word Generator</h1>
    <p>Random Word: <%= request.getAttribute("randomWord") %></p>
    <p>Generated Count: <%= request.getAttribute("counter") %></p>
    <p>Last Generated Time: <%= request.getAttribute("lastGeneratedTime") %></p>
    <form action="randomWord" method="get">
        <button type="submit">Generate</button>
    </form>
</body>
</html>
