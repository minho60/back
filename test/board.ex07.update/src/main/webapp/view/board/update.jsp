<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<title>써브웨이</title>
<link href="${pageContext.request.contextPath}/static/css/board.css" rel="stylesheet">
</head>
<body>
<h1>게시글 수정(update.jsp)</h1>
<%-- action 경로를 서블릿 매핑인 /board/update로 설정 --%>
<form name="updateFrm" method="post" action="${pageContext.request.contextPath}/board/update">
	<table>
		<tr>
			<th>이름</th>
			<td><input name="userid" value="${bb.userid}" size="30" readonly></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input name="subject" value="${bb.subject}" size="50"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" rows="10" cols="50">${bb.content}</textarea></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="pass" size="15"> 
				<span>(작성 시 비밀번호 입력)</span>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정완료" onclick="updateCheck()">
				<input type="reset" value="다시수정">
				<input type="button" value="뒤로" onclick="history.back()">
			</td>
		</tr>
	</table>
	<%-- 상세 보기 서블릿에서 넘어온 파라미터 유지 --%>
	<input type="hidden" name="num" value="${param.num}"> 
	<input type="hidden" name="nowPage" value="${param.nowPage}">
</form>

<script src="${pageContext.request.contextPath}/static/js/board.js"></script>
</body>
</html>