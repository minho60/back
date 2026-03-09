/**
 * list.jsp
 * 검색어가 비어있는지 확인하는 check() 함수
 */
function check() {
    var f = document.searchFrm;
    if (f.keyWord.value.trim() == "") {
        alert("검색어를 입력하세요.");
        f.keyWord.focus();
        return;
    }
    f.submit();
}

/**
 * read.jsp
 */
function list() {
	const frm = document.listFrm;
	
	// nowPage 값이 없거나 null이면 기본값 1을 할당
	if (!frm.nowPage.value || frm.nowPage.value === "") {
	    frm.nowPage.value = "1";
	}
	
	frm.submit();
}

/**
 * [게시글 수정 유효성 검사]
 * 사용자가 수정 폼을 작성하고 '수정완료' 버튼을 눌렀을 때 호출됩니다.
 * 목적: 필수 항목(비밀번호) 입력 여부를 확인하여 서버의 불필요한 요청을 방지합니다.
 */
function updateCheck() {
    // 1. 폼 객체 참조
    // <form name="updateFrm">으로 정의된 폼 요소에 접근합니다.
    const frm = document.updateFrm;

    // 2. 비밀번호 입력 여부 및 공백 체크
    // .value: 입력된 값을 가져옴
    // .trim(): 문자열 앞뒤의 의미 없는 공백을 제거 (스페이스바만 입력하는 경우 방지)
    // ! (NOT 연산자): 값이 비어있다면 true가 됨
    if (!frm.pass.value.trim()) {
        // 3. 사용자 알림 및 포커스 이동
        alert("수정을 위해 비밀번호를 입력하세요.");
        
        // 입력창으로 커서를 이동시켜 사용자가 바로 입력할 수 있게 편의성 제공
        frm.pass.focus();
        
        // 함수를 여기서 종료하여 frm.submit()이 실행되지 않도록 막음
        return;
    }

    // 4. 서버로 데이터 전송
    // 모든 유효성 검사를 통과했을 경우, 폼의 action 경로(/board/update)로 데이터를 전송(POST)합니다.
    frm.submit();
}

/**
 * 게시물 삭제 전 유효성 검사를 수행하는 함수
 * delete.jsp의 '삭제완료' 버튼 클릭 시 호출됨
 */
function deleteCheck() {
    // 1. form 객체 참조: name 속성이 'delFrm'인 폼을 변수에 할당
    const frm = document.delFrm;

    // 2. 비밀번호 입력값 확인
    // frm.pass.value: 입력된 값
    // .trim(): 문자열 양 끝의 공백을 제거 (스페이스바만 입력한 경우 방지)
    if (frm.pass.value.trim() === "") {
        // 3. 입력값이 없으면 경고창을 띄우고 중단
        alert("패스워드를 입력하세요.");
        
        // 4. 입력창으로 커서를 이동시켜 바로 입력할 수 있게 함
        frm.pass.focus();
        
        // 5. 함수 종료: 아래의 frm.submit()이 실행되지 않도록 함
        return;
    }

    // 6. 모든 검사를 통과하면 폼 데이터를 서버(deleteBoard 서블릿 등)로 전송
    frm.submit();
}