<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 선언문</title>
</head>
<body>
	<%-- 선언문: 변수, 메서드 선언 JSTL --%>
	<c:set var="totalCount2" value="100" />
	<c:set var="a2" value="10" />
	<c:set var="b2" value="20" />
	<c:set var="now" value="<%= new Date() %>" />
	
	<%-- for 문 --%>
	<c:set var="sum2" value="0" />
    <c:forEach var="i" begin="1" end="10">
   		<c:set var="sum2" value="${sum2+i}"/>
	</c:forEach> 
	
	
	<%-- 표현문(EL) --%>
	변수 출력(EL): ${totalCount2}<br>
	변수 출력(EL): ${a2+b2}<br>
	변수 출력(EL): ${now}<br>
	for문 출력: ${sum2}	


</body>
</html>