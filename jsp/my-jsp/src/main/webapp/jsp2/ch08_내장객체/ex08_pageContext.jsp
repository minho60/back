<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pageContext(EL)</title>
</head>
<body>	
	<%-- <% String path = request.getContextPath(); %> --%>
	<c:set var="path" value="${pageContext.request.contextPath}" />
	
	<img src="${path}/images/tomcat.png" alt="톰캣">
</body>
</html>