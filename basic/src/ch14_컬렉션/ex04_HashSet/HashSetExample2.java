package ch14_컬렉션.ex04_HashSet;

import java.util.*;
	
public class HashSetExample2 {
	public static void main(String[] args) {
		//HashSet 컬렉션 생성
		Set<Member> set = new HashSet<Member>();

		//Member 객체 저장
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30));

		//저장된 객체 수 출력
		System.out.println("총 객체 수 : " + set.size());
	}
}