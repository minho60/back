<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%-- JSTL Core 라이브러리 선언: 조건문(c:choose) 등을 사용하기 위함 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<%-- 외부 CSS 연결: ${pageContext.request.contextPath}를 사용하여 절대 경로 지정 --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/board.css">
<title>써브웨이</title>
</head>
<body>
<h1>글 읽기</h1>	

<table class="read">
	<tr>
		<td>
			<%-- 게시글 상세 정보 테이블 --%>
			<table>
				<tr>
					<th>이 름</th>
					<%-- 서블릿에서 request.setAttribute("bb", bb)로 보낸 객체의 필드 출력 --%>
					<td>${bb.userid}</td>
					<th>등록날짜</th>
					<td>${bb.regdate}</td>
				</tr>
				<tr>
					<th>제 목</th>
					<td colspan="3">${bb.subject}</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td colspan="3">
						<%-- 파일 존재 여부에 따른 조건부 렌더링 --%>
						<c:choose>
							<c:when test="${not empty bb.filename}">
								<%-- 자바스크립트 down() 함수를 호출하여 파일 다운로드 실행 --%>
								<a href="javascript:down('${bb.filename}')">${bb.filename}</a>
								<span>(${bb.filesize}KBytes)</span>
							</c:when>
							<c:otherwise>등록된 파일이 없습니다.</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<%-- 게시글 본문 내용 --%>
					<td colspan="4">${bb.content}</td>
				</tr>
				<tr>
					<%-- 조회수 출력 --%>
					<td colspan="4">조회수 ${bb.readcount}</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
	<%-- 버튼 영역 --%>
		<div>
		    <%-- JS의 list() 함수를 호출하여 하단의 listFrm을 제출(목록 유지 이동) --%>
		    <a href="javascript:list()">목록 보기</a>
		      <a href="${pageContext.request.contextPath}/board/update?num=${bb.num}&nowPage=${nowPage}">수정</a>
		      <a href="${pageContext.request.contextPath}/board/delete?num=${bb.num}&nowPage=${nowPage}">삭제</a>
		</div>
		</td>
	</tr>
</table>

<%-- 
    [중요: 목록 유지용 숨겨진 폼]
    상세 보기 페이지에서 다시 목록으로 돌아갈 때, 
    보던 페이지 번호와 검색어 상태를 그대로 들고 가기 위해 사용합니다.
--%>
<form name="listFrm" method="get" action="${pageContext.request.contextPath}/board/list">
    <%-- 현재 페이지 번호 저장 (값이 없으면 기본값 1) --%>
    <input type="hidden" name="nowPage" value="${empty nowPage ? '1' : nowPage}">
    
    <%-- 검색어가 존재할 경우에만 검색 조건(field)과 검색어(word)를 파라미터로 포함 --%>
    <c:if test="${not empty keyWord}">
        <input type="hidden" name="keyField" value="${keyField}">
        <input type="hidden" name="keyWord" value="${keyWord}">
    </c:if>
</form>



<%-- 자바스크립트 연결: down() 파일다운로드 함수 및 list() 폼 제출 함수 포함 --%>
<script src="${pageContext.request.contextPath}/static/js/board.js"></script>
</body>
</html>