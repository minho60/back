package ch11_base모듈.sec02_System;

/**
 * System.nanoTime();
 *  - 10의 -9승 초 단위로 진행된 시간 반환 
 */
public class Ex04_nanoTime메서드 {
	public static void main(String[] args) {
		long time1 = System.nanoTime();
		int sum = 0;
		for(int i=1; i<=1000000; i++) {
			sum += i;
		}
		long time2 = System.nanoTime();

		System.out.println("1~1000000까지의 합: " + sum);
		System.out.println("계산에 " + (time2-time1) + " 나노초가 소요되었습니다.");
	}
}