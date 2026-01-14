package ch14_컬렉션.ex07_Properties;

import java.util.Properties;
/**
 * Properties
 * 	- Hashtable의 자식 클래스이다.
 *  - 키와 값을 String 타입으로 제한한 컬렉션이다.
 *  - 주로 확장자가 .properties인 프로퍼티 파일을 읽을 때 사용한다.
 *
 * 프로퍼티 파일
 *  - 키와 값이 =기호로 연결되어 있는 텍스트 파일이다.
 *  - 일반 텍스트 파일과 다르게 ISO 8859-1 문자셋으로 저장되며,
 *    한글일 경우에는 \\u+유니코드로 표현되어 저장된다.
 *    
 * 객체 생성 후
 * 		Properties properties = new Properties();
 * load() 메서드로 프로퍼티 파일의 내용을 메모리로 로드한다.
 * 		properties.load(Xxx.class.getResourceAsStream("database.properties"));
 * 
 */
public class PropertiesExample {
	public static void main(String[] args) throws Exception {
		//Properties 컬렉션 생성
		Properties properties = new Properties();

		//PropertiesExample.class와 동일한 ClassPath에 있는 database.properties 파일 로드
		properties.load(PropertiesExample.class.getResourceAsStream("database.properties"));

		//주어진 키에 대한 값 읽기
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String admin = properties.getProperty("admin");

		//값 출력
		System.out.println("driver : " + driver);
		System.out.println("url : " + url);
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		System.out.println("admin : " + admin);
	}
}