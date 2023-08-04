
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<table class="table">
    <thead>
        <th>Nombre del País</th>
        <th>Numero de ciudades</th>
    </thead>
    <tbody>
        <c:forEach var="row" items="${table}">                
        <tr>
            <td>${row[0]}</td>
			<td>${row[1]}</td> <!-- SE ACCEDE DE MANERA DISTINTA YA QUE 
								SETEAMOS LOS VALORES QUE LLEGAN DESDE REPOSITORIO -->
        </tr>
        </c:forEach>
    </tbody>
</table>
