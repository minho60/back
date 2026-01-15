package ch15_람다식.ex05_메서드참조;
/**
 * 메서드 참조
 *  - 메서드를 참조해서 매개변수의 정보 및 리턴 타입을 알아내
 *    람다식에서 불필요한 매개변수를 제거하는 것을 목적으로 한다.
 *    
 *    (left, right) -> Math.max(left, right);
 *    
 *    Math :: max;
 *   
 *  - 정적 메서드의 경우
 *    
 *    	클래스 :: 메서드
 *    
 *  - 인스턴스 메서드의 경우
 *    
 *    	참조변수 :: 메서드
 *  
 */
public class MethodReferenceExample {
	public static void main(String[] args) {
		Person person = new Person();
		
		//정적 메소드일 경우
		//람다식
		//person.action((x, y) -> Computer.staticMethod(x, y));		
		//메소드 참조
		person.action(Computer :: staticMethod);
		
		//인스턴스 메소드일 경우
		Computer com = new Computer();
		//람다식
		//person.action((x, y) -> com.instanceMethod(x, y));		
		//메소드 참조
		person.action(com :: instanceMethod);
	}
}