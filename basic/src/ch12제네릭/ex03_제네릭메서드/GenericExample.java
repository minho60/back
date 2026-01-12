package ch12제네릭.ex03_제네릭메서드;
/**
 * 제네릭 메서드
 *  - 타입 파라미터를 가지고 있는 메서드
 *  - 리턴 타입 앞에 <> 기호를 추가하고,
 *    타입 파라미터를 정의한 뒤, 리턴 타입과 매개변수 타입에서 사용한다.
 *
 *    	public <A, B, ...> 리턴타입 메서드명(매개변수, ...) {...}
 *
 */
public class GenericExample {
	//제네릭 메소드
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<T>();
		box.set(t);
		return box;
	}

	public static void main(String[] args) {
		//제네릭 메소드 호출
		Box<Integer> box1 = boxing(100);
		int intValue = box1.get();
		System.out.println(intValue);

		//제네릭 메소드 호출
		Box<String> box2 = boxing("홍길동");
		String strValue = box2.get();
		System.out.println(strValue);
	}
}