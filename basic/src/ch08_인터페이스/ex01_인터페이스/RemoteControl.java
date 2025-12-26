package ch08_인터페이스.ex01_인터페이스;
/**
 * 인터페이스(interface)
 *  - 클래스가 반드시 구현해야 하는 메서드의 규약(Contract)
 *  - 몸체가 없는 메서드만 선언하고, 실제 구현은 implements한 클래스에서 정의
 * 	- 다형성 구현에 주된 기술
 * 
 * 인터페이스 선언
 * 	- interface 키워드를 사용한다.
 *  - 접근제한자는 public 또는 default -> 클래스와 같다.
 *  
 *  	inteface 인터페이스명 {...}
 *  	public interface 인터페이스명 {
 *  		// public 상수 필드
 *  		// public 추상 메서드
 *  		// public 디폴트 메서드
 *  		// public 정적 메서드
 *  		// private 메서드
 *  		// private 정적 메서드
 * 		}
 * 
 */
public interface RemoteControl {
	//public 추상 메소드
	public void turnOn();
}	