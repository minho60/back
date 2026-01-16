package ch16_스트림.ex05_중간처리;

import java.util.Arrays;
import java.util.stream.IntStream;
/**
 * 요소 변환(매핑)
 *  - 매핑(mapping)은 스트림의 요소를 다른 요소로 변환하는 중간 처리 기능이다.
 * 
 * 매핑 메서드
 *  - 기본 타입 간의 변환이거나 기본 타입 요소를 래퍼(wrapper) 객체 요소로 변환
 *  2. DoubleStream asDoubleStream(): int -> double, long -> double
 *  3. LongStream asLongStream(): int -> long
 *  4. Stream<Integer> boxed(): int -> Integer
 *     Stream<Long> boxed(): long -> Long
 *     Stream<Double> boxed(): double -> Double
 *   
 */
public class 매핑2 {
	public static void main(String[] args) {
		int[] intArray = { 1, 2, 3, 4, 5};
		
		IntStream intStream = Arrays.stream(intArray);
		intStream
			.asDoubleStream()
			.forEach(d -> System.out.println(d));
			
		System.out.println();
		
		intStream = Arrays.stream(intArray);
		intStream
			.boxed()
			.forEach(obj -> System.out.println(obj.intValue()));
	}
}