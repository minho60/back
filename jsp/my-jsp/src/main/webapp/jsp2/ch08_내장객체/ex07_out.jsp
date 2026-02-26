<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Out(EL)</title>
</head>
<body>

	<%-- 표현식 --%>
	<%="직접 출력하는 메시지" %>
	<%="HELLO JSP" %>
	<%="<br>" %>
	<%=(10+20) %>
	
	<hr>
	<%-- EL --%>
	out.print("직접 출력하는 메시지");
	out.print("HELLO JSP");
	out.print(<br>);
	out.print(10+20);

</body>
</html>