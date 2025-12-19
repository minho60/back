package ch05_참조타입;
/**
 * 데이터 타입
 * 	1. 기본 타입
 * 		- 정수 타입: byte, char, short, int, long
 * 		- 실수 타입: float, double
 * 		- 논리 타입: boolean
 * 
 *  2. 참조(객체) 타입
 *  	- 배열(array) 타입
 *      - 문자열 타입: String
 *  	- 열거(enum) 타입
 *  	- 클래스(class) 타입
 *  	- 인터페이스(interface) 타입
 *
 * 기본 타입 - 값 자체 저장
 *  - 예) int num = 3;
 * 참조 타입 - 번지(주소) 저장
 *  - 예) int[] nums = new int[] {1,2,3}
 *  
 * 참조 타입은 null 값을 가질 수 있다. -> 참조하는 주소 값이 없다.
 *  
 * 배열(Array)?
 *  - 연속된 공간에 값을 나열시키고, 각 값에 인덱스(index)를 부여해 놓은 자료구조이다.
 *  - 인덱스는 대괄호([])와 함께 사용하여 각 항목의 값을 읽거나 저장하는데 사용한다.
 *  - 같은 타입의 값만 관리한다.
 *  - 배열의 길이
 *  	- 배열에 저장할 수 있는 항목 수
 *  	- 생성과 동시에 길이가 결정된다. 
 *  	-> 늘리거나 줄일 수 없다.
 *      -> 읽기 전용! -> 값을 바꿀 수 없다.
 *      - 배열.length
 *  
 *  - 배열 선언  	
 *  	타입[] 배열; (관례)
 *  	타입 배열[];
 *  	// 값 목록 없이 향후 값들을 저장할 목적으로 배열을 미리 생성할 수 있다.
 *  	배열 = new 타입[길이];
 *  	// new 연산자로 배열을 생성하면 배열 항목은 기본값으로 초기화된다.
 *  	-> 정수 배열은 0, 실수 배열은 0.0, 논리 배열은 false, 참조 배열은 null 
 *  	
 *  - 배열 할당
 *  	// 리터럴
 *  	배열 = {값, ...};
 *      // new 연산자
 *  	배열 = new 타입[] {값, ...};
 *  	// null 값을 가질 수 있다.
 *  	배열 = null;
 *  
 *  - 배열 선언 및 할당
 *  	타입[] 배열 = {값, ...};
 *  	타입[] 배열 = new 타입[] {값, ...};
 *  	
 *  - 읽기(Read)
 *  	배열명[인덱스]
 *  - 저장(할당, Update)
 *  	배열명[인덱스] = 값;
 *  
 */
public class Ex05_배열 {

	// args는 String 타입의 배열 변수
	public static void main(String[] args) {
	
		// int 타입의 배열 선언
		// int[] 변수; 또는 int 변수[];
		int[] arr1;
		int[] arr3;

		// 배열 할당 - new 연산자
		arr1 = new int[] { 1, 2, 3 }; 

		// 선언 및 할당
		// 타입[] 변수 = new 타입[] { 값, ... };
		int[] arr2 = new int[] { 1, 2, 3 };
		
		// 배열의 값 수정
		arr2[0] = 10;
		
		arr3 = arr2; 
		
		// 참조 변수 비교
		// ==은 주소(번지) 비교
		// new 연산자로 생성한 배열 변수의 값은 서로 다른 주소를 갖는다.
		System.out.println(arr1 == arr2); // false
		System.out.println(arr2 == arr3); // true
		
		
		// 배열 변수 선언과 배열 생성(create) - 리터럴
		// 타입[] 변수 = { 값1, ... };
		String[] season = { "Spring", "Summer", "Fall", "Winter" };

		// 배열의 항목값 읽기(조회, read)
		// 배열[인덱스]
		System.out.println("season[0] : " + season[0]);
		System.out.println("season[1] : " + season[1]);
		System.out.println("season[2] : " + season[2]);
		System.out.println("season[3] : " + season[3]);

		// 인덱스 1번 항목의 값 변경(갱신, update)
		// 배열[인덱스] = 값;
		season[1] = "여름";
		System.out.println("season[1] : " + season[1]);
		System.out.println();

		//배열 변수 선언과 배열 생성
		int[] scores = { 83, 90, 87 };

		//총합과 평균 구하기
		int sum = 0;
//		for(int i=0; i<3; i++) {
		for(int i=0; i<scores.length; i++) {
			sum += scores[i];
		}
		System.out.println("총합 : " + sum);
		// 강제 타입(형) 변환(down casting)
		double avg = (double) sum / scores.length;
		System.out.println("평균 : " + avg);
		
		
		// 배열 변수 선언과 배열 생성
		// 변수 = new 타입[길이]
		// 3개의 값을 가진 배열
		arr1 = new int[3];
		//배열 항목의 초기값 출력
		for(int i=0; i<3; i++) {
			System.out.print("arr1[" + i + "] : " + arr1[i] + ", ");
		}
		System.out.println();
		//배열 항목의 값 변경
		arr1[0] = 10;
		arr1[1] = 20;
		arr1[2] = 30;
		//배열 항목의 변경 값 출력
		for(int i=0; i<3; i++) {
			System.out.print("arr1[" + i + "] : " + arr1[i] + ", ");
		}
		System.out.println("\n");

		//배열 변수 선언과 배열 생성
		double[] arr4 = new double[3];
		//배열 항목의 초기값 출력
		for(int i=0; i<3; i++) {
			System.out.print("arr4[" + i + "] : " + arr4[i] + ", ");
		}
		System.out.println();
		//배열 항목의 값 변경
		arr4[0] = 0.1;
		arr4[1] = 0.2;
		arr4[2] = 0.3;
		//배열 항목의 변경 값 출력
		for(int i=0; i<3; i++) {
			System.out.print("arr4[" + i + "] : " + arr4[i] + ", ");
		}
		System.out.println("\n");

		//배열 변수 선언과 배열 생성
		String[] arr5 = new String[3];
		//배열 항목의 초기값 출력
		for(int i=0; i<3; i++) {
			System.out.print("arr5[" + i + "] : " + arr5[i] + ", ");
		}
		System.out.println();
		//배열 항목의 값 변경
		arr5[0] = "1월";
		arr5[1] = "2월";
		arr5[2] = "3월";
		//배열 항목의 변경값 출력
		for(int i=0; i<3; i++) {
			System.out.print("arr5[" + i + "] : " + arr5[i] + ", ");
		}
		

		System.out.println("\n");

		//배열을 매개값으로 주고, printItem() 메서드 호출
		printItem( new int[] { 83, 90, 87 } );
		
	} // 메인 메서드 끝
	
	// printItem() 메서드 선언
	// 접근제한자 [static] 리턴타입 메서드( 타입[] 매개변수 ) {
	// void는 반환 값이 없을 경우 기록하는 타입
	public static void printItem( int[] scores ) {
		//매개변수가 참조하는 배열의 항목을 출력
		for(int i=0; i<scores.length; i++) {
			System.out.println("score[" + i + "]: " + scores[i]);
		}
	}

} // 클래스 끝