<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session result(EL))</title>
</head>
<body>


<%--if(id != null){ --%>	
<c:choose> 
	<c:when test="${idKey ne null }">
	<h1>Session Example1</h1>
	<p><b>${idKey}</b>님이 좋아하시는 계절과 과일은</p>
	<p>
	<b>${season}</b>과 	
	<b>
	<c:forEach var="fruit" items="${fruits}" varStatus="st">
	${fruit}${!st.last ? ',' : ''}
	</c:forEach> 
	</b>입니다.
	</p>
		
	<p>세션 ID : ${pageContext.session.id}</p>
	<p>세션 유지 시간 : ${pageContext.session.maxInactiveInterval}초</p>

	<%--현재 세션(HttpSession)을 즉시 무효화(파기) --%>
	<%session.invalidate(); %>
	</c:when>
	<%-- } else { --%>
	<c:otherwise>	
		<p>세션의 시간이 경과를 하였거나 다른 이유로 연결을 할 수가 없습니다.</p>
	</c:otherwise>
</c:choose>
</body>
</html>