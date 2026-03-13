<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="/css/board.css">
</head>
<body>

<h1>JSP 자유게시판</h1>
<p>자유롭게 글을 올리고, 정보를 공유할 수 있는 공간입니다.</p>
<table>
    <tr>
        <th>순번</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
    </tr>

<c:forEach var="bb" items="${list}">
    <tr>
        <td>${bb.num}</td>
        <td>${bb.subject}</td>
        <td>${bb.userid}</td>
        <td>${bb.regdate}</td>
        <td>${bb.readcount}</td>
    </tr>
</c:forEach>

</table>

<br>
total records : ${count}

</body>
</html>