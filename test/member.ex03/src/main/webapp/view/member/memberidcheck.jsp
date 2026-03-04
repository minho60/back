<%-- 
    JSP 페이지 설정: 
    language="java": 자바 코드를 사용함
    contentType: 브라우저에 보낼 데이터 형식과 문자셋 설정
    pageEncoding: JSP 파일 자체의 저장 문자셋 설정
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL(JSP Standard Tag Library)의 Core 태그를 사용하기 위한 선언 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>ID 중복체크</title>
    <%-- CSS 연결: 서블릿 컨텍스트 경로를 동적으로 가져와서 경로 설정 --%>
    <link href="${pageContext.request.contextPath}/static/css/member.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="id-display">
            <%-- c:out 태그: 크로스 사이트 스크립팅(XSS) 공격을 방지하며 값을 출력 --%>
            [ <c:out value="${inputId}" /> ]
        </div>

        <%-- 
            c:choose 태그: 자바의 switch-case 또는 if-else 문과 유사한 조건문 
            ${result} 값은 서블릿(Controller)에서 request.setAttribute("result", ...)로 넘겨준 데이터임
        --%>
        <c:choose>
            <%-- 1. 중복 확인 결과가 true인 경우 (아이디가 이미 존재함) --%>
            <c:when test="${result}">
                <div class="msg error">
                    이미 사용 중인 아이디입니다.
                </div>
                <button class="btn-close" onclick="window.close()">닫기</button>
            </c:when>
            
            <%-- 2. 중복 확인 결과가 false인 경우 (아이디 사용 가능) --%>
            <c:otherwise>
                <div class="msg success">
                    사용 가능한 아이디입니다.
                </div>
                <%-- 
                    사용하기 버튼 클릭 시: 
                    member.js에 정의된 applyId() 함수를 호출하여 
                    부모창(회원가입 폼)에 이 아이디를 전달하고 팝업을 닫음 
                --%>
                <button class="btn-use" onclick="applyId('${inputId}')">사용하기</button>
                &nbsp;
                <button class="btn-close" onclick="window.close()">닫기</button>
            </c:otherwise>
        </c:choose>
    </div>
    
    <%-- 자바스크립트 연결: 부모창과 통신하는 로직(applyId 등)이 담긴 파일 --%>
    <script src="${pageContext.request.contextPath}/static/js/member.js"></script>
</body>
</html>