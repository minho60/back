<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL Core 태그 라이브러리 (필요 시 조건문 등을 쓰기 위해 선언) --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <%-- static/css/member.css 파일을 연결 --%>
    <link rel="stylesheet" href="/css/member.css">
    <title>써브웨이 - 로그인</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
<section class="login-container">
    <h1>LOGIN</h1>
    
    <%-- 
        [중요: 스프링 시큐리티 로그인 폼 규칙]
        1. action="/member/login": SecurityConfig의 .loginProcessingUrl("/member/login")과 일치해야 합니다.
        2. method="post": 인증 정보 전송을 위해 반드시 POST 방식을 사용합니다.
    --%>
    <form method="post" action="/member/login">
        <div>
            <label for="id">아이디: </label>
            <%-- name="username": 시큐리티가 기본적으로 아이디를 찾는 파라미터명입니다. --%>
            <input type="text" name="username" id="id" placeholder="아이디" required>
        </div>
        <div>
            <label for="pwd">비밀번호: </label>
            <%-- name="password": 시큐리티가 기본적으로 비밀번호를 찾는 파라미터명입니다. --%>
            <input type="password" name="password" id="pwd" placeholder="비밀번호" required>
        </div>
        
        <div class="button-group">
            <%-- type="submit": 이 버튼을 눌러야 폼 데이터가 시큐리티 인증 프로세스로 전송됩니다. --%>
            <button type="submit" class="btn-login">로그인</button>
            
            <%-- 
                [회원가입 버튼] 
                type="button": 기본 submit 동작을 방지하여 실수로 로그인을 시도하지 않게 합니다.
                onclick: 클릭 시 가입 페이지로 경로를 이동시킵니다.
            --%>
            <button type="button" class="btn-join" onclick="location.href='/member/join'">회원가입</button>
        </div>
    </form>

    <%-- 하단 푸터 (주석 해제 시 활성화 가능) --%>
    <%-- 
    <div class="login-footer">
        <p>아직 회원이 아니신가요? <a href="/member/join">회원가입 하기</a></p>
    </div>
    --%>
</section>

<%-- 
    [로그인 실패 처리 스크립트]
    시큐리티는 인증 실패 시 URL 뒤에 '?error'를 붙여 이 페이지로 다시 보냅니다.
    fail.js 내부에서 'location.search.includes("error")'를 체크하여 경고창을 띄우는 로직이 있을 것입니다.
--%>
<script src="/js/fail.js"></script>
</body>
</html>