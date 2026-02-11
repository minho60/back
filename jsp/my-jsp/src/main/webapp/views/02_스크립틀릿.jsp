<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립틀릿</title>
</head>
<body>
	<%-- 선언문 --%>
	<%! 
		// 새로고침시 안바뀜
		Date now1 = new Date(); 
	%>

	<%-- 스크립틀릿: 
			- 자바 로직을 실행하는 문법
			- 제어문, 변수 선언
			- 요청이 올 때마다 실행됨 --%>
			
	<% 
		// 새로고침시 바뀜
		Date now2 = new Date(); 
	%>
	<%-- JSTL 표현문 --%>
	<c:set var="now3" value="<%= new Date() %>" />
	
	
	<%-- 표현문 --%>
	선언문으로 작성한 변수: <%= now1 %><br>
	선언문으로 작성한 변수: <%= new Date() %><br>
	스크립틀릿으로 작성한 변수: <%= now2 %><br>
	
	<h2>EL</h2>
	JSTL로 작성한 변수:${now3}

</body>
</html>