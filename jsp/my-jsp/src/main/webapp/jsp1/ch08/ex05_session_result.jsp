<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String season = request.getParameter("season");
	String fruit = request.getParameter("fruit");

	// Object value = session.getAttribute(String name);
	// - 세션에 저장된 이름(name)에 해당하는 값을 반환
	// - 세션(Session)에 저장된 값을 꺼내오는 메서드
	String id = (String) session.getAttribute("idKey");
	// String sessionId = session.getId();
	// - 현재 사용자의 세션(Session)을 식별하는 고유한 ID 값을 반환
	String sessionId = session.getId();
	int intervalTime = session.getMaxInactiveInterval();
	if(id != null){
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Session Example1</h1>
	<p><b><%=id%></b>님이 좋아하시는 계절과 과일은</p>
	<p><b><%=season%></b>과 <b><%=fruit%></b> 입니다.</p>
	<p>세션 ID : <%=sessionId%></p>
	<p>세션 유지 시간 : <%=intervalTime%>초</p>
	<%
			//현재 세션(HttpSession)을 즉시 무효화(파기)
			session.invalidate();
		} else {
			out.println("세션의 시간이 경과를 하였거나 다른 이유로 연결을 할 수가 없습니다.");
	  }
	%>
</body>
</html>