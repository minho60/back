package ch11_base모듈.sec06_Date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
/**
 * 특정 날짜와 시간 비교
 * 	-> year부터 second까지 매개값을 모두 int 타입 값으로 지정한다.
 * 
 *  - static LocalDateTime of(int year, int month, int day, int hour, int minute, int second)
 *  	: 연, 월, 일, 시, 분, 초로 객체 생성
 *  
 *  - boolean isBefore(LocalDateTime other): 이전 여부
 *	- boolean isAfter(LocalDateTime other):	이후 여부
 *	- boolean isEqual(LocalDateTime other):	동일 시점
 *
 *	- long until(Temporal end, ChronoUnit u): 차이 계산
 *  		 
 */
public class Ex06_LocalDateTimeCompare {
	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");

		LocalDateTime startDateTime = LocalDateTime.of(2021, 1, 1, 0, 0, 0);
		System.out.println("시작일: " + startDateTime.format(dtf));
		
		LocalDateTime endDateTime = LocalDateTime.of(2021, 12, 31, 0, 0, 0);
		System.out.println("종료일: " + endDateTime.format(dtf));
 
		// startDateTime 이 endDateTime 보다 이전인가?
		if(startDateTime.isBefore(endDateTime)) {
			System.out.println("진행 중입니다.");
			//startDateTime 이 endDateTime 보다 같은가?
		} else if(startDateTime.isEqual(endDateTime)) {
			System.out.println("종료합니다.");
			//startDateTime 이 endDateTime 보다 이후 인가?
		} else if(startDateTime.isAfter(endDateTime)) {
			System.out.println("종료했습니다.");
		}
		
		long remainYear = startDateTime.until(endDateTime, ChronoUnit.YEARS);
		long remainMonth = startDateTime.until(endDateTime, ChronoUnit.MONTHS);
		long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS);
		long remainHour = startDateTime.until(endDateTime, ChronoUnit.HOURS);
		long remainMinute = startDateTime.until(endDateTime, ChronoUnit.MINUTES);
		long remainSecond = startDateTime.until(endDateTime, ChronoUnit.SECONDS);
		System.out.println("남은 해: " + remainYear);
		System.out.println("남은 월: " + remainMonth);
		System.out.println("남은 일: " + remainDay);
		System.out.println("남은 시간: " + remainHour);
		System.out.println("남은 분: " + remainMinute);
		System.out.println("남은 초: " + remainSecond);
	}
}