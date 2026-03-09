<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css">
    <title>써브웨이</title>
</head>
<body>
<h1>LOGIN</h1>
<form method="post" action="${pageContext.request.contextPath}/login">
    <div>
        <label for="id">아이디: </label>
        <input type="text" name="id" id="id" placeholder="아이디" required>
    </div>
    <div>
        <label for="pwd">비밀번호: </label>
        <input type="password" name="pwd" id="pwd" placeholder="비밀번호" required>
    </div>
    <div>
        <button type="submit">로그인</button>
    </div>
</form>
</body>
</html>