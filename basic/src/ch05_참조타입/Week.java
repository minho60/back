package ch05_참조타입;


/**
 * 열거 타입
 * 	- 미리 정의 된 상수들의 집합을 나타내는 자료형을 의미한다.
 * 	- 한정된 값을 갖는 타입
 * 	- 예) 요일, 계절 등
 * 
 * 열거 상수
 * 	- 열거 타입으로 사용할 수 있는 한정된 값
 * 	- 영문 대문자, 스네이크 표기법(관례) 
 */

// 열거 타입(enum)
public enum Week {
	// 열거 상수
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY,
	SUNDAY
}