<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Request Example(JSTL+EL)</h1>
	<p>성명 :${name } <p/>
	<p>학번 : ${studentNum}<p/>
	<p>성별 : ${gender}<p/>
	<p>학과 : ${major}<br>

	<%--
	
		<%
			if(values != null){
				for(String val: values){
		%>			
				 <p>취미: <%=val %> </p>
		<%		
				}
			}
		%>
	
	--%>
	
	<c:if test="${hobbies ne null}">
		<c:forEach var="hobby" items="hobbies">
		<p>취미: ${hobby} </p>
		</c:forEach>
	</c:if>
	
</body>
</html>