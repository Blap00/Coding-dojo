
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
	
<h1>consulta para obtener todos los países con un superficie de área inferior a 501 y una población mayor a 100.000</h1>
<table class="table">
    <thead>
        <th>Nombre del País</th>
        <th>Area de terreno del País</th>
        <th>Cantidad de gente en el País</th>
    </thead>
    <tbody>
        <c:forEach var="row" items="${table}">                
        <tr>
            <td>${row[0].name}</td>
			<td>${row[0].surface_area}</td>
			<td>${row[0].population}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
