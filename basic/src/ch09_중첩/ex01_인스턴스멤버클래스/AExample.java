package ch09_중첩.ex01_인스턴스멤버클래스;

public class AExample {
	public static void main(String[] args) {
		//A 객체 생성
		A a = new A();

		//B 객체 생성
		A.B b = a.new B();
	}
}