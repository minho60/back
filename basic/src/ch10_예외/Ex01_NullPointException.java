package ch10_예외;
/**
 * 에러(Error)?
 * 	- 컴퓨터 하드웨어의 고장으로 인해 응용프로그램 실행 오류가 발생하는 것
 * 
 * 예외(Exception)?
 * 	- 잘못된 사용 또는 코딩으로 인한 오류
 *  - 예외가 발생되면 프로그램은 곧바로 종료되지만,
 *    예외 처리를 통해 계속 실행 상태를 유지할 수 있다.
 *    
 * 예외 종류
 * 1. 일반 예외(Exception)
 * 	- 컴파일러가 예외 처리 코드 여부를 검사하는 예외
 * 2. 실행 예외(Runtime Exception)
 * 	- 컴파일러가 예외 처리 코드 여부를 검사하지 않는 예외
 * 
 * 자바는 예외가 발생하면 예외 클래스로부터 객체를 생성한다.
 * 이 객체는 예외 처리 시 사용된다.
 * 자바의 모든 에러와 예외 클래스는 Throwable을 상속받아 만들어지고,
 * 추가적으로 예외 크래스는 java.lang.Exception 클래스를 상속받는다.
 * 자바는 자주 사용되는 예외 클래스를 표준 라이브러리로 제공한다.
 * 
 */
public class Ex01_NullPointException {
	public static void printLength(String data) {
		int result = data.length();
		System.out.println("문자 수: " + result);
	}

	public static void main(String[] args) {
		System.out.println("[프로그램 시작]\n");
		printLength("ThisIsJava");
		printLength(null);
		System.out.println("[프로그램 종료]");
	}
}
