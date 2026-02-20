<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력 페이지</title></head>
<body>
	<h1>설문 조사</h1>
	<form action="${pageContext.request.contextPath}/request/jstl" method="post">
		이름: <input type="text" name="name"><br>
		나이: <input type="number" name="age"><br>
		관심분야:
		<input type="checkbox" name="hobby" value="Java">Java
		<input type="checkbox" name="hobby" value="SQL">SQL
		<input type="checkbox" name="hobby" value="Web">Web
		<button type="submit">전송</button>
	</form>
</body>
</html>