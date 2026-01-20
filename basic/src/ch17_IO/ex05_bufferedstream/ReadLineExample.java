package ch17_IO.ex05_bufferedstream;

import java.io.*;

/**
 * 문자 입력 스트림 Reader에 BufferedReader를 연결하면 성능 향상뿐만 아니라
 * 행 단위로 문자열을 읽는 readLine() 메서드를 제공한다.
 *
 * 문자 파일을 행 단위로 읽는 코드
 *
 * 		BufferedReader br = new BufferedReader(new FileReader("..."));
 * 		while(true) {
 * 			// 파일에서 한 행씩 읽음
 * 			String str = br.readLine();
 * 			// 더 이상 읽을 행이 없을 경우(파일 끝) while 문 종료
 * 			if(str == null) break;
 * 		}
 *
 */
public class ReadLineExample {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
			new FileReader("src/ch18/sec07/exam02/ReadLineExample.java")
		);
		
		int lineNo = 1;
		while(true) {
			String str = br.readLine();
			if(str == null) break;
			System.out.println(lineNo + "\t" + str);
			lineNo++;
		}
		
		br.close();
	}
}