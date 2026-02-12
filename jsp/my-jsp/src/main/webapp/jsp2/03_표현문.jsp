
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 디렉티브: JSTL 라이브러리 연결 --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 선언문: 변수 선언, 메서드 정의 --%>
	<%! int num =50; %>
	<%-- JSTL  --%>
	<c:set var="num2" value="50" />
	
	<%-- 스크립트릿: 자바로직 --%>
	<% num+=10; %>
	
	
	<%-- JSTL  --%>
	<c:set var="num2" value="${num2 + 10 }" />
	
	<%-- 표현식: 변수 출력 --%>
	표현식: <%= num %><br>
	
	
	표현식(EL): ${num2}
	
</body>
</html>
