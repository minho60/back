<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>회원가입</title>
	</head>
	<body>
		<h2>회원가입</h2>
		<form method="post" action="${pageContext.request.contextPath}/member">

    <div >
        <label for="name">이름</label>
        <input type="text" id="name" name="name" required>
    </div>

    <div>
        <label for="id">아이디</label>
        <input type="text" id="id" name="id" required>
    </div>

    <div class="form-group">
        <label for="pwd">비밀번호</label>
        <input type="password" id="pwd" name="pwd" required>
    </div>

    <div>
        <label for="phone">전화번호</label>
        <input type="text" id="phone" name="phone" placeholder="010-0000-0000" required>
    </div>

    <div>
        <label for="email">이메일</label>
        <input type="email" id="email" name="email" required>
    </div>

    <div>
        <label for="zipcode">우편번호</label>
        <input type="text" id="zipcode" name="zipcode" required>
    </div>

    <div>
        <label for="address1">주소1</label>
        <input type="text" id="address1" name="address1" required>
    </div>

    <div>
        <label for="address2">주소2</label>
        <input type="text" id="address2" name="address2" required>
    </div>

    <div>
        <label>성별</label>
        <label><input type="radio" name="gender" value="M" required> 남자</label>
        <label><input type="radio" name="gender" value="F"> 여자</label>
    </div>

    <div>
        <label>취미</label>
        <label><input type="checkbox" name="hobby" value="인터넷"> 인터넷</label>
        <label><input type="checkbox" name="hobby" value="여행"> 여행</label>
        <label><input type="checkbox" name="hobby" value="게임"> 게임</label>
        <label><input type="checkbox" name="hobby" value="영화"> 영화</label>
        <label><input type="checkbox" name="hobby" value="운동"> 운동</label>
    </div>

    <div>
        <label for="job">직업</label>
        <select id="job" name="job" required>
            <option value="">선택하세요</option>
            <option value="회사원">회사원</option>
            <option value="연구전문직">연구전문직</option>
            <option value="교수학생">교수학생</option>
            <option value="일반자영업">일반자영업</option>
            <option value="공무원">공무원</option>
            <option value="의료인">의료인</option>
            <option value="법조인">법조인</option>
            <option value="종교,언론,예술인">종교.언론/예술인</option>
            <option value="농,축,수산,광업인">농/축/수산/광업인</option>
            <option value="주부">주부</option>
            <option value="무직">무직</option>
            <option value="기타">기타</option>
        </select>
    </div>

    <div>
        <input type="submit" value="회원가입">
    </div>

</form>

	</body>
</html>