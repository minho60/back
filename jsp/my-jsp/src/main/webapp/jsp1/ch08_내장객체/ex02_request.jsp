<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장객체: request</title>
</head>
<body>
	<form method="post" action="ex02_request_pro.jsp">
		<div>
			<label for="name">성명:</label>
			<input name="name">
		</div>
		<div>
			<label for="studentNum">학번 :</label>
			<input name="studentNum">
		</div>
		
		<h2>성별</h2>
		<label>남자 <input  type="radio" name="gender"  value="man" checked></label>
		<label>여자 <input type="radio" name="gender" value="woman"></label>

		<h2>전공선택</h2>
		
		전공 : <select name="major">
				<option selected value="국문학과">국문학과</option>
				<option value="영문학과">영문학과</option>
				<option value="수학과">수학과</option>
				<option value="정치학과">정치학과</option>
				<option value="체육학과">체육학과</option>
			  </select><br>

			<h2>관심목록</h2>
			<label><input type="checkbox" name="hobby" value="독서">독서</label>
			<label><input type="checkbox" name="hobby" value="여행">여행</label>
			<label><input type="checkbox" name="hobby" value="영화">영화</label>
			<label><input type="checkbox" name="hobby" value="게임">게임</label>
			<label><input type="checkbox" name="hobby" value="독서">독서</label>
		
  
		<input type="submit" value="보내기">
	</form>
</body>
</html>