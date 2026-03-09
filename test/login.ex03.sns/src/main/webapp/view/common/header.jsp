<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>써브웨이</title>
</head>
<body>
<header>
	<h1><a href="${pageContext.request.contextPath}/main">
		<img src="${pageContext.request.contextPath}/static/assets/img/dodram.svg" alt="써브웨이">
	</a></h1>
    <%-- 세션에 저장된 userName이 있는지 확인
    	userName이 비어있지 않을 때만 출력 --%>
    <c:if test="${not empty sessionScope.userName}"> 
	    <h3>
	        ${sessionScope.userName}님, 웹 사이트 방문을 환영합니다.
	    </h3>
    </c:if>
    
    <nav>
    	<c:choose>
	    	<%-- 세션에 userName이 없으면 (로그인 전) --%>
	    	<c:when test="${empty sessionScope.userName}">
			    <a href="${pageContext.request.contextPath}/login">로그인</a>
			    <a href="${pageContext.request.contextPath}/join">회원가입</a>
		    </c:when>
	    	<%-- 세션에 userName이 있으면 (로그인 후) --%>
	    	<c:otherwise>
			    <a href="${pageContext.request.contextPath}/logout">로그아웃</a>
			    <a href="${pageContext.request.contextPath}/main">내 정보</a>
		    </c:otherwise>
	    </c:choose>
    </nav>
    <%-- (선택사항) 새로고침 시 이름이 계속 떠있는 걸 방지하려면 세션 값을 지웁니다. --%>
    <%-- <% session.removeAttribute("userName"); %> --%>
</header>
</body>
</html>