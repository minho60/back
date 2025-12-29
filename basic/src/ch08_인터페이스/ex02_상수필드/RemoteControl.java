package ch08_인터페이스.ex02_상수필드;

/**
 * 상수 필드
 *  - [public static final] 타입 상수면 = 값; 
 */
public interface RemoteControl {
	// 상수는 대문자 + 스네이크 표기법(관례)
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
}