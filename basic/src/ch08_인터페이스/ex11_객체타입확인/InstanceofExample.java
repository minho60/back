package ch08_인터페이스.ex11_객체타입확인;

public class InstanceofExample {
	public static void main(String[] args) {
		//구현 객체 생성
		Taxi taxi = new Taxi();
		Bus bus = new Bus();

		//ride() 메소드 호출 시 구현 객체를 매개값으로 전달
		ride(taxi);
		System.out.println();
		ride(bus);
	}
	
	//인터페이스 매개변수를 갖는 메소드
	public static void ride(Vehicle vehicle) {
		//방법1
		//Bus가 vehicle타입에 대입 가능한지 확인
		/*if(vehicle instanceof Bus) {
		 *  강제타입 변환
 			Bus bus = (Bus) vehicle;
 			bus.checkFare();
 		}*/

		//방법2
		// 타입확인 + 타입변환
		if(vehicle instanceof Bus bus) {
			bus.checkFare();
		}
		
		vehicle.run();
	}
}