<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>헤더 페이지</title>
    </head>
    <body>
        <%
            String siteName = "Welcome To Dodram";
        %>
        <header>
            <h1><%= siteName %></h1>
            <h1><%= request.getParameter("siteName") %></h1>

		<h1>
			<a href="index.jsp"><%= siteName %></a>
		</h1>
		<nav>
			<ul>
				<li><a href="sub.jsp">서브페이지1</a></li>
				<li><a href="#">메뉴2</a></li>
				<li><a href="#">메뉴3</a></li>
			</ul>
		</nav>
	</header>

    </body>
</html>