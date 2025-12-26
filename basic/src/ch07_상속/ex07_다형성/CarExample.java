package ch07_상속.ex07_다형성;

public class CarExample {
	public static void main(String[] args) {
		//Car 객체 생성
		Car myCar = new Car();

		//Tire 객체 장착
		Tire tire = new Tire();
		myCar.tire = new Tire();
		myCar.run(); // 회전합니다.

		//HankookTire 객체 장착
		myCar.tire = new HankookTire();
		myCar.run();

		//KumhoTire 객체 장착
		myCar.tire = new KumhoTire();
		myCar.run();
	}
}