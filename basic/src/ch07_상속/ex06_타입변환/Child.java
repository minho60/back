package ch07_상속.ex06_타입변환;

public class Child extends Parent {
	//필드 선언
	public String field2;

	//메소드 오버라이딩
	@Override
	public void method2() {
		System.out.println("Child-method2()");
	}

	//메소드 선언
	public void method3() {
		System.out.println("Child-method3()");
	}
}