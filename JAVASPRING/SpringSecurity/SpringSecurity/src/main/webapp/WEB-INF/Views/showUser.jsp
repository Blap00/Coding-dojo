<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title>Dashboard</title>

<a href="/dashboard/logout" >Logout!</a>
<h1>Welcome ${user.firstName} !</h1>
<div style="border: 1px solid black">
	<ul>
		<li>First Name: <c:out value="${user.firstName}"/></li>
		<li>Last Name: <c:out value="${user.lastName}"/></li>
		<li>Email: <c:out value="${user.email}"/></li>
		<li>Sign up date: <fmt:formatDate value="${user.createdAt}" pattern="MMMM dd, yyyy" /> </li>
		<li>Last Sign in: <fmt:formatDate value="${user.lastLogoutDate}" pattern="MMMM dd, yyyy HH:mm:ss" /></li>
		
	</ul>
</div>