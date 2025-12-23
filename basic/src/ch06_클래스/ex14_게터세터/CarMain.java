package ch06_클래스.ex14_게터세터;

public class CarMain {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		// 음수는 입력 못하게 제한
		myCar.setSpeed(-50); // 쓰기(수정)
		int result = myCar.getSpeed(); //읽기
		System.out.println("현재속도는"+result+"km입니다.");
		
		myCar.setSpeed(50); // 쓰기(수정)
		result = myCar.getSpeed(); //읽기
		System.out.println("현재속도는"+result+"km입니다.");
		
		// 멈춤
		if (!myCar.isStop()) {
			myCar.setStop(true);
		}
		System.out.println(myCar.getSpeed());
	}

}
