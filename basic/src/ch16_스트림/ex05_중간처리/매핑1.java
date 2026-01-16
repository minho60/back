package ch16_스트림.ex05_중간처리;

import java.util.ArrayList;
import java.util.List;
/**
 * 요소 변환(매핑)
 *  - 매핑(mapping)은 스트림의 요소를 다른 요소로 변환하는 중간 처리 기능이다.
 * 
 * 매핑 메서드
 * 
 * 	1. mapXxx(): 요소를 다른 요소로 변환
 * 
 *  - 기본 타입 간의 변환이거나 기본 타입 요소를 래퍼(wrapper) 객체 요소로 변환
 *  2. DoubleStream asDoubleStream(): int -> double, long -> double
 *  3. LongStream asLongStream(): int -> long
 *  4. Stream<Integer> boxed(): int -> Integer
 *     Stream<Long> boxed(): long -> Long
 *     Stream<Double> boxed(): double -> Double
 *    
 *  5. flatMapXxx()
 * 
 *   
 */
// Student 스트림을 score 스트림으로 변환하고 점수를 콘솔에 출력
public class 매핑1 {
	public static void main(String[] args) {
		//List 컬렉션 생성
		List<Student1> studentList = new ArrayList<>();
		studentList.add(new Student1("홍길동", 85));
		studentList.add(new Student1("홍길동", 92));
		studentList.add(new Student1("홍길동", 87));
		
		//Student를 score 스트림으로 변환
		studentList.stream()
			.mapToInt(s -> s.getScore())
			.forEach(score -> System.out.println(score));
	}
}