package ch11_base모듈.sec01_Object.ex01_equals메서드;
/**
 * Object의 equals() 메서드
 * 	- 객체의 번지를 비교하고 boolean 값을 리턴한다.
 *  - 비교 연산자인 ==과 동일한 결과를 리턴한다.
 *  -> 두 객체가 동일한 객체이면 true, 아니면 false
 * 
 *  	public boolean equals(Object obj)
 *  
 *  
 * 동등 비교란? 객체가 비록 달라도 내부의 데이터가 같은지를 비교하는 것이다.
 * 일반적으로 Object의 equals() 메서드는 재정의해서 동등 비교용으로 사용한다. 
 * String은 equals() 메서드를 재정의해서 내부 문자열이 같은지를 비교한다.
 *  
 */
public class EqualsExample {
	public static void main(String[] args) {
		Member obj1 = new Member("blue");
		Member obj2 = new Member("blue");
		Member obj3 = new Member("red");

		if(obj1.equals(obj2)) {
			System.out.println("obj1과 obj2는 동등합니다.");
		} else {
			System.out.println("obj1과 obj2는 동등하지 않습니다.");
		}

		if(obj1.equals(obj3)) {
			System.out.println("obj1과 obj3은 동등합니다.");
		} else {
			System.out.println("obj1과 obj3은 동등하지 않습니다.");
		}
	}
}