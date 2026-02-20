<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청및 인코딩</title>
<style>
    body { font-family: Arial, sans-serif; }
    .result { margin-top: 20px; font-weight: bold; }
</style>
</head>
<body>
	<%-- 한글 인코딩 --%>
	<%
	request.setCharacterEncoding("UTF-8");
	%>

	<h2>단일 파라미터 수집</h2>  
	<%=request.getParameter("name")%>

	<h2>숫자 파라미터 수집 </h2> 
	<%
	String sAge = request.getParameter("age");
	int age = (sAge != null) ? Integer.parseInt(sAge) : 0;
	%>
	내년 나이:<%=age + 1%>

	<h2>다중 파라미터 수집</h2>
	<h3>취미 선택</h3>

<form method="post">
    <input type="checkbox" name="hobby" value="독서"> 독서<br>
    <input type="checkbox" name="hobby" value="운동"> 운동<br>
    <input type="checkbox" name="hobby" value="영화감상"> 영화감상<br>
    <input type="checkbox" name="hobby" value="게임"> 게임<br>
    <input type="submit" value="전송">
</form>
	
	<div class="result">
		<%
		String[] hobbies = request.getParameterValues("hobby");

		if (hobbies != null) {
			out.print("선택한 취미 : ");
			for (String h : hobbies) {
				out.print(h + " ");
			}
		} else {
			out.print("선택한 취미가 없습니다.");
		}
		%>
	</div>
<%-- ctrl+ spacebar 임포트  --%>
<% ArrayList<String> list = new ArrayList<>(); %>
	
	
</body>
</html>