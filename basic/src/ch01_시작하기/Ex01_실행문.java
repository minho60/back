package ch01_시작하기;

public class Ex01_실행문 {
	// 클래스 생성 후
	// main을 쓰고 ctrl + spacebar
	// 프로그램의 시작 진입점
	public static void main(String[] args) {
		
		// 실행문(Statement)?
		// -> 실행문 끝에는 반드시 ;(세미콜론)을 쓴다.
		// 정수(Integer): byte, short, char, int, long
		int x; // 변수 선언
		x = 1; // 변수 값 할당
		int y=2; // 변수 선언 및 할당
		int result= x+y; // 변수 선언 및 할당(연산) 
		
		System.out.println(result); // 출력
	}

}
