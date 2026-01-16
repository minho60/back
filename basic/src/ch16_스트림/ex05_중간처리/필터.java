package ch16_스트림.ex05_중간처리;

import java.util.ArrayList;
import java.util.List;

/**
 * 요소 걸러내기(필터링) - 필터링은 요소를 걸러내는 중간 처리 기능이다. - 필터링 메서드에는 distinct(), filter()
 * 
 * distinct(): 요소의 중복 제거 filter(): 매개값으로 주어진 Predicate가 true를 리턴하는 요소만 필터링
 * 
 */
public class 필터 {
	public static void main(String[] args) {
		// List 컬렉션 생성
		List<String> list = new ArrayList<>();
		list.add("홍길동");
		list.add("신용권");
		list.add("감자바");
		list.add("신용권");
		list.add("신민철");

		// 중복 요소 제거
		list.stream()
			.distinct()
			.forEach(n -> System.out.println(n));
		System.out.println();

		// 신으로 시작하는 요소만 필터링
		list.stream()
			.filter(n -> n.startsWith("신"))
			.forEach(n -> System.out.println(n));
		System.out.println();

		// 중복 요소를 먼저 제거하고, 신으로 시작하는 요소만 필터링
		list.stream()
			.distinct()
			.filter(n -> n.startsWith("신")).forEach(n -> System.out.println(n));
	}
}