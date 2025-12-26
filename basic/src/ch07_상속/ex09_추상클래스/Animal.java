package ch07_상속.ex09_추상클래스;

/**
 * 추상 메서드
 *  - 자식 클래스의 공통 메서드라는 것만 정의할 뿐, 실행 내용을 가지지 않는다.
 * 	- abstract 키워드가 있고, 메서드 실행 내용인 중괄호 {}가 없다. 
 *  - 추상 메서드는 지식 클래스에서 반드시 재정의(오버라이딩)해서 실행 내용을 채워야 한다.
 *  
 *  	[접근제한자] abstract 반환타입 메서드명();
 */
public abstract class Animal {
	//메소드 선언
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}

	//추상 메소드 선언
	public abstract void sound();
}