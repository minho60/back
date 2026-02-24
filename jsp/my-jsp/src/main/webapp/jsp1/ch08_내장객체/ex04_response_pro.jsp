<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    /*
     * [1] HTTP/1.0 호환 캐시 방지 설정
     *
     * Pragma: no-cache
     *  - 주로 HTTP/1.0 브라우저 및 프록시 서버를 위한 캐시 제어 헤더
     *  - 페이지를 캐시에 저장하지 않도록 지시
     *  - 최신 브라우저에서는 Cache-Control이 주 역할을 함
     */
    // response.setHeader("헤더이름","값");
    // - 서버가 클라이언트(브라우저)로 보내는 HTTP 응답(Response)에 헤더 값을 직접 설정
    response.setHeader("Pragma", "no-cache");

    /*
     * [2] 요청 프로토콜이 HTTP/1.1인지 확인
     *
     * request.getProtocol()
     *  - 요청에 사용된 HTTP 프로토콜 및 버전 반환
     *  - 예: "HTTP/1.1"
     */
    // request.getProtocol()
    // - 클라이언트가 서버에 요청할 때 사용한 HTTP 프로토콜과 버전을 문자열로 반환
    if (request.getProtocol().equals("HTTP/1.1")) {

        /*
         * [3] HTTP/1.1 전용 캐시 방지 설정
         *
         * Cache-Control: no-store
         *  - 응답 내용을 브라우저 및 중간 캐시에 저장하지 않도록 강제
         *  - 뒤로가기 / 새로고침 시에도 서버에서 다시 요청하게 함
         *  - 보안이 중요한 페이지(로그인, 개인정보)에 사용
         */
        response.setHeader("Cache-Control", "no-store");
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Response Example1</h1>
	<p>http://localhost:8080/my-jsp/jsp1/ch08_내장객체/ex04_response.jsp가</p>
	<p>http://localhost:8080/my-jsp/jsp1/ch08_내장객체/ex04_response_pro.jsp로 변경되었습니다.</p>
</body>
</html>