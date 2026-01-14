package ch14_컬렉션.ex09_TreeMap;

import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
/**
 * TreeMap
 * 	- 이진 트리를 기반으로 한 Map 컬렉션
 * 	- TreeSet과의 차이점은 키와 값이 저장된 Entry를 저장한다는 점이다.
 *  - TreeMap에 엔트리를 저장하면 키를 기준으로 자동 정렬된다.
 *  -> 부모 키 값과 비교해서 낮은 것은 왼쪽, 높은 것은 오른쪽 자식 노드에 Entry 객체를 저장한다.
 *  
 * 객체 생성
 *  - Map 타입 변수에 대입해도 되지만, 검색 관련 메서드가 TreeMap에만 정의되어 있다.
 *    
 * 		TreeMap<K, V> treeMap = new TreeMap<K, V>();
 * 		TreeMap<K, V> treeMap = new TreeMap<>();
 * 
 * 검색 관련 메서드
 * 		1. Map.Entry<K,V> firstEntry(): 제일 낮은 Map.Entry를 리턴
 * 		2. Map.Entry<K,V> lastEntry(): 제일 높은 Map.Entry를 리턴
 * 		3. Map.Entry<K,V> lowerEntry(): 주어진 키보다 바로 아래 Map.Entry를 리턴
 * 		4. Map.Entry<K,V> higherEntry(): 주어진 키보다 바로 위 Map.Entry를 리턴
 * 		5. Map.Entry<K,V> floorEntry()
 * 			: 주어진 키와 동등한 키가 있으면 해당 Map.Entry를 리턴, 
 * 			  없다면 주어진 키 바로 아래의 Map.Entry를 리턴 
 * 		6. Map.Entry<K,V> ceilingEntry()
 * 			: 주어진 키와 동등한 키가 있으면 해당 Map.Entry를 리턴,
 * 			  없다면 주어진 키 바로 위의 Map.Entry를 리턴
 * 		7. Map.Entry<K,V> pollFirstEntry(): 제일 낮은 Map.Entry를 커내오고 컬렉션에서 제거함
 * 		8. Map.Entry<K,V> pollLastEntry(): 제일 높은 Map.Entry를 꺼내오고 컬렉션에서 제거함
 * 		9. NavigableSet<K> descendingKeySet(): 내림차순으로 정렬된 키의 NavigableSet을 리턴
 * 	   10. NavigableMap<K,V> descendingMap()
 * 			: 내림차순으로 정렬된 Map.Entry의 NavigableMap을 리턴
 * 	   
 * 11. NavigableMap<K,V> headMap(K tokey, boolean inclusive)
 * 			: 주어진 키보다 낮은 Map.Entry들을 NavigableMap으로 리턴.
 * 			  주어진 키의 Map.Entry 포함 여부는 두 번째 매개값에 따라 달라짐
 * 	   12. NavigableMap<K,V> tailMap(K fromKey, boolean inclusive)
 * 		   	: 주어진 객체보다 높은 Map.Entry들을 NavigableMap으로 리턴.
 * 			  주어진 객체 포함 여부는 두 번째 매개값에 따라 달라짐.
 * 	   13. NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
 * 			: 시작과 끝으로 주어진 키 사이의 Map.Entry들을 NavigableMap 컬렉션으로 반환.
 * 			  시작과 끝 키의 Map.Entry 포함 여부는 두 번째, 네 번째 매개값에 다라 달라짐
 *
 * java.util.Map.Entry 인터페이스 
 *   - Map 내부에 저장된 “하나의 키–값(Key–Value) 쌍”을 표현하는 인터페이스
 *   
 *   1. K getKey(): key 반환
 *   2. V getValue(): value 반환
 *   3. V setValue(V value): value 수정
 *  
 */
// 영어 단어와 페이지 번호를 무작위로 저장하고 검색
public class TreeMapExample {
	public static void main(String[] args) {
		//TreeMap 컬렉션 생성
		TreeMap<String,Integer> treeMap = new TreeMap< >();

		//엔트리 저장
		treeMap.put("apple", 10);
		treeMap.put("forever", 60);
		treeMap.put("description", 40);
		treeMap.put("ever", 50);
		treeMap.put("zoo", 80);
		treeMap.put("base", 20);
		treeMap.put("guess", 70);
		treeMap.put("cherry", 30);

		//정렬된 엔트리를 하나씩 가져오기
		Set<Entry<String, Integer>> entrySet = treeMap.entrySet();
		for(Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
		System.out.println();

		//특정 키에 대한 값 가져오기
		Entry<String,Integer> entry = null;
		entry = treeMap.firstEntry();
		System.out.println("제일 앞 단어: " + entry.getKey() + "-" + entry.getValue());
		entry = treeMap.lastEntry();
		System.out.println("제일 뒤 단어: " + entry.getKey() + "-" + entry.getValue());
		entry = treeMap.lowerEntry("ever");
		System.out.println("ever 앞 단어: " + entry.getKey() + "-" + entry.getValue() + "\n");
		
		//내림차순으로 정렬하기
		NavigableMap<String,Integer> descendingMap = treeMap.descendingMap();
		Set<Entry<String,Integer>> descendingEntrySet = descendingMap.entrySet();
		for(Entry<String,Integer> e : descendingEntrySet) {
			System.out.println(e.getKey() + "-" + e.getValue());
		}
		System.out.println();
		
		//범위 검색
		System.out.println("[c~h 사이의 단어 검색]");
		NavigableMap<String,Integer> rangeMap = treeMap.subMap("c", true, "h",	false);
		for(Entry<String, Integer> e : rangeMap.entrySet()) {
			System.out.println(e.getKey() + "-" + e.getValue());
		}
	}
}