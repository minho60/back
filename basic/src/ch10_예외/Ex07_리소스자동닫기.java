package ch10_예외;


/**
 * 리소스(resource)?
 * 	- 데이터를 제공하는 객체를 말한다.
 *  - 리소스는 사용하기 위해 열어야(open) 하며, 
 *    사용이 끝난 다음에는 닫아야(close) 한다.
 *  - 예를 들어, 파일 내용을 읽기 위해서는 파일을 열어야 하며,
 *    다 읽고 난 후에는 파일을 닫아야 다른 프로그램에서 사용할 수 있다.
 *  - 리소스를 사용하다가 예외가 발생될 경우에도 안전하게 닫는 것이 중요하다.
 *    그렇지 않으면 리소스가 불안정한 상태로 남아있게 된다.
 *    
 * try-with-resources 구문
 *  - try 괄호()에 리소스를 여는 코드를 작성하면
 *    try 블록이 정상적으로 실행을 완료했거나 도중에 예외가 발생하면 
 *    자동으로 리소스의 close() 메서드가 호출되어
 * 	  예외 발생 여부와 상관없이 리소스를 자동으로 닫아 준다.
 *  - try-with-resources 블록을 사용하기 위해서는 
 *    리소스는 java.lang.AutoCloseable 인터페이스를 구현해서
 *    AutoCloseable 인터페이스의 close() 메서드를 재정의해야 한다.
 * 
 *   	try( // 리소스를 여는 코드 ) {
 *   		// 예외 발생 가능 코드
 *   	} catch(예외종류 e) {
 *   		// 예외 처리
 *   	}
 *
 *		
 * Java 8 이전에는 try 괄호()안에 리소스 변수를 반드시 선언해야 했지만
 * 		
 * 		try(
 * 			FileInputStream fis1 = new FileInputStream("file1.txt");
 * 			FileInputStream fis2 = new FileInputStream("file2.txt");
 * 		) {
 * 			...
 * 		} catch(IOException e)  {
 * 			...
 * 		}
 * 
 * Java 9 이후부터는 외부 리소스 변수를 사용할 수 있다.
 *		
 *		FileInputStream fis1 = new FileInputStream("file1.txt");
 *		FileInputStream fis2 = new FileInputStream("file2.txt");
 *
 *		try(fis1; fis2) {
 *			...
 *		} catch(IOException e) {
 *			...
 *		}
 *		
 *
 */
public class Ex07_리소스자동닫기 {
	public static void main(String[] args) {
		try (MyResource res = new MyResource("A")) {
			String data = res.read1();
			int value = Integer.parseInt(data);
		} catch(Exception e) {
			System.out.println("예외 처리: " + e.getMessage());
		}
		
		System.out.println();
		
		try (MyResource res = new MyResource("A")) {
			String data = res.read2();
			//NumberFormatException 발생
			int value = Integer.parseInt(data);
		} catch(Exception e) {
			System.out.println("예외 처리: " + e.getMessage());
		}
		
		System.out.println();
		
		/*try (
			MyResource res1 = new MyResource("A"); 
			MyResource res2 = new MyResource("B")
		) {
			String data1 = res1.read1();
			String data2 = res2.read1();
		} catch(Exception e) {
			System.out.println("예외 처리: " + e.getMessage());
		}*/
		
		MyResource res1 = new MyResource("A"); 
		MyResource res2 = new MyResource("B");
		try (res1; res2) {
			String data1 = res1.read1();
			String data2 = res2.read1();
		} catch(Exception e) {
			System.out.println("예외 처리: " + e.getMessage());
		}
	}
}
