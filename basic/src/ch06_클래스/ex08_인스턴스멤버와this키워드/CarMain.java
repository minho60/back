package ch06_클래스.ex08_인스턴스멤버와this키워드;

public class CarMain {

	public static void main(String[] args) {
		// 객체생성
		Car myCar = new Car("소나타");
		Car yourCar = new Car("벤츠");

		// 메서드 호출
		myCar.run();
		yourCar.run();
		
	}

}
