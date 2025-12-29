package ch08_인터페이스.ex02_상수필드;

/**
 * 인터페이스의 상수 필드 접근
 *  - static 필드이므로
 *  - 인터페이스명.필드명 
 */
public class RemoteControlExample {
	public static void main(String[] args) {
		 System.out.println("리모콘 최대 볼륨: " + RemoteControl.MAX_VOLUME);
		 System.out.println("리모콘 최저 볼륨: " + RemoteControl.MIN_VOLUME);
	}
}