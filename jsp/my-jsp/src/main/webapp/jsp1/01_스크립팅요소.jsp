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
	<%-- 선언문: 변수, 메서드 선언 --%>
	<%!
		// 변수
		int totalCount = 100;
		// 메서드 정의
		public int plus(int a, int b) {
			return a + b;
		}
	%>

	
	<%-- 선언문 --%>
	<%! // 새로고침시 안바뀜
	 Date now1 = new Date();
	%>

	<%-- 스크립틀릿: 
			- 자바 로직을 실행하는 문법
			- 제어문, 변수 선언
			- 요청이 올 때마다 실행됨
			- 메서즈 정의 x
--%>

	<%
	// 새로고침시 바뀜 
	Date now2 = new Date();
	%>

	<%-- 표현문 --%>
	변수 출력: <%=totalCount%><br>
	메서드 출력: <%=plus(10, 20)%><br>
	선언문으로 작성한 변수:<%= now1%><br> 
	선언문으로 작성한 변수:<%= new Date()%><br> 
	스크립틀릿으로 작성한 변수:<%=now2%><br>




</body>
</html>