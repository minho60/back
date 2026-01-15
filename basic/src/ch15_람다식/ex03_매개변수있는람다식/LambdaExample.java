package ch15_람다식.ex03_매개변수있는람다식;
/**
 * 함수형 인터페이스의 추상 메서드에 매개변수가 있는 경우
 *  -> 매개변수를 선언할 때 타입은 생략할 수 있고,
 *     구체적인 타입 대신 var를 사용할 수도 있다.
 *     
 *     (타입 매개변수, ...) -> { 실행문; 실행문; }
 *     (var 매개변수, ...) -> { 실행문; 실행문; }
 *     (매개변수, ...) -> { 실행문; 실행문; }
 *
 *  - 실행문이 하나이면 중괄호{} 생략할 수 있다.
 *  
 *     (타입 매개변수, ...) -> 실행문;
 *     (var 매개변수, ...) -> 실행문;
 *     (매개변수, ...) -> 실행문;
 *  
 *  - 매개변수가 하나일 경우에는 괄호()를 생략할 수 있다.
 *  	
 *   	매개변수 -> {실행문; 실행문;}
 *   	매개변수 -> 실행문;
 *     
 *     
 */
public class LambdaExample {
	public static void main(String[] args) {
		Person person = new Person();

		//매개변수가 두 개일 경우
		person.action1((name, job) -> {
			System.out.print(name + "이 ");
			System.out.println(job + "을 합니다.");
		});
		person.action1((name, job) -> System.out.println(name + "이 " + job + "을 하지 않습니다."));
		
		//매개변수가 한 개일 경우
		person.action2(word -> {
			System.out.print("\"" + word + "\"");
			System.out.println("라고 말합니다.");
		});
		person.action2(word -> System.out.println("\"" + word + "\"라고 외칩니다."));
	}
}