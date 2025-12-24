package ch07_상속.ex03_메서드재정의;

public class SupersonicAirplane extends Airplane {
	//상수 선언
	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 2;
	//상태 필드 선언
	public int flyMode = NORMAL;

	//메소드 재정의
	@Override
	public void fly() {
		if(flyMode == SUPERSONIC) {
			System.out.println("초음속 비행합니다.");
		} else {
			//Airplane 객체의 fly() 메소드 호출
			// super: 부모 클래스를 가르킨다.
			// super(): 부모클래스의 기본생성자를 가르킨다.
			super.fly();
		}
	}
}