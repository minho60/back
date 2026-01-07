package ch11_base모듈.sec02_System;

/**
 * System 클래스의 err 필드
 *  - 콘솔(Console)에 에러 내용 출력
 *  - 콘솔 종류에 따라 출력 글자색이 빨간색으로 출력된다.
 * 		- System.out.println();
 * 		- System.out.print();
 * 		- System.out.printf();
 * 
 * 		- System.err.println();
 * 
 * 
 */
public class Ex01_err필드 {

	public static void main(String[] args) {
		try {
			int value = Integer.parseInt("1oo");
		} catch(NumberFormatException e) {
			System.err.println("[에러 내용]");
			System.err.println(e.getMessage());
		}
	}
}