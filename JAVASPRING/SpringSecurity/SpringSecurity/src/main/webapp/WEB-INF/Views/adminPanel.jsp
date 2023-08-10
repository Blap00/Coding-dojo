
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dash</title>
<style>
#tabla1 {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#tabla1 td, #tabla1 th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

#tabla1 tr:nth-child(even) {
  background-color: #dddddd;
}
.link-button {
    background: none;
    border: none;
    color: blue;
    text-decoration: underline;
    cursor: pointer;
    padding: 0;
    font-family: inherit;
    font-size: inherit;
    display: inline-block;
  	
}
logout-link{
	float: right;
}
</style>
</head>
<body>

<a href="/dashboard/logout" class="logout-link">Logout!</a>
<h1>Welcome, ${admin.firstName} !</h1>
<table id="tabla1">
    <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
		<c:forEach items="${users}" var="user">
		    <tr>
		        <td><c:out value="${user.firstName} ${user.lastName}" /></td>
		        <td><c:out value="${user.email}" /></td>
		       	<td>
		       		<c:if test="${!user.admin}">
			       		<form:form action="/admin/${user.id}/delete" method="delete">
							<input type="submit" class="link-button" value="Delete" />
	   					</form:form>
   					</c:if>
   					
   					<c:if test="${!user.admin}">
	   					<form:form action="/admin/assign-admin/${user.id}" method="post">
							<input type="submit" class="link-button" value="make-admin" />
	   					</form:form>
   					</c:if>
   					
   					<c:if test="${user.admin}">
   						<p>admin</p>
					</c:if>
   					
		       	</td>
		    </tr>
		</c:forEach>

        
    </tbody>
</table>


</body>
</html>