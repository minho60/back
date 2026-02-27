<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>회원가입</title>
	</head>
	<body>
		<h2>회원가입</h2>
		<form action="${pageContext.request.contextPath}/member" method="post">
			<div>
				<label for="userid">아이디:</label>
				<input type="text" name="userid" id="userid">
			</div>
			<div>
				<label for="userpw">비밀번호:</label> 
				<input type="password" name="userpw" id="userpw">
			</div>
			<div>
				<button type="submit">가입하기</button>
			</div>
		</form>
	</body>
</html>