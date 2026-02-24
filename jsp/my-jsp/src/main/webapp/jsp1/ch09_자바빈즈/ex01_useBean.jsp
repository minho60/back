<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--useBean의 id가 setProperty 와 getProperty의 name과 연결 --%>
<%-- 
	<jsp:useBean id="객체명" class="전체클래스(패키지포함)"/>
	 - 자바의 객체를 생성하거나 기존 객체를 찾는다.
	 - id는 setProperty 와 getProperty의 name과 같아야 한다.
	 
	 클래스 타입 객체(인스턴스) = new 생성자();
	 Ch09JavaBeans test = new Ch09javaBeans();
	 	

 --%>
<jsp:useBean id="test" class="jsp.Ch09JavaBeans"/>

<%--
	<jsp:setProperty name="객체명" property="속성" value="값" />
	 - 빈객체의 필드 값 설정
	 - name 은 useBean의 id
	 public class Ch09JavaBeans {
		// private 멤버 변수 선언
		private String message = "";
	
 --%>
<jsp:setProperty name="test" property="message" value="빈을 쉽게 정복하자" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>간단한 빈 프로그래밍</h1>
	<br>
	<%--
	<jsp:getProperty name="test" property="message" />
		- 빈 객체에저장된 값을 가져와 화면에 출력
	
	 --%>
	Message: <jsp:getProperty name="test" property="message" />
</body>
</html>