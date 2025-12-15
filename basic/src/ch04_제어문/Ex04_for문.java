package ch04_제어문;

public class Ex04_for문 {

	public static void main(String[] args) {
		/*
		 * for 문
		 * 	- 조건식이 true이면 실행문을 반복한다.
		 * 
		 * 		for(초깃값; 조건식; 증감식){
		 * 			실행문;
		 * 		}
		 * 
		 * 		실행순서
		 * 			1. 초기식
		 * 			2. 조건식
		 * 			3. 실행문
		 * 			4. 증감식
		 * 
		 */
		
		//1~10 까지 자연수
		for(int i =1; i<=10; i++) {
			System.out.print(i+" ");
		}
			
		System.out.println("\n");	
		
		//1~100까지 합
		int sum = 0;
		int i;
			
		for(i=1; i<=100; i++) {
			sum += i;
		}
			
		System.out.println("1~" + (i-1) + " 합 : " + sum);
		
		System.out.println("\n");
		
		//부동 소수점
		// 0.1 부터 1.0까지 10번 반복 될 것 같으나, 9번만 반복한다.
		// 왜? float 타입은 연산 과정에서 소수점을 정확히 표현 못한다.
		// 	증감식에서 x에 더해지는 실제 값은 0.1보다 약간 클 수 있다.

		for(float x=0.1f; x<=1.0f; x+=0.1f) {
			System.out.println(x);
		}
		
		
		
	}
}
