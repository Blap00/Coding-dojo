
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
	
<h1>consulta para obtener todos los pa�ses con un Monarquia de �rea mayor a 200 y una expectacion de vida superior a los 75 a�os</h1>
<table class="table">
    <thead>
        <th>Nombre del Pa�s</th>
        <th>�Tiene monarqu�a?</th>
        <th>Area del Pa�s</th>
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
