package ch04.sec05;

import java.util.Scanner;

public class KeyControlExample {
	public static void main(String[] args) {
		// 참조 타입: string, 클래스 ...
		// new 키워드로 생성한 객체를 특별히 instance(인스턴스)
		// Scanner()생성자 함수를 통해 scanner인스턴스 사용
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		int speed = 0;

		while(run) {
			System.out.println("-----------------------------");
			System.out.println("1. 증속 | 2. 감속 | 3. 중지");
			System.out.println("-----------------------------");
			System.out.print("선택: ");

			String strNum = scanner.nextLine();

			if(strNum.equals("1")) {
				speed++;
				System.out.println("현재 속도 = " + speed);
			} else if(strNum.equals("2")) {
				speed--;
				System.out.println("현재 속도 = " + speed);
			} else if(strNum.equals("3")) {
				run = false;
			}
		}

		System.out.println("프로그램 종료");
	}
}