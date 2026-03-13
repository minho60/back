<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%-- JSTL Core 태그 사용 선언 --%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<%-- 
    [서버 메시지 처리 영역]
    Controller에서 리다이렉트 시 붙여준 파라미터(?duplicate 또는 ?error)를 감지합니다.
--%>
<c:if test="${not empty param.duplicate}">
    <script>
        // DB에서 아이디 중복 예외(Catch 블록)가 발생하여 리다이렉트 되었을 때 실행
        window.onload = function() {
            alert("이미 사용 중인 아이디입니다. 다른 아이디를 입력해주세요.");
        };
    </script>
</c:if>

<c:if test="${not empty param.error}">
    <script>
        // 필수 입력값 누락 등 일반적인 처리 실패 시 실행
        window.onload = function() {
            alert("회원가입 처리 중 오류가 발생했습니다.");
        };
    </script>
</c:if>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<%-- 
    Spring Boot의 정적 자원 경로 설정: 
    src/main/resources/static/css/member.css 파일을 불러옵니다. 
--%>
<link rel="stylesheet" href="/css/member.css">
<title>써브웨이</title>
</head>

<body>
	<%@ include file="../common/header.jsp" %>
	<section>
		<h2>안녕하세요. Subway 회원가입 페이지 입니다.</h2>
		<p>회원정보를 입력해주세요.</p>
		
		<%-- 가입 데이터 전송 폼: MemberController의 /process(POST)로 전송 --%>
		<form name="regFrm" method="post" action="/member/join">
			<table class="form-table">
				<tr>
					<th>이름</th>
					<td>
						<input type="text" id="name" name="name" required>
						<%-- 유효성 검사 실패 시 자바스크립트로 보여줄 에러 메시지 (기본은 숨김 처리 되어있을 것) --%>
						<p class="error" id="nameError">이름은 한글 2자 이상 입력하세요.</p>
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<%-- 라디오 버튼: 같은 name(gender)을 공유하여 택 1 구조 생성 --%>
						<label><input type="radio" name="gender" value="1" checked required> 남</label>
						<label><input type="radio" name="gender" value="2"> 여</label>
					</td>
				</tr>
				<tr>
					<th>휴대폰 번호</th>
					<td>
                        <input type="tel" id="phone" name="phone" placeholder="01012345678" required>
						<p class="error" id="phoneError">휴대폰 번호 형식이 올바르지 않습니다.</p>
                    </td>
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
						<%-- 주소 필드는 오타 방지를 위해 readonly(읽기전용)로 설정하고 API를 통해 입력받음 --%>
						<input type="text" name="zipcode" id="postcode" placeholder="우편번호" size="5" readonly>
						<input type="button" onclick="execKakaoPostcode()" value="우편번호 찾기"><br>
						<input type="text" name="address1" id="address" placeholder="주소" size="45" readonly><br>
						<input type="text" name="address2" id="detailAddress" placeholder="상세주소" size="45">
					</td>
				</tr>
				<tr>
					<th>취미</th>
					<td>
						<%-- 체크박스: name이 모두 'hobby'이므로 서버(MemberDTO)에서 배열이나 리스트로 수집됨 --%>
						<label><input type="checkbox" name="hobby" value="인터넷">인터넷</label>
						<label><input type="checkbox" name="hobby" value="여행">여행</label>
						<label><input type="checkbox" name="hobby" value="게임">게임</label>
						<label><input type="checkbox" name="hobby" value="영화">영화</label>
						<label><input type="checkbox" name="hobby" value="운동">운동</label>
					</td>
				</tr>
				<tr>
					<th>직업</th>
					<td>
                        <select name="job" required>
							<option value="0" selected>선택하세요.</option>
							<option value="회사원">회사원</option>
							<option value="연구전문직">연구전문직</option>
							<option value="교수학생">교수학생</option>
							<option value="일반자영업">일반자영업</option>
							<option value="공무원">공무원</option>
							<option value="의료인">의료인</option>
							<option value="법조인">법조인</option>
							<option value="종교,언론,에술인">종교.언론/예술인</option>
							<option value="농,축,수산,광업인">농/축/수산/광업인</option>
							<option value="주부">주부</option>
							<option value="무직">무직</option>
							<option value="기타">기타</option>
					    </select>
                    </td>
				</tr>
			</table>
			<%-- 초기값은 disabled(비활성). join.js에서 유효성 검사 통과 시 활성화시키도록 설계됨 --%>
			<button id="memberBtn" disabled>회원가입</button>
		</form>
	</section>

	<%-- 외부 라이브러리 및 스크립트 --%>
	<%-- 1. 카카오 우편번호 서비스 API --%>
	<script src="https://t1.kakaocdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<%-- 2. 회원가입 유효성 검사 및 우편번호 함수가 담긴 커스텀 JS --%>
	<script src="/js/member.js"></script>
</body>
</html>