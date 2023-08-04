
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
	
<h1>consulta para obtener paises por region en el mundo</h1>
<table class="table">
    <thead>
        <th>Nombre de la region</th>
        <th>Cantidad por region</th>
    </thead>
    <tbody>
        <c:forEach var="row" items="${table}">                
        <tr>
            <td>${row[0]}</td>
			<td>${row[1]}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
