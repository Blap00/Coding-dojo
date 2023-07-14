<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dojo Survey Index</title>
    <link rel="stylesheet" href="css/styleResult.css">
    <style>
        

    </style>
</head>

<body>
    <div class="container" id="FormsArea">
        <table>
            <thead>
                <tr>
                    <th rowspan="2">
                        <u>Submitted info:</u>
                    </th>
                </tr>
            </thead>
            <tr>
                <td>
                    Name:
                </td>
                <td>
                    <c:out value="${name}" />               
                </td>
            </tr>
            <tr>
                <td>
                    Dojo Location:
                </td>
                <td>
                    <c:out value="${dojoLoc}" />               
                </td>
            </tr>
            <tr>
                <td>
                    Favorite Language:
                </td>
                <td>
                    <c:out value="${favLang}" />!!!               
                </td>
            </tr>
            <tr>
                <td>
                    Comment:
                </td>
                <td>
                    <c:out value="${commentarea}" />               
                </td>
            </tr>
        </table>
        <!-- Button to go back -->
        <a href="/"><button type="submit">Go Back</button></a>
    </div>
</body>

</html>
