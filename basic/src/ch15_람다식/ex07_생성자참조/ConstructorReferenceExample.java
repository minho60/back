package ch15_람다식.ex07_생성자참조;
/**
 * 생성자 참조
 * 	- 생성자를 참조한다는 것은 객체를 생성하는 거을 의미한다.
 *  - 람다식이 단순히 객체를 생성하고 리턴하도록 구성된다면 람다식을 생성자 참조로 대치할 수 있다.
 *  
 *   	(a, b) -> {return new 클래스(a, b); }
 *   
 *   	클래스 :: new
 *   
 *  - 생성자가 오버로딩되어 여러 개가 있을 경우,
 *    컴파일러는 함수형 인터페이스의 추상 메서드와 동일한 
 *    매개변수 타입과 개수를 가지고 있는 생성자를 찾아 실행한다.
 *    만약, 해당 생성자가 존재하지 않으면 컴파일 오류가 발생한다. 
 *   
 */
public class ConstructorReferenceExample {
	public static void main(String[] args) {
		Person person = new Person();

		//Member m1 = person.getMember1((a) -> {return new Member(a)});
		Member m1 = person.getMember1( Member :: new );
		System.out.println(m1);
		System.out.println();

		Member m2 = person.getMember2( Member :: new );
		System.out.println(m2);
	}
}