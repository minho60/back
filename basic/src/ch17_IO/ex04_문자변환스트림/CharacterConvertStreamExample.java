package ch17_IO.ex04_문자변환스트림;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
/**
 * 보조 스트림
 *  - 다른 스트림과 연결되어 여러 가지 편린한 기능을 제공해주는 스트림을 말한다.
 *  - 보조 스트림은 자체적으로 입출력을 수행할 수 없기 때문에
 *    입출력 소스로부터 직접 생성된 입출력 스트림에 연결해서 사용해야 한다.
 *  - 입출력 스트림에 보조 스트림을 연결하려면
 *    보조 스트림을 생성할 때 생성자 매개값으로 입출력 스트림을 제공하면 된다.
 *
 *    1. InputStreamReader: 바이트 스트림을 문자 스트림으로 변환
 *    2. BufferedInputStream: 입출력 성능 향상
 *    	 BufferedOutputStream
 *    	 BufferedReader
 *    	 BufferedWriter
 *    3. DataInputStream: 기본 타입 데이터 입출력
 *    	 DataOutputStream
 *    4. PrintStream: 줄바꿈 처리 및 형식화된 문자열 출력
 *    	 PrintWriter
 *    5. ObjectInputStream: 객체 입출력
 *    	 ObjectOutputStream
 *
 *
 *    	보조스트림 변수 = new 보조스트림(입출력스트림);
 *
 *    	InputStream is = new FileInputStream("...");
 *    	InputStreamReader reader = new InputStreamReader(is);
 *
 *  - 보조 스트림은 또 다른 보조 스트림과 연결되어 스트림 체인으로 구성할 수 있다.
 *
 *  	보조스트림2 변수 = new 보조스트림2(보조스트림1);
 *
 *  	InputStream is = new FileInputStream("...");
 *  	InputStreamReader reader = new InputStreamReader(is);
 *  	BufferedReader br = new BufferedReader(reader);
 *
 * 문자 변환 스트림
 *  - 바이트 스트림(InputStream, OutputStream)에서 입출력 데이터가 문자라면
 *    문자 스트림(Reader, Writer)로 변환해서 사용하는 것이 좋다.
 *  -> 왜? 문자로 바로 입출력하는 편리함과 문자셋 종류를 지정할 수 있다.
 *
 * InputStream -> Reader로 변환
 *
 *  	InputStream is = new FileInputStream("C:/Temp/test.txt");
 *  	Reader reader = new InputStreamReader(is);
 *
 * OutputStream -> Writer로 변환
 *
 * 		OutputStream os = new FileOutputStream("C:/Temp/test.txt");
 * 		Writer writer = new OutputStreamWriter(os);
 *
 *
 */
// UTF-8 문자셋으로 파일에 문자를 저장하고, 저장된 문자를 다시 읽는다.
// 소스 스트림은 바이트 기반 FileOutputStream과 FileInputStream이지만,
// 문자 기반 스트림인 Writer와 Reader로 변환해서 사용한다.
public class CharacterConvertStreamExample {
	public static void main(String[] args) throws Exception {
		write("문자 변환 스트림을 사용합니다.");
		String data = read();
		System.out.println(data);
	}

	public static void write(String str) throws Exception {
		OutputStream os = new FileOutputStream("C:/kmh/git/back/basic/src/ch17_입출력/temp/test4.txt");
		Writer writer = new OutputStreamWriter(os, "UTF-8");
		writer.write(str);
		writer.flush();
		writer.close();
	}
	
	public static String read() throws Exception {
		InputStream is = new FileInputStream("C:/kmh/git/back/basic/src/ch17_입출력/temp/test4.txt");
		Reader reader = new InputStreamReader(is, "UTF-8");
		char[] data = new char[100];
		int num = reader.read(data);
		reader.close();
		String str = new String(data, 0, num);
		return str;
	}
}