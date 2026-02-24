<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.ContextPath();	

	String protocol = request.Protocol();
	String serverName = request.ServerName();
	int serverPort = request.getServerPort();
	String remoteAddr = request.getRemoteAddr();
	String remoteHost = request.getRemoteHost();
	String method = request.getMethod();
	StringBuffer requestURL = request.getRequestURL();
	String requestURI = request.getRequestURI();
	String useBrowser = request.getHeader("User-Agent");
	String fileType = request.getHeader("Accept");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>requset(EL)</title>
</head>
<body>
		<h1>Request Example2</h1>
		프로토콜 : ${pageContext.request.protocol }<p/>
		서버의 이름 : ${pageContext.request.serverName }<p/>
		서버의 포트 번호 :${pageContext.request.serverPort } <p/>
		사용자 컴퓨터의 주소 :${pageContext.request.remoteAddr } <p/>
		사용자 컴퓨터의 이름 :${pageContext.request.remoteHost } <p/>
		사용 method :${pageContext.request.method } <p/>
		요청 경로(URL) :${pageContext.request.requestURL }<p/>
		요청 경로(URI) :${pageContext.request.requestURI }<p/>
		현재 사용하는 브라우저 :${pageContext.request.useBrowser }<p/>
		브라우저가 지원하는 file의 type :${pageContext.request.fileType }<p/>
</body>
</html>