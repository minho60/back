<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- getMessage() 호출 
	<jsp:getProperty name="test" property="message" />
	
	--%>

	${test.message }

</body>
</html>