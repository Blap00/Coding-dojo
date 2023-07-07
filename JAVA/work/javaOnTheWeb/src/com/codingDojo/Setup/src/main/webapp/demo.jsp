<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>demo.jsp</title>
	</head>
	<body>
		<%!public int add(int a, int b) {
			return a + b;
		}%>
		<%
		int i = 2;
		int j = 4;
		%>

		<h1>Hello World!</h1>
		<h2>Result intern: <%=add(i, j)%></h2>
		<%
		for (int index = 0; index < 5; index++) {
		%>
		<h4>index: <%=index%></h4>
		<%
		}
		%>
		<p>
			The actual time is;
			<%=new Date()%>
		</p>
	</body>
</html>