package ch10_예외;
/**
 * 예외 처리 코드?
 *  - 예외가 발생했을 때 프로그램의 갑작스러운 종료를 막고 정상 실행을 유지할 수 있도록 처리하는 코드
 *  - try-catch-finally 블록은 생성자 내부와 메서드 내부에 작성한다.
 *  - try 블록에서 작성한 코드가 예외 없이 정상 실행되면 catch 블록은 실행되지 않고 finally 블록은 실행된다.
 *  - try 블록에서 예외가 발생하면 catch 블록이 실행되고, finally 블록이 실행된다.
 *  - 예외 발생 여부와 상관없이 finally 블록은 항상 실행된다.
 *  - 심지어 try 블록과 catch 블록에서 return 문을 사용하더라도 finally 블록은 항상 실행된다.
 *  - finally 블록은 옵션으로 생략 가능하다.
 *  
 *  	try {
 *  		// 예외 발생 가능 코드
 *  	} catch(예외클래스 e) {
 *  		// 예외 처리
 *  	} [finally {
 *  		// 항상 실행
 *  	}]
 *  
 * 예외 정보를 얻는 3가지 방법
 * 1. e.getMessage(): 예외 발생 이유만 리턴
 * 2. e.toString(): 예외 발생 이유와 예외 종류 리턴
 * 3. e.printStackTrace(): 예외 발생 이유, 예외 종류, 예외 발생 위치 추적 내용
 *  	
 */
public class Ex02_예외처리 {
	public static void printLength(String data) {
//		int result =0;
		try {
			// 예외 발생 가능 코드
			int result = data.length();
			System.out.println("문자수:"+ result);
		} catch(NullPointerException e) {
			// 예외 처리 결과 출력
			// Cannot invoke "String.length()" because "data" is null
			 System.out.println(e.getMessage());
			// java.lang.NullPointerException
			// System.out.println(e.toString());
			// e.printStackTrace();
		} finally {
			System.out.println("마무리 실행");
		}
	}

	public static void main(String[] args) {
		System.out.println("[프로그램 시작]\n");
		printLength("ThisIsJava");
		printLength(null);
		System.out.println("[프로그램 종료]");
	}
}
