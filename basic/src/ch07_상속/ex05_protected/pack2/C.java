package ch07_상속.ex05_protected.pack2;

// A와 C는 다른 패키지에 있으며, A 클래스를 상속 받지 않았다.
public class C {
	//메소드 선언
	public void method() {
		//A a = new A();		//x
		//a.field = "value"; 		//x
		//a.method(); 			//x
	}
}