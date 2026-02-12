<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- 
	JSP 지시자(directives)
		- JSP 페이지가 어떻게 동작할지에 대한  
		  JSP 페이지의 환경·설정 정보를 지정
		
		<%@ 지시자이름 속성="값" %>

	 1. include 지시자
		- 다른 JSP 정적인 포함
		- 하나의 Servlet으로 변환
		- 메뉴, 헤더, 푸터에 사용
		- JSP → Servlet 변환(컴파일) 시점에 소스 자체가 합쳐짐
		- 정적 include
		- 변수, 함수 공유 가능
		- 파라미터 전달 ❌
		- 실무에서는 제한적으로 사용
		
		<%@ include file="경로/파일" %>
		예) <%@ include file="header.jsp" %>
	
	2. 액션 include
		- 변수, 함수 공유 ❌
		- 파라미터 전달 ❌
		
	3. JSTL import	
		- 변수, 함수 공유 ❌
		- 파라미터 전달 ❌
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서브페이지</title>
</head>
<body>

	<header>
		<h1><a href="index.jsp">메인페이지</a></h1>
		<nav>
			<ul>
				<li><a href="sub.jsp">서브페이지1</a></li>
				<li><a href="#">메뉴2</a></li>
				<li><a href="#">메뉴3</a></li>		
			</ul>
		</nav>
	</header>

<%-- 	<%@ include file="header.jsp"%> --%>
	<% String loginId = "admin"; %>


	<section>
		<h2>섹션</h2>
		<p>로그인 사용자:<%=loginId%></p>
		<%-- header.jsp의 지역변수 공유 --%>
		<%-- <p>사이트명 재사용:<%=siteName%></p> --%>
	</section>
	
	<footer>
	
	</footer>

	
<%-- 	<%@ include file="footer.jsp"%> --%>
</body>
</html>