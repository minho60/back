package ch06_클래스.ex01_oop;

/**
 * 클래스
 *  (1) 실행 클래스
 *  	- main 메서드를 가지고 있는 실행 가능한 클래스
 *  (2) 라이브러리 클래스
 *  	- 실행할 수 없으며, 다른 클래스에서 이용하는 클래스
 * 
 * 클래스 구성요소
 * - 필드
 * - 생성자
 * - 메서드
 * 		(1) 인스턴스 메서드: static(❌).
 * 			- 객체 생성 후 객체를 통해서 사용
 * 		(2) 정적(static, 클래스) 메서드: static(⭕).
 * 			- 객체 생성 없이 클래스 이름으로 메서드 사용
 */

public class StudentMain {
	
	// main() 메서드
	public static void main(String[] args) {
		// 객체 생성
		// 타입 변수 = new 생성자();
		Student s1 = new Student();
		Student s2 = new Student();
		
		System.out.println("s1 변수가 Student 객체를 참조합니다.");
		System.out.println("s2 변수가 Student 객체를 참조합니다.");
	}

}
