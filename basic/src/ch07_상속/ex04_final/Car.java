package ch07_상속.ex04_final;

/**
 * final 키워드
 * 1. 필드
 * 		[접근제한자][static] final
 * 		-> 값 변경이 불가능한 상수
 * 2. 클래스
 * 		[접근제한자] final class 클래스명{...}
 * 		-> 상속불가 -> 즉, 부모 클래스가 될 수 없다.	
 * 3. 메서드
 * 		[접근제한자] final 리턴타입 메서드명(매개변수,...){...}
 * 		-> 자식 클래스에서 재정의 불가
 *  
 */
public class Car {
	//필드 선언
	public int speed;

	//메소드 선언
	public void speedUp() {
		speed += 1;
	}

	//final 메소드
	public final void stop() {
		System.out.println("차를 멈춤");
		speed = 0;
	}
}