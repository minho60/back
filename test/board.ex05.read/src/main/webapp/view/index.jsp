<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>써브웨이</title>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet">
</head>
<body>
	<h1>써브웨이 메인페이지</h1>
	<p>[실습] 메인 페이지가 열리면 최근글 5개 보이기</p>
	<table>
		<tr>
			<th>제목</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="bb" items="${list}">
			<tr>
				<td><a href="board/list">${bb.subject}</a></td>
				<td>${bb.regdate}</td>
			</tr>
		</c:forEach>
	</table>
<hr>
현재 총 ${totalRecord}건의 게시글이 있습니다.
</body>
</html>