<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장객체 EL</title>
</head>
<body>


	<%-- 아이디:<%=request.getParameter("userid")%> --%>
	아이디:${param.userid}<br>
	경로:<%=request.getContextPath() %><br>
	
	경로: ${pageContext.request.contextPath}<br>
	경로: ${request.contextPath}<br>
	
	
	<c:set var="msg" value="hello" scope="request"/>
	${msg}
	<c:redirect url="ex03_main.jsp" />
	
	
</body>
</html>