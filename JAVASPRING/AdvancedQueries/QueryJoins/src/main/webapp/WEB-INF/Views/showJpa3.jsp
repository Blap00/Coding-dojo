
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<table class="table">
    <thead>
        <th>Nombre del País</th>
        <th>Nombre de la Ciudad</th>
        <th>Distrito</th>
        <th>Poblacion</th>
    </thead>
    <tbody>
        <c:forEach var="row" items="${table}">                
        <tr>
            <td>${row[0].name}</td>
			<td>${row[1].name}</td>
			<td>${row[1].district}</td>
			<td>${row[1].population}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
