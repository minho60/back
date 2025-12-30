package ch09_중첩.ex02_정적멤버클래스;


public class A2Main {

	public static void main(String[] args) {
		//B 객체 생성 및 인스턴스 필드 및 메소드 사용
		A2.B b = new A2.B();
		System.out.println(b.field1);
		b.method1();

		//B 클래스의 정적 필드 및 메소드 사용
		System.out.println(A2.B.field2);
		A2.B.method2();

	}

}
