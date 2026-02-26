<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pageContext</title>
</head>
<body>
	<% String path = request.getContextPath(); %>
	<img src="<%= path %>/images/tomcat.png" alt="톰캣">
</body>
</html>