package ch15_람다식.ex01_람다식이란;
/**
 * 람다식(Lambda Expressions)
 *  - 자바는 함수형 프로그래밍을 위해 Java 8부터 람다식을 지원한다.
 *  	
 *   	(매개변수, ...) -> { 처리 내용 }
 *  
 *  - 함수형 프로그래밍(functional programming)?
 *  	-> 함수를 정의하고 이 함수를 데이터 처리부로 보내 데이터를 처리하는 기법을 말한다.
 *  	   데이터 처리부는 데이터만 가지고 있을 뿐, 처리 방법이 정해져 있지 않아 외부에서 제공된 함수에 의존한다.
 *  
 *  - 자바는 람다식을 익명 구현 객체로 변환한다.
 *  - 익명 구현 객체란? 이름이 없는 인터페이스 구현 객체
 *  - 람다식은 인터페이스의 익명 구현 객체이므로 인터페이스 타입의 매개변수에 대입될 수 있다.
 *  
 *  - 인터페이스의 익명 구현 객체를 람다식으로 표현하려면 
 *    인터페이스가 단 하나의 추상 메서드만 가져야 한다.
 *  - 인터페이스가 단 하나의 추상 메서드를 가질 때, 
 *    이를 함수형 인터페이스(functional interface)라고 한다.
 *  - @FunctionalInterface 애노테이션은 함수형 인터페이스임을 보장한다.
 *  
 *  
 *  	// 인터페이스
 *  	public interface Runnable {
 *  		void run();
 *  	}
 *  	
 *  	// 람다식
 *  	() -> {}
 *  
 *  	// 인터페이스
 *  	@FunctionalInterface
 *  	public interface Calculable {
 *  		void calculate(int x, int y);
 *  	}
 *  
 *  	// 람다식
 *  	(x, y) ->  { ... }
 *  
 *   	// 람다식을 익명 구현 객체로 변환한다.
 *  	// Calculable 인터페이스의 익명 구현 객체
 *  	new Calculable() {
 *  		@Override
 *  		public void calculate(int x, int y) { 처리내용 }
 *  	};
 *  
 *  
 */
public class LambdaExample {
	public static void main(String[] args) {
		action((x, y) -> {
			int result = x + y;
			System.out.println("result: " + result);
		});

		action((x, y) -> {
			int result = x - y;
			System.out.println("result: " + result);
		});
	}

	public static void action(Calculable calculable) {
		//데이터
		int x = 10;
		int y = 4;
		//데이터 처리
		calculable.calculate(x, y);
	}
}