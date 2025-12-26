package ch07_상속.ex07_다형성;

public class Driver {
	//메소드 선언(클래스 타입의 매개변수를 가지고 있음)
	public void drive(Vehicle vehicle) {
		vehicle.run();
	}
}