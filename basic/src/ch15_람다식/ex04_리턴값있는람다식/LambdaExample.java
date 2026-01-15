package ch15_람다식.ex04_리턴값있는람다식;
/**
 * 리턴값이 있는 람다식
 *  - return 문 하나만 있을 경우에는 중괄호{}와 함께 return 키워드를 생략할 수 있다.
 *  - 리턴값은 연산식 또는 리턴값 있는 메서드 호출로 대체할 수 있다.
 *  
 *   	(매개변수, ...) ->  {return 값;}
 *   
 *   	(매개변수, ...) -> 값;
 *   
 *   
 */
public class LambdaExample {
	public static void main(String[] args) {
		Person person = new Person();

		//실행문이 두 개 이상일 경우
		person.action((x, y) -> {
			double result = x + y;
			return result;
		});

		//리턴문이 하나만 있을 경우(연산식)
		//person.action((x, y) -> {
		// return (x + y);
		//});
		
		// 실행문이 return으로 한 문장일 경우
		// {}와 return 생략 가능
		person.action((x, y) -> (x + y));

		//리턴문이 하나만 있을 경우(메소드 호출)
		//person.action((x, y) -> {
		// return sum(x, y);
		//});
		person.action((x, y) -> sum(x, y));
		}
	
	public static double sum(double x, double y) {
		return (x + y);
	}
}