package ch12제네릭.ex01_제네릭이란;

public class GenericExample {
	public static void main(String[] args) {

		// Java 7 이후
		// 변수를 선언할 때와 동일한 타입으로 호출하고 싶다면
		// 생성자 호출 시 생성자에는 타입을 명시하지 않고 <>(다이아몬드 연산자)만 붙일 수 있다.
		// Box를 생성할 때 타입 파라미터 T 대신 String으로 대체
		
		//Box<String> box1 = new Box<String>();
		Box<String> box1 = new Box<>();
		box1.content = "안녕하세요.";
		String str = box1.content;
		System.out.println(str);

		//Box<Integer> box2 = new Box<Integer>();
		Box<Integer> box2 = new Box<>();
		box2.content = 100;
		int value = box2.content;
		System.out.println(value);
	}
}