<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
	</head>
	<body>
		<%--
			액션 include 태그
				- 요청(request) 시점마다 실행 시 포함
				- 동적 include
				- 변수 공유 ❌
				- 파라미터 전달 ⭕
				- JSP 전통 방식 MVC에서 자주 사용
			
				<jsp:include page="target.jsp">
					<jsp:param name="key" value="value" />
				</jsp:include>
		--%>

		<%-- <%@ include file="header.jsp" %> --%>
		<jsp:include page="header.jsp">
			<jsp:param name="siteName" value="JSP Study"/>
		</jsp:include>

		<%
			String loginId = "admin";
		%>

		<main>
			<p>로그인 사용자: <%= loginId %></p>
			<%-- 지역 변수 공유x --%>
			<%-- <p>사이트명 재사용: <%= siteName %></p> --%>
		</main>

		<%-- <%@ include file="footer.jsp" %> --%>
		<jsp:include page="footer.jsp">
			<jsp:param name="siteName" value="JSP Study"/>
			<jsp:param name="year" value="<%= java.time.Year.now().getValue() %>"/>
		</jsp:include>
	</body>
</html>