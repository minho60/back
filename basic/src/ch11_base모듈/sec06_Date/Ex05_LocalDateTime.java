package ch11_base모듈.sec06_Date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * java.util.Date -> Java 1.0
 * java.util.Calender -> Java 1.1 -> java.text.SimpleDateFormat
 * 
 * java.time.LocalDateTime -> java.time.format.DateTimeFormatter
 *  - Java 8 이후 현재 컴퓨터의 날짜와 시간을 얻는 방법
 * 		
 * 		LocalDateTime now = LocalDateTime.now();
 * 
 * 	- static LocalDateTime now(): 시스템 현재 날짜와 시간 반환
 *  - String format(DateTimeFormatter formatter): 지정 포맷의 문자열로 변환
 *  - LocalDateTime plusDays(long days): +일 연산, 새 객체 반환
 *  - LocalDateTime plusYears(long years): +년 연산, 새 객체 반환
 *  - LocalDateTime minusMonths(long months): -월 연산, 새 객체 반환
 *  
 * java.time.format.DateTimeFormatter 
 * 
 * 	- static DateTimeFormatter ofPattern(String pattern): 사용자 정의 패턴 생성
 *  - 패턴 기호
 *  	
 *  	yyyy	년
 *  	MM		월
 *  	dd		일
 *  	E		요일
 *  	a		AM/PM
 *  	HH		시(24시간)
 *  	hh		시(12시간)
 *  	mm		분
 *  	ss		초
 *  	SSS		밀리초
 *  
 */
public class Ex05_LocalDateTime {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
		System.out.println("현재 시간: " + now.format(dtf));
		
		// 기존 날짜의 년도에 1을 더해서 새 객체로 반환
		LocalDateTime result1 = now.plusYears(1);
		System.out.println("1년 덧셈: " + result1.format(dtf));
		
		// 기존 날짜의 월에 2를 빼서 새 객체로 반환
		LocalDateTime result2 = now.minusMonths(2);
		System.out.println("2월 뺄셈: " + result2.format(dtf));
		
		// 기존 날짜의 일에 7를 더해서 새 객체로 반환		
		LocalDateTime result3 = now.plusDays(7);
		System.out.println("7일 덧셈: " + result3.format(dtf));
			}
	}