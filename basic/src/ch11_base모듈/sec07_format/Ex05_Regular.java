package ch11_base모듈.sec07_format;

import java.util.regex.Pattern;

/**
 * java.util.regex.Pattern
 *  - 정규 표현식(Reqular Expression) 클래스
 *  - 문자열이 올바르게 구성되었는지 검증한다.
 *  - 예) 이메일이나 전화번호를 사용자가 제대로 입력했는지 검증
 *    
 *  표현 및 기호
 *  	[]		한 개의 문자
 *  			[abc]		a,b,c 중 하나의 문자
 *  			[^abc]		a,b,c 이외의 하나의 문자
 *  			[a-zA-Z]	a~z,A~Z 중 하나의 문자 -> 1개의 영문자
 *  	\d		한 개의 숫자, [0-9]와 동일
 *  	\s		공백
 *  	\w		한 개의 알파벳 또는 한 개의 숫자, [a-zA-Z_0-9]와 동일
 *  	\.		.
 *  	.		모든 문자 중 한 개의 문자
 *  	?		없음 또는 한 개
 *  	*		없음 또는 한 개 이상
 *  	+		한 개 이상
 *  	{n}		정확히 n개
 *  	{n,}	최소한 n개
 *  	{n,m}	n개부터 m개까지
 *  	a|b		a 또는 b
 *  	()		그룹핑
 *  
 *  
 * 	- static boolean matches(String regex, CharSequence input) 
 *  
 */
public class Ex05_Regular {
	public static void main(String[] args) {
		// 아이디 비밀번호 ai 프롬프트 사용해서 여러가지 조건으로 적용 가능
		// 전화번호
		// \\는 이스케이프 문자로 역슬래시(\) 하나를 문자열로 포함시킨다.
		String regExp = "(02|010)-\\d{3,4}-\\d{4}";
		String data = "010-123-4567";
		boolean result = Pattern.matches(regExp, data);
		if(result) {
			System.out.println("정규식과 일치합니다.");
		} else {
			System.out.println("정규식과 일치하지 않습니다.");
		}
			
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		data = "angel@mycompanycom";
		result = Pattern.matches(regExp, data);
		if(result) {
			System.out.println("정규식과 일치합니다.");
		} else {
			System.out.println("정규식과 일치하지 않습니다.");
		}
	}
}
