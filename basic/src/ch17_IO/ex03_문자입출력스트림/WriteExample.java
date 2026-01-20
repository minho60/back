package ch17_IO.ex03_문자입출력스트림;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
/**
 * 문자 입출력 스트림
 * 
 * 문자 출력
 * 	- Writer는 문자 출력 스트림의 최상위 클래스로 추상 클래스이다.
 *  - Writer는 OutputStream과 사용 방법은 동일하지만, 출력 단위가 문자(char)이다.
 *  - 문자열을 출력하는 write(String str) 메서드를 추가로 제공한다.
 *  
 * 		- FileWriter
 * 		- BufferedWriter
 * 		- PrintWriter
 * 		- OutputStreamWriter
 * 
 * 
 * 		void write(int c): 매개값으로 주어진 한 문자 출력
 * 		void write(char[] cbuf): 매개값으로 주어진 배열의 모든 문자 출력
 * 		void write(char[] cbuf, int off, int len)
 * 			: 매개값으로 주어진 배열에서 cbuf[off]부터 len개까지의 문자 출력
 * 		void write(String str): 매개값으로 주어진 문자열 출력
 * 		void write(String str, int off, int len)
 * 			: 매개값으로 주어진 문자열에서 off 순번부터 len개까지으 문자 출력
 * 		void flush(): 버퍼에 잔류하는 모든 문자 출력
 * 		void close(): 출력 스트림을 닫고 사용 메모리 해제
 *  
 */
// 하나의 문자, 문자 배열, 문자열을 각각 출력하는 방법을 보여 준다.
public class WriteExample {
	public static void main(String[] args) {
		try {
			//문자 기반 출력 스트림 생성
			Writer writer = new FileWriter("C:/kmh/git/back/basic/src/ch17_입출력/temp/test2.txt");

			//1 문자씩 출력
			char a = 'A';
			writer.write(a);
			char b = 'B';
			writer.write(b);

			//char 배열 출력
			char[] arr = { 'C', 'D', 'E' };
			writer.write(arr);

			//문자열 출력
			writer.write("FGH");
			
			//버퍼에 잔류하고 있는 문자들을 출력하고, 버퍼를 비움
			writer.flush();
			
			//출력 스트림을 닫고 메모리 해제
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}