<%@ page contentType="text/html; charset=UTF-8" %>
<%-- JSTL Core 태그 라이브러리: 제어문(if, choose), 반복문(forEach), 출력(out) 등을 사용 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>써브웨이</title>
<%-- 외부 CSS 연결: contextPath를 사용하여 절대 경로로 설정 (경로 꼬임 방지) --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/board.css">
</head>
<body>

<h1>써브웨이 자유게시판</h1>
<p>자유롭게 글을 올리고, 정보를 공유할 수 있는 공간입니다.</p>

<%-- 
    [검색 영역 (Search Area)] 
    - method="get": 검색어는 URL에 노출되어도 상관없으며, 페이지 복사/공유를 위해 GET 방식 선호
    - action: 검색을 처리할 컨트롤러 주소 지정
--%>
<div class="search">
	<form name="searchFrm" method="get" action="${pageContext.request.contextPath}/board/list" class="search-form">
		<%-- 검색 필드 (제목, 작성자, 내용 등) --%>
		<select name="keyField" title="검색 필드 선택">
            <%-- 
                [상태 유지 로직]
                3항 연산자($ {조건 ? '참' : '거짓'})를 사용하여 
                기존에 선택했던 검색 필드가 검색 후에도 그대로 유지되게 함 (selected)
            --%>
			<option value="userid" ${keyField eq 'userid' ? 'selected' : ''}>작성자</option>
			<option value="subject" ${keyField eq 'subject' ? 'selected' : ''}>제목</option>
			<option value="content" ${keyField eq 'content' ? 'selected' : ''}>내용</option>
		</select> 
        
		<%-- 
            검색어 입력창
            - c:out: XSS(크로스 사이트 스크립팅) 공격을 방지하며 검색어를 안전하게 출력
        --%>
		<input type="search" name="keyWord" value="<c:out value='${keyWord}'/>" placeholder="검색어를 입력해 주세요.">
        
		<%-- type="button"으로 지정하여 JS의 check() 함수를 거쳐 제출되도록 함 --%>
		<button type="button" onclick="check()">검색</button>
	</form>
</div>

<%-- [게시글 목록 테이블] --%>
<table>
    <tr>
        <th>순번</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
    </tr>

<%-- 리스트가 비어있지 않을 때만 반복문 수행 --%>
<c:forEach var="bb" items="${list}">
    <tr>
        <td>${bb.num}</td>
        <%-- 제목 클릭 시 상세 페이지로 이동하도록 추후 <a> 태그 추가 가능 --%>
        <td>${bb.subject}</td>
        <td>${bb.userid}</td>
        <td>${bb.regdate}</td>
        <td>${bb.readcount}</td>
    </tr>
</c:forEach>

<%-- 검색 결과가 없을 경우 예외 처리 (선택사항) --%>
<c:if test="${empty list}">
    <tr>
        <td colspan="5" style="text-align:center;">검색 결과가 없습니다.</td>
    </tr>
</c:if>

</table>

<%-- 
    [페이징 처리 영역] 
    주의: 검색어가 있는 상태에서 페이지를 이동하면 검색 조건이 사라질 수 있음.
    따라서 <a> 태그의 href에 &keyField=${keyField}&keyWord=${keyWord}를 붙여주는 것이 정석.
--%>
<div class="pagination">
    
    <%-- [이전] 버튼 --%>
    <c:if test="${currentPage > 1}">
        <a href="list?page=${currentPage - 1}&keyField=${keyField}&keyWord=${keyWord}">[이전]</a>
    </c:if>

    <%-- [페이지 번호] --%>
    <c:forEach var="i" begin="1" end="${totalPages}">
        <c:choose>
            <c:when test="${i == currentPage}">
                <strong>${i}</strong>
            </c:when>
            <c:otherwise>
                <a href="list?page=${i}&keyField=${keyField}&keyWord=${keyWord}">${i}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <%-- [다음] 버튼 --%>
    <c:if test="${currentPage < totalPages}">
        <a href="list?page=${currentPage + 1}&keyField=${keyField}&keyWord=${keyWord}">[다음]</a>
    </c:if>
    
</div>

<br>
total records : ${count}

<%-- 자바스크립트 파일 연결: 검색어 유효성 검사(check함수) 포함 --%>
<script src="${pageContext.request.contextPath}/static/js/board.js"></script>
</body>
</html>