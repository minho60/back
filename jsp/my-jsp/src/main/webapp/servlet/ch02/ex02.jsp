<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/my-jsp/static/css/style.css">
</head>
<body>
	<!-- 
		action="자바 서블릿 경로"
		method "get| 기본값"
	-->
	<form action="/my-jsp/getPost" method="post">
		<div>
			<label for="username"> 이름: </label>
			<input type="text" name="username" id="username">
		</div>
		<div>
			<label for="userage"> 나이: </label>
			<input type="text" name="userage" id="userage">
		</div>
		<div>
			<label for="userid"> 아이디</label>
			<input type="text" name="userid" id="userid">
		</div>
		<div>
			<label for="userpw">비빌번호 : </label>
			<input type="password" name="userpw" id="userpw">
		</div>
		<div>
		<h3>취미선택: </h3>
		<label><input type="checkbox" name="hobby" value="독서">독서</label>
		<label><input type="checkbox" name="hobby" value="여행">여행</label>
		<label><input type="checkbox" name="hobby" value="영화">영화</label>
		<label><input type="checkbox" name="hobby" value="게임">게임</label>
		</div>
		<button type="submit">전송</button>
	</form>
</body>
</html>