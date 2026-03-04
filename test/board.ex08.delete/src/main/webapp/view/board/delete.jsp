<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL Core 태그 라이브러리: 조건문, 반복문, URL 처리 등을 위해 사용 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>써브웨이 - 게시물 삭제</title>
<%-- EL(${...})을 사용하여 컨텍스트 루트 경로를 동적으로 가져와 CSS 연결 --%>
<link href="${pageContext.request.contextPath}/static/css/board.css" rel="stylesheet">
</head>
<body>
<h1>게시물 삭제(delete.jsp)</h1>
<p>게시물을 삭제하려면 비밀번호를 입력해주세요.</p>

<%-- 
  action: 실제 삭제 처리를 담당하는 서블릿(Controller) 경로로 지정
  method: 비밀번호가 포함되므로 보안상 POST 방식 사용 
--%>
<form name="delFrm" method="post" action="${pageContext.request.contextPath}/board/delete">
	<table>
		<tr>
			<td>
				<%-- 사용자로부터 게시물 비밀번호를 입력받는 필드 --%>
				<input type="password" name="pass" size="20" maxlength="15" placeholder="비밀번호 입력">
			</td>
		</tr>
		<tr>
			<td>
				<%-- onClick="deleteCheck()": 외부 JS 파일(board.js)에 정의된 유효성 검사 함수 호출 --%>
				<input type="button" value="삭제완료" onClick="deleteCheck()"> 
				<input type="reset" value="다시쓰기">
				<%-- 브라우저의 이전 페이지로 이동 --%>
				<input type="button" value="뒤로" onClick="history.back()">
			</td>
		</tr>
	</table>
	
	<%-- 
	  사용자 눈에는 보이지 않지만, 서버로 반드시 전달해야 하는 데이터 (Hidden 필드)
	  param.nowPage: 삭제 후 원래 보던 페이지 번호로 돌아가기 위함
	  param.num: 어떤 게시물을 삭제할지 식별하는 고유 번호
	--%>
	<input type="hidden" name="nowPage" value="${param.nowPage}">
	<input type="hidden" name="num" value="${param.num}">
</form>

<%-- 유효성 검사 및 폼 전송 로직이 담긴 JavaScript 파일 연결 --%>
<script src="${pageContext.request.contextPath}/static/js/board.js"></script>
</body>
</html>