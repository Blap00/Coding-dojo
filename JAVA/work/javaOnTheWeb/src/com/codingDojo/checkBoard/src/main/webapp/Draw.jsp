<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>A Web Page</title>
		<link rel="stylesheet" type="text/css" href="./css/style.css">
	</head>
	<body>
		<%
		int height = Integer.parseInt(request.getParameter("height"));
		int width = Integer.parseInt(request.getParameter("width"));
		%>
		<h2>CheckerBoard: <%=width%>W X <%=height%>H</h2>
		<table class="checkerboard">
			<%
			for (int i = 0; i < height; i++) {
			%>
			<tr>
				<%
				for (int j = 0; j < width; j++) {
				%>
				<%
				if ((i + j) % 2 == 0) {
				%>
				<td class="white"></td>
				<%
				} else {
				%>
				<td class="black"></td>
				<%
				}
				%>
				<%
				}
				%>
			</tr>
			<%
			}
			%>
		</table>	
</body>
</html>