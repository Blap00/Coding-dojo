<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.fabianPalma.web.models.clickerModelo" %>
<!DOCTYPE html>
<html>
	<head>
    	<title>Button Clicker</title>
    	<style type="text/css">
			body{
				text-align: center;
			}
			h1{
				margin-top: 8vh;
			}
			p{
				margin-bottom: 7vh;
			}
			button{
				background: aqua;
	    		width: 8vw;
    			height: 6vh;
    			font-size: 3vh;
		    	margin-bottom: 4vh;
			}
		</style>
	</head>
	<body>
	
		<%
			clickerModelo model = (clickerModelo) session.getAttribute("model");
		%>
		<h1>Button Clicker Result</h1>
	    <p>Clicks: <%= model.getCounter() %></p>
	    <a href="BotonClickerServlet">Back to Clicker</a>
	</body>
</html>