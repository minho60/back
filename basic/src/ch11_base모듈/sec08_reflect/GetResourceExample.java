package ch11_base모듈.sec08_reflect;
/**
 * java.lang.Class
 * 	- Class 객체는 클래스 파일(*.class)의 경로 정보를 가지고 있기 때문에
 *    이 경로를 기준으로 상대 경로에 있는 다른 리소스 파일(이미지, XML, Property 파일)의 정보를 얻을 수 있다.
 *
 *  - public URL getResource(String name)
 *  	: 클래스패스(classpath)에 존재하는 리소스 파일을 찾아 URL로 반환하는 메서드
 *  
 * java.net.URL
 *  - 네트워크 또는 로컬 자원을 식별하고 접근하기 위한 표준 클래스
 *  
 *  - public String getPath()
 *  	: java.net.URL 객체가 표현하는 자원 위치 중에서 “경로(path) 부분만” 문자열로 반환
 *  
 */
public class GetResourceExample {
	public static void main(String[] args) {
		Class clazz = Car.class;

		String photo1Path = clazz.getResource("photo1.jpg").getPath();
		String photo2Path = clazz.getResource("images/photo2.jpg").getPath();

		System.out.println(photo1Path);
		System.out.println(photo2Path);
	}
}