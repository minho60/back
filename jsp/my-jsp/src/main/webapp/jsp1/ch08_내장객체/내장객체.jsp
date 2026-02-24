<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장객체</title>
</head>
<body>
	<%--1. 인코딩 설정: 클라이언트가 보낸 post 방식의 데이터의 한글 깨짐 방지 --%>
	<%request.setCharacterEncoding("UTF-8");%>
	
	<%--2. URL파라미터 또는 form 데이터 가져오기 --%>
	getParameter:<%=request.getParameter("userid")%><br>
	
	<%-- 3. 프로젝트 루트 경로 가져오기(예, my-jsp) --%>
	getContextPath:<%=request.getContextPath() %><br>
	
	<%-- 4. 요청이 유지되는 동안 데이터 저장(지정)하기  --%>
	<% request.setAttribute("msg","hello"); %><br>
	<%-- 5. 저장된 데이터 가져오기 --%>
	getAttribute:<%=request.getAttribute("msg") %>
	
	<%-- 6. out:브라우저에 내용출력 --%>
	<%
	int totalBuffer = out.getBufferSize();
	int remainBuffer = out.getRemaining();
	int useBuffer = totalBuffer - remainBuffer;
	%>
	
	<%-- 7. 브라우저에게 해당 경로로 다시 접속하라고 명령 
			- HTML 내용들이 화면에 보이기 전에 즉시 페이지가 전환된다.
	 --%>
	<h1>Out Example1</h1>
	<p><b>현재 페이지의 Buffer 상태</b></p>
	<p>출력 Buffer의 전체 크기 : <%=totalBuffer%>byte</p>
	<p>남은 Buffer의 크기 : <%=remainBuffer%>byte</p>
	<p>현재 Buffer의 사용량 : <%=useBuffer%>byte</p>
	
	<%-- JSTL --%>
	<c:set var="total" value="${pageContext.out.bufferSize }"/>
	<c:set var="remain" value="${pageContext.out.remaining }"/>
	
	<h1>Out Example1(JSTL+EL)</h1>
	<p><b>현재 페이지의 Buffer 상태</b></p>
	<p>출력 Buffer의 전체 크기 : ${total}byte</p>
	<p>남은 Buffer의 크기 : ${remain}byte</p>
	<p>현재 Buffer의 사용량 : ${total-remain}byte</p>
	
	
	<%--<% response.sendRedirect("ex03_main.jsp"); --%>
	
	
</body>
</html>