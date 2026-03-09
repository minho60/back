/**
 * [loginWithNaver]
 * 네이버 로그인 버튼 클릭 시 호출되는 함수입니다.
 * 사용자를 네이버 아이디 로그인 인증 화면으로 이동시킵니다.
 */
function loginWithNaver() {
    // 1. Client ID: 네이버 개발자 센터에서 내 애플리케이션을 등록하고 발급받은 고유 키입니다.
    const clientId = 'kkZ_z1OsnyKqkMqPbBOv'; 

    // 2. Callback URL: 네이버 인증이 완료된 후 사용자를 돌려보낼(Redirect) 주소입니다.
    // - 주의: 네이버 개발자 센터 설정의 '서비스 URL' 및 'Callback URL'과 정확히 일치해야 합니다.
    // - encodeURIComponent(): URL에 특수문자가 포함될 경우 발생할 수 있는 오류를 방지하기 위해 인코딩합니다.
    const callbackUrl = encodeURIComponent('http://localhost:9090/sns/naver-callback');

    // 3. State: 사이트 간 요청 위조(CSRF) 공격을 방지하기 위한 보안용 랜덤 문자열입니다.
    // - 인증 요청 시 보낸 값을 콜백(Callback) 시점에 다시 확인하여 요청의 무결성을 검증합니다.
    const state = Math.random().toString(36).substr(2, 11); 
    
    // 4. 네이버 로그인 인증 요청 URL 조립
    // - response_type=code: 인증 결과로 '인가 코드(Authorization Code)'를 받겠다고 명시합니다.
    // - client_id: 내 앱의 식별자
    // - redirect_uri: 인증 완료 후 돌아올 주소
    // - state: 위에서 생성한 보안 상태값
    const naverAuthUrl = `https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=${clientId}&redirect_uri=${callbackUrl}&state=${state}`;
    
    // 5. 페이지 이동: 현재 창의 주소를 조립된 네이버 인증 URL로 변경하여 이동시킵니다.
    location.href = naverAuthUrl;
}/**
 * 
 */