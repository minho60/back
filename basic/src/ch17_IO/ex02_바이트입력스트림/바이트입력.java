package ch17_IO.ex02_바이트입력스트림;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/**
 * 바이트 입력 스트림
 *  - java.io.InputStream은 바이트 입력 스트림의 최상위 클래스로, 추상 클래스이다.
 *  	- FileInputStream
 *  	- BufferedInputStream
 *  	- DataInputStream
 *  
 *  - FileInputStream 생성자는 주어진 파일이 존재하지 않을 경우
 *    FileNotFoundException을 발생시킨다.
 *    read(), close() 메서드에서 IOException이 발생할 수 있다.
 *  
 *  1. int read(): 1byte를 읽은 후 읽은 바이트를 리턴
 *  2. int read(byte[] b): 읽은 바이트를 매개값으로 주어진 배열에 저장 후 읽은 바이트 수를 리턴
 *  3. void close(): 입력 스트림을 닫고 사용 메모리 해제
 *  
 *  
 */
// C:/Temp/test1.db에 저장한 내용을 1byte씩 끝까지 읽는다.
public class 바이트입력 {
	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("C:/kmh/git/back/basic/src/ch17_입출력/temp/test1.db");

			while(true) {
				int data = is.read();
				if(data == -1) break;
				System.out.println(data);
			}
			
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}