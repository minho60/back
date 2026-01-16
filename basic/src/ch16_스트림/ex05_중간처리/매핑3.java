package ch16_스트림.ex05_중간처리;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 요소 변환(매핑)
 *  - 매핑(mapping)은 스트림의 요소를 다른 요소로 변환하는 중간 처리 기능이다.
 *
 * 매핑 메서드
 *  - 요소를 복수 개의 요소로 변환
 *
 *  	flatMapXxx(): 하나의 요소를 복수 개의 요소들로 변환한 새로운 스트림을 리턴한다.
 *
 */
public class 매핑3 {
	public static void main(String[] args) {
		//문장 스트림을 단어 스트림으로 변환
		List<String> list1 = new ArrayList< >();
		list1.add("this is java");
		list1.add("i am a best developer");
		list1.stream().
		flatMap(data -> Arrays.stream(data.split(" ")))
		.forEach(word -> System.out.println(word));
		
		System.out.println();
		
		//문자열 숫자 목록 스트림을 숫자 스트림으로 변환
		List<String> list2 = Arrays.asList("10, 20, 30", "40, 50");
		list2.stream()
		.flatMapToInt(data -> {
			String[] strArr = data.split(",");
			int[] intArr = new int[strArr.length];
			for (int i = 0; i < strArr.length; i++) {
				intArr[i] = Integer.parseInt(strArr[i].trim());
			}
			return Arrays.stream(intArr);
		})
		.forEach(number -> System.out.println(number));
	}
}	