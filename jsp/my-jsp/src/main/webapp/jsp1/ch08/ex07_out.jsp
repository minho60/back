<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- out 내장객체: 브라우저로 데이터를 출력하기 위한 기본 출력 스트림 --%>
	<%-- 스크립틀릿 --%>
	<% 
	out.println("직접 출력하는 메시지");
    out.print("Hello JSP");
    out.println("<br>");
    out.print(10 +20);
	%>	
	<hr>
	<%-- 표현식 --%>
	<%="직접 출력하는 메시지" %>
	<%="HELLO JSP" %>
	<%="<br>" %>
	<%=(10+20) %>
</body>
</html>