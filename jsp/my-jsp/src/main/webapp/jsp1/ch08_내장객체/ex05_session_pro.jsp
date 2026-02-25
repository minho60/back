<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");

	// session.setAttribute(String name, Object value);
	// 세션(Session)에 데이터를 저장하여 같은 사용자에 대해 여러 요청 동안 공유할 수 있게 하는 메서드
	session.setAttribute("idKey",id);
	// session.setMaxInactiveInterval(int seconds);
	// 세션(Session)의 유효 시간을 설정
	session.setMaxInactiveInterval(60*5);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Session Example1</h1>
	<form method="post" action="ex05_session_result.jsp">
	    1.가장 좋아하는 계절은?<br>
		<p><input type="radio" name="season" value="봄">봄
		<input type="radio" name="season" value="여름">여름
		<input type="radio" name="season" value="가을">가을
		<input type="radio" name="season" value="겨울">겨울</p>

		2.가장 좋아하는 과일은?<br>
		<p><input type="radio" name="fruit" value="watermelon">수박
		<input type="radio" name="fruit" value="melon">멜론
		<input type="radio" name="fruit" value="apple">사과
		<input type="radio" name="fruit" value="orange">오렌지</p>
		<input type="submit" value="결과보기">
	</form>
</body>
</html>