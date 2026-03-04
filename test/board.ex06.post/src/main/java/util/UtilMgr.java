package util;

import java.io.File;

/**
 * [UtilMgr - Utility Manager]
 * 프로젝트 전반에서 공통적으로 사용되는 독립적인 기능(문자열 처리, 파일 관리 등)을 
 * 모아놓은 유틸리티 클래스입니다.
 */
public class UtilMgr {

    /**
     * [Private 생성자]
     * 유틸리티 클래스는 상태를 가지지 않으므로 외부에서 new UtilMgr()로 
     * 인스턴스를 생성할 필요가 없습니다. 이를 방지하여 메모리 낭비를 막습니다.
     */
    private UtilMgr() {
        // 인스턴스화 방지
    }

    /**
     * [문자열 치환 (null-safe)]
     * 특정 문자열 내의 패턴을 찾아 새 문자열로 바꿔줍니다.
     * * @param str         원본 문자열
     * @param pattern     찾을 문자 (예: "<")
     * @param replacement 바꿀 문자 (예: "&lt;")
     * @return 치환된 문자열 (원본이 null이면 null 반환)
     * * 활용 예: 게시판 내용 중 HTML 태그가 실행되지 않도록 특수문자로 변환할 때 사용합니다.
     */
    public static String replace(String str, String pattern, String replacement) {
        // null 체크를 통해 NullPointerException 발생을 원천 차단(null-safe)
        if (str == null) return null;
        
        // Java String 클래스의 기본 replace 메서드를 활용하여 치환 결과 반환
        return str.replace(pattern, replacement);
    }
}