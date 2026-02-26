<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String studentNum = request.getParameter("studentNum");
	String gender = request.getParameter("gender");
	String major = request.getParameter("major");

	if(gender.equals("man")){
		gender = "남자";
	} else {
		gender = "여자";
	}
	
	String[] values = request.getParameterValues("hobby");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Request Example1</h1>
	<p>성명 : <%=name%><p/>
	<p>학번 : <%=studentNum%><p/>
	<p>성별 : <%=gender%><p/>
	<p>학과 : <%=major%><br>
	<%
		if(values != null){
			for(String val: values){
	%>			
			 <p>취미: <%=val %> </p>
	<%		
			}
		}
	%>
</body>
</html>