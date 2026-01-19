package ch16_스트림.ex06_최종처리;

import java.util.Arrays;
/**
 * 요소 기본 집계
 *  - 집계(Aggregate)는 최종 처리 기능으로 요소들을 처리해서
 *    카운팅, 합계, 평균값, 최댓값, 최솟값등과 같이 하나의 값으로 산출하는 것을 말한다.
 *    즉, 대량의 데이터를 가공해서 하나의 값으로 축소하는 리덕션(Reduction)이라고 볼 수 있다.
 *    
 * 스트림이 제공하는 기본 집계
 *  - 집계 메서드가 리턴하는 OptionalXXX는 
 *    Optional, OptionalDouble, OptionalInt, OptionalLong 클래스를 말한다.
 *    이들을 최종값으로 저장하는 객체로
 *    get(), getAsDouble(), getAsInt(), getAsLong()을 호출하면 최종값을 얻을 수 있다.
 * 
 * 	1. long count(): 요소 개수
 *  2. OptionalXXX findFirst(): 첫 번째 요소
 *  3. Optional<T> max(Comparator<T>): 최대 요소
 *     OptionalXXX max()
 *  4. Optional<T> min(Comparator<T>): 최소 요소
 *     OptionalXXX min()
 *  5. OptionalDouble average(): 요소 평균
 *  6. int|long|double sum(): 요소 총합
 *  
 * 
 */
public class 집계1 {
	public static void main(String[] args) {
		//정수 배열
		int[] arr = {1, 2, 3, 4, 5};

		//카운팅
		long count = Arrays.stream(arr)
				.filter(n -> n%2==0)
				.count();
		System.out.println("2의 배수 개수: " + count);

		//총합
		long sum = Arrays.stream(arr)
				.filter(n -> n%2==0)
				.sum();
		System.out.println("2의 배수의 합: " + sum);

		//평균
		double avg = Arrays.stream(arr)
				.filter(n -> n%2==0)
				.average()
				.getAsDouble();
		System.out.println("2의 배수의 평균: " + avg);

		//최대값
		int max = Arrays.stream(arr)
				.filter(n -> n%2==0)
				.max()
				.getAsInt();
		System.out.println("최대값: " + max);
		
		//최소값
		int min = Arrays.stream(arr)
				.filter(n -> n%2==0)
				.min()
				.getAsInt();
		System.out.println("최소값: " + min);
		
		//첫 번째 요소
		int first = Arrays.stream(arr)
				.filter(n -> n%3==0)
				.findFirst()
				.getAsInt();
		System.out.println("첫 번째 3의 배수: " + first);
	}
}