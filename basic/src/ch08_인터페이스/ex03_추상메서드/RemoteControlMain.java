package ch08_인터페이스.ex03_추상메서드;

public class RemoteControlMain {

	public static void main(String[] args) {
		// 인터페이스 변수 선언
		RemoteControl rc;
		
		// 객체할당
		rc = new Television();
		rc.turnOn();
		rc.setVolume(-1);
		rc.turnOff();
		
		
		rc = new Audio();
		rc.turnOn();
		rc.setVolume(13);
		rc.turnOff();

		

	}

}
