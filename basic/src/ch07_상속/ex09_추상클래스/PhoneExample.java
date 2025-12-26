package ch07_상속.ex09_추상클래스;

public class PhoneExample {
	public static void main(String[] args) {
		//Phone phone = new Phone();

		SmartPhone smartPhone = new SmartPhone("홍길동");

		smartPhone.turnOn();
		smartPhone.internetSearch();
		smartPhone.turnOff();
	}
}