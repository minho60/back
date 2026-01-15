package ch15_람다식.ex02_매개변수없는람다식;
/**
 * 매개변수가 없는 람다식
 * 	- 함수형 인터페이스의 추상 메서드에 매개변수가 없을 때
 *  - 실행문이 하나이면 중괄호{} 생략 가능
 *  
 *   	() -> {
 *   		실행문;
 *   		실행문;
 *   	}
 *   
 *   	() -> 실행문;
 *   
 */
public class LambdaExample {
	public static void main(String[] args) {
		Person person = new Person();

		//실행문이 두 개 이상인 경우 중괄호 필요
		person.action(() -> {
			System.out.println("출근을 합니다.");
			System.out.println("프로그래밍을 합니다.");
		});

		//실행문이 한 개일 경우 중괄호 생략 가능
		person.action(() -> System.out.println("퇴근합니다."));
	}
}