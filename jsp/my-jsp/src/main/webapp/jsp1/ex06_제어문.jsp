<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="path" value="${getcontext.request.contextPath }"/>
<% String path = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP1</title>
	<style>
		table,td {border: 1px solid;}
	</style>
</head>
<body>
	<%--
		<% %> 안은 자바 코드
		HTML 출력은 블록 밖에서 실행
	 --%>
	 <h1>제어문: 스크립틀릿+표현식</h1>
	 <h2>조건문: 스크립틀릿</h2>
	<% int score = 75;
		if (score >= 80) { 
	%>
			<b> 합격입니다.</b>
	<% } else { %>
			<b> 불합격입니다.</b>
	<% }	%>
	<h2>반복문: 스크립틀릿+표현식</h2>	
	<%
		for(int i=1; i<=5; i++){
			//콘솔 출력
			System.out.println(i);
	%>		
		<%-- 브라우저 출력 --%>
		<b><%= i %></b>
		<%-- 상대주소 --%>
		<img src="../images/<%= i %>.png" alt="이미지<%=i %>" >
		<%-- 절대주소 --%>
		<img src="<%=path %>/images/<%= i %>.png" alt="이미지<%=i %>" >
	<%	} %>
	<hr>
	<%
		int n=1;
		while(n <= 3){
	%>		
			<p> <%= n %>번째 반복</p>
	<%	n++; } %>
	
	<h2>구구단(중첩 for)</h2>
	<table>
	<%
		for(int i=1; i<=9; i++){ 
	%>
			<tr>
	<%			
			for(int j=2; j<=9; j++){
	%>		
				<td><%= j %>*<%=i %> = <%= i*j %></td>
	
	<%	
			}
	%>
			
			</tr>
	<%	
	}
	%>
	</table>
	<h2>향상된 for문</h2>
	<% String [] fruits = {"사과", "바나나", "포도"}; %>
	
	<ul>
	<% 	for(String fruit: fruits){ %>		
			<li> <%= fruit %> </li>
		
	<%	} %>
	</ul>
		
	
	
</body>
</html>