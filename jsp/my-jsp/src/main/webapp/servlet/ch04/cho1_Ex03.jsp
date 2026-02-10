<!-- 페이지 디렉티브  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 1.선언문 --%>
	<%!
	
	%>
	
	<%-- 2.스크립틀릿 --%>	
	<%
		// 자바 프로그래밍
		String root = request.getContextPath();
	%>
	
	<%-- 경로: /프로젝트명/서블릿 주소 --%>
	<%-- 3. 표현식 --%>	
	<%= 2+3 %>
	
	
	<a href="/my-jsp/requestMethod">requestMethod 1</a>
	<a href="<%= root %>/requestMethod">requestMethod 2</a>
	<a href="${pageContext.request.contextPath}/requestMethod">requestMethod 3</a>

</body>
</html>