<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- page 디렉티브 --%>       
<%@ page import="java.util.Date" %>
<%-- tablib 디렉티브 --%>    
<%-- 톰캣 9.0 이전 --%>    
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"  %>--%>

<%-- 톰캣 10.1 --%> 
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>
<%--
	JSP 구성요소
		1. 디렉티브(Directive)
			1) <%@ page %> (필수)
			2) <%@ include %> (선택)
			3) <%@ taglib %> (필수) -> JSTL
			
		2. 스크립트요소(Script)
			1) 선언문	<%! %>:변수·메서드 선언
			2) 스크립틀릿 <% %>:Java 로직(제어문, ...) -> JSTL
			3) 표현식	<%= %>	:출력
		
		3. 액션 태그(Action Tag)
		
		4. 내장 객체
			request(요청)
			response(응답)	
			session(세션)
			application(서버전역)
			
			out(출력)
			pageContext(루트)
			
	1. 디렉티브(Directive)
		- page 디렉티브
		<%@ page import="패키지, 클래스,..." %>
--%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp 시작하기</title>
</head>
<body>
  <h1>Hello JSP</h1>
  <!-- HTML 주석 -->
  <%-- JSP 주석: 페이지 소스 보기에 출력 X --%>
  <%
  
	  // 스크립틀릿 ❌ -> JSTL로 전환❌
	  /* Java 로직(제어문, ...) 
	  	자바의 주석
	  */
	  // 변수선언
  		int sum=0;
		for (int i=0; i<=10; i++){
			sum += i;
		}  
		System.out.println("난 콘솔 출력:"+ sum);
		out.println("JSP out 내장객체로 출력:"+ sum);
   %>
   
   <%-- JSTL --%>
    <c:set var="sum2" value="0" />
    <c:forEach var="i" begin="1" end="10">
   		<c:set var="sum2" value="${sum2+i}"/>
	</c:forEach> 
   
   
  <%--
  		표현식
  			- 출력용 JAVA코드
  			- 변수, 메서드 호출문
  			<%= 변수 %>
  			<%= 메서드() %>
  	
   --%>
  
    <p>현재 시간: <%= new java.util.Date() %></p>
    <p>JSP 표현식으로 출력 :<%=sum %></p>
    <p>JSP 표현식으로 출력(EL) :${sum2} </p>
    
    
</body>
</html>