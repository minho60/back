package ch16_스트림.ex06_최종처리;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * 요소 그룹핑
 *  - collect() 메서드는 컬렉션 요소들을 그룹핑해서 Map 객체를 생성하는 기능도 제공한다.
 *  - Collectors.groupingBy() 메서드에서 얻은 Collector를 
 *    collect() 메서드를 호출할 때 제공하면 된다.
 *  - groupingBy()는 Function을 이용해서 T를 K로 매핑하고, 
 *    K를 키로 해 List<T>를 값으로 갖는 Map 컬렉션을 생성한다.
 *  
 *   	Collector<T,?,Map<K,List<T>>> groupingBy(Function<T,K> classifier)
 */
public class 수집2 {
	public static void main(String[] args) {
		List<Student2> totalList = new ArrayList< >();
		totalList.add(new Student2("홍길동", "남", 92));
		totalList.add(new Student2("김수영", "여", 87));
		totalList.add(new Student2("감자바", "남", 95));
		totalList.add(new Student2("오해영", "여", 93));
		
		Map<String, List<Student2>> map = totalList.stream()
			.collect(
				Collectors.groupingBy(s -> s.getSex())
			);
			
		List<Student2> maleList = map.get("남");
		maleList.stream().forEach(s -> System.out.println(s.getName()));
		System.out.println();
		
		List<Student2> femaleList = map.get("여");
		femaleList.stream().forEach(s -> System.out.println(s.getName()));
	}
}