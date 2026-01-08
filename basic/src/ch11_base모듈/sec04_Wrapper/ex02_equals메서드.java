package ch11_base모듈.sec04_Wrapper;
/**
 * 포장 객체는 내부 값을 비교하기 위해 ==와 != 연산자를 사용할 수 없다.
 * -> 왜? 내부의 값을 비교하는 것이 아니라, 포장 객체의 번지를 비교하기 때문이다.
 * 
 * 그러나, 포장 객체의 효율적 사용을 위해 다음 범위의 값을 갖는 포장 객체는 공유된다.
 * 		
 * 		boolean: true, false
 * 		char: \u0000~\u007f
 * 		byte, short, int: -128~127
 * 
 * 포장 객체에 정확히 어떤 값이 저장될 지 모르는 상황이라면
 * ==과 !=은 사용하지 않는 것이 좋다.
 * 대신 equals() 메서드로 내부 값을 비교할 수 있다.
 * -> 포장 클래스의 equals() 메서드는 내부의 값을 비교하도록 재정의되어 있다.
 */
public class ex02_equals메서드 {
	public static void main(String[] args) {
		//-128~127 초과값일 경우
		Integer obj1 = 300;
		Integer obj2 = 300;
		System.out.println("==: " + (obj1 == obj2));
		System.out.println("equals(): " + obj1.equals(obj2));
		System.out.println();

		//-128~127 범위값일 경우
		Integer obj3 = 10;
		Integer obj4 = 10;
		System.out.println("==: " + (obj3 == obj4));
		System.out.println("equals: " + obj3.equals(obj4));
	}
}