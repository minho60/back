package ch12제네릭.ex04_제한된타입파라미터;
/**
 * 제한된 타입 파라미터(Bounded Type Parameter)
 * 	- 모든 타입으로 대체할 수 없고,
 *    특정 타입과 자식 또는 구현 관계에 있는 타입만 대체할 수 있는 타입 파라미터
 *     
 *     	public <T extends 상위타입> 리턴타입 메서드(매개변수, ...) {...}
 *     
 * java.lang.Number
 *  - Java에서 모든 숫자(wrapper) 타입의 최상위 추상 클래스
 *    
 *  - public abstract double doubleValue();
 *		 : 숫자 객체의 값을 double 기본형으로 변환하여 반환
 *     
 */
public class GenericExample {
	//제한된 타입 파라미터를 갖는 제네릭 메소드
	public static <T extends Number> boolean compare(T t1, T t2) {
		//T의 타입을 출력
		System.out.println("compare(" + t1.getClass().getSimpleName() + ", " +
				t2.getClass().getSimpleName() + ")");

		//Number의 메소드 사용
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();

		return (v1 == v2);
	}

	public static void main(String[] args) {
		//제네릭 메소드 호출
		boolean result1 = compare(10, 20);
		System.out.println(result1);
		System.out.println();

		//제네릭 메소드 호출
		boolean result2 = compare(4.5, 4.5);
		System.out.println(result2);
	}
}