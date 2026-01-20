package ch17_IO.ex03_문자입출력스트림;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
/**
 * 문자 읽기
 *  - Reader는 문자 입력 스트림의 최상위 클래스로 추상 클래스이다.
 *  	- FileReader
 *  	- BufferedReader
 *  	- InputStreamReader
 *  
 *   1. int read(): 1개의 문자를 읽고 리턴
 *   2. int read(char[] cbuf)
 *   	: 읽은 문자들을 매개값으로 주어진 문자 배열에 저장하고 읽은 문자 수를 리턴
 *   3. void close(): 입력 스트림을 닫고, 사용 메모리 해제
 *   
 */
public class ReadExample {
	public static void main(String[] args) {
		try {
			Reader reader = null;

			//1 문자씩 읽기
			reader = new FileReader("C:/kmh/git/back/basic/src/ch17_입출력/temp/test2.txt");
			while(true) {
				int data = reader.read();
				if(data == -1) break;
				System.out.print((char)data);
			}
			reader.close();
			System.out.println();

			//문자 배열로 읽기
			reader = new FileReader("C:/kmh/git/back/basic/src/ch17_입출력/temp/test.txt");
			char[] data = new char[100];
			while(true) {
				int num = reader.read(data);
				if(num == -1) break;
				for(int i=0; i<num; i++) {
					System.out.print(data[i]);
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}