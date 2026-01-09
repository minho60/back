package ch11_base모듈.sec06_Date;

import java.text.*;
import java.util.*;
/**
 * java.util.Date
 * 	- 날짜를 표현하는 클래스로 객체 간에 날짜 정보를 주고받을 때 사용된다.
 * 
 * 		// 생성자
 * 		Date(): 컴퓨터의 현재 날짜를 읽어 Date 객체로 만든다.
 * 
 *  
 * java.util.Calendar
 * 	- 다양한 시간대별로 날짜와 시간을 얻을 때 사용
 * java.time.LocalDateTime 
 * 	- 날짜와 시간을 조작할 때 사용
 * java.text.SimpleDateFormat
 * 
 */
public class Ex01_Date {
	public static void main(String[] args) {
		Date now = new Date();
		String strNow1 = now.toString();
		System.out.println(strNow1);
		
		/**
		 * java.text.SimpleDateFormat
		 *  - 날짜를 형식화된 문자열로 변환
		 * 
		 * 패턴 문자
		 *   1. y: 년
		 *   2. M: 월
		 *   3. d: 일
		 *   4. D: 월 구분이 없는 일(1~365)
		 *   5. E: 요일
		 *   6. a: 오전/오후
		 *   7. w: 년의 몇 번째 주
		 *   8. W: 월의 몇 번째 주
		 *   9. H: 시(0~23)
		 *  10. h: 시(1~12)
		 *  11. K: 시(0~11)
		 *  12. k: 시(1~24)
		 *  13. m: 분
		 *  14. s: 초
		 *  15. S: 밀리세컨드(1/1000초)
		 *    
		 */
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);
	}
}