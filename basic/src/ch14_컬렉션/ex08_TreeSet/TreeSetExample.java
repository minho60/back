package ch14_컬렉션.ex08_TreeSet;

import java.util.NavigableSet;
import java.util.TreeSet;
/**
 * 검색 기능을 강화시킨 컬렉션
 * 1. TreeSet
 * 2. TreeMap
 * 3. Comparable
 * 4. Comparator
 * 
 * TreeSet
 * 	- 이진 크리(binary tree)를 기반으로 한 Set 컬렉션
 *  - TreeSet에 객체를 저장하면 부모 노드의 객체와 비교해서 
 *    낮은 것은 왼쪽 자식 노드에, 높은 것은 오른쪽 자식 노드에 저장하여
 *    자동으로 정렬된다.
 *    
 * 이진 트리?
 * 	- 여러 개의 노드(node)가 트리 형태로 연결된 구조로,
 *    루트 노드(root node)라고 불리는 하나의 노드에서 시작해
 *    각 노드에 최대 2개의 노드를 연결할 수 있는 구조를 가지고 있다.
 *    
 * 객체 생성
 *  - Set 타입 변수에 대입해도 되지만 TreeSet 타입으로 대입한 이유?
 *  -> 검색 관련 메서드가 TreeSet에만 정의되어 있기 때문이다.
 *  
 * 		TreeSet<E> treeSet = new TreeSet<E>();   
 * 		TreeSet<E> treeSet = new TreeSet();
 *
 * 
 * 검색 관련 메서드
 * 		1. E first(): 제일 낮은 객체 리턴
 * 		2. E last(): 제일 높은 객체 리턴
 * 		3. E lower(E e): 주어진 객체보다 바로 아래 객체 리턴
 * 		4. E higher(E e): 주어진 객체보다 바로 위 객체 리턴
 * 		5. E floor(E e)
 * 			: 주어진 객체와 동등한 객체가 있으면 리턴, 
 * 			  만약 없다면 주어진 객체의 바로 아래의 객체 리턴
 * 		6. E ceiling(E e)
 * 			: 주어진 객체와 동등한 객체가 있으면 리턴, 
 * 		      만약 없다면 주어진 객체의 바로 위의 객체 리턴
 * 		7. E pollFirst(): 제일 낮은 객체를 꺼내오고 컬렉션에서 제거함
 * 		8. E pollLast(): 제일 높은 객체를 커내오고 컬렉션에서 제거함
 * 		9. iterator<E> desendingIterator(): 내림차순으로 정렬된 iterator를 리턴
 * 	   10. NavigableSet<E> descendingSet(): 내림차순으로 정렬된 NavigableSet을 리턴
 * 	   11. NavigableSet<E> headSet(E toElement, boolean inclusive)
 * 			: 주어진 객체보다 낮은 객체들을 NavigableSet으로 리턴
 * 			  주어진 객체 포함 여부는 두 번째 매개값에 따라 달라짐
 * 	   12. NavigableSet<E> tailSet(E fromElement, boolean inclusive)
 * 			: 주어진 객체보다 높은 객체들을 NavigableSet으로 리턴
 * 			  주어진 객체 포함 여부는 두 번째 매개값에 따라 달라짐
 * 	   13. NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
 * 			: 시작과 끝으로 주어진 객체 사이의 객체들을 NavigableSet으로 리턴,
 * 			  시작과 끝 객체의 포함 여부는 두 번째, 네 번째 매개값에 따라 달라짐
 * 
 * 
 */
public class TreeSetExample {
	public static void main(String[] args) {
		//TreeSet 컬렉션 생성
		TreeSet<Integer> scores = new TreeSet< >();

		//Integer 객체 저장
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);

		//정렬된 Integer 객체를 하나씩 가져오기
		for(Integer s : scores) {
			System.out.print(s + " ");
		}
		System.out.println("\n");

		//특정 Integer 객체를 가져오기
		System.out.println("가장 낮은 점수: " + scores.first());
		System.out.println("가장 높은 점수: " + scores.last());
		System.out.println("95점 아래 점수: " + scores.lower(95));
		System.out.println("95점 위의 점수: " + scores.higher(95));
		System.out.println("95점이거나 바로 아래 점수: " + scores.floor(95));
		System.out.println("85점이거나 바로 위의 점수: " + scores.ceiling(85) + "\n");

		//내림차순으로 정렬하기
		NavigableSet<Integer> descendingScores = scores.descendingSet();
		for(Integer s : descendingScores) {
			System.out.print(s + " ");
		}
		System.out.println("\n");
		
		//범위 검색( 80 <= )
		NavigableSet<Integer> rangeSet = scores.tailSet(80, true);
		for(Integer s : rangeSet) {
			System.out.print(s + " ");
		}
		System.out.println("\n");
		
		//범위 검색( 80 <= score < 90 )
		rangeSet = scores.subSet(80, true, 90, false);
		for(Integer s : rangeSet) {
			System.out.print(s + " ");
		}
	}
}