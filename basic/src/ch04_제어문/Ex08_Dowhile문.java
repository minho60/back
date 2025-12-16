package ch04_제어문;

import java.util.Scanner;

/**
 * for 문과 while문은 조건이 false이면 한 번도 실행 x
 * do while 문은 조건이 false라도 최소한 1번은 실행한다.
 */
public class Ex08_Dowhile문 {

	public static void main(String[] args) {
		System.out.println("메시지를 입력하세요.");
		System.out.println("프로그램을 종료하려면 q를 입력하세요.");

		Scanner scanner = new Scanner(System.in);
		String inputString;

		do {
			System.out.print(">");
			inputString = scanner.nextLine();
			System.out.println(inputString);
		} while( ! inputString.equals("q") );

		System.out.println();
		System.out.println("프로그램 종료");

	}

}
