package ch11_base모듈.sec03_String;
/**
 * String 클래스
 *  - 문자열을 저장하고 조작할 때 사용한다.
 *  - 문자열 리터럴은 자동으로 String 객체로 생성되지만,
 *  - String 클래스의 다양한 생성자를 이용해서 직접 객체를 생성할 수도 있다.
 *  
 * getBytes()
 *  - 문자열(String)을 바이트 배열(byte[])로 변환
 *  
 *  	byte[] getBytes()
 *		byte[] getBytes(String charsetName)
 *  
 * Arrays.toString()
 *  - 배열의 모든 요소를 문자열 형태로 변환
 *  
 *  	public static String toString(int[] a)
 * 
 */
import java.util.Arrays;

public class ex01_ByteToString {
	public static void main(String[] args) throws Exception  {
		
		// 리터럴
		String data = "자바";
		
		// new 생성자
		// String data2 = new String("자바");
		
		//String -> byte 배열(기본: UTF-8 인코딩)
		byte[] arr1 = data.getBytes();
		//byte[] arr1 = data.getBytes("UTF-8");
		System.out.println("arr1:"+arr1);
		System.out.println("arr1: " + Arrays.toString(arr1));
		
		//byte 배열 -> String(기본: UTF-8 디코딩)
		String str1 = new String(arr1);
		//String str1 = new String(arr1, "UTF-8");
		System.out.println("str1: " + str1);
		
		//String -> byte 배열(EUC-KR 인코딩)
		byte[] arr2 = data.getBytes("EUC-KR");
		System.out.println("arr2: " + Arrays.toString(arr2));
		
		//byte 배열 -> String(기본: UTF-8 디코딩)
		String str2 = new String(arr2, "EUC-KR");
		System.out.println("str2: " + str2);
	}
}