<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	
    <%-- 세션에 저장된 userName이 있는지 확인 --%>
    <h3>
        ${sessionScope.userName}님, 웹 사이트방문을 환영합니다.
    </h3>
    
    <br>
    <a href="${pageContext.request.contextPath}/login">로그인</a>
    <a href="${pageContext.request.contextPath}/join">회원가입</a>
    <%-- (선택사항) 새로고침 시 이름이 계속 떠있는 걸 방지하려면 세션 값을 지웁니다. --%>
    <% session.removeAttribute("userName"); %>
	
	
</body>
</html>