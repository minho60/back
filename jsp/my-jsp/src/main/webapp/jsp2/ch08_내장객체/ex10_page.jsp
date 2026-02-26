<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page(EL)</title>
</head>
<body>
	<%
		pageContext.setAttribute(
			"className",
			page.getClass().getName()
		);
	%>
	클래스명: ${className}
</body>
</html>