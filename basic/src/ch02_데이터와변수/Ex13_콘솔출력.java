package ch02_데이터와변수;

public class Ex13_콘솔출력 {

	public static void main(String[] args) {
		int value = 123;

		// 줄 바꿈 된다.
		System.out.println(value);

		// 줄바꿈 안된다.
		System.out.print(value + "\n");

		// format(형식) 지정 출력
		/*
		 * system.out.printf("형식 문자열", 값1, 값2,...); 
		 * - 형식 문자열의 구성 
		 * 	- %[값의 순번$][플래그][전체자릿수][.소수자릿수]변환문자 
		 * 	- %는 형식 문자열의 시작 - 변환 문자는 d(정수), f(실수), s(문자열), c(문자), b(불리언) 
		 * 	- 플래그는 생략하면 왼쪽이 공백 
		 * 	- 는 오른쪽이 공백으로 채워지고,
		 * 	- 0은 왼쪽이 공백개신 0으로 채워진다. 
		 * 	- 줄 바꿈은 \n 또는 %n을 직접 넣는다.
		 */
		// system.out.printf("형식문자", 출력값);
		System.out.printf("상품 가격:%d원\n", value);
		System.out.printf("상품 가격:%6d원\n", value);
		System.out.printf("상품 가격:%-6d원\n", value);
		System.out.printf("상품 가격:%06d원\n", value);

		double area = 3.14159 * 10 * 10;
		// 형식문자열의 개수 만큼 값을 표시해야 한다.
		System.out.printf("반지름이 %d인 원의 넓이는 %10.2f 입니다.\n", 10, area);
		
		String name ="홍길동";
		String job= "개발자";
		System.out.printf("%06d | %-10s | %10s\n", 1, name, job);
		
		System.out.println();
		
	}
}
