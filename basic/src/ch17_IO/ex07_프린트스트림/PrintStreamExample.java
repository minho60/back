package ch17_IO.ex07_프린트스트림;

import java.io.FileOutputStream;
import java.io.PrintStream;
/**
 * 프린트 스트림
 * 	- PrintStream과 PrintWriter는 프린터와 유사하게 출력하는
 * 	  print(), println(), printf() 메서드를 가지고 있는 보조 스트림이다.
 *  - 콘솔 출력을 위해 System.out.println()을 사용하였은데,
 *    그 이유는 out이 PrintStream 타입이기 때문이다.
 *  - PrintStream은 바이트 출력 스트림과 연결되고,
 *    PrintWriter는 문자 출력 스트림과 연결된다.
 *    
 *    PrintStream ps = new PrintStream(바이트출력스트림);
 *    PrintWriter pw = new PrintWriter(문자출력스트림);
 *    
 *  1. void print(boolean b)
 *  2. void print(char c)
 *  3. void print(double d)
 *  4. void print(float f)
 *  5. void print(int i)
 *  6. void print(long l)
 *  7. void print(Object obj)
 *  8. void print(String s)
 *  
 *  1. void println(boolean b)
 *  2. void println(char c)
 *  3. void println(double d)
 *  4. void println(float f)
 *  5. void println(int i)
 *  6. void println(long l)
 *  7. void println(Object obj)
 *  8. void println(String s)
 *  9. void println()
 *  
 *  - printf() 메서드는 형식화된 문자열(format string)을 출력한다.
 * 
 */
// FileOutputStream에 보조로 PrintStream을 연결해서
// print(), println(), printf() 메서드로 문자열을 출력한다.
public class PrintStreamExample {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("C:/kmh/git/back/basic/src/ch17_IO/temp/printstream.txt");
		PrintStream ps = new PrintStream(fos);
		
		ps.print("마치 ");
		ps.println("프린터가 출력하는 것처럼 ");
		ps.println("데이터를 출력합니다.");
		ps.printf("| %6d | %-10s | %10s | \n", 1, "홍길동", "도적");
		ps.printf("| %6d | %-10s | %10s | \n", 2, "감자바", "학생");
		
		ps.flush();
		ps.close();
	}
}