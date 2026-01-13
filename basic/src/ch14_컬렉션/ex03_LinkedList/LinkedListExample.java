package ch14_컬렉션.ex03_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList
 *  - 삽입/삭제가 빠름, 인덱스 접근은 느림
 *
 *  객체 생성
 *  	List<E> list = new LinkedList<E>(); // E에 지정된 타입의 객체만 저장
 *  	List<E> list = new LinkedList<>();
 *  	List list = new LinkedList(); // 모든 타입의 객체 저장
 *
 */
// ArrayList와 LinkedList에 10000개의 객체를 삽입하는데 걸린 시간을 측정한 것이다.
// 0번 인덱스에 String 객체를 10000번 추가하기 위해 add(int index, E element) 메서드를 이용하였다.
public class LinkedListExample {
	public static void main(String[] args) {
		//ArrayList 컬렉션 객체 생성 
		List<String> list1 = new ArrayList<String>();

		//LinkedList 컬렉션 객체 생성
		List<String> list2 = new LinkedList<String>();

		//시작 시간과 끝 시간을 저장할 변수 선언
		long startTime;
		long endTime;

		//ArrayList 컬렉션에 저장하는 시간 측정
		startTime = System.nanoTime();
		for(int i=0; i<10000; i++) {
			list1.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.printf("%-17s %8d ns \n", "ArrayList 걸린 시간: ", (endTime-startTime) );

		//LinkedList 컬렉션에 저장하는 시간 측정
		startTime = System.nanoTime();
		for(int i=0; i<10000; i++) {
			list2.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.printf("%-17s %8d ns \n", "LinkedList 걸린 시간: ", (endTime-startTime) );
	}
}