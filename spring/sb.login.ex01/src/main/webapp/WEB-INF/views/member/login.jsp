<%-- 1. JSP 설정: 문서의 타입과 인코딩을 UTF-8로 설정하여 한글 깨짐을 방지합니다. --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- 2. JSTL Core 라이브러리: 조건문(c:if) 등을 사용하기 위해 선언합니다. (Jakarta EE 10 대응) --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%-- 
    3. 알림 메시지 처리 (FlashAttribute):
    - Controller에서 rttr.addFlashAttribute("msg", "...")로 보낸 데이터는 이 페이지가 로드될 때 'msg'라는 이름으로 전달됩니다.
    - <c:if>: msg 변수가 비어있지 않다면 내부의 <script>를 실행합니다.
    - alert("${msg}"): 사용자에게 팝업창으로 오류 메시지(예: "아이디가 일치하지 않습니다.")를 보여줍니다.
--%>
<c:if test="${not empty msg}">
    <script>
        alert("${msg}");
    </script>
</c:if>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <%-- 
        4. 정적 자원 연결: 
        - 스프링 부트의 기본 정적 자원 경로는 src/main/resources/static 입니다.
        - 따라서 /css/member.css는 실제 static/css/member.css 파일을 찾아갑니다.
    --%>
    <link rel="stylesheet" href="/css/member.css">
    <title>써브웨이 - 로그인</title>
</head>
<body>
<%@include file="../common/header.jsp" %>
<h1>LOGIN</h1>

<%-- 
    5. 로그인 폼:
    - method="post": 비밀번호와 같은 민감한 정보는 URL에 노출되지 않도록 POST 방식을 사용합니다.
    - action="/login": 폼 데이터를 MemberController의 @PostMapping("/login") 메서드로 전송합니다.
--%>
<form method="post" action="/login">
    <div>
        <label for="id">아이디: </label>
        <%-- name="id": 서버에서 @RequestParam("id")로 받기 위한 핵심 속성입니다. --%>
        <input type="text" name="id" id="id" placeholder="아이디" required>
    </div>
    <div>
        <label for="pwd">비밀번호: </label>
        <%-- type="password": 입력 시 문자가 '*' 또는 '●'로 가려지게 합니다. --%>
        <%-- name="pwd": 서버에서 @RequestParam("pwd")로 매핑됩니다. --%>
        <input type="password" name="pwd" id="pwd" placeholder="비밀번호" required>
    </div>
    <div>
        <%-- submit 타입 버튼을 누르면 form의 action 경로로 데이터가 전송됩니다. --%>
        <button type="submit">로그인</button>
    </div>
</form>
</body>
</html>