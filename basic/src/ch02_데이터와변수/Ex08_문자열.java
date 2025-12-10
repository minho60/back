package ch02_데이터와변수;

/**
 * 데이터 타입
 * 1. 기본 타입: 정수(byte,short, int, long, char), 실수(float, double), boolean
 * 2. 참조타입: String
 * 
 * 문자 vs 문자열
 * 1. 문자 리터럴? 하나의 문자를 작은 따옴표(')로 감싼 것
 * 2. 문자 리터럴은 유니코드로 변환되어 저장된다.
 * 3. 유니코드(Unicode)는 세계 각국의 문자를 0~65535 숫자로 매핑한 국제 표준 규약이다.
 * 4. 작은 따옴표(')로 감싼 한 개의 문자는 char 타입이지만, 
 * 5. 큰 따옴표(")로 감싼 여러개의 문자들은 유니코드로 변환되지 않는다.
 * 6. 문자열을 변수에 저장 할 떄는 String 타입을 사용한다.
 * 7. String 타입은 참조 타입이다.
 * 
 * 특수문자 (이스케이프(escape) 문자)
 * 1. '
 * 2. "
 * 3. \
 * 4. t탭
 * 5. \n 줄바꿈
 * 6. 캐리지 리턴(CR, Carriage Return)
 */
public class Ex08_문자열 {

	public static void main(String[] args) {
		//char var1 = "A"; // char 타입은 단일 따옴표 리터럴 사용
		//char var2 = '홍길동'; // char 타입은 단일 문자 1자만 사용
		//char var1 = ''; // 빈 문자열 ❌
		
		
		String str1 = "A";
		String str2 = ""; // 빈 문자열 가능
		String name = "홍길동";
		String job = "프로그래머";
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(name);
		System.out.println(job);

		
		//특수문자
		String str = "나는 \"자바\"를 배웁니다.";
		System.out.println(str);
		
		//줄바꿈
		str = "나는\n자바를\n배웁니다.";
		System.out.println(str);
		
		
		
		//탭
		//str = "번호		이름		직업";
		String record1 = "1		홍길동		개발자";
		String record2 = "100		허준		의사";
		str = "번호\t이름\t직업";
		System.out.println(str);
		System.out.println("----------------------------");
		System.out.println(record1);
		System.out.println(record2);
		
	}

}
