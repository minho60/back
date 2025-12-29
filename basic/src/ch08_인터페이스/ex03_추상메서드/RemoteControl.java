package ch08_인터페이스.ex03_추상메서드;

/**
 * 추상메서드
 *  - 중괄호{...}가 없는 메서드
 *  - 구현 클래스에서 반드시 재정의 해야한다.
 *  
 *  
 *   [public abstract] 리턴타입 메서드명([매개변수,...]);
 */
public interface RemoteControl {
	// 상수필드
	// 최대볼륨
	//모두 대문자 스네이크 표기법 (관례)
	// 형식:[public static final]타입 필드명 = 값;
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	
	// 추상 메서드
	// 형식: [public abstract] 리턴타입 메서드명([매개변수,...]);
	// 전원켜기
	// 리턴 값이 없으면: void
	// 카멜 표기법(관례)
	void turnOn();
	//전원끄기
	void turnOff();
	// 볼륨조절
	void setVolume(int volume);
}
