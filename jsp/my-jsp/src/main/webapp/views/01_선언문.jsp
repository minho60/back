<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<%--JSTL --%>
	<c:set var="totalCount2" value="100" />
	<c:set var="a2" value="10" />
	<c:set var="b2" value="20" />
	

	<%-- 표현식: 변수 출력 --%>
	변수 출력: <%=totalCount%>
	<br>
	<!-- 표현식: 메서드 호출 -->
	메서드 출력: <%=plus(10, 20)%>
	
	<hr>
	
	<%-- EL --%>
	변수 출력(EL): ${totalCount2}
	<br>
	변수 출력(EL): ${a2+b2}

	


</body>
</html>