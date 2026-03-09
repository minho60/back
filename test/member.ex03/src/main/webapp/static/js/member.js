/**
 * Subway 회원가입 통합 스크립트
 */

// [전역 상태 관리]
// 아이디 중복 체크 통과 여부를 저장합니다. 
// 아이디가 사용 가능한 상태일 때만 true가 되며, 아이디 입력란이 수정되면 false로 초기화됩니다.
window.isIdAvailable = false; 

// [DOM 요소 참조] HTML의 각 입력 필드와 에러 메시지 영역을 변수에 할당합니다.
const nameInput = document.getElementById("name");
const phoneInput = document.getElementById("phone");
const userId = document.getElementById("id");
const pwd = document.getElementById("pwd");
const pwdConfirm = document.getElementById("pwdConfirm");
const email = document.getElementById("email");
const memberBtn = document.getElementById("memberBtn"); // 가입하기 버튼

const nameError = document.getElementById("nameError");
const phoneError = document.getElementById("phoneError");
const idError = document.getElementById("idError");
const pwdError = document.getElementById("pwdError");
const pwdConfirmError = document.getElementById("pwdConfirmError");
const emailError = document.getElementById("emailError");

// [상태 추적] 사용자가 해당 필드에 한 번이라도 입력(터치)했는지 여부를 관리합니다.
let touched = { name: false, phone: false, id: false, pwd: false, pwdConfirm: false, email: false };

// [정규표현식] 각 필드의 유효성 검사 규칙을 정의합니다.
const regex = {
    name: /^[가-힣]{2,}$/,                // 한글 2자 이상
    phone: /^010\d{8}$/,                 // 010으로 시작하는 숫자 11자리
    id: /^[a-zA-Z0-9]{8,12}$/,           // 영문/숫자 8~12자리
    email: /^[^\s@]+@[^\s@]+\.[^\s@]+$/  // 이메일 형식 (@와 . 포함)
};

/**
 * [함수] 회원가입 버튼 상태 업데이트
 * 모든 필드가 유효하고 아이디 중복 체크가 완료되었을 때만 버튼을 활성화합니다.
 */
function updateJoinButton() {
    const isFormValid = 
        regex.name.test(nameInput.value.trim()) &&
        regex.phone.test(phoneInput.value.trim()) &&
        regex.id.test(userId.value) &&
        validatePwd(pwd.value) &&
        (pwd.value === pwdConfirm.value && pwdConfirm.value !== "") &&
        regex.email.test(email.value) &&
        window.isIdAvailable; // 최종 관문: 중복체크 성공 여부

    // 조건 충족 시 버튼 비활성화 해제 및 스타일 적용
    memberBtn.disabled = !isFormValid;
    memberBtn.classList.toggle("active", isFormValid);
}

/**
 * [보조 함수] 비밀번호 복합 규칙 검사
 * 길이(10~16자)와 문자 조합(영문, 숫자, 특수문자 중 2종 이상)을 확인합니다.
 */
function validatePwd(v) {
    let count = 0;
    if (/[A-Za-z]/.test(v)) count++;      // 영문 포함 시 점수+1
    if (/[0-9]/.test(v)) count++;         // 숫자 포함 시 점수+1
    if (/[^A-Za-z0-9]/.test(v)) count++;  // 특수문자 포함 시 점수+1
    return v.length >= 10 && v.length <= 16 && count >= 2;
}

/**
 * [공통 함수] 입력값 검증 및 에러 메시지 표시 제어
 */
function toggleError(inputEl, errorEl, regexKey) {
    const v = inputEl.value.trim();
    if (v === "") {
        errorEl.style.display = "none"; // 비어있을 때는 에러를 띄우지 않음
        return false;
    }
    const ok = regex[regexKey].test(v); // 정규표현식 검사 실행
    errorEl.style.display = ok ? "none" : "block"; // 통과하면 숨기고 실패하면 표시
    return ok;
}

// [이벤트 리스너] 사용자가 값을 입력할 때마다 실시간으로 검증을 수행합니다.

nameInput.addEventListener("input", () => {
    touched.name = true;
    toggleError(nameInput, nameError, 'name');
    updateJoinButton();
});

phoneInput.addEventListener("input", () => {
    touched.phone = true;
    toggleError(phoneInput, phoneError, 'phone');
    updateJoinButton();
});

userId.addEventListener("input", () => {
    touched.id = true;
    window.isIdAvailable = false; // [주의] 아이디가 수정되면 다시 중복체크를 해야 함
    toggleError(userId, idError, 'id');
    updateJoinButton();
});

pwd.addEventListener("input", () => {
    touched.pwd = true;
    const ok = validatePwd(pwd.value);
    pwdError.style.display = (pwd.value === "" || ok) ? "none" : "block";
    // 비밀번호가 바뀌면 비밀번호 확인 칸도 일치 여부를 다시 확인해야 함
    if(touched.pwdConfirm) {
        pwdConfirmError.style.display = (pwd.value === pwdConfirm.value) ? "none" : "block";
    }
    updateJoinButton();
});

pwdConfirm.addEventListener("input", () => {
    touched.pwdConfirm = true;
    const ok = (pwd.value === pwdConfirm.value);
    pwdConfirmError.style.display = (pwdConfirm.value === "" || ok) ? "none" : "block";
    updateJoinButton();
});

email.addEventListener("input", () => {
    touched.email = true;
    toggleError(email, emailError, 'email');
    updateJoinButton();
});

/**
 * [외부 연동] 아이디 중복 체크 팝업창 열기
 */
function idCheck(idValue) {
    if (!regex.id.test(idValue)) {
        alert("아이디 형식을 확인해주세요.");
        return;
    }
    // 서블릿 경로로 아이디 값을 쿼리 스트링으로 전달하며 팝업 오픈
    const url = path + "/member/idcheck?id=" + idValue;
    window.open(url, "IDCheck", "width=350,height=250");
}

/**
 * [팝업창 전용 함수] 중복 체크 완료 후 아이디를 부모창(회원가입 폼)에 적용
 */
function applyId(idValue) {
    // 팝업을 열었던 부모창(opener)이 살아있는지 확인
    if (opener && !opener.closed) {
        const parentIdInput = opener.document.getElementById("id");
        parentIdInput.value = idValue; // 부모창 아이디 입력란에 값 세팅
        opener.window.isIdAvailable = true; // 부모창의 '중복체크 통과' 상태 업데이트
        opener.updateJoinButton(); // 부모창의 가입 버튼 활성화 여부 다시 계산
        window.close(); // 팝업창 닫기
    }
}

/**
 * [API 연동] 카카오 주소찾기 서비스 호출
 */
function execKakaoPostcode() {
    new kakao.Postcode({
        oncomplete: function(data) {
            // 도로명 주소와 지번 주소 중 선택한 타입을 변수에 할당
            let addr = (data.userSelectedType === 'R') ? data.roadAddress : data.jibunAddress;
            document.getElementById('postcode').value = data.zonecode; // 우편번호
            document.getElementById("address").value = addr;           // 기본 주소
            document.getElementById("detailAddress").focus();          // 상세 주소로 포커스 이동
        }
    }).open();
}/**
 * 
 */