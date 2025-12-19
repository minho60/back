package ch05_참조타입;

/**
 * 데이터 타입
 * 1. 기본 타입
 * 		- 정수 타입: byte, char, short, int, long
 * 		- 실수 타입: float, double
 * 		- 논리 타입:  boolean
 * 2. 참조타입
 * 		- 배열(array) 타입: []
 * 		- 문자열 타입: String
 * 		- 열거(enum) 타입 
 * 		- 클래스(class) 타입 
 * 		- 인터페이스(interface) 타입
 * 
 *  기본 타입 - 값 자체 저장
 *  	예) int num = 3;
 *  참조 타입 - 번지(주소) 저장
 *  	예) int[] nums = new int[] {1,2,3}
 * 
 * 
 */

public class Ex01_배열{

	//args 는 String 타입의 배열 변수
		public static void main(String[] args) {
			// 자바스크립트 [10, "문자", true]
			
			// int 타입의 배열 선언
			// int[] 변수; 또는 int 변수[];
			int[] arr1; //배열 변수 arr1 선언
			int[] arr3; //배열 변수 arr3 선언
				
			// 배열 선언 및 할당
			int[] arr2 = new int[] { 1, 2, 3 }; 
			
			// crtl+i: 선택영역 자동 들여쓰기
			
			// 배열 생성 - 리터럴 방식으로 변수 초기화 
			//배열 { 1, 2, 3 }을 생성하고 arr1 변수에 대입
			arr1 = new int[] { 1, 2, 3 }; 
			
			//배열 변수 arr2의 값을 배열 변수 arr3에 대입
			arr3 = arr2; 

			// arr1과 arr2 변수가 같은 배열을 참조하는지 검사
			System.out.println(arr1 == arr2); // false
			// arr2와 arr3 변수가 같은 배열을 참조하는지 검사
			System.out.println(arr2 == arr3); // true
			

	}

}
