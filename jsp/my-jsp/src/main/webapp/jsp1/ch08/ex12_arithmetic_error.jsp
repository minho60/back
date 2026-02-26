<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 페이지</title>
</head>
<body>
	<h2>에러가 발생했습니다.</h2>
	
	<ul>
		<li>상태 코드: ${pageContext.errorData.statusCode}</li>
		<li>요청 URI: ${pageContext.errorData.requestURI}</li>
		<li>예외 타입: <%= exception.getClass().getName() %></li>
		<li>에러 메시지: <%= exception.getMessage() %></li>
	</ul>
</body>
</html>