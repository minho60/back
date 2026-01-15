package ch14_컬렉션.ex13_수정불가;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 수정할 수 없는(unmodifiable) 컬렉션
 *  - 요소를 추가, 삭제할 수 없는 컬렉션
 * 
 * 1. List, Set, Map 인터페이스의 정적 메서드인 of()로 생성
 *  
 *  	List<E> immutalbeList = List.of(E... elements);
 *  	Set<E> immutalbeSet = Set.of(E... elements);
 *  	Map<K,V> immutalbeMap = Map.of(K k1, V v1, K k2, V v2, ...);
 *  
 * 2. List, Set, Map 인터페이스의 정적 메서드인 copyOf()을 이용해 기존 컬렉션을 복사하여 생성
 *  
 *  	List<E> immutableList = List.copyOf(Collection<E> coll);
 *  	Set<E> immutableSet = Set.copyOf(Collection<E> coll);
 *  	Map<K,V> immutableMap = Map.copyOf(Map<K,V> map);
 *  
 * 3. 배열로부터 수정할 수 없는 List 컬렉션 생성
 * 		
 * 		String[] arr = {"A", "B", "C"};
 * 		List<String> immutableList = Arrays.asList(arr);
 *  
 */
// 수정할 수 없는 컬렉션 생성
public class ImmutableExample {
	public static void main(String[] args) {
		//List 불변 컬렉션 생성
		List<String> immutableList1 = List.of("A", "B", "C");
		//immutableList1.add("D"); (x)

		//Set 불변 컬렉션 생성
		Set<String> immutableSet1 = Set.of("A", "B", "C");
		//immutableSet1.remove("A"); (x)

		//Map 불변 컬렉션 생성
		Map<Integer, String> immutableMap1 = Map.of(
				1, "A",
				2, "B",
				3, "C"
				);
		//immutableMap1.put(4, "D"); (x)
		
		//List 컬렉션을 불변 컬렉션으로 복사
		List<String> list = new ArrayList< >();
		list.add("A");
		list.add("B");
		list.add("C");
		List<String> immutableList2 = List.copyOf(list);
		
		//Set 컬렉션을 불변 컬렉션으로 복사
		Set<String> set= new HashSet< >();
		set.add("A");
		set.add("B");
		set.add("C");
		Set<String> immutableSet2 = Set.copyOf(set);
			
		//Map 컬렉션을 불변 컬렉션으로 복사
		Map<Integer, String> map = new HashMap< >();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		Map<Integer, String> immutableMap2 = Map.copyOf(map);
		
		//배열로부터 List 불변 컬렉션 생성
		String[] arr = { "A", "B", "C" };
		List<String> immutableList3 = Arrays.asList(arr);
	}
}