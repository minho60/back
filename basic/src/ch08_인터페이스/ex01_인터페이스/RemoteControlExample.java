package ch08_인터페이스.ex01_인터페이스;

public class RemoteControlExample {
	public static void main(String[] args) {
		RemoteControl rc;

		//rc 변수에 Television 객체를 대입
		rc = new Television();
		rc.turnOn();
		
		//rc 변수에 Audio 객체를 대입(교체시킴)
		rc = new Audio();
		rc.turnOn();
	}
}