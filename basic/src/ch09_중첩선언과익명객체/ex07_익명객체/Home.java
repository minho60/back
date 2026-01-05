package ch09_중첩선언과익명객체.ex07_익명객체;
/**
 * 익명 구현 객체
 * 	- 익명 구현 객체를 인터페이스를 구현해서 생성된다.
 *  - 익명 구현 객체로 생성된 객체는 인터페이스 타입의 필드, 로컬변수, 매개변수의 값으로 대입할 수 있다.
 *  - 중괄호 블록 안의 필드와 메서드는 익명 구현 객체가 가져할 멤버로,
 *    중괄호 블록 안에서만 사용할 수 있다.
 *  - 익명 구현 객체는 인턴페이스 타입에 대입되므로 인터페이스 타입에 선언된 멤버만 접근할 수 있다.
 *  - 중괄호 블록 안에는 주로 인터페이스의 추상 메서드를 재정의하는 코드가 온다.
 *  
 *   	new 인터페이스() {
 *   		// 필드
 *   		// 메서드
 *   	}
 */
public class Home {
	//필드에 익명 구현 객체 대입
	private RemoteControl rc = new RemoteControl() {
		@Override
		public void turnOn() {
			System.out.println("TV를 켭니다.");
		}
		@Override
		public void turnOff() {
			System.out.println("TV를 끕니다.");
		}
	};
		
	//메소드(필드 이용)
	public void use1() {
		rc.turnOn();
		rc.turnOff();
	}
	
	//메소드(로컬 변수 이용)
	public void use2() {
		//로컬 변수에 익명 구현 객체 대입
		RemoteControl rc = new RemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("에어컨을 켭니다.");
			}
			@Override
			public void turnOff() {
				System.out.println("에어컨을 끕니다.");
			}
		};
		rc.turnOn();
		rc.turnOff();
	}
	
	//메소드(매개변수 이용)
	public void use3(RemoteControl rc) {
		rc.turnOn();
		rc.turnOff();
	}
}