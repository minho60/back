<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error!!</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common.css">
</head>
<body>
<div id="error">
	<div>
		<img src="${pageContext.request.contextPath}/static/assets/logo.svg" alt="logo">
		<c:choose>
	        <%-- 404 에러일 경우 --%>
	        <c:when test="${code == 404}">
	            <p><b>404.</b> 페이지를 찾을 수 없습니다.</p>
	            <p>입력하신 주소가 올바른지 다시 한번 확인해 주세요.</p>
	        </c:when>
	
	        <%-- 500 에러일 경우 --%>
	        <c:when test="${code == 500}">
	            <p><b>500.</b> 서버 내부 오류</p>
	            <p>시스템에 일시적인 장애가 발생했습니다. 잠시 후 다시 시도해 주세요.</p>
	        </c:when>
	
	        <%-- 그 외 모든 에러 --%>
	        <c:otherwise>
	            <p>예상치 못한 오류가 발생했습니다.</p>
	            <p>관리자에게 문의해 주세요.</p>
	        </c:otherwise>
	    </c:choose>
	</div>
	<div>
		<img src="${pageContext.request.contextPath}/static/assets/monkey.jpg" alt="error">
	</div>
	

</div>
</body>
</html>