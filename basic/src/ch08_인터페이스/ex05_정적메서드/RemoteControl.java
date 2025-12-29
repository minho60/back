package ch08_인터페이스.ex05_정적메서드;

/**
 * 정적메서드
 * - 접근제한자를 생략하면 public 이다.		
 * 		
 * 		[public/private] static 리턴타입 메서드명(매개변수,...){실행부}
 */
public interface RemoteControl {
	//상수 필드
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;

	//추상 메소드
	void turnOn();
	void turnOff();
	void setVolume(int volume);

	//디폴트 메소드
	default void setMute(boolean mute) {
		//이전 예제와 동일한 코드이므로 생략
	}

	//정적 메소드
	static void changeBattery() {
		System.out.println("리모콘 건전지를 교환합니다.");
	}
}