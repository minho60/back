<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<%-- 경로 표현식을 스프링 표준에 맞춰 /static을 제외하고 작성합니다. --%>
<link rel="stylesheet" href="/css/member.css">
<title>써브웨이</title>
</head>

<body>
	<section>
		<h2>안녕하세요. Subway 회원가입 페이지 입니다.</h2>
		<p>회원정보를 입력해주세요.</p>
		<form name="regFrm" method="post" action="/member/join">
			<table class="form-table">
				<tr>
					<th>이름</th>
					<td>
						<input type="text" id="name" name="name" required>
						<p class="error" id="nameError">이름은 한글 2자 이상 입력하세요.</p>
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td><%-- 같은 name을 가진 그룹 내의 요소 중 하나에만 required를 추가하면 그룹 전체에 적용됩니다. 
							(보통 코드 가독성을 위해 모든 라디오 버튼에 적어주기도 합니다.) --%>
						<label><input type="radio" name="gender" value="1" checked required> 남</label>
						<label><input type="radio" name="gender" value="2"> 여</label>
					</td>
				</tr>
				<tr>
					<th>휴대폰 번호</th>
					<td><input type="tel" id="phone" name="phone" placeholder="01012345678" required>
						<p class="error" id="phoneError">휴대폰 번호 형식이 올바르지 않습니다.</p>
				</tr>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" id="id" name="id" required>
						<p class="error" id="idError">아이디는 영문·숫자 조합 8자 이상 12자리 이하입니다.</p>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" id="pwd" name="pwd" required>
						<p class="error" id="pwdError">비밀번호는 영문,숫자,특수기호 중 2가지 이상 조합하여 10자리 이상 16자리 이하입니다.</p>
					</td>
				</tr>
				<tr>
					<th>이메일 주소</th>
					<td>
						<input type="email" id="email" name="email" required>
						<p class="error" id="emailError">올바른 이메일 형식으로 입력해주세요.</p>
					</td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td>
						<input type="text" name="zipcode" id="postcode" placeholder="우편번호" size="5" readonly>
						<input type="button" onclick="execKakaoPostcode()" value="우편번호 찾기"><br>
						<input type="text" name="address1" id="address" placeholder="주소" size="45" readonly><br>
						<input type="text" name="address2" id="detailAddress" placeholder="상세주소" size="45">
					</td>
				</tr>
				<tr>
					<th>취미</th>
					<td>
						<label><input type="checkbox" name="hobby" value="인터넷">인터넷</label>
						<label><input type="checkbox" name="hobby" value="여행">여행</label>
						<label><input type="checkbox" name="hobby" value="게임">게임</label>
						<label><input type="checkbox" name="hobby" value="영화">영화</label>
						<label><input type="checkbox" name="hobby" value="운동">운동</label>
					</td>
				</tr>
				<tr>
					<th>직업</th>
					<td><select name=job required>
							<option value="0" selected>선택하세요.
							<option value="회사원">회사원
							<option value="연구전문직">연구전문직
							<option value="교수학생">교수학생
							<option value="일반자영업">일반자영업
							<option value="공무원">공무원
							<option value="의료인">의료인
							<option value="법조인">법조인
							<option value="종교,언론,에술인">종교.언론/예술인
							<option value="농,축,수산,광업인">농/축/수산/광업인
							<option value="주부">주부
							<option value="무직">무직
							<option value="기타">기타
					</select></td>
				</tr>
			</table>
			<button id="memberBtn" disabled>회원가입</button>
		</form>
	</section>

	<script src="https://t1.kakaocdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="/js/member.js"></script>
</body>

</html>