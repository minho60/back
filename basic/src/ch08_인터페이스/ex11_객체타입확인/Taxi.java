package ch08_인터페이스.ex11_객체타입확인;

public class Taxi implements Vehicle {
	@Override
	public void run() {
		System.out.println("택시가 달립니다.");
	}
}