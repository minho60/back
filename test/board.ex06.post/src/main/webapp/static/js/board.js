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