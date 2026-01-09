package ch11_base모듈.sec04_Wrapper;
/**
 * 포장(Wrapper) 클래스
 *  - 기본 타입(byte, char, short, int, long, float, double, boolean)의
 *    값을 갖는 객체를 생성하기 위한 클래스
 *  - 포장 객체는 포장하고 있는 기본 타입의 값을 변경할 수 없고,
 *    객체로 생성하는 데 목적이 있다.
 *  - 컬렉션 객체는 기본 타입의 값은 저장할 수 없고, 객체만 저장할 수 있다.
 *    
 *    java.lang.Byte
 *    java.lang.Character
 *    java.lang.Short
 *    java.lang.Integer
 *    java.lang.Long
 *    java.lang.Float
 *    java.lang.Double
 *    java.lang.Boolean
 *    
 * 박싱(boxing)
 *  - 기본 타입의 값을 포장 객체로 만드는 과정
 *  - 포장 클래스 변수에 기본 타입 값이 대입될 때 발생
 * 언박싱(unboxing)
 *  - 포장 객체에서 기본 타입의 값을 얻어내는 과정
 *  - 기본 타입 변수에 포장 객체가 대입될 때 발생
 *
 * Integer.valueOf()
 *  - 정수 값을 Integer 객체로 변환(박싱)하는 정적 메서드
 * obj.intValue()
 *  - Integer 객체가 가지고 있는 값을 기본 타입 int로 꺼내는 메서드
 *    
 */
public class Ex01_integer메서드 {
	public static void main(String[] args) {
		//Boxing
		Integer obj = 100;
		System.out.println("value: " + obj.intValue());

		//Unboxing
		int value = obj;
		System.out.println("value: " + value);
		
		//연산 시 Unboxing
		int result = obj + 100;
		System.out.println("result: " + result);
	}
}