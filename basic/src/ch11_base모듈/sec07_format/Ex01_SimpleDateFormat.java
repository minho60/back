package ch11_base모듈.sec07_format;

import java.text.SimpleDateFormat;
import java.util.Date;
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
public class Ex01_SimpleDateFormat {
	public static void main(String[] args) {
		Date now = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println( sdf.format(now) );

		sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println( sdf.format(now) );

		sdf = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss");
		System.out.println( sdf.format(now) );

		sdf = new SimpleDateFormat("오늘은 E요일");
		System.out.println( sdf.format(now) );

		sdf = new SimpleDateFormat("올해의 D번째 날");
		System.out.println( sdf.format(now) );

		sdf = new SimpleDateFormat("이달의 d번째 날");
		System.out.println( sdf.format(now) );
	}
}