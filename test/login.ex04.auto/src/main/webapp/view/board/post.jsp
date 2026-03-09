<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>써브웨이</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/board.css">
</head>
<body>
<%@ include file="/view/common/header.jsp" %>
<h1>글 쓰기(Create)</h1>
<form name="postFrm" method="post" action="${pageContext.request.contextPath}/board/post" enctype="multipart/form-data">
	<table>
		<tr>
			<th>작성자</th>
			<td><input name="userid" size="16" maxlength="8" required placeholder="필수 입력, 8자이내"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input name="subject" size="50" maxlength="30" required placeholder="필수 입력, 30자이내"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" rows="15" cols="60"></textarea></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pass" size="30" maxlength="15" required placeholder="필수 입력, 15자이내"></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td><input type="file" name="filename" size="50"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="등록하기">
				<input type="reset" value="다시쓰기">
				<input type="button" value="목록 보기" onClick="location.href='${pageContext.request.contextPath}/board/list'">
			</td>
		</tr>
	</table>
</form>
<%@ include file="/view/common/footer.jsp" %>
</body>
</html>