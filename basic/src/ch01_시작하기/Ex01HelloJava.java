package ch01_시작하기;
/* package 패키지명;
 * 1. 소문자로 기록
 * 2. 숫자로 시작 X
 * 3. 특수 문자는 . 과 _
 * 	
 */

/**
 *  문서주석(Javadoc):alt+shift+j
 *  @autor 작성자명
 *  기능: Hello
 *  작성일: 2025-12-09
 *  
 */


/*
 *  접근제한자 class 클래스명 {코드}
 *  1. 파스칼 표기법(관례) - 단어별 첫글자를 대문자
 *  2. _, $, 숫자 가능
 *  3. 예약어(키워드) 사용불가 - public, class, package,...
 */
public class Ex01HelloJava {
	/*
	 * 여러줄 주석 : ctrl+shift+/
	 */
	
	// 문자: char
	// 문자열: string
	// 정수: byte, short, int, long
	// 실수: float, double
	// 불: boolean
	// 배열: []
	// void: 메서드의 리턴 값이 없음
	// 접근제한자 static void main(데이터 타입 인자) 
	// - 프로그램의 시작점 
	public static void main(String[] args) {
		// ctrl + /: 주석, 한줄 주석
		// ctrl + shift + L: 단축키 목록
		// ctrl + +/-: 코드 뷰의 글자 크기를 확대/축소
		// F2 또는 alt+shift+R :이름바꾸기
		// alt + 위아래방향키: 선택한 영역 위치이동
		// ctrl + alt+ 위아래방향키: 선택한 줄 복제
		// ctrl + D :선택한 영역 삭제
		// ctrl + SPACE: 자동 완성
		// ctrl + F11: 실행
		// ctrl +  M: 코드 편집창 최대화/ 원래대로
		// ctrl + I: 선택한 영역 자동 들여쓰기
		// ctrl + shift + F: 자동 들여쓰기
		// alt + shift + Y:줄 바꿈
		
		
		// char 문자: 문자 1자 -> 예) 'A', 'a', '가' ..
		// String "문자열"
		// 객체.메서드(인자)
		// print() - 줄 바꿈 안됨.
		System.out.print("Hello,Java");
		// println() - 줄 바꿈 된다.
		System.out.println("Hello, Java");
	}
}
