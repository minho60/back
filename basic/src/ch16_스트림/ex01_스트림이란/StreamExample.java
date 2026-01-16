package ch16_스트림.ex01_스트림이란;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;
/**
 * 스트림(Stream)이란?
 *  - Java 8부터 컬렉션 및 배열 요소 반복 처리에 사용!
 *  - 스트림은 요소들이 하나씩 흘러가면서 처리된다는 의미를 가지고 있다.
 *  
 *  - List 컬렉션의 stream() 메서드로 Stream 객체를 얻고,
 *    forEach() 메서드로 요소를 어떻게 처리할지를 람다식으로 제공한다.
 *    
 *  	Stream<String> stream = list.stream();
 *  	stream.forEach(item -> //item 처리);
 *  
 */
//Set 컬렉션 요소를 하나씩 읽고 출력하기 위해 스트림을 사용한다.
public class StreamExample {
	public static void main(String[] args) {
		//Set 컬렉션 생성
		Set<String> set = new HashSet< >();
		set.add("홍길동");
		set.add("신용권");
		set.add("감자바");

		//Stream을 이용한 요소 반복 처리
		Stream<String> stream = set.stream();
		stream.forEach( name -> System.out.println(name) );
	}
}