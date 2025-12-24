package ch07_상속.ex05_protected.pack1;

/**
 * protected 접근 제한자
 * 1. 같은 패키지는 접근가능
 * 2. 상속 받은 자식 클래스의 경우 다른 패키지라도 접근가능  
 * 
 * 즉, B 클래스는 A 클래스 멤버를 사용가능
 * 		C, D 클래스는 A 클래스를 상속 받아야 사용가능
 */
public class A {
	//필드 선언
	protected String field;

	//생성자 선언
	protected A() {
	}

	//메소드 선언
	protected void method() {
	}
}