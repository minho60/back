package ch05_참조타입;

import java.util.Calendar;

// ctrl+shift+o: 자동임포트
// Java.lang 패키지 -> 기본 패키지 -> import 없이 사용

public class Ex08_EnumMain {

	public static void main(String[] args) {
		// Week 열거 타입 변수 선언
		// 참조타입 변수 = null;
		Week today = null;

		// Calendar 얻기
		// 객체 생성
		// string 변수 = "문자열"
		// string 변수 = new String("문자열");
		// cal 객체 생성
		// 클래스 변수  = 클래스.메서드();
		Calendar cal = Calendar.getInstance();

		// 오늘의 요일 얻기(1~7)
		int week = cal.get(Calendar.DAY_OF_WEEK);

		// 숫자를 열거 상수로 변환해서 변수에 대입
		switch (week) {
		case 1:
			today = Week.SUNDAY;
			break;
		case 2:
			today = Week.MONDAY;
			break;
		case 3:
			today = Week.TUESDAY;
			break;
		case 4:
			today = Week.WEDNESDAY;
			break;
		case 5:
			today = Week.THURSDAY;
			break;
		case 6:
			today = Week.FRIDAY;
			break;
		case 7:
			today = Week.SATURDAY;
			break;
		}

		// 열거 타입 변수를 사용
		if (today == Week.SUNDAY) {
			System.out.println("일요일에는 축구를 합니다.");
		} else {
			System.out.println("열심히 자바를 공부합니다.");
		}

	}

}
