/**
 * 로그인 실패 알림 및 URL 관리 스크립트
 * (보통 fail.js 파일로 관리하거나 login.jsp 하단에 배치함)
 */

// [1] window.onload: 
// 브라우저가 HTML, CSS, 이미지 등 모든 리소스를 완벽히 로드한 시점에 실행됩니다.
// 로그인 실패 후 리다이렉트된 페이지가 완전히 그려진 후 팝업을 띄우기 위함입니다.
window.onload = function() {

    /**
     * [2] location.search: 
     * 현재 브라우저 주소창의 쿼리 스트링(예: ?error 또는 ?error=true)을 가져옵니다.
     * * [3] indexOf('error') !== -1:
     * 'error'라는 문자열이 URL에 포함되어 있는지 검사합니다.
     * 스프링 시큐리티는 인증 실패 시 기본적으로 '/login?error'로 리다이렉트시키기 때문입니다.
     */
    if (location.search.indexOf('error') !== -1) {
        
        // [4] 사용자 알림: 브라우저 표준 경고창으로 실패 메시지를 출력합니다.
        alert("아이디 또는 비밀번호가 일치하지 않습니다.");
        
        /**
         * [5] history.replaceState(): 브라우저 주소창 정리 (UX 개선)
         * - 첫 번째 인자({}): 보관할 상태 데이터 (없으므로 빈 객체)
         * - 두 번째 인자(null): 페이지 제목 (대부분 무시됨)
         * - 세 번째 인자(location.pathname): 파라미터가 제거된 순수 경로 (예: /member/login)
         * * ※ 이 코드가 중요한 이유:
         * 사용자가 경고창을 확인한 후 '새로고침(F5)'을 눌렀을 때, 
         * 주소창에 '?error'가 남아있으면 알림창이 중복해서 뜨는 불편함을 방지합니다.
         */
        history.replaceState({}, null, location.pathname);
    }
};