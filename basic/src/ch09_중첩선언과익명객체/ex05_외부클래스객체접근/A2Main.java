package ch09_중첩선언과익명객체.ex05_외부클래스객체접근;

public class A2Main {
	public static void main(String[] args) {
		//A 객체 생성
		A2 a = new A2();

		//A 메소드 호출
		a.useB();
	}
}