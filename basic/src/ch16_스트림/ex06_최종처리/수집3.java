package ch16_스트림.ex06_최종처리;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 수집3 {
	public static void main(String[] args) {
		List<Student> totalList = new ArrayList<>();
		totalList.add(new Student("홍길동", "남", 92));
		totalList.add(new Student("김수영", "여", 87));
		totalList.add(new Student("감자바", "남", 95));
		totalList.add(new Student("오해영", "여", 93));
		
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