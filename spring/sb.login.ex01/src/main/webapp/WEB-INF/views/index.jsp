<%-- 1. 페이지 설정: 언어, 콘텐츠 타입(HTML), 문자 인코딩(UTF-8)을 정의합니다. --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- 
    2. JSTL core 태그 라이브러리 선언:
    - Tomcat 10 버전 이상(Jakarta EE)에서는 uri가 "jakarta.tags.core"여야 합니다. 
    - 이 선언이 있어야 <c:choose>, <c:if> 등을 사용할 수 있습니다.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>써브웨이 - 메인</title>
</head>
<body>
	
	<%@include file="common/header.jsp" %>
		
	
    <h1>메인 페이지</h1>
    
    <%-- 
        3. <c:choose>: 자바의 switch-case나 if-else if 문과 유사한 조건문입니다.
           여러 조건 중 일치하는 하나만 실행합니다.
    --%>
    <c:choose>
        
        <%-- 
            [조건 1] 로그인 세션이 있는 경우:
            - test="${not empty sessionScope.userName}": 
              세션 영역(sessionScope)에 'userName'이라는 이름의 데이터가 비어있지 않은지 확인합니다.
            - MemberController에서 session.setAttribute("userName", ...)를 실행했다면 이 부분이 작동합니다.
        --%>
        <c:when test="${not empty sessionScope.userName}">
            <p>
                <%-- ${...}: EL(Expression Language) 표현식으로 세션에 저장된 값을 출력합니다. --%>
                <strong>${sessionScope.userName}님</strong> 로그인 중입니다.
            </p>
            <%-- 로그아웃은 Controller의 @GetMapping("/logout")으로 이동합니다. --%>
            <a href="/logout">로그아웃</a>
            <%-- 추후 게시판 기능 구현 시 연결될 링크입니다. --%>
            <a href="/board/list">게시판 가기</a>
        </c:when>
        
        <%-- 
            [조건 2] 위의 모든 조건이 일치하지 않는 경우 (로그아웃 상태):
            - 세션에 데이터가 없거나 session.invalidate()가 호출된 후라면 이 화면이 보입니다.
        --%>
        <c:otherwise>
            <p>로그인이 필요합니다.</p>
            <%-- Controller의 @GetMapping("/login") 매핑과 연결됩니다. --%>
            <a href="/login">로그인</a>
            <%-- Controller의 @GetMapping("/member/join") 매핑과 연결됩니다. --%>
            <a href="/member/join">회원가입</a>
        </c:otherwise>
        
    </c:choose>
</body>
</html>