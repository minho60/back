package ch09_중첩.ex01_인스턴스멤버클래스;


public class AExample2 {
	public static void main(String[] args) {
		//A 객체 생성
		A2 a = new A2();

		//A 인스턴스 메소드 호출
		a.useB();
	}
}