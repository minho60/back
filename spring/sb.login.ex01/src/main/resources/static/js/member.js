/**
 * Subway 회원가입 통합 스크립트 (간소화 버전)
 * 목적: 사용자 입력의 실시간 검증 및 가입 버튼 활성화 제어
 */

// [1] 전역 상태 관리
// 아이디 중복 체크 통과 여부 (true: 사용 가능 / false: 중복 또는 미체크)
// 실제 운영 시에는 AJAX 중복 체크 통과 시에만 true로 변경하도록 설계해야 합니다.
window.isIdAvailable = true; 

// [2] DOM 요소 참조 (입력창 및 버튼)
const nameInput = document.getElementById("name");       // 이름 입력란
const phoneInput = document.getElementById("phone");     // 휴대폰 번호 입력란
const userId = document.getElementById("id");           // 아이디 입력란
const pwd = document.getElementById("pwd");             // 비밀번호 입력란
const email = document.getElementById("email");         // 이메일 입력란
const memberBtn = document.getElementById("memberBtn"); // 회원가입 완료 버튼

// [3] 에러 메시지 영역 참조 (문구 노출용)
// 유효성 검사 실패 시 화면에 "block" 처리되어 나타날 <p> 태그들입니다.
const nameError = document.getElementById("nameError");
const phoneError = document.getElementById("phoneError");
const idError = document.getElementById("idError");
const pwdError = document.getElementById("pwdError");
const emailError = document.getElementById("emailError");

// [4] 정규표현식(Regex) 정의
// 각 데이터의 형식을 정의한 규칙 세트입니다.
const regex = {
    name: /^[가-힣]{2,}$/,                // 한글로만 2자 이상 입력
    phone: /^010\d{8}$/,                 // 010으로 시작하고 뒤에 숫자 8개 (총 11자)
    id: /^[a-zA-Z0-9]{8,12}$/,           // 영문 혹은 숫자로 8~12자 사이
    email: /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/ // 표준 이메일 형식 (계정@도메인.확장자)
};

/**
 * [5] 비밀번호 유효성 검사 함수
 * 규칙: 10~16자 이내이며, 영문/숫자/특수문자 중 최소 2종류 이상 혼합
 * @param {string} v - 입력된 비밀번호 문자열
 * @returns {boolean} - 유효성 통과 여부
 */
function validatePwd(v) {
    let count = 0;
    if (/[A-Za-z]/.test(v)) count++;      // 영문 포함 시 +1
    if (/[0-9]/.test(v)) count++;         // 숫자 포함 시 +1
    if (/[^A-Za-z0-9]/.test(v)) count++;  // 특수문자(영문/숫자 아닌 것) 포함 시 +1
    
    // 길이 조건(10~16)과 조합 조건(2종 이상)을 모두 만족해야 true
    return v.length >= 10 && v.length <= 16 && count >= 2;
}

/**
 * [6] 전체 폼 유효성 판단 및 버튼 상태 업데이트
 * 모든 입력값이 정규식 및 규칙을 통과했을 때만 "회원가입" 버튼을 활성화합니다.
 */
function updateJoinButton() {
    // 모든 필드의 통과 여부를 AND(&&) 연산으로 확인
    const isFormValid = 
        regex.name.test(nameInput.value.trim()) && // 이름 통과?
        regex.phone.test(phoneInput.value.trim()) && // 전화번호 통과?
        regex.id.test(userId.value) &&              // 아이디 통과?
        validatePwd(pwd.value) &&                  // 비밀번호 통과?
        regex.email.test(email.value) &&           // 이메일 통과?
        window.isIdAvailable;                      // 아이디 중복체크 통과?

    // 결과에 따라 버튼의 비활성화(disabled) 상태 결정
    memberBtn.disabled = !isFormValid;
    
    // 통과 시 css의 .active 클래스를 추가하여 버튼을 초록색으로 변경
    if(isFormValid) memberBtn.classList.add("active");
    else memberBtn.classList.remove("active");
}

/**
 * [7] 필드별 에러 메시지 노출/숨김 처리 함수 (공통)
 * @param {HTMLElement} inputEl - 입력 필드 요소
 * @param {HTMLElement} errorEl - 해당 에러 메시지 요소
 * @param {string} regexKey - 사용할 정규표현식 키값
 */
function checkField(inputEl, errorEl, regexKey) {
    const v = inputEl.value.trim();
    
    // 입력값이 아예 없으면 에러 메시지도 숨김 (초기 상태처럼 보이기 위함)
    if (v === "") {
        errorEl.style.display = "none";
        return;
    }
    
    // 정규표현식 테스트 결과 확인
    const isOk = regex[regexKey].test(v);
    
    // 통과하면 에러 숨김(none), 실패하면 에러 노출(block)
    errorEl.style.display = isOk ? "none" : "block";
    
    // 값이 바뀔 때마다 전체 가입 버튼 상태도 재검토
    updateJoinButton();
}

// [8] 실시간 입력 이벤트 리스너 등록
// 사용자가 타이핑을 할 때마다(input 이벤트) 즉시 검증을 수행합니다.
nameInput.addEventListener("input", () => checkField(nameInput, nameError, 'name'));
phoneInput.addEventListener("input", () => checkField(phoneInput, phoneError, 'phone'));
userId.addEventListener("input", () => checkField(userId, idError, 'id'));
email.addEventListener("input", () => checkField(email, emailError, 'email'));

// 비밀번호는 복합 검증이 필요하므로 별도 핸들러 사용
pwd.addEventListener("input", () => {
    const ok = validatePwd(pwd.value);
    // 비어있거나 규칙을 통과했으면 에러 숨김
    pwdError.style.display = (pwd.value === "" || ok) ? "none" : "block";
    updateJoinButton();
});

/**
 * [9] 카카오 주소 API 연동 함수
 * 버튼 클릭 시 우편번호 찾기 팝업을 실행합니다.
 */
function execKakaoPostcode() {
    new kakao.Postcode({
        oncomplete: function(data) {
            // 사용자가 도로명 주소(R)를 선택했는지 지번 주소(J)를 선택했는지 판단
            let addr = (data.userSelectedType === 'R') ? data.roadAddress : data.jibunAddress;
            
            // HTML 각 칸에 값 채워넣기
            document.getElementById('postcode').value = data.zonecode; // 우편번호
            document.getElementById("address").value = addr;           // 주소
            
            // 상세 주소창으로 포커스를 이동시켜 다음 입력을 유도
            document.getElementById("detailAddress").focus();
        }
    }).open();
}