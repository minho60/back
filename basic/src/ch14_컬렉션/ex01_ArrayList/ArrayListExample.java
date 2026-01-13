package ch14_컬렉션.ex01_ArrayList;

import java.util.ArrayList;
import java.util.List;
/**
 * 컬렉션 프레임워크
 * 1. List 인터페이스
 *  	- 순서 유지, 중복 저장 가능
 *  	- 구현 클래스: ArrayList, Vector, LinkedList
 * 2. Set 인터페이스
 * 		- 순서x, 중복x
 *  	- 구현 클래스: HashSet, TreeSet
 * 3. Map 인터페이스
 * 		- 키와 값으로 구성된 엔트리 저장
 *  	- 키는 중복x
 *  	- 구현 클래스: HashMap, Hashtable, TreeMap, Properties
 * 
 * List 컬렉션
 * 객체 추가
 * 	1. boolean add(E e): 주어진 객체를 맨 끝에 추가
 *  2. void add(int index, E element): 주어진 인덱스에 객체를 추가
 *  3. set(int index, E element): 주어진 인덱스의 객체를 새로운 객체로 바꿈
 *  
 * 객체 검색
 *  1. boolean contains(Object o): 주어진 객체가 저장되어 있는지 여부
 *  2. E get(int index): 주어진 인덱스에 저장된 객체를 리턴
 *  3. isEmpty(): 컬렉션이 비어 있는지 조사
 *  4. int size(): 저장되어 있는 전체 객체 수를 리턴
 *  
 * 객체 삭제
 *  1. void clear(): 저장된 모든 객체를 삭제
 *  2. E remove(int index): 주어진 인덱스에 저장된 객체를 삭제
 *  3. boolean remove(Object o): 주어진 겍체를 삭제
 *  
 * ArrayList
 * 	- 일반 배열과 차이점은 제한 없이 객체를 추가할 수 있다. -> 동적 크기 조절
 *  - 객체 생성
 *  
 *  	List<E> 변수 = new ArrayList<E>(); -> E에 지정된 타입의 객체만 저장
 *		List<E> 변수 = new ArrayList<>();
 *		List 변수 = new ArrayList(); -> 모든 종류의 객체 저장
 *  
 *  - 객체 삭제
 *  	- 특정 인덱스의 객체를 제거하면 바로 뒤 인덱스부터 마지막 인덱스까지 모두 앞으로 1씩 당겨진다.
 *  - 객체 삽입
 *  	- 특정 인덱스에 객체를 삽입하면 해당 인덱스부터 마지막 인덱스까지 모두 1씩 밀려난다.
 *  -> 빈번한 객체 삭제와 삽입이 일어나는 곳에서는 ArrayList를 사용하는 것은 바람직하지 않다.
 * 
 */
public class ArrayListExample {
	public static void main(String[] args) {
		//ArrayList 컬렉션 생성
		List<Board> list = new ArrayList< >();
		
		//객체 추가
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이4"));
		list.add(new Board("제목5", "내용5", "글쓴이5"));

		//저장된 총 객체 수 얻기
		int size = list.size();
		System.out.println("총 객체 수: " + size);
		System.out.println();
				
		//특정 인덱스의 객체 가져오기
		Board board = list.get(2);
		System.out.println(board.getSubject() + "\t" + board.getContent() +
								"\t" + board.getWriter());
		System.out.println();
			
		//모든 객체를 하나씩 가져오기
		for(int i=0; i<list.size(); i++) {
			Board b = list.get(i);
			System.out.println(b.getSubject() + "\t" + b.getContent() +
								"\t" + b.getWriter());
		}
		System.out.println();
			
		//객체 삭제
		list.remove(2);
		list.remove(2);
			
		//향상된 for문으로 모든 객체를 하나씩 가져오기
		for(Board b : list) {
			System.out.println(b.getSubject() + "\t" + b.getContent() +
								"\t" + b.getWriter());
		}
	}
}