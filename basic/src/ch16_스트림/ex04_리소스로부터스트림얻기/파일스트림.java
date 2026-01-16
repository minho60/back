package ch16_스트림.ex04_리소스로부터스트림얻기;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
/**
 * java.nio.file.Files
 * 	- line() 메서드: 텍스트 파일의 행 단위 스트림을 얻을 수 있다. 
 */
public class 파일스트림 {
	public static void main(String[] args) throws Exception {
		//1. 파일경로를 객체화
		// - 클래스명.class: 클래스의 메타정보를 가져온다.
		// - getResource("파일명"): 클래스패스(src/main/resource 등)에서 파일 찾아 URL을 반환
		// - toURI(): URL을 URI로 변환
		Path path = Paths.get(파일스트림.class.getResource("data.txt").toURI());
		//2.파일의 내용을 줄 단위 스트림으로 읽어오기
		// - Files.lines(경로, 인코딩방식)
		// 		- 지정된 경로의 파일을 열어 한 줄 씩 순차적으로 읽는 스트림 생성
		//	- Charset.defaultCharset(): 운영체제의 기본 문자 인코딩(예: UTF-8)을 사용하여 텍스트 해석
		Stream<String> stream = Files.lines(path, Charset.defaultCharset());
		stream.forEach(line -> System.out.println(line) );
		stream.close();
	}
}