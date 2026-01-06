package ch10_예외;
/**
 * 예외 떠넘기기
 * 	- 메서드 내부에서 예외가 발생할 때
 * 	  try-catch 블록으로 예외를 처리하는 것이 기본이지만,
 * 	  메서드를 호출한 곳으로 예외를 떠넘길 수도 있다.
 *  - throws 키워드가 붙어 있는 메서드에서 해당 예외를 처리하지 않고 떠넘겼기 때문에
 *    이 메서드를 호출하는 곳에서 예외를 받아 처리해야 한다.
 *  - 나열해야 할 예외 클래스가 많을 경우
 *    throws Exception 또는 throws Throwable 만으로 모든 예외를 떠넘길 수도 있다.
 * 
 *  	리턴타입 메서드명(매개변수, ...) throws 예외클래스1, 예외클래스2, ... {
 *  		...
 *  	}
 *  
 *  모든 예외 떠넘기기
 *  	
 *  	리턴타입 메서드명(매개변수, ...) throws Exception {
 *  		...
 *  	}
 *  
 */
public class Ex08_예외전가 {
	public static void main(String[] args) {
		try {
			findClass();
		} catch(ClassNotFoundException e) {
			System.out.println("예외 처리: " + e.toString());
		}
	}
	// 예외 떠넘기기
	public static void findClass() throws ClassNotFoundException {
		// 예외 발생 코드
		Class.forName("java.lang.String2");
	}
}