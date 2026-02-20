<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"  %> 
<c:set var="path" value="${pageContext.request.contextPath}" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
	<style>
		table,td {border: 1px solid;}
	</style>
</head>
<body>
	<%--
		<% %> 안은 자바 코드
		HTML 출력은 블록 밖에서 실행
	 --%>
	 
	<%-- 
	
	<% int score = 75;
		if (score >= 80) { 
	%>
			<b> 합격입니다.</b>
	<% } else { %>
			<b> 불합격입니다.</b>
	<% }	%>
	
	--%>
	
	<%-- JSTL --%>
	<c:set var="score" value="75"/>
	<%-- JSTL + EL --%>
	<c:if test="${score >=80}" >
		<b> 합격입니다.</b>
	</c:if>
	<c:if test="${score < 80}" >
		<b> 불합격입니다.</b>
	</c:if>
	
	<c:choose>
		<c:when test="${score >= 80}">
		<b>합격입니다.</b>
		</c:when>
		<c:otherwise>
			<b>꽝입니다.</b>
		</c:otherwise>
	</c:choose>	
	<hr>		
	<c:forEach var="i" begin="1" end="5" step="1">
		<b>${i}</b>
		<%-- 상대 경로 --%>
		<img src="../images/${i}.png" alt="이미지${i}" >
		<%-- 절대 경로 --%>
		<img src="${pageContext.request.contextPath}/images/${i}.png" alt="이미지${i}" >
		<img src="${path}/images/${i}.png" alt="이미지${i}" >
	</c:forEach>
	<hr>
	<c:forEach var="n" begin="1" end="3" step="1">
		<p>${n} 번쨰 반복</p>
	</c:forEach>
	<hr>
	<table>
	<%-- step을 생략 하면 1씩 증가 --%>
	<c:forEach var="i" begin="1" end="9">
			<tr>
				<c:forEach var="j" begin="2" end="9">
					<td> ${j}*${i} = ${i*j }</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<h2>향상된 for문 EL</h2>
	<%-- JSTL+EL --%>
	<%--
	에러:
	<c:set var="fruits1" value="${new String[] {"사과","바나나","딸기"} }" />
	
	 --%>
	<%-- JSTL+표현식 --%>
	<c:set var="fruits2" value='<%= new String[] {"사과","바나나","딸기"} %>' />
	<%--
		첫 번쨰 형식:
			<c:forEach var="변수명" begin="시작값" end="끝값" step="증감값">
		두 번째 형식:
			<c:forEach var="변수명" items="${배열명}"[varStatus="상태변수명"]>
			속성		의미
			index	0부터
			count	1부터
			first	첫 요소 여부
			last	마지막 요소 여부
			
				
	 --%>
	
	

	<ul>
	<c:forEach var="fruit" items="${fruits1}">
		<li>${fruit}</li>
	</c:forEach>	
	</ul>

	<ul>
	<c:forEach var="fruit" items="${fruits2}" varStatus="st">
		<li>${st.index}${fruit}</li>
		<%--
		<li>${st.count}${fruit}</li>
		<li>${st.first}${fruit}</li>
		<li>${st.last}${fruit}</li>
		
		 --%>
	</c:forEach>	
	</ul>
	
	
	
	
</body>
</html>