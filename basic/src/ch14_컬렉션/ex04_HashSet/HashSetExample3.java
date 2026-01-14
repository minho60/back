package ch14_컬렉션.ex04_HashSet;

import java.util.*;

/**
 * 객체 검색
 * 1. for 문
 * 		for (E e : Set) {
 * 			...
 * 		}
 * 
 * 2. iterator() 메서드
 * 		Iterator<E> iterator = set.iterator();
 * 
 * java.util.Iterator
 * 	- 요소를 순차적으로(하나씩) 꺼내기 위해 사용하는 반복자(Iterator, 반복기) 인터페이스
 *  - Iterator란? 컬렉션의 요소를 하나씩 꺼내는 반복자
 * 
 * (1) boolean hasNext(): 가져올 객체가 있으면 true, 없으면 false
 * (2) E next(): 컬렉션에서 하나의 객체를 가져온다.
 * (3) void remove(): next()로 가져온 객체를 Set 컬렉션에서 제거한다.
 * 
 * 		// hasNext() 메서드로 가져올 객체가 있는지 확인
 * 		while(iterator.hasNext()) {
 * 			// next() 메서드로 객체를 가져온다.
 * 			E e = iterator.next();
 * 		}
 * 
 */
public class HashSetExample3 {
	public static void main(String[] args) {
		//HashSet 컬렉션 생성
		Set<String> set = new HashSet<String>();
		
		//객체 추가
		set.add("Java");
		set.add("JDBC");
		set.add("JSP");
		set.add("Spring");
		
		//객체를 하나씩 가져와서 처리
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			//객체를 하나 가져오기
			String element = iterator.next();
			System.out.println( element);
			if(element.equals("JSP")) {
				//가져온 객체를 컬렉션에서 제거
				iterator.remove();
			}
		}
		System.out.println();
		
		//객체 제거
		set.remove("JDBC");
		
		//객체를 하나씩 가져와서 처리
		for(String element : set) {
			System.out.println(element);
		}
	}
}