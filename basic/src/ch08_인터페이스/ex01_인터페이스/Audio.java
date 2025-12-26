package ch08_인터페이스.ex01_인터페이스;
/**
 * 구현 클래스 선언
 *  - implements 키워드는 해당 클래스가 인터페이스를 통해 사용할 수 있다는 표시이며,
 *  - 인터페이스의 추상 메서드를 재정의한 메서드가 있다는 뜻이다.
 *
 * 		[접근제한자] class 클래스명 implements 인터페이스명 {...}
 *
 */
public class Audio implements RemoteControl {
	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다.");
	}
}