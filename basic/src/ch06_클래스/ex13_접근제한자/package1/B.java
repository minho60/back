package ch06_클래스.ex13_접근제한자.package1;

public class B {
	B b;
	// default 필드 선언
	B b1 =  new B(false);
	B b2 =  new B(10);
	B b3 =  new B("문자열");
	
	// public 필드
	public int field1;
	// default 필드
	int field2;
	// private 필드
	private int field3;
	
	
	
	// A 클래스 접근 가능
	// 왜? A 클래스는 default로 선언
	// -> 같은 패키지 내에서는 접근 가능
	// A와 B 클래스는 package1로 같은 패키지에 있다.
	//A a;
	//A a1;
	//A a2;
	
	//cannot be resolved(해석된) to a type
	// D 는 어떤 유형우로도 해석 될 수 없다.
	// D 클래스는 default 선언했고, 다른 패키지이기 때문에 에러 발생
	// D d1;
	// D d2;
	
	//public 생성자
	public B(boolean b) {
		
	}
	
	//default 생성자
	B(int i){
		
	}
	
	// private 생성자
	private B(String s) {
		field1 =1;
		field2 =2;
		field3 =3;

		method1();
		method2();
		method3();
	}
	
	// public 메서드
	public void method1(){}
	// default 메서드
	void method2(){}
	// private 메서드
	private void method3(){}

}
