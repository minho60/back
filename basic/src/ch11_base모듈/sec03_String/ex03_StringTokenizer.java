package ch11_base모듈.sec03_String;

import java.util.StringTokenizer;
/**
 * java.util.StringTokenizer 클래스
 *  - 문자열이 구분자(delimiter)로 연결되어 있을 경우
 *    구분자를 기준으로 문자열을 분리하려면?
 *    -> String의 split() 메서드를 이용하거나
 *    -> StringTokenizer 클래스를 이용할 수 있다.
 * 
 * split()
 * 	- 정규 표현식으로 구분하고,
 *  - 여러 종류의 구분자 가능
 *  	
 *  	String data = "홍길동&이수홍,박연수,김자바-최명호";
 *  	String[] names = data.split("&|,|-");
 *  
 * StringTokenizer
 *  - 문자로 구분한다.
 *  - 한 종류의 구분자
 *  
 *  	String data = "홍길동/이수홍/박연수";
 *  	StringTokenizer st = new StringTokenizer(data, "/");
 *  
 *  	int countTokens(): 분리할 수 있는 문자열의 총 수
 *  	boolean hasMoreTokens(): 남아 있는 문자열이 있는지 여부
 *  	String nextToken(): 문자열을 하나씩 가져옴
 * 
 */
public class ex03_StringTokenizer {
	public static void main(String[] args) {
		String data1 = "홍길동&이수홍,박연수";
		String[] arr = data1.split("&|,");
		for(String token : arr) {
			System.out.println(token);
		}
		System.out.println();

		String data2 = "홍길동/이수홍/박연수";
		StringTokenizer st = new StringTokenizer(data2, "/");
		System.out.println(st.countTokens());
		
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
		System.out.println(st.countTokens());
	}
}