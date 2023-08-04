
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
	
<h1>consulta para obtener todos los países con un Monarquia de área mayor a 200 y una expectacion de vida superior a los 75 años</h1>
<table class="table">
    <thead>
        <th>Nombre del País</th>
        <th>¿Tiene monarquía?</th>
        <th>Area del País</th>
        <th>Expectativas de vida</th>
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
