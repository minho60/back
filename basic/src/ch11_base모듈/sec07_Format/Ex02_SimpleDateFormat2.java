package ch11_base모듈.sec07_Format;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * java.util.Calendar 클래스 - 달력을 표현하는 추상 클래스 - 날짜와 시간을 계산하는 방법이 지역과 문화에 따라 다르기
 * 때문에 특정 역법(날짜와 시간을 매기는 방법)에 따르는 달력은 자식 클래스에서 구현한다. - 특별한 역법을 사용하는 경우가 아니라면, 정적
 * 메서드인 getInstance() 메서드를 이용하여 컴퓨터에 설정되어 있는 시간대(TimeZone)를 기준으로 Calendar 하위 객체를
 * 얻을 수 있다.
 * 
 * Calendar.getInstance() - 현재 날짜와 시간 정보를 가진 Calendar 객체를 생성하여 반환하는 정적 메서드
 * 
 * public static Calendar getInstance()
 * 
 * Calendar now = Calendar.getInstance();
 * 
 * - Calendar가 제공하는 날짜와 시간에 대한 정보를 얻기 위해서는 get() 메서드를 이용한다. - get() 메서드의 매개값으로
 * Calendar에 정의된 상수를 주면 상수가 의미하는 값을 리턴한다.
 * 
 * int year = now.get(Calendar.YEAR); // 년도 int month = now.get(Calendar.MONTH)
 * + 1; // 월 int day = now.get(Calendar.DAY_OF_MONTH); // 일 int week =
 * now.get(Calendar.DAY_OF_WEEK); // 요일 int amPm = now.get(Calendar.AM_PM); //
 * 오전/오후 int hour = now.get(Calendar.HOUR); // 시 int minute =
 * now.get(Calendar.MINUTE); // 분 int second = now.get(Calendar.SECOND); // 초
 * 
 */
public class Ex02_SimpleDateFormat2 {
	public static void main(String[] args) {
		// 객체생성
		Calendar now = Calendar.getInstance();
		System.out.println(now);

		int year = now.get(Calendar.YEAR); // 년도
		int month = now.get(Calendar.MONTH) + 1; // 월
		int day = now.get(Calendar.DAY_OF_MONTH); // 일
		int week = now.get(Calendar.DAY_OF_WEEK); // 요일
		int amPm = now.get(Calendar.AM_PM); // 오전/오후
		int hour = now.get(Calendar.HOUR); // 시
		int minute = now.get(Calendar.MINUTE); // 분
		int second = now.get(Calendar.SECOND); // 초

	
		String strAmPm = null;
		if (amPm == Calendar.AM) {
			strAmPm = "오전";
		} else {
			strAmPm = "오후";
		}

		String strWeek = null;
		switch (week) {
		case Calendar.MONDAY:
			strWeek = "월";
			break;
		case Calendar.TUESDAY:
			strWeek = "화";
			break;
		case Calendar.WEDNESDAY:
			strWeek = "수";
			break;
		case Calendar.THURSDAY:
			strWeek = "목";
			break;
		case Calendar.FRIDAY:
			strWeek = "금";
			break;
		case Calendar.SATURDAY:
			strWeek = "토";
			break;
		default:
			strWeek = "일";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(year + "-" + month + "-" + day);
		System.out.println(year + "년" + month + "월" + day + "일");
		System.out.println(year + "." + month + "." + day + strAmPm + hour + ":" + minute + ":" + second);
		System.out.println("오늘은" + week + "요일");
		System.out.println("오늘은" + day + "번째날");
		System.out.println("이달의" + day + "번째날");

	}
}