<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dojo Survey Index</title>
    <link rel="stylesheet" href="css/styleIndex.css">
</head>

<body>
    <div class="container" id="msgErrorA">
        <c:out value="${error}" />
    </div>
    <div class="container" id="FormsArea">
        <form action="/checkForm" method="post">
            <label class="labelmodify" for="name">Your Name:
                <input type="text" name="name" id="nameinput">
            </label><br />
            <label class="labelmodify" for="dojoLoc">Dojo Location:
                <select name="dojoLoc" id="dojoLocation">
                    <option value="San Jose" selected>San Jose</option>
                </select>
            </label><br />
            <label class="labelmodify" for="favLang">Favorite Language:
                <select name="favLang" id="favoriteLang">
                    <option value="Python" selected>Python</option>
                    <option value="Java">Java</option>
                </select>
            </label><br />
            <label for="commentarea">Comments (optional)</label> <br>
            <textarea name="commentarea" id="commentarea" cols="30" rows="5"></textarea>
            <br>
            <button type="submit">Button</button>
        </form>
    </div>
</body>

</html>