
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<table class="table">
    <thead>
        <th>Nombre del Pa�s</th>
        <th>Lenguaje</th>
        <th>Porcentaje</th>
    </thead>
    <tbody>
        <c:forEach var="row" items="${table}">                
        <tr>
            <td>${row[0].name}</td>
			<td>${row[1].language}</td>
			<td>${row[1].percentage}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
