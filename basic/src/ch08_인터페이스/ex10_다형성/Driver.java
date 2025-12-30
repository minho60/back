package ch08_인터페이스.ex10_다형성;

public class Driver {
	// 매개변수로 인터페이스 타입 사용
	// -> 매개변수의 다형성 구현
	void drive( Vehicle vehicle ) {
		vehicle.run();
	}
}