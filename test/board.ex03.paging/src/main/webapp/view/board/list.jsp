<%@ page contentType="text/html; charset=UTF-8" %>
<%-- JSTL의 Core 태그 라이브러리를 사용하기 위한 선언 (c:if, c:forEach 등을 사용 가능하게 함) --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>써브웨이</title>
<%-- 외부 스타일시트 연결: ${pageContext.request.contextPath}는 프로젝트의 루트 경로를 자동으로 찾아줌 --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/board.css">
</head>
<body>

<h1>써브웨이 자유게시판</h1>
<p>자유롭게 글을 올리고, 정보를 공유할 수 있는 공간입니다.</p>
<table>
    <tr>
        <th>순번</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
    </tr>

<%-- 
    [데이터 목록 출력] 
    items="${list}": 서블릿(Controller)에서 request.setAttribute("list", list)로 보낸 묶음
    var="bb": 리스트 안의 요소를 하나씩 꺼내 쓸 때 사용할 변수명 (BoardBean의 약자)
--%>
<c:forEach var="bb" items="${list}">
    <tr>
        <td>${bb.num}</td>       <%-- BoardBean의 getNum() 호출 --%>
        <td>${bb.subject}</td>   <%-- BoardBean의 getSubject() 호출 --%>
        <td>${bb.userid}</td>    <%-- BoardBean의 getWriter() 호출 --%>
        <td>${bb.regdate}</td>   <%-- BoardBean의 getRegdate() 호출 --%>
        <td>${bb.readcount}</td> <%-- BoardBean의 getReadcount() 호출 --%>
    </tr>
</c:forEach>

</table>

<%-- 
    [페이징 처리 영역] 
    서블릿에서 계산해서 넘겨준 currentPage(현재 페이지)와 totalPages(전체 페이지 수)를 활용함 
--%>
<div class="pagination">
    
    <%-- [이전] 버튼: 현재 페이지가 1보다 클 때만 화면에 표시 --%>
    <c:if test="${currentPage > 1}">
        <a href="list?page=${currentPage - 1}">[이전]</a>
    </c:if>

    <%-- 
        [페이지 번호 리스트] 
        1부터 시작해서 전체 페이지 수(totalPages)까지 반복하며 번호를 생성
    --%>
    <c:forEach var="i" begin="1" end="${totalPages}">
        <c:choose>
            <%-- 현재 내가 보고 있는 페이지 번호일 경우 --%>
            <c:when test="${i == currentPage}">
                <strong>${i}</strong> <%-- 링크를 걸지 않고 굵게 표시하여 현재 위치를 알림 --%>
            </c:when>
            <%-- 내가 보고 있지 않은 다른 페이지 번호일 경우 --%>
            <c:otherwise>
                <a href="list?page=${i}">${i}</a> <%-- 클릭 시 해당 페이지 파라미터를 넘김 --%>
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <%-- [다음] 버튼: 현재 페이지가 마지막 페이지(totalPages)보다 작을 때만 화면에 표시 --%>
    <c:if test="${currentPage < totalPages}">
        <a href="list?page=${currentPage + 1}">[다음]</a>
    </c:if>
    
</div>

<br>
<%-- 서블릿에서 보낸 전체 게시글 수(count) 출력 --%>
total records : ${count}

</body>
</html>