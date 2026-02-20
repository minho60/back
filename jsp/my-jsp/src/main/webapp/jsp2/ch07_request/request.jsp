<%-- <%@page import="java.util.Arrays"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>이전 방식</title>
	</head>
	<body>
		<h2>수집된 데이터</h2>
		<%-- param 객체를 통해 직접 접근 가능
				- ${param.name}은 내부적으로 
				  request.getParameter("name")을 호출하는 것과 같습니다.
				- 데이터 타입: 문자열(String)
		--%>
		<%-- 서블릿에서 데이터를 가공(예: 나이에 10을 더함, DB에서 이름을 검색함 등)했다면, 
			 반드시 setAttribute로 담아서 ${name} 형태로 사용해야 합니다. --%>
		<p>이름: ${param.name}</p>
		<p>현재 나이: ${param.age}세 (10년 뒤: ${futureAge}세)</p>
		
		<%-- <p>관심 분야: ${not empty paramValues.hobby ? paramValues.hobby : "없음"}</p>  --%>
		
		<%-- <p>관심 분야:
			<c:choose>
				<c:when test="${not empty paramValues.hobby}">
					${fn:join(paramValues.hobby, ", ")}
				</c:when>
				<c:otherwise>
					없음
				</c:otherwise>
			</c:choose>
		</p> --%>

		<p>관심 분야:
			<c:forEach var="hobby" items="${hobbies}" varStatus="status">
				<%-- ${hobby}<c:if test="${!status.last}">, </c:if> --%>
				${hobby}${!status.last ? ', ' : ''}
			</c:forEach>
		</p>
	</body>
</html>