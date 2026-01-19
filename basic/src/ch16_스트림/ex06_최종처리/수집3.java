package ch16_스트림.ex06_최종처리;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * Collectors.groupingBy() 메서드는 그룹핑 후 
 * 매핑 및 집계(평균, 카운팅, 연결, 최대, 최소, 합계)를 수행할 수 있도록 
 * 두 번째 매개값인 Collector를 가질 수 있다.
 * 
 *  	1. Collector mapping(Function, Collector): 매핑
 *  	2. Collector averagingDouble(ToDoubleFunction): 평균값
 *  	3. Collector counting(): 요소 수
 *  	4. Collector maxBy(Comparator): 최댓값
 *  	5. Collector minBy(Comparator): 최솟값
 *  	6. Collector reducing(BinaryOperator<T>): 커스텀 집계 값
 *  	   Collector reducing(T identity, BinaryOperator<T>)
 *  
 */
public class 수집3 {
	public static void main(String[] args) {
		List<Student2> totalList = new ArrayList<>();
		totalList.add(new Student2("홍길동", "남", 92));
		totalList.add(new Student2("김수영", "여", 87));
		totalList.add(new Student2("감자바", "남", 95));
		totalList.add(new Student2("오해영", "여", 93));
		
		Map<String, Double> map = totalList.stream()
				.collect(
					Collectors.groupingBy(
						s -> s.getSex(),
						Collectors.averagingDouble(s->s.getScore())
					)
				);
		
		System.out.println(map);
	}
}