package ch12제네릭.ex01_제네릭이란;

/**
 * 제네릭(Generic)?
 * 	- 결정되지 않은 타입을 파라미터로 처리하고,
 *    실제 사용할 때 파라미터를 구체적인 타입으로 대체시키는 기능
 *  - 타입 파라미터 기호는 A~Z까지 임의 알파벳을 사용하면 된다.
 *  - 주의할 점은 타입 파라미터를 대체하는 타입은 클래스 및 인터페이스라는 것이다.
 *    -> 주의! 기본 타입은 타입 파라미터의 대체 타입이 될 수 없다.
 *  - 변수를 선언할 때와 동일한 타입으로 호출하고 싶다면
 *    생성자 호출 시 생성자에는 타입을 명시하지 않고 <>만 붙일 수 있다.
 *    
 *    	public class 클래스명<A, B, ...> {...}
 *    	public interface 인터페이스<A, B, ...> {...}
 *    
 */
public class Box<T> {
	public T content;
}
class Box2{
	public String content;
	public int content2;
}