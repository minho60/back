package ch08_인터페이스.ex08_인터페이스상속;

/**
 * 인터페이스 상속
 *  - 다중 상속을 허용한다.
 *  
 *  	[접근제한자] class 클래스명 extends 클래스1, 클래스2,...{...}
 *  		-> 클래스 다중상속(X)
 *  
 *   	[접근제한자] interface 자식인터페이스 extends 부모인터페이스1, 부모인터페이스2,...{...}
 *   		-> 인터페이스 다중상속(O)
 *   
 *   	[접근제한자] interface 인터페이스명 implements 인터페이스1, 인터페이스2,...{...}
 *   		-> 인터페이스 다중구현 가능
 *   
 *   
 */
public interface InterfaceC extends InterfaceA, InterfaceB {
	//추상 메소드
	void methodC();
}