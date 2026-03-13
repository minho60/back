// index.jsp
// 디버깅용: 현재 주소창의 쿼리 스트링(?...)을 콘솔에 찍어봅니다.
console.log("스크립트 로드됨. 현재 URL 파라미터: " + location.search);

// 페이지의 모든 HTML 요소가 로드된 후 실행됩니다.
window.onload = function() {
    // URL에 'regSuccess'라는 글자가 포함되어 있는지 검사합니다.
    // 예: http://localhost:8080/?regSuccess
    if (location.search.includes('regSuccess')) {
        alert("회원가입이 성공적으로 완료되었습니다! 로그인 후 이용해주세요.");
        
        /*-- 
            [중요] history.replaceState
            알림창을 띄운 후 주소창에서 '?regSuccess'를 제거합니다.
            이 처리를 하지 않으면 사용자가 'F5' 새로고침을 할 때마다 계속 알림창이 뜨게 됩니다.
        */
        history.replaceState({}, null, location.pathname);
    }
};