package ch06_클래스.ex02_필드와생성자;

public class CarMain {

	public static void main(String[] args) {
		// new 연산자는 객체 생성 후 생성자를 호출해서 객체를 초기화한다.
		Car myCar = new Car();
		Car myCar2 = new Car("소나타");
		System.out.println("현재 모델은?"+ myCar.model);
		System.out.println("현재 모델은?"+ myCar2.model);
	}

}
