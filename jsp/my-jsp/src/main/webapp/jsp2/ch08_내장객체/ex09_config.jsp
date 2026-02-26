<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>config(EL)</title>
</head>
<body>
	<%-- 출력됨 --%>
	<%--
	관리자: <%= application.getInitParameter("adminEmail") %>
	 --%>
	
	<%-- 출력되지 않음 --%>
	<%--
	관리자: <%= config.getInitParameter("adminEmail") %>	
	 --%>
	 관리자: ${initParam.adminEmail}
</body>
</html>