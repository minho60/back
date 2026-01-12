package ch12제네릭.ex02_제네릭타입;
/**
 * 제네릭 타입
 *  - 결정되지 않은 타입을 파라미터로 가지는 클래스와 인터페이스를 말한다.
 *  - 선언부에 '<>'부호가 붙고 그 사이에 타입 파라미터들이 위치한다.
 *  - 변수명과 동일한 규칙에 따라 작성할 수 있지만
 *    일반적으로 대문자 알파벳 한 글자로 표현한다.
 *  - 외부에서 제네릭 타입을 사용하려면 타입 파라미터에 구체적인 타입을 지정해야 한다.
 *    -> 만약 지정하지 않으면 Object 타입이 암묵적으로 사용된다.
 *  
 *     	public class 클래스명<A, B, ...> {...}
 *    	public interface 인터페이스<A, B, ...> {...}
 *    
 */

//제네릭 타입
public class Product<K, M> {
	//필드
	private K kind;
	private M model;
	
	//메소드
	public K getKind() { return this.kind; }
	public M getModel() { return this.model; }
	public void setKind(K kind) { this.kind = kind; }
	public void setModel(M model) { this.model = model; }
}