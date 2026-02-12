<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
		 import="java.util.*"
         session="true"
         isErrorPage="false" %>
<%-- <%@ page import="java.util.*" %> 
	import만 따로 쓰기 가능
--%>


<%--
	language	사용 언어 (java 고정)
	contentType	응답 타입 + 문자셋
	pageEncoding	JSP 파일 인코딩
	import	Java 클래스 import
	session	session 사용 여부
	isErrorPage	에러 페이지 여부

 --%>
         
<%-- 
	지시자(Directive) 
		- JSP 페이지가 어떻게 동작할지에 대한 “설정 정보”를 서버(JSP 컨테이너)에게 알려주는 문법입니다.
		
		<%@ 지시자이름 속성="값" %>
		
		- 지시자 이름:page, include, taglib
		<%@ page	JSP 페이지 전체 설정
		<%@ include	다른 JSP 포함
		<%@ taglib	JSTL / 커스텀 태그 사용

--%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>