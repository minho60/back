package ch16_스트림.ex06_최종처리;

import java.util.Arrays;
import java.util.List;

public class 커스텀집계 {
	public static void main(String[] args) {
		List<Student2> studentList = Arrays.asList(
				new Student2("홍길동", 92),
				new Student2("신용권", 95),
				new Student2("감자바", 88)
		);		
		//방법1
		int sum1 = studentList.stream()
				.mapToInt(Student2 :: getScore)
				.sum();		
		//방법2
		int sum2 = studentList.stream()
						.map(Student2 :: getScore)
						.reduce(0, (a, b) -> a+b);
		
		System.out.println("sum1: " + sum1);
		System.out.println("sum2: " + sum2);
	}
}