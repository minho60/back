<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/login.css">
<title>써브웨이</title>
</head>
<body>
	<div id="container">
		<div id="wrap">
			<h1>LOGIN</h1>
			<form method="post" action="${pageContext.request.contextPath}/login">
				<div>
					<label for="id">아이디: </label> <input type="text" name="id" id="id"
						placeholder="아이디" required>
				</div>
				<div>
					<label for="pwd">비밀번호: </label> <input type="password" name="pwd"
						id="pwd" placeholder="비밀번호" required>
				</div>
				<%-- 기존 폼 내부 로그인 버튼 위에 추가 --%>
				<div class="login_group"
					style="display: flex; align-items: center; gap: 10px;">
					<input type="checkbox" name="rememberMe" id="rememberMe"> <label
						for="rememberMe" style="cursor: pointer;">로그인 상태 유지</label>
				</div>
				<div>
					<button type="submit">로그인</button>
				</div>
				<div class="links">
					<a href="${pageContext.request.contextPath}/join">회원가입</a>
				</div>

				<div class="sns_login">
					<a href="#" onclick="loginWithNaver(); return false;">네이버 로그인</a>
				</div>

			</form>
		</div>
	</div>
	<div class="ft">
		<%@ include file="/view/common/footer.jsp"%>
	</div>
	<script src="${pageContext.request.contextPath}/static/js/login.js"></script>
</body>
</html>