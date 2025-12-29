package ch08_인터페이스.ex06_private메서드;

/**
 * private 접근제한자
 *  - 현재 중괄호{}블록 내에서만 사용 -> 캡슐화 
 *  
 *  	private 리턴타입 메서드명([매개변수,...]){...}
 *  		-> 디폴트 메서드에서 호출
 *  		-> 정적 메서드는 호출불가
 *  	private static 리턴타입 메서드명([매개변수,...]){...}
 *  		-> 디폴트 메서드와 정적 메서드에서 모두 호출
 *  
 *  디폴트 메서드
 *   - private메서드와 privat default 메서드 모두 호출 가능
 *  
 *  정적메서드
 *   - private static메서드만 호출 가능 
 *  
 */
public interface Service {
	//디폴트 메소드
	default void defaultMethod1() {
		System.out.println("defaultMethod1 종속 코드");
		// private 메서드 호출
		defaultCommon();
	}
	
	default void defaultMethod2() {
		System.out.println("defaultMethod2 종속 코드");
		defaultCommon();
	}

	//private 메소드
	private void defaultCommon() {
		System.out.println("defaultMethod 중복 코드A");
		System.out.println("defaultMethod 중복 코드B");
	}

	//정적 메소드
	static void staticMethod1() {
		System.out.println("staticMethod1 종속 코드");
		staticCommon();
	}

	static void staticMethod2() {
		System.out.println("staticMethod2 종속 코드");
		staticCommon();
	}

	//private 정적 메소드
	private static void staticCommon() {
		System.out.println("staticMethod 중복 코드C");
		System.out.println("staticMethod 중복 코드D");
	}
}