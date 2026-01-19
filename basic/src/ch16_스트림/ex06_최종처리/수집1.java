package ch16_스트림.ex06_최종처리;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * 필터링한 요소 수집
 *  
 *  R collect(Collector<T,A,R> collector)
 *   - 요소들을 필터링 또는 매핑한 후 요소들을 수집하는 최종 처리 메서드
 *   - 필요한 요소만 컬렉션에 담을 수 있고,
 *     요소들을 그룹핑한 후에 집계도할 수 있다.
 *   - 매개값인 Collector는 어떤 요소를 어떤 컬렉션에 수집할 것인지를 결정한다.
 *   - 타입 파라미터의 T는 요소, A는 누적기(Accumulator), R은 요소가 저장될 컬렉션이다.
 *   -> T 요소를 A 누적기가 R에 저장한다는 의미이다.
 *   
 *      Collector<T,?,List<T>> toList(): T를 List에 저장
 *      Collector<T,?,Set<T>> toSet(): T를 Set에 저장
 *      Collector<T,?,Map<K,U>> toMap(Function<T,K> keyMapper, Function<T,U> valueMapper)
 *      	: T를 K와 U로 매핑하여 K를 키로, U를 값으로 Map에 저장
 *   
 *    
 */
public class 수집1 {
	public static void main(String[] args) {
		List<Student2> totalList = new ArrayList< >();
		totalList.add(new Student2("홍길동", "남", 92));
		totalList.add(new Student2("김수영", "여", 87));
		totalList.add(new Student2("감자바", "남", 95));
		totalList.add(new Student2("오해영", "여", 93));
		
		//남학생만 묶어 List 생성
		/*List<Student> maleList = totalList.stream()
		 		.filter(s->s.getSex().equals("남"))
		 		.collect(Collectors.toList());*/
			
		List<Student2> maleList = totalList.stream()
				.filter(s->s.getSex().equals("남"))
				.toList();
		
		maleList.stream()
			.forEach(s -> System.out.println(s.getName()));
		
		System.out.println();
		
		//학생 이름을 키, 학생의 점수를 값으로 갖는 Map 생성
		Map<String, Integer> map = totalList.stream()
				.collect(
					Collectors.toMap(
						s -> s.getName(), //Student 객체에서 키가 될 부분 리턴
						s -> s.getScore() //Student 객체에서 값이 될 부분 리턴
					)
			);
			
		System.out.println(map);
	}
}