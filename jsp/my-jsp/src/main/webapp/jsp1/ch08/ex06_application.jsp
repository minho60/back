<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
			application 내장 객체
				- 웹 애플리케이션 전체에서 공유되는 전역 객체
				- 서버가 시작될 때 생성
				- 서버가 종료될 때 소멸
				- 모든 사용자, 모든 JSP/Servlet에서 공유
	--%>
	
	<%-- 
			실행 방법: F5, 브라우저 새로고침 또는 시크릿 창 등 다른 브라우저에 실행
			서버 재시작: 0으로 초기화
	 --%>
	<%
		Integer count = (Integer) application.getAttribute("visitCount");
		if (count == null) {
			count = 0;
		}
		application.setAttribute("visitCount", count + 1);
	%>
	
	
	방문자: <%= count %>
</body>
</html>