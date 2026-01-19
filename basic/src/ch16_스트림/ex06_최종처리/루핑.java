package ch16_스트림.ex06_최종처리;

import java.util.Arrays;

/**
* 요소를 하나씩 처리(루핑)
*  - 루핑(looping)은 스트림에서 요소를 하나씩 반복해서 가져와 처리하는 것을 말한다.
*  
*  	peek(): 중간 처리 메서드
*  	forEach(): 최종 처리 메서드
*  
*/
public class 루핑 {
	public static void main(String[] args) {
		int[] intArr = { 1, 2, 3, 4, 5 };

		//잘못 작성한 경우
		Arrays.stream(intArr)
			.filter(a -> a%2==0)
			.peek(n -> System.out.println(n)); 		//최종 처리가 없으므로 동작하지 않음

		//중간 처리 메소드 peek()을 이용해서 반복 처리
		int total = Arrays.stream(intArr)
			.filter(a -> a%2==0)
			.peek(n -> System.out.println(n)) 		//동작함
			.sum(); //최종 처리
		System.out.println("총합: " + total + "\n");

		//최종 처리 메소드 forEach()를 이용해서 반복 처리
		Arrays.stream(intArr)
			.filter(a -> a%2==0)
			.forEach(n -> System.out.println(n)); 	//최종 처리이므로 동작함
	}
}