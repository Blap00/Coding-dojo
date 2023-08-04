
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
	
<h1>consulta para obtener todas las ciudades Argentinas con poblacion superior a 500000</h1>
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
            <td>${row[0]}</td>
			<td>${row[1]}</td>
			<td>${row[2]}</td>
			<td>${row[3]}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
