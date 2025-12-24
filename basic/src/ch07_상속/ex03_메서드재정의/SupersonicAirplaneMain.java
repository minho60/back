package ch07_상속.ex03_메서드재정의;

public class SupersonicAirplaneMain {
	public static void main(String[] args) {
		Airplane ap = new Airplane();
		ap.fly();
		
		SupersonicAirplane sa = new SupersonicAirplane();
		
		// 부모메서드: takeOff(), fly(), land()
		sa.takeOff();
		// fly()는 재정의된 자식 fly()가 먼저 호출된다.
		
		sa.fly(); //super.fly()
		// 자식: flyMode, fly()
		sa.flyMode = SupersonicAirplane.SUPERSONIC;
		sa.fly(); 
		sa.flyMode = SupersonicAirplane.NORMAL;
		sa.fly(); // super.fly()
		
		sa.land();
	}
}