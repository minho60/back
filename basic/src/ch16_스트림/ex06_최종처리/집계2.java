package ch16_스트림.ex06_최종처리;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
/**
 * Optional 클래스
 * 	- Optional, OptionalDouble, OptionalInt, OptionalLong 클래스는
 *    집계값만 저장하는 것이 아니라, 집계값이 존재하지 않을 경우 디폴트 값을 설정하거나,
 *    집계값을 처리하는 Consumer를 등록할 수 있다.
 *    
 *    1. isPresent(): 집계값이 있는지 여부
 *    2. orElse(디폴트값): 집계값이 없을 경우 디폴트 값 설정
 *    3. ifPresent(): 집계값이 있을 경우 Consumer에서 처리
 *    
 */
public class 집계2 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList< >();

		/*//예외 발생(java.util.NoSuchElementException)
 		double avg = list.stream()
 			.mapToInt(Integer :: intValue)
 			.average()
 			.getAsDouble();
		*/

		//방법1
		OptionalDouble optional = list.stream()
			.mapToInt(Integer :: intValue)
			.average();
		if(optional.isPresent()) {
			System.out.println("방법1_평균: " + optional.getAsDouble());
		} else {
			System.out.println("방법1_평균: 0.0");
		}

		//방법2
		double avg = list.stream()
			.mapToInt(Integer :: intValue)
			.average()
			.orElse(0.0);
		System.out.println("방법2_평균: " + avg);
		
		//방법3
		list.stream()
			.mapToInt(Integer :: intValue)
			.average()
			.ifPresent(a -> System.out.println("방법3_평균: " + a));
	}
}