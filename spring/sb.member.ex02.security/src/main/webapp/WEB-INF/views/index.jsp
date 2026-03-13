<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL Core 태그 라이브러리 사용 선언 (조건문, 반복문 등 사용 가능) --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>써브웨이</title>
</head>
<body>
	<%@ include file="common/header.jsp" %>
    <h1>메인 페이지</h1>

    <%-- 
        [로그인 상태 분기 처리]
        c:choose는 자바의 switch-case문과 유사한 역할을 합니다.
    --%>
    <c:choose>
        <%-- 
          1. 로그인 성공 상태: 
          스프링 시큐리티는 인증에 성공하면 세션의 'SPRING_SECURITY_CONTEXT'라는 키값에 인증 객체를 저장합니다.
          이 값이 비어있지 않다면(not empty) 로그인된 사용자로 판단합니다.
        --%>
        <c:when test="${not empty sessionScope.SPRING_SECURITY_CONTEXT}">
            <p>
                <%-- SecurityConfig의 SuccessHandler에서 세션에 담은 'userName'(실명) 출력 --%>
                <strong>로그인에 성공하셨습니다! ${sessionScope.userName}</strong>님, 환영합니다.<br>
                
                <%-- 시큐리티 인증 객체 내부에서 꺼낸 'name'(보통 로그인 ID) 출력 --%>
                (정보: ${sessionScope.SPRING_SECURITY_CONTEXT.authentication.name}님 접속 중)
            </p>
            
            <%-- 
                [로그아웃 처리] 
                스프링 시큐리티의 기본 설정은 CSRF 보호를 위해 로그아웃을 POST 방식으로 요청해야 합니다.
                따라서 단순 링크(<a>)가 아닌 <form>과 버튼을 사용합니다.
            --%>
            <form action="/logout" method="post" style="display:inline;">
                <button type="submit">로그아웃</button>
            </form>
        </c:when>

        <%-- 2. 로그인하지 않은 상태: 세션에 인증 정보가 없을 때 실행 --%>
        <c:otherwise>
            <p>로그인이 필요합니다.</p>
            <a href="/member/login">로그인</a>
            <a href="/member/join">회원가입</a>
        </c:otherwise>
    </c:choose>

    <%-- 
        [회원가입 성공 알림 스크립트]
        Controller에서 리다이렉트 시 보낸 파라미터를 감지하여 처리합니다.
    --%>
    <script src="/js/success.js"></script>
</body>
</html>