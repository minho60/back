package ch06_클래스.ex05_메서드;

public class Computer {

	// Syntax error on token "{", { expected after this token
	// 구문오류, 클래스 안에 중괄호를 삽입해라

	// 합계
	// 1~10까지 합
    // 타입 메서드(타입 ... 매개변수)
	// values는 배열 타입 변수 처럼 사용된다.
	// int values = {값, 값, 값, ...}
	int sum(int... values) {
		int sum = 0;
		for (int i = 0; i <values.length; i++) {
			sum += values[i];
		}
		return sum;
	}

}
