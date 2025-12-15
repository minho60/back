package ch04_제어문;

public class Ex05_구구단 {

	public static void main(String[] args) {
		
		//중첩 for문
		// 바깥 for문 - 2단~9단
		for (int m=2; m<=9; m++) {
			System.out.println("*** " + m + "단 ***");
			// 안쪽 for문 - 단 내에서 1~9까지 곱
			for (int n=1; n<=9; n++) {
				System.out.println(m + " x " + n + " = " + (m*n));
			}
		}

	}

}
