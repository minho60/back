package ch06_클래스.ex09_정적멤버;
/**
 * 21.정적(static) 멤버
 * 	- 자바는 클래스 로더(loader)를 이용해서 클래스를 메서드 영역에 저장하고 사용한다.
 *  - 정적 멤버? 메서드 영역의 클래스에 고정적으로 위치하는 멤버를 말한다.
 *  -> 따라서, 정적 멤버는 객체 생성 없이 클래스를 통해 바로 사용 가능하다.
 * 
 * 언제 사용?
 *  - 객체마다 가지고 있을 필요성이 없는 공용적인 필드는 정적 필드로 선언하는 것이 좋다.
 *  - 인스턴스 필드를 이용하지 않는 메서드는 정적 메서드로 선언하는 것이 좋다.
 * 
 * 사용 방법?
 *  1. 정적 필드
 *   	static 타입 변수 [= 초깃값];
 *  2. 정적 메서드
 *  	static 리턴타입 메서드(매개변수,...) {...}
 *   	
 */
public class Calculator {
	// 인스턴스 필드
	String color;
	
	// 정적 필드
	// static 타입 변수[=초깃값];
	static double pi = 3.141592;
	
	// 인스턴스 메서드
	void setColor(String color) {
		this.color = color;
	}
	
	// 정적 메서드
	static int add(int x, int y) {
		return x+y;
	}

}
