<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 처리 페이지</title>
</head>
<body>
	<%--
			exception 내장 객체
				- 에러 처리 전용으로, 조건이 맞을 때만 존재하는 객체
				- page 지시자에 아래 설정 필요
				<%@ page isErrorPage="true" %>
				- 이 설정이 없으면 exception 객체 존재하지 않음
	--%>
	<h2>에러 발생</h2>
	에러 내용: <%= exception.getMessage() %>
	
</body>
</html>