<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
    JSP Languege surpport 프로그램을 추가
 --%>
    
    <%-- JSP1.0 --%>
	<%= request.getAttribute("info") %>
    
    <%-- JSP2.0 EL --%>
    ${info}
    
</body>
</html>