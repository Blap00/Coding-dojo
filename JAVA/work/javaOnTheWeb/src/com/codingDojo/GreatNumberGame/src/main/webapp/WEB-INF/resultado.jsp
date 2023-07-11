<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Great Number Game</title>
</head>
<body>
    <h1>Great Number Game</h1>
    <p>${message}</p>
    <form action="guess" method="post">
        <label for="guess">Ingresa tu número:</label>
        <input type="number" id="guess" name="guess" required>
        <button type="submit">Adivinar</button>
    </form>
</body>
</html>
