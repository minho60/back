<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 1. 한글 인코딩 설정
	// request.setCharacterEncoding("UTF-8");

	// 2. 단일 파라미터 수집
	String name = request.getParameter("name");
	String ageStr = request.getParameter("age");
	
	// 3. 숫자 파마라터 변환 (String -> int)
	int age = (ageStr != null && !ageStr.isEmpty()) ? Integer.parseInt(ageStr) : 0;
	int futureAge = age + 10;
	
	// 4. 다중 파라미터 수집 (Checkbox)
	String[] hobbies = request.getParameterValues("hobby");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이전 방식</title>
</head>
<body>
	<h2>수집된 데이터</h2>
	<p>이름: <%= name %></p>
	<p>현재 나이: <%= age %>세 (10년 뒤: <%= futureAge %>세)</p>
	<p>관심 분야: <%= (hobbies != null) ? Arrays.toString(hobbies) : "없음" %></p>
</body>
</html>