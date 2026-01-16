package ch16_스트림.ex04_리소스로부터스트림얻기;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
/**
 * 배열로부터 스트림 얻기
 * 	- java.util.Arrays 클래스를 이용하면 다양한 종류의 배열로부터 스트림을 얻을 수 있다. 
 */
public class 배열스트림 {
	public static void main(String[] args) {
		String[] strArray = { "홍길동", "신용권", "김미나"};
		Stream<String> strStream = Arrays.stream(strArray);
		strStream.forEach(item -> System.out.print(item + ","));
		System.out.println();
		
		int[] intArray = { 1, 2, 3, 4, 5 };
		IntStream intStream = Arrays.stream(intArray);
		intStream.forEach(item -> System.out.print(item + ","));
		System.out.println();
	}
}