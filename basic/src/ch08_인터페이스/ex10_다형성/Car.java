package ch08_인터페이스.ex10_다형성;

public class Car {
	//필드
	Tire tire1 = new HankookTire();
	Tire tire2 = new HankookTire();

	//메소드
	void run() {
		tire1.roll();
		tire2.roll();
	}
}