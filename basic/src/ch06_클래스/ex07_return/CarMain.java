package ch06_클래스.ex07_return;

public class CarMain {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		// 리턴값이 없는 메서드 호출
		myCar.setGas(5);
		
		//리턴 값이 있는 메서드 호출
		if(myCar.isLeftGas()) {
			System.out.println("출발합니다.");
			myCar.run();
		}
		System.out.println("gas를 주입하세요");
		
	}

}
