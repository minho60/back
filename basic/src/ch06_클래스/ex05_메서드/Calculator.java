package ch06_클래스.ex05_메서드;

/**
 * 14.메서드 선언
 * 
 *   	[접근제어자] [static] 반환타입 메서드이름(매개변수목록) {
 *   			실행 코드
 *   			[return] 반환값;
 *   		} 
 * 
 * 		리턴타입 메서드명(매개변수,...) { 실행코드; }
 * 
 *  - 리턴타입
 *  	- 메서드가 실행한 후 호출한 곳으로 전달하는 결과값의 타입
 *  	- 리턴값이 없는 메서드는 void로 작성한다.
 * 		- 리턴 타입이 있는 메서드는 실행 블록 안에서 return 문으로 리턴값을 반드시 지정해야 한다.
 * 
 *  - 메서드명은 카멜 표기법 (관례)
 *  
 * 18.메서드 오버로딩?
 * 	- 메서드 이름은 같고, 매개변수의 타입, 개수, 순서가 다른 메서드를 여러 개 선언하는 것
 * 	- 왜? 다양한 매개값을 처리하기 위해서
 */
/**
 * 
 */
public class Calculator {

	/*
	 * [접근제한자] 리턴타입 메서드명([매개변수,...]){실행코드;[return 값];}
	 */
	// 1. 리턴(반환)값이 없는 메서드
	// - 리턴값이 없는 메서드는 void로 작성한다.
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	
	// 2. 매개변수와 리턴 값이 있는 메서드
	// 덧셈
	int add(int x, int y) {
		int result = x + y;
		return result;
	}
	// 나눗셈
	double divide(int x, int y) {
		// x는 강제 형 변환
		// y 는 double로 자동 변환
		// 왜? 연산시 큰 타입으로 자동 형 변환
		double result = (double) x / y;
		return result;
	}
	
	// 메서드 오버로딩
	// 사각형 넓이: areaRectangle
	

	
	// - 정사각형 -> 가로:width  세로:height 가 같다.
	// 메서드 이름은 카멜표기법(관례)
	double areaRectangle(double width) {
		return width*width;
	}
	
	// - 직사각형
	double areaRectangle(double width, double height) {
		return width*height;
	}
	
	
}
