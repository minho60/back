package ch16_스트림.ex05_중간처리;

import java.util.ArrayList;
import java.util.List;
/**
 * 요소 정렬
 * 	- 정렬은 요소를 오름차순 또는 내림차순으로 정렬하는 중간 처리 기능이다.
 * 
 *  	sorted()
 *  	sorted(Comparator<T>)
 * 
 * 1. Comparable 구현 객체의 정렬
 *  - 스트림의 요소가 객체일 경우 객체가 Comparable을 구현하고 있어야만 
 *    sorted() 메서드를 사용하여 정렬할 수 있다.
 *    그렇지 않으면 ClassCastException이 발생한다.
 *    
 * 2. Comparator를 이용한 정렬
 *  
 */
// Student 스트림을 score 기준으로 오름차순 또는 내림차순으로 정렬한 새로운 Student 스트림을 생성하는 방법
public class 정렬2 {
	public static void main(String[] args) {
		//List 컬렉션 생성
		List<Student2> studentList = new ArrayList<>();
		studentList.add(new Student2("홍길동", 30));
		studentList.add(new Student2("신용권", 10));
		studentList.add(new Student2("유미선", 20));
		
		//점수를 기준으로 오름차순으로 정렬한 새 스트림 얻기
		studentList.stream()
			.sorted((s1, s2) -> Integer.compare(s1.getScore(), s2.getScore()))
			.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));	
		System.out.println();
		
		//점수를 기준으로 내림차순으로 정렬한 새 스트림 얻기
		studentList.stream()
			.sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()))
			.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));	
	}
}